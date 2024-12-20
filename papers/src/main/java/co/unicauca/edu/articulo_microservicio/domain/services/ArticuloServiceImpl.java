package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.DTO.ArticuloDeConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;
import co.unicauca.edu.articulo_microservicio.infrastructure.repositories.IArticuloRepository;
import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ArticuloConConferenciasDTO;
import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.domain.models.AppUser;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.domain.events.ArticuloCreadoEvent;
import co.unicauca.edu.articulo_microservicio.domain.events.EstadoActualizadoEvent;
import co.unicauca.edu.articulo_microservicio.infrastructure.rabbit.ConfigRabbitMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author sonhuila
 */
@Service
public class ArticuloServiceImpl implements IArticuloService {

    private static final Logger logger = LoggerFactory.getLogger(ArticuloServiceImpl.class);
    @Autowired
    private WebClient.Builder webClientBuilder;
    private final IArticuloRepository servicioAccesoBaseDatos;
    private final ConferenciaService servicioConsumirObtencionConferencias;
    private final ModelMapper modelMapper;
    private final RabbitTemplate rabbitTemplate;

    public ArticuloServiceImpl(IArticuloRepository servicioAccesoBaseDatos, ModelMapper modelMapper, ConferenciaService servicioConsumirObtencionConferencias, RabbitTemplate rabbitTemplate) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
        this.servicioConsumirObtencionConferencias = servicioConsumirObtencionConferencias;
        this.rabbitTemplate = rabbitTemplate;

  
    }

    public void enviarEventoArticuloCreado(ArticuloCreadoEvent evento) {
        try {
            rabbitTemplate.convertAndSend(ConfigRabbitMQ.ARTICULO_EXCHANGE, 
                    ConfigRabbitMQ.ARTICULO_ROUTING_KEY, 
                    evento);
            logger.info("Evento ArticuloCreadoEvent enviado exitosamente: {}", evento);
        } catch (Exception e) {
            logger.error("Error al enviar el evento ArticuloCreadoEvent: {}", evento, e);
        }
    }

    @Override
    public List<ArticuloDTO> findAll() {
        List<Articulo> articulosEntity = this.servicioAccesoBaseDatos.findAll();
        return this.modelMapper.map(articulosEntity, new TypeToken<List<ArticuloDTO>>() {
        }.getType());
    }

    @Override
    public ArticuloDTO findById(Integer id) {
        Optional<Articulo> objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
        return objArticuloEntity.map(articulo -> this.modelMapper.map(articulo, ArticuloDTO.class)).orElse(null);
    }

    @Override
    public boolean existsById(Integer id) {
        return this.servicioAccesoBaseDatos.existsById(id);
    }

    @Override

public ArticuloDTO save(ArticuloDTO articulo) {
    // Mapear el DTO al modelo de entidad
    Articulo articuloEntity = this.modelMapper.map(articulo, Articulo.class);

    // Asegurarse de que las calificaciones no se procesen en esta etapa
    if (articuloEntity.getCalificaciones() != null) {
        articuloEntity.setCalificaciones(null); // Ignorar las calificaciones al guardar el artículo inicialmente
    }

    // Guardar el artículo
    Articulo savedArticulo = this.servicioAccesoBaseDatos.save(articuloEntity);

    // Mapear la entidad guardada de nuevo al DTO
    ArticuloDTO articuloDTO = modelMapper.map(savedArticulo, ArticuloDTO.class);

    // Crear y enviar un evento para notificar la creación del artículo
    ArticuloCreadoEvent evento = new ArticuloCreadoEvent(
        savedArticulo.getId(),
        savedArticulo.getNombre(),
        savedArticulo.getAutores(),
        savedArticulo.getResumen(),
        savedArticulo.getPalabrasClaves()
    );
    enviarEventoArticuloCreado(evento);

    return articuloDTO;
}


    @Override
    public ArticuloDTO update(Integer id, ArticuloDTO articulo) {
        if (servicioAccesoBaseDatos.existsById(id)) {
            Articulo articuloEntity = this.modelMapper.map(articulo, Articulo.class);
            articuloEntity.setId(id);
            Articulo updatedArticulo = this.servicioAccesoBaseDatos.save(articuloEntity);
            return this.modelMapper.map(updatedArticulo, ArticuloDTO.class);
        }
        return null; // o lanzar una excepción si el artículo no existe
    }

    @Override
    public boolean delete(Integer id) {
        if (servicioAccesoBaseDatos.existsById(id)) {
            servicioAccesoBaseDatos.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ConferenciaDTO> ListarConferenciasDeArticulo(Integer idArticulo) {
        return servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
    }

    @Override
    public ArticuloConConferenciasDTO listarDatosrticuloConSusConferencias(Integer idArticulo) {
        List<ConferenciaDTO> conferencias = servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
        Optional<Articulo> articuloOpt = servicioAccesoBaseDatos.findById(idArticulo);
        ArticuloDTO articuloDTO = articuloOpt.map(articulo -> modelMapper.map(articulo, ArticuloDTO.class)).orElse(null);
        return new ArticuloConConferenciasDTO(articuloDTO, conferencias);
    }
    
    public AppUser obtenerUsuarioPorId(Integer idUsuario) {
        String url = String.format("http://localhost:8081/api/user/%d", idUsuario);

        try {
            Mono<AppUser> response = webClientBuilder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(AppUser.class);

            return response.block(); // Bloquea hasta obtener la respuesta
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario con ID " + idUsuario, e);
        }
    }
    
    @Override
    public void actualizarEstadoArticulo(Integer id, EstadoRevision nuevoEstado) {
        // Buscar el artículo por su ID
        Optional<Articulo> articuloOpt = servicioAccesoBaseDatos.findById(id);

        if (articuloOpt.isPresent()) {
            Articulo articulo = articuloOpt.get();
            EstadoRevision estadoAnterior = articulo.getEstadoActual(); // Obtener el estado actual
            articulo.setEstadoActual(nuevoEstado); // Actualizar al nuevo estado

            // Guardar los cambios en la base de datos
            servicioAccesoBaseDatos.save(articulo);

            // Crear y enviar el evento
            EstadoActualizadoEvent evento = new EstadoActualizadoEvent(
                id, 
                articulo.getNombre(), 
                estadoAnterior.name(),  // Convertir el enum a String
                nuevoEstado.name(),     // Convertir el enum a String
                articulo.getAutor().getIdUsuario(),
                articulo.getAutor().getNombreUsuario(),
                articulo.getAutor().getCorreoUsuario(),
                articulo.getAutor().getIdUsuario(), // ID del usuario
                articulo.getAutor().getNombreUsuario(), // Nombre del usuario
                articulo.getAutor().getCorreoUsuario() // Correo del usuario
            );
            rabbitTemplate.convertAndSend(ConfigRabbitMQ.ARTICULO_EXCHANGE,
                ConfigRabbitMQ.ESTADO_ACTUALIZADO_ROUTING_KEY,
                evento);

            // Loguear la operación
            logger.info("Estado del artículo actualizado de {} a {} y evento publicado: {}", 
                        estadoAnterior, nuevoEstado, evento);
        } else {
            // Manejo de error: artículo no encontrado
            logger.warn("Artículo con ID {} no encontrado para actualizar el estado.", id);
            throw new IllegalArgumentException("Artículo no encontrado");
        }
    }

}

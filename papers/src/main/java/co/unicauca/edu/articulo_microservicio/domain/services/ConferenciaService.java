package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.DTO.ArticuloDeConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
/**
 *
 * @author sonhuila
 */
@Service
public class ConferenciaService implements IConferenciaService{

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ModelMapper modelMapper; // Asegúrate de que este bean esté configurado correctamente
    

    @Override
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        String url = "http://localhost:7777/api/Conferencia/articulo/" + idArticulo;

        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);

        ConferenciaDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
    @Override
    public void enviarArticuloAConferencia(ArticuloDTO articulo) {
        // Crear una instancia de ArticuloDeConferenciaDTO manualmente
        ArticuloDeConferenciaDTO articuloDTO = new ArticuloDeConferenciaDTO();

        // Mapear los campos manualmente
        articuloDTO.setId(articulo.getId());
        articuloDTO.setConferencia(articulo.getIdConferencia());
        articuloDTO.setNombre(articulo.getNombre());
        articuloDTO.setAutores(articulo.getAutores());
        articuloDTO.setPalabrasClaves(articulo.getPalabrasClaves());
    
        // Convertir el estadoActual (Enum) a String antes de asignarlo
        articuloDTO.setEstadoActual(articulo.getEstadoActual().name());
        // Realizar la llamada HTTP al microservicio conferencia
        String url = "http://localhost:7777/api/Conferencia/AddArticulos";

        webClientBuilder.build()
                .post()
                .uri(url)
                .bodyValue(articuloDTO)
                .retrieve()
                .toBodilessEntity()
                .block(); // Ejecuta la llamada de manera sincrónica
    }
    
    @Override
    public boolean verificarConferencia(Integer idConferencia) {
        String url = "http://localhost:7777/api/Conferencia/VerificarConferencia/" + idConferencia;

        // Llamada al endpoint del servicio de conferencias
        Mono<Boolean> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Boolean.class);

        // Bloqueo para obtener la respuesta directamente (puedes usar programadores reactivos si prefieres)
        return response.block();
    }
}


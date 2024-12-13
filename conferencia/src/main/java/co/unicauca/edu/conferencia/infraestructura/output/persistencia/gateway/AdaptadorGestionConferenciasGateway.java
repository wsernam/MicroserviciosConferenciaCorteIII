package co.unicauca.edu.conferencia.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;

import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOArticulo;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaArticulo;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaEvaluador;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio.IArticuloRepositorio;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio.IConferenciaRepositorio;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio.IEvaluadorRepositorio;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdaptadorGestionConferenciasGateway implements PuertoGestionConferenciaGateway {

    private IConferenciaRepositorio repositorio;
    private IArticuloRepositorio repositorioA;
    private IEvaluadorRepositorio repositorioE;
    private final ModelMapper modelMapper;
    private RabbitTemplate rabbitTemplate;

  

  

    public AdaptadorGestionConferenciasGateway(IConferenciaRepositorio repositorio, IArticuloRepositorio repositorioA,
            IEvaluadorRepositorio repositorioE, ModelMapper modelMapper, RabbitTemplate rabbitTemplate) {
        this.repositorio = repositorio;
        this.repositorioA = repositorioA;
        this.repositorioE = repositorioE;
        this.modelMapper = modelMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<Conferencia> getConferencias() {
        List<PersistenciaConferencia> persistenciaConferencias = this.repositorio.findAll();
        List<Conferencia> respuestaConferencias = this.modelMapper.map(persistenciaConferencias, new TypeToken<List<Conferencia>>() {
        }.getType());
        return respuestaConferencias;
    }

    @Override
    public Conferencia setConferencia(Conferencia prmConferencia) {

        PersistenciaConferencia entidadConferencia = this.modelMapper.map(prmConferencia, PersistenciaConferencia.class);
        PersistenciaConferencia objConferencia = this.repositorio.save(entidadConferencia);
        Conferencia objConferenciaRespuesta = this.modelMapper.map(objConferencia, Conferencia.class);

        return objConferenciaRespuesta;

    }

    @Override
    public boolean verifyById(int prmId) {
        return this.repositorio.existsById(prmId);
    }

    @Override
    public Conferencia EncontrarPorId(Integer prmId) {
        PersistenciaConferencia conferenciaEncontrada = this.repositorio.findById(prmId).orElse(null);
        return this.modelMapper.map(conferenciaEncontrada, Conferencia.class);
    }
    @Transactional
    @Override
    public Conferencia addArticulo(Articulo articulo) {
  
         Integer idConferencia=articulo.getConferencia();
   

        // Obtener la conferencia asociada
        Conferencia conferencia = EncontrarPorId(idConferencia);
       
       
        // Guardar los cambios en la conferencia persistencia
        Integer idArticulo=articulo.getId();
        PersistenciaArticulo perArticulo= modelMapper.map(articulo, PersistenciaArticulo.class);
        perArticulo.setId(idArticulo);
        this.repositorioA.save(perArticulo);

        PersistenciaConferencia persistenciaConferencia = modelMapper.map(conferencia, PersistenciaConferencia.class);
        persistenciaConferencia.getArticulosRecibidos().add(perArticulo);
        repositorio.save(persistenciaConferencia);

        return modelMapper.map(persistenciaConferencia, Conferencia.class);

        
    }
    @Transactional
    @Override
    public String postularEvaluador(Evaluador evaluador) {
        // Verificar si la conferencia existe
        if (!verifyById(evaluador.getConferenciaId())) {
            System.out.println("Conferencia no encontrada para el evaluador.");
            return "Conferencia no encontrada";
        }
    
        // Obtener la conferencia desde la base de datos
        PersistenciaConferencia persistenciaConferencia = repositorio.findById(evaluador.getConferenciaId())
                .orElseThrow(() -> new RuntimeException("Conferencia no encontrada"));
    
        // Mapear el evaluador
        PersistenciaEvaluador persisEvaluador = modelMapper.map(evaluador, PersistenciaEvaluador.class);
    
        // Agregar el evaluador a la conferencia
        persistenciaConferencia.getEvaluadores().add(persisEvaluador);
    
        // Guardar los cambios
        repositorio.save(persistenciaConferencia);
    
        return "Evaluador postulado correctamente";
    }
    

  
}

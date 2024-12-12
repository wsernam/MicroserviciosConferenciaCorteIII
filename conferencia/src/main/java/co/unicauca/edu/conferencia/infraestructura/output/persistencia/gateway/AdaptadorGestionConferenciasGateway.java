package co.unicauca.edu.conferencia.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;

import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio.IConferenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdaptadorGestionConferenciasGateway implements PuertoGestionConferenciaGateway {

    private IConferenciaRepositorio repositorio;
    private final ModelMapper modelMapper;
    private RabbitTemplate rabbitTemplate;

    public AdaptadorGestionConferenciasGateway(IConferenciaRepositorio repositorio,
            ModelMapper modelMapper, RabbitTemplate rabbitTemplate) {
        this.repositorio = repositorio;
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

    @Override
    public Conferencia addArticulo(Integer prmIdArticulo, Integer idConferencia) {

        PersistenciaConferencia conferencia = this.repositorio.findById(idConferencia).orElse(null);
        ArrayList<Integer> listaArticulos = new ArrayList<>();
        listaArticulos = (ArrayList<Integer>) conferencia.getArticulosRecibidos();
        listaArticulos.add(prmIdArticulo);
        conferencia.setArticulosRecibidos(listaArticulos);
        PersistenciaConferencia resultado = repositorio.save(conferencia);
        return this.modelMapper.map(resultado, Conferencia.class);
    }

    @Override
    public String postularEvaluador(Evaluador evaluador) {
        // Verificar si la conferencia existe
        if (!verifyById(evaluador.getConferenciaId())) {
            System.out.println("Conferencia no encontrada para el evaluador.");
            return "Conferencia no encontrada";
        }

        // Obtener la conferencia asociada
        Conferencia conferencia = EncontrarPorId(evaluador.getConferenciaId());

        // Verificar si la conferencia ya tiene el evaluador o si se alcanzó el límite
        if (!conferencia.puedeAceptarEvaluador()) {
            return "Límite de evaluadores alcanzado o evaluador ya registrado.";
        }

        // Agregar el evaluador a la conferencia
        conferencia.getEvaluadores().add(evaluador); // Asumiendo que tienes un método getEvaluadores que te da la lista de evaluadores

        // Guardar los cambios en la conferencia
        PersistenciaConferencia persistenciaConferencia = modelMapper.map(conferencia, PersistenciaConferencia.class);
        repositorio.save(persistenciaConferencia);

        return "Evaluador postulado correctamente";
    }
}

package co.unicauca.edu.conferencia.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;

import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio.IConferenciaRepositorio;

@Service
public class AdaptadorGestionConferenciasGateway implements PuertoGestionConferenciaGateway {

    private IConferenciaRepositorio repositorio;
    private ModelMapper modelMapper;
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

}

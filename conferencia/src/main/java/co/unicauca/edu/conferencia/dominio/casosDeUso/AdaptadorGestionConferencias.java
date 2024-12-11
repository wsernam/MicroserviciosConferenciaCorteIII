package co.unicauca.edu.conferencia.dominio.casosDeUso;

import java.util.List;

import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGestionConferencia;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;

public class AdaptadorGestionConferencias implements PuertoGestionConferencia {
 PuertoGestionConferenciaGateway servicioRepositorio;
 PuertoComunicacionResultado mensaje;
 

    public AdaptadorGestionConferencias(PuertoGestionConferenciaGateway servicioRepositorio,
        PuertoComunicacionResultado mensaje) {
    this.servicioRepositorio = servicioRepositorio;
    this.mensaje = mensaje;
}

    @Override
    public List<Conferencia> listarConferencia() {
       return this.servicioRepositorio.getConferencias();
    }

    @Override
    public Conferencia crearConferencia(Conferencia prmConferencia) {

      String resultado=prmConferencia.validarFechas();
      if(!resultado.equals("ok")){
        return this.mensaje.prepararRespuestaFallida(resultado);
        
      }else{
       return this.servicioRepositorio.setConferencia(prmConferencia);

      }
    }

    @Override
    public boolean existeConferencia(int prmId) {
       return this.servicioRepositorio.verifyById(prmId);
    }
    
    
}

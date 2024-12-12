package co.unicauca.edu.conferencia.dominio.casosDeUso;

import java.util.List;

import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGestionConferencia;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
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
        return (Conferencia) this.mensaje.prepararRespuestaFallida(resultado);
        
      }else{
       return this.servicioRepositorio.setConferencia(prmConferencia);

      }
    }

    @Override
    public boolean existeConferencia(int prmId) {
       return this.servicioRepositorio.verifyById(prmId);
    }

    
    @Override
    public Conferencia AñadirArticulo(Articulo prmArticulo) {
        System.out.println("EL ARTICULO QUE LLEGA ES:"+prmArticulo);
        Integer idConferencia=prmArticulo.getConferencia();
        System.out.println("EL ID DE LA CONFERENCIA DEL ARTICULO ES:"+idConferencia);
       
        if(!servicioRepositorio.verifyById(idConferencia)){
            System.out.println("NO EXISTE LA CONFERENCIA");
            return (Conferencia) this.mensaje.prepararRespuestaFallida("No existe la conferencia");
        }
        System.out.println("EXISTE LA CONFERENCIA");
        Conferencia conferencia=servicioRepositorio.EncontrarPorId(idConferencia);
        System.out.println("LA CONFERENCIA ES:"+conferencia);
        String resultado=conferencia.maxArticulosRecibidos();
        if(!resultado.equals("ok")){
            System.out.println("llEGO AL MAXIMO DE ARTICULOS");
            return (Conferencia) this.mensaje.prepararRespuestaFallida(resultado);
        }

        Conferencia respuesta=this.servicioRepositorio.addArticulo(prmArticulo.getId(), conferencia.getId());
      
        System.out.println("CONFERENCIA CON SUS ARTICULOS"+conferencia);

        return respuesta;
        


    }


    
    
}

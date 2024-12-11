package co.unicauca.edu.conferencia.dominio.casosDeUso;

import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGuardarArticuloUserCase;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;

public class AdaptadorGuardarArticuloUserCase implements PuertoGuardarArticuloUserCase {
PuertoGestionConferenciaGateway servicioConferenciaRepositorio;

 PuertoComunicacionResultado mensaje;
    @Override
    public Articulo AñadirArticulo(Articulo prmArticulo) {
        Integer idConferencia=prmArticulo.getIdConferencia();
       
        if(!servicioConferenciaRepositorio.verifyById(idConferencia)){
            return (Articulo) this.mensaje.prepararRespuestaFallida("No existe la conferencia");
        }
        Conferencia conferencia=servicioConferenciaRepositorio.EncontrarPorId(idConferencia);
        String resultado=conferencia.maxArticulosRecibidos();
        if(!resultado.equals("ok")){
            return (Articulo) this.mensaje.prepararRespuestaFallida(resultado);
        }
        conferencia.setArticulosRecibidos(prmArticulo);

        return prmArticulo;
        


    }
    
}

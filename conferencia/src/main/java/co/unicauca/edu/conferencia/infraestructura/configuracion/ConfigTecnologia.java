package co.unicauca.edu.conferencia.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoGestionConferenciaGateway;
import co.unicauca.edu.conferencia.dominio.casosDeUso.AdaptadorGestionConferencias;

@Configuration
public class ConfigTecnologia {


//HACE LO MISMO QUE @Service Debido a que el dominio no puede estar contaminado de tecnologías (iría en cao de uso)
    @Bean
    public AdaptadorGestionConferencias crearAdaptadorGestionConferencias(
            PuertoGestionConferenciaGateway objGestionarConferenciaGateway,
            PuertoComunicacionResultado objConferenciaComunicacionResultado) {
        AdaptadorGestionConferencias objGestionarConferencia = new AdaptadorGestionConferencias(objGestionarConferenciaGateway,
                objConferenciaComunicacionResultado);
        return objGestionarConferencia;
    }
   

    
}

package co.unicauca.edu.conferencia.aplicación.puertos.output.comunicacionResultado;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.unicauca.edu.conferencia.aplicación.puertos.output.PuertoComunicacionResultado;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
@Service
public class AdaptadorComunicacionResultado implements PuertoComunicacionResultado {
    
    @Override
    public Conferencia prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);//Se puede lanzar un BAD_REQUEST
    }
    
}

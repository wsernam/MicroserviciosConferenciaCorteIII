package co.unicauca.edu.conferencia.aplicación.puertos.output;

import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;

public interface PuertoComunicacionResultado {
    public Conferencia prepararRespuestaFallida(String error);
    
}

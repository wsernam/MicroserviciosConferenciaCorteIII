package co.unicauca.edu.conferencia.aplicación.puertos.input;

import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;

public interface PuertoGestionConferencia {
   
      public List<Conferencia> listarConferencia();
    public Conferencia crearConferencia(Conferencia prmConferencia);
    public boolean existeConferencia(int prmId);
    
}

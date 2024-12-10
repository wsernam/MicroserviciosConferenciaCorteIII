package co.unicauca.edu.conferencia.aplicación.puertos.output;

import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;


public interface PuertoGestionConferenciaGateway {
    public List<Conferencia> getConferencias();
    public Conferencia setConferencia(Conferencia prmConferencia);
    public boolean verifyById(int prmId);
    
}

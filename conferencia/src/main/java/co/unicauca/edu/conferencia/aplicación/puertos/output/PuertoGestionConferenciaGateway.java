package co.unicauca.edu.conferencia.aplicación.puertos.output;

import java.util.List;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;

public interface PuertoGestionConferenciaGateway {
    public List<PersistenciaConferencia> getConferencias();
    public PersistenciaConferencia setConferencia(PersistenciaConferencia prmConferencia);
    public boolean existeConferencia(int prmId);
    
}

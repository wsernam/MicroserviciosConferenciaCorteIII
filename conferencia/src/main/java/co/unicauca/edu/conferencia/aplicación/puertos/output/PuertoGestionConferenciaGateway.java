package co.unicauca.edu.conferencia.aplicación.puertos.output;

import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;


public interface PuertoGestionConferenciaGateway {
    public List<Conferencia> getConferencias();
    public Conferencia setConferencia(Conferencia prmConferencia);
    public boolean verifyById(int prmId);
    public Conferencia EncontrarPorId(Integer prmId);
    public String postularEvaluador(Evaluador evaluador);
    public Conferencia addArticulo(Articulo articulo);
}

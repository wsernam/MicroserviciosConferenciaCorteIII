package co.unicauca.edu.conferencia.aplicación.puertos.input;

import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;

public interface PuertoGestionConferencia {

    public List<Conferencia> listarConferencia();

    public Conferencia crearConferencia(Conferencia prmConferencia);

    public boolean existeConferencia(int prmId);

    public Conferencia AñadirArticulo(Articulo prmArticulo);
    
    public void postularEvaluador(Evaluador evaluador);
    

}

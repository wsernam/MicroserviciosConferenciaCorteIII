package co.unicauca.edu.conferencia.aplicación.puertos.input;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;

public interface PuertoGuardarArticuloUserCase {
    public Conferencia AñadirArticulo(Articulo prmArticulo);
    
}

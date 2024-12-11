package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class PersistenciaArticulo {
    private Integer id;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public PersistenciaArticulo() {
    }

    
}

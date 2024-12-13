package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter

@Entity
public class PersistenciaArticulo {
    @Id
    private Integer id;
    private Integer conferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public PersistenciaArticulo() {
    }
    
    
}

package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTOArticulo {
    private Integer id;
    private Integer idConferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public DTOArticulo() {
    }
    
    
}

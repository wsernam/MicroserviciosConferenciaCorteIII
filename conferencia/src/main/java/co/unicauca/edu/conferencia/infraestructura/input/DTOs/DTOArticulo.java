package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.util.ArrayList;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTOArticulo {
    private Integer id;
    private Integer conferencia;
    private String nombre;
    private ArrayList<String> autores;
    private Articulo articuloAsignado;
    private String palabrasClaves;
    public DTOArticulo() {
    }
    
    
}

package com.conference.gui.entities;

import jakarta.persistence.Id;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
/**
 *
 * @author Ashlee Campaz
 */
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades desconocidas
public class Articulo {
    
    private int idArticulo;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;


    public Articulo() {
    }

    public Articulo( String nombre, ArrayList<String> autores, String resumen, String palabrasClaves) {

        this.nombre = nombre;
        this.autores = autores;
        this.resumen = resumen;
        this.palabrasClaves = palabrasClaves;
     
    }



   
    
}

package co.unicauca.edu.articulo_microservicio.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Articulo {

    @Id  // Anotación para el campo de clave primaria
     @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idArticulo;

    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
   

    public Articulo() {
    }
}

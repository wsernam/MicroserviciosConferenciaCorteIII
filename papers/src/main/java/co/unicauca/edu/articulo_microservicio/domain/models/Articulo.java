package co.unicauca.edu.articulo_microservicio.domain.models;

import co.unicauca.edu.articulo_microservicio.domain.services.EstadoArticulo;
import co.unicauca.edu.articulo_microservicio.domain.services.estados.Resultado;
import co.unicauca.edu.articulo_microservicio.domain.services.estados.EstadoFormulado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Articulo {
    @Transient // Ignorar este campo en la persistencia
    private EstadoArticulo estado;
    @Id  // Anotación para el campo de clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idArticulo;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
   

    public Articulo() {
        this.estado = new EstadoFormulado();//estado inicial
    }
    
    public Resultado enviarAEvaluacion() {
        return estado.enviarAEvaluacion(this);
    }
    
    public Resultado aprobar() {
        return estado.aprobar(this);
    }
    
        public Resultado fijarObservaciones() {
        return estado.formularConObservaciones(this);
    }

    public Resultado noAprobar() {
        return estado.rechazar(this);
    }

    public String obtenerEstadoActual() {
        return estado.toString();
    }
}

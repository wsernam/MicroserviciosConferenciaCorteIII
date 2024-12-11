package co.unicauca.edu.articulo_microservicio.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Articulo {
    @Id  // Anotación para el campo de clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> calificaciones;
    @Transient // Ignorar este campo en la persistencia
    private EstadoRevision estadoActual;
        
    public void iniciarRevision() {
        estadoActual.iniciarRevision(this);
    }

    public void completarRevision() {
        estadoActual.completarRevision(this);
    }

    public void revisarEstado() {
        estadoActual.revisarEstado(this);
    }
    
    public void agregarCalificacion(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
    }
}

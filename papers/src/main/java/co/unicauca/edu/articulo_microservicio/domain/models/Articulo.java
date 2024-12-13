package co.unicauca.edu.articulo_microservicio.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
    private Integer idConferencia;
    private String nombre;
    private ArrayList<String> autores; // autores del artículo

    @ManyToOne
    private AppUser autor; // Autor que subió el artículo y recibirá notificaciones

    @ManyToOne
    private AppUser evaluador; // Evaluador asignado al artículo

    private String resumen;
    private String palabrasClaves;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> calificaciones = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private EstadoRevision estadoActual;

    // Métodos para manejar el estado del artículo
    public void iniciarRevision() {
        estadoActual.iniciarRevision(this);
    }

    public void completarRevision() {
        estadoActual.completarRevision(this);
    }

    public void revisarEstado() {
        estadoActual.revisarEstado(this);
    }

    public void evaluar(boolean aprobado) {
        estadoActual.evaluar(this, aprobado);
    }

    // Método para agregar una calificación con manejo de relación bidireccional
    public void agregarCalificacion(Calificacion calificacion) {
    if (calificaciones == null) {
        calificaciones = new ArrayList<>();
    }
    calificacion.setArticulo(this); // Establece la relación inversa
    this.calificaciones.add(calificacion);
}

    // Método para actualizar calificaciones existentes
    public void actualizarCalificaciones(List<Calificacion> nuevasCalificaciones) {
        // Elimina las calificaciones existentes que ya no están en la lista nueva
        this.calificaciones.clear();

        // Añade las nuevas calificaciones
        if (nuevasCalificaciones != null) {
            for (Calificacion nuevaCalificacion : nuevasCalificaciones) {
                this.agregarCalificacion(nuevaCalificacion);
            }
        }
    }
    
        public void setCalificaciones(List<Calificacion> nuevasCalificaciones) {
        // Eliminar calificaciones actuales
        if (this.calificaciones != null) {
            this.calificaciones.clear();
        }

        // Agregar nuevas calificaciones
        if (nuevasCalificaciones != null) {
            for (Calificacion calificacion : nuevasCalificaciones) {
                calificacion.setArticulo(this); // Configurar la relación inversa
                this.calificaciones.add(calificacion);
            }
        }
    }
}

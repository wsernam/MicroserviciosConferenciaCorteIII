package co.unicauca.edu.articulo_microservicio.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wsern
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "calificaciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idEvaluador", "idArticulo"})
})
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacion;

    @Column(nullable = false)
    private int idEvaluador;

    @Column(nullable = false)
    private String nombreEvaluador;

    @Column(nullable = false)
    private int calificacion; // Valor entre 1 y 10

    @ManyToOne
    @JoinColumn(name = "idArticulo", nullable = false) // Relación con Articulo
    private Articulo articulo;

    // Constructor adicional
    public Calificacion(int idEvaluador, String nombreEvaluador, int calificacion, Articulo articulo) {
        this.idEvaluador = idEvaluador;
        this.nombreEvaluador = nombreEvaluador;
        this.calificacion = calificacion;
        this.articulo = articulo;
    }
}
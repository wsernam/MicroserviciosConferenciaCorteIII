package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author sonhuila
 */
@Entity
public class PersistenciaEvaluador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especialidad;

    @ManyToOne
    private PersistenciaConferencia conferencia;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public PersistenciaConferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(PersistenciaConferencia conferencia) {
        this.conferencia = conferencia;
    }
    
}

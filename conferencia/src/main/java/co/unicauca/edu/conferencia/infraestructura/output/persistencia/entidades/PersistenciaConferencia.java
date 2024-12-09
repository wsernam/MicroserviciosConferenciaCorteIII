package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor



@Entity
@Table(name = "conferencias")
public class PersistenciaConferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String temas;
    private String entidadOrganizadora;
    private String pais;
    private String estado;
    private String ciudad;
    private String direccion;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Temporal(TemporalType.DATE)
    private Date fechaFinRecepcion;

    @Temporal(TemporalType.DATE)
    private Date fechaFinEvaluacion;

    private int numMaxRecepcion;
    private int numMaxAceptacion;
    private float calificacionMinAceptable;

   
    private List<Integer> organizadores;

    
    private List<Integer> autores;

    
    private List<Integer> evaluadores;

    
    private List<Integer> articulosRecibidos;

    
    private List<Integer> articulosAceptados;
}

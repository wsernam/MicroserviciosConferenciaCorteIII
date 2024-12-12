package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "conferencias")
public class PersistenciaConferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String nombre;
    public String temas;
    public String entidadOrganizadora;
    public String pais;
    public String estado;
    public String ciudad;
    public String direccion;
    public LocalDate fechaFin;
    public LocalDate fechaInicio;
    public LocalDate fechaFinRecepcion;
    public LocalDate fechaFinEvaluacion;
    public int numMaxRecepcion;
    public int numMaxAceptacion;
    public float calificacionMinAceptable;
    private List<Integer> articulosRecibidos;
    private List<Integer> articulosAceptados;
    private List<Integer> organizadores;
    private List<Integer> autores;
    private List<Integer> evaluadores;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersistenciaEvaluador> evaluadores = new ArrayList<>();

    public PersistenciaConferencia() {
        this.articulosAceptados = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PersistenciaConferencia{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", temas='" + temas + '\''
                + ", entidadOrganizadora='" + entidadOrganizadora + '\''
                + ", pais='" + pais + '\''
                + ", estado='" + estado + '\''
                + ", ciudad='" + ciudad + '\''
                + ", direccion='" + direccion + '\''
                + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin
                + ", fechaFinRecepcion=" + fechaFinRecepcion
                + ", fechaFinEvaluacion=" + fechaFinEvaluacion
                + ", numMaxRecepcion=" + numMaxRecepcion
                + ", numMaxAceptacion=" + numMaxAceptacion
                + ", calificacionMinAceptable=" + calificacionMinAceptable
                + ", organizadores=" + organizadores
                + ", autores=" + autores
                + ", evaluadores=" + evaluadores
                + '}';
    }
}

package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    public String organizador;
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


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "conferencia_id") // Esto crea una clave foránea en la tabla Articulo
    public List<PersistenciaArticulo> articulosRecibidos;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "conferencia_id") // Esto crea una clave foránea en la tabla Articulo
    public List<PersistenciaArticulo> articulosAceptados;

    
    public List<Integer> organizadores;
    public List<Integer> autores;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PersistenciaEvaluador> evaluadores;

    public PersistenciaConferencia() {
       
    }

    public List<PersistenciaArticulo> getArticulosAceptados() {
        return articulosAceptados;
    }

    public void setArticulosAceptados(List<PersistenciaArticulo> articulosAceptados) {
        this.articulosAceptados = articulosAceptados;
    }

    public List<PersistenciaArticulo> getArticulosRecibidos() {
        return articulosRecibidos;
    }

    public void setArticulosRecibidos(List<PersistenciaArticulo> articulosRecibidos) {
        this.articulosRecibidos = articulosRecibidos;
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

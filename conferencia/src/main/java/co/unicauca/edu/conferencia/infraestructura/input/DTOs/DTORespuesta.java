package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTORespuesta {
    private Integer id;
    private String organizador;
    private String nombre;
    private String temas;
    private String entidadOrganizadora;
    private String pais;
    private String estado;
    private String ciudad;
    private String direccion;
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaFinRecepcion;
    private LocalDate fechaFinEvaluacion;
    private int numMaxRecepcion;
    private int numMaxAceptacion;
    private float calificacionMinAceptable;
    public List<DTOArticulo> articulosAceptados;
    public List<DTOArticulo> articulosRecibidos;
    private List<Evaluador> evaluadores;
    public DTORespuesta() {
        this.articulosAceptados = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "DTORespuesta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", temas='" + temas + '\'' +
                ", entidadOrganizadora='" + entidadOrganizadora + '\'' +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaFin=" + fechaFin +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinRecepcion=" + fechaFinRecepcion +
                ", fechaFinEvaluacion=" + fechaFinEvaluacion +
                ", numMaxRecepcion=" + numMaxRecepcion +
                ", numMaxAceptacion=" + numMaxAceptacion +
                ", calificacionMinAceptable=" + calificacionMinAceptable +

                '}';
    }

    public List<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Evaluador> evaluadores) {
        this.evaluadores = evaluadores;
    }
    
    
}

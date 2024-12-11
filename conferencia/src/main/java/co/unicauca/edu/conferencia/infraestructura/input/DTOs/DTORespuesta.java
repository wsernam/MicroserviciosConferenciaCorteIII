package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTORespuesta {
    private int id;
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
    private List<Integer> articulosAceptados;
    private List<Integer> articulosRecividos;
    public DTORespuesta() {
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
                ", articulosAceptados=" + articulosAceptados +
                ", articulosRecividos=" + articulosRecividos +
                '}';
    }
    
    
}

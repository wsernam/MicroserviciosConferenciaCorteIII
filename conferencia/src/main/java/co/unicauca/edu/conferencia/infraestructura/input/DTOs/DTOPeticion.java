package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTOPeticion {
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
    public DTOPeticion() {
    }
    @Override
    public String toString() {
        return "DTOPeticion{" +
           "nombre='" + nombre + '\'' +
           ", temas='" + temas + '\'' +
           ", entidadOrganizadora='" + entidadOrganizadora + '\'' +
           ", pais='" + pais + '\'' +
           ", estado=" + estado + '\'' +
            ", ciudad=" + ciudad + '\'' +
            ", direccion="+ direccion + '\'' +
            ", fechaFin=" + fechaFin + '\'' +
            ", fechaInicio="+ fechaInicio + '\'' +
            ", fechaFinRecepcion="+ fechaFinRecepcion + '\'' +
            ", fechaFinEvaluacion="+ fechaFinEvaluacion + '\'' +
            ", numMaxRecepcion="+ numMaxRecepcion + '\'' +
           ",  numMaxAceptacion="+ numMaxAceptacion + '\'' +
            ", calificacionMinAceptable="+ calificacionMinAceptable + '\'' +
           '}';
}

    
}

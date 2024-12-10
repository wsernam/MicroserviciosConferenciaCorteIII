package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import co.unicauca.edu.conferencia.dominio.modelos.Fecha;
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
    private Fecha fechaFin;
    private Fecha fechaInicio;
    private Fecha fechaFinRecepcion;
    private Fecha fechaFinEvaluacion;
    private int numMaxRecepcion;
    private int numMaxAceptacion;
    private float calificacionMinAceptable;
}

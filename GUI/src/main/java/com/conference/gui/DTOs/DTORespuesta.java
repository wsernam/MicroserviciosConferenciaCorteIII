package com.conference.gui.DTOs;

import com.conference.gui.entities.Evaluador;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTORespuesta {
    private Long id;
    private String nombre;
    private String organizador;
    private String temas;
    private String entidadOrganizadora;
    private String pais;
    private String estado;
    private String ciudad;
    private String direccion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaFinRecepcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaFinEvaluacion;
    private int numMaxRecepcion;
    private int numMaxAceptacion;
    private float calificacionMinAceptable;
    public List<Evaluador> evaluadores;
    public List<Integer> articulosAceptados;
    public List<Integer> articulosRecibidos;
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
    
    
}

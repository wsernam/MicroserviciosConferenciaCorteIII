/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

/**
 *
 * @author Ashlee Campaz
 */
@Getter
@Setter
@NoArgsConstructor

public class Conference {
     private static final long serialVersionUID = 1L;
    private String   organizador;
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

    public Conference(String organizador, String nombre, String temas, String entidadOrganizadora, String pais, String estado, String ciudad, String direccion, LocalDate fechaFin, LocalDate fechaInicio, LocalDate fechaFinRecepcion, LocalDate fechaFinEvaluacion, int numMaxRecepcion, int numMaxAceptacion, float calificacionMinAceptable) {
        this.organizador = organizador;
        this.nombre = nombre;
        this.temas = temas;
        this.entidadOrganizadora = entidadOrganizadora;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFinRecepcion = fechaFinRecepcion;
        this.fechaFinEvaluacion = fechaFinEvaluacion;
        this.numMaxRecepcion = numMaxRecepcion;
        this.numMaxAceptacion = numMaxAceptacion;
        this.calificacionMinAceptable = calificacionMinAceptable;
    }



    @Override
    public String toString() {
        return "Conference{" + "  nombre=" + nombre  + '}';
    }
    
    public String toStringBasic(){
        return "Conferencia"; 
    }
}

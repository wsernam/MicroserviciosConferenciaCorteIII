/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.entities;

import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ashlee Campaz
 */
@Getter
@Setter
@AllArgsConstructor
public class Conferencia {
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
    private List<Integer> articulosAceptados;
    private List<Integer> articulosRecividos;

    public Conferencia(String nombre, String temas, String entidadOrganizadora, String pais, String estado,
            String ciudad, String direccion, Fecha fechaFin, Fecha fechaInicio, Fecha fechaFinRecepcion,
            Fecha fechaFinEvaluacion, int numMaxRecepcion, int numMaxAceptacion, float calificacionMinAceptable) {
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




    public void setArticulosAceptados(List<Integer> articulosAceptados) {
        this.articulosAceptados = articulosAceptados;
    }



    public boolean ValidarFechas(Fecha fechaInicio, Fecha fechaRecepcionArticulos, Fecha fechaEvaluacion) {
        // Validar que la fecha de inicio de la conferencia sea futura
        if (!fechaInicio.esMayorAFechaActual()) {
           // throw new IllegalArgumentException("La fecha de inicio debe ser mayor a la fecha actual");
            return false;
        }

        // La fecha de recepción de artículos debe ser antes de la conferencia
        if (fechaRecepcionArticulos.esDespuesDe(fechaInicio)) {
           // throw new IllegalArgumentException("La fecha de recepción de artículos debe ser antes de la conferencia");
           return false;
        }

        // La fecha de evaluación debe ser válida en el rango
        if (!fechaEvaluacion.estaEnRango(fechaRecepcionArticulos, fechaInicio)) {
            //throw new IllegalArgumentException("La fecha de evaluación debe ser después de la recepción y antes de la fecha de inicio de la conferencia");
            return false;
        }
        return true;
    }

    public boolean MaxArticulosAceptados(int numMaxAceptados){
        if(articulosAceptados.size()>numMaxAceptacion){
            return false;
        }
        return true;    
    }    

    public boolean MaxArticulosRecividos(int numMaxRecividos){
        if(articulosRecividos.size()>numMaxRecepcion){
            return false;
        }
        return true;    
    }

    public String toStringBasic(){
        return nombre + "/t" + pais + "/t"  + ciudad + "/t" + temas;
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author Ashlee Campaz
 */

public class Conferencia {
    private Long id; 
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
    private List<Integer> articulosRecibidos;

    public Conferencia(String nombre, String temas, String entidadOrganizadora, String pais, String estado,
            String ciudad, String direccion, Fecha fechaFin, Fecha fechaInicio, Fecha fechaFinRecepcion,
            Fecha fechaFinEvaluacion, int numMaxRecepcion, int numMaxAceptacion, float calificacionMinAceptable,
            List<Integer> articulosAceptados, List<Integer> articulosRecibidos) {
        
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
        this.articulosAceptados = articulosAceptados;
        this.articulosRecibidos = articulosRecibidos;
    }

    public Conferencia(Long id, String nombre, String temas, String entidadOrganizadora, String pais, String estado,
            String ciudad, String direccion, Fecha fechaFin, Fecha fechaInicio, Fecha fechaFinRecepcion,
            Fecha fechaFinEvaluacion, int numMaxRecepcion, int numMaxAceptacion, float calificacionMinAceptable,
            List<Integer> articulosAceptados, List<Integer> articulosRecibidos) {
        this.id = id;
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
        this.articulosAceptados = articulosAceptados;
        this.articulosRecibidos = articulosRecibidos;
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
        if(articulosRecibidos.size()>numMaxRecepcion){
            return false;
        }
        return true;    
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getEntidadOrganizadora() {
        return entidadOrganizadora;
    }

    public void setEntidadOrganizadora(String entidadOrganizadora) {
        this.entidadOrganizadora = entidadOrganizadora;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Fecha getFechaFinRecepcion() {
        return fechaFinRecepcion;
    }

    public void setFechaFinRecepcion(Fecha fechaFinRecepcion) {
        this.fechaFinRecepcion = fechaFinRecepcion;
    }

    public Fecha getFechaFinEvaluacion() {
        return fechaFinEvaluacion;
    }

    public void setFechaFinEvaluacion(Fecha fechaFinEvaluacion) {
        this.fechaFinEvaluacion = fechaFinEvaluacion;
    }

    public int getNumMaxRecepcion() {
        return numMaxRecepcion;
    }

    public void setNumMaxRecepcion(int numMaxRecepcion) {
        this.numMaxRecepcion = numMaxRecepcion;
    }

    public int getNumMaxAceptacion() {
        return numMaxAceptacion;
    }

    public void setNumMaxAceptacion(int numMaxAceptacion) {
        this.numMaxAceptacion = numMaxAceptacion;
    }

    public float getCalificacionMinAceptable() {
        return calificacionMinAceptable;
    }

    public void setCalificacionMinAceptable(float calificacionMinAceptable) {
        this.calificacionMinAceptable = calificacionMinAceptable;
    }

    public List<Integer> getArticulosRecibidos() {
        return articulosRecibidos;
    }

    public void setArticulosRecibidos(List<Integer> articulosRecibidos) {
        this.articulosRecibidos = articulosRecibidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "{" +
                "\"nombre\":\"" + nombre + "\"," +
                "\"temas\":\"" + temas + "\"," +
                "\"entidadOrganizadora\":\"" + entidadOrganizadora + "\"," +
                "\"pais\":\"" + pais + "\"," +
                "\"estado\":\"" + estado + "\"," +
                "\"ciudad\":\"" + ciudad + "\"," +
                "\"direccion\":\"" + direccion + "\"," +
                "\"fechaFin\":\"" + fechaFin.toString() + "\"," +
                "\"fechaInicio\":\"" + fechaInicio.toString() + "\"," +
                "\"fechaFinRecepcion\":\"" + fechaFinRecepcion.toString() + "\"," +
                "\"fechaFinEvaluacion\":\"" + fechaFinEvaluacion.toString() + "\"," +
                "\"numMaxRecepcion\":" + numMaxRecepcion + "," +
                "\"numMaxAceptacion\":" + numMaxAceptacion + "," +
                "\"calificacionMinAceptable\":" + calificacionMinAceptable + "," +
                "\"articulosAceptados\":[" + listToJson(articulosAceptados) + "]," +
                "\"articulosRecibidos\":[" + listToJson(articulosRecibidos) + "]" +
                "}";
    }
    
    private String listToJson(List<Integer> list) {
        return list == null ? "" : list.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
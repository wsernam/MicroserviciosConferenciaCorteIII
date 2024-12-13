/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.mapper;

import com.apigateway.DTOs.DTOPeticion;
import com.apigateway.DTOs.DTORespuesta;
import com.apigateway.entities.Conferencia;
import com.apigateway.entities.Fecha;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ashlee Campaz
 */
public class DTOConferenciaMapper {
    
    public static Conferencia mappearDTOPeticion(DTOPeticion objConferencia){
        String nombre = objConferencia.getNombre();
        String temas = objConferencia.getTemas();
        String entidadOrganizadora = objConferencia.getEntidadOrganizadora();
        String pais = objConferencia.getPais();
        String estado = objConferencia.getEstado();
        String ciudad = objConferencia.getCiudad();
        String direccion = objConferencia.getDireccion();
        
        Fecha fechaFin = new Fecha(objConferencia.getFechaFin());
        Fecha fechaInicio = new Fecha (objConferencia.getFechaInicio());
        Fecha fechaFinRecepcion = new Fecha (objConferencia.getFechaFinRecepcion()); 
        Fecha fechaFinEvaluacion = new Fecha (objConferencia.getFechaFinEvaluacion());
        int numMaxRecepcion = objConferencia.getNumMaxAceptacion();
        int numMaxAceptacion = objConferencia.getNumMaxAceptacion();
        float calificacionMinAceptable = objConferencia.getCalificacionMinAceptable();
        return new Conferencia (nombre,  temas,  entidadOrganizadora,  pais,  estado,  ciudad,  direccion,  fechaFin,  fechaInicio,  fechaFinRecepcion,  fechaFinEvaluacion,  numMaxRecepcion,  numMaxAceptacion,  calificacionMinAceptable, new ArrayList(), new ArrayList());
    
    }
    
    public static Conferencia mappearDTORespuesta(DTORespuesta objConferencia){
        Long id = objConferencia.getId();
        String nombre = objConferencia.getNombre();
        String temas = objConferencia.getTemas();
        String entidadOrganizadora = objConferencia.getEntidadOrganizadora();
        String pais = objConferencia.getPais();
        String estado = objConferencia.getEstado();
        String ciudad = objConferencia.getCiudad();
        String direccion = objConferencia.getDireccion();
        
        Fecha fechaFin = new Fecha(objConferencia.getFechaFin());
        Fecha fechaInicio = new Fecha (objConferencia.getFechaInicio());
        Fecha fechaFinRecepcion = new Fecha (objConferencia.getFechaFinRecepcion()); 
        Fecha fechaFinEvaluacion = new Fecha (objConferencia.getFechaFinEvaluacion());
        int numMaxRecepcion = objConferencia.getNumMaxAceptacion();
        int numMaxAceptacion = objConferencia.getNumMaxAceptacion();
        float calificacionMinAceptable = objConferencia.getCalificacionMinAceptable();
        return new Conferencia (id, nombre,  temas,  entidadOrganizadora,  pais,  estado,  ciudad,  direccion,  fechaFin,  fechaInicio,  fechaFinRecepcion,  fechaFinEvaluacion,  numMaxRecepcion,  numMaxAceptacion,  calificacionMinAceptable, new ArrayList(), new ArrayList());
    
    }
}

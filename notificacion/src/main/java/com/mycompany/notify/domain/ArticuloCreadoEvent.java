/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author wsern
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticuloCreadoEvent {
    private int idArticulo;
    private String nombre;
    private String resumen;
    
    public ArticuloCreadoEvent(int idArticulo, String nombre, String resumen){
        this.idArticulo=idArticulo;
        this.nombre=nombre;
        this.resumen=resumen;
    }
}

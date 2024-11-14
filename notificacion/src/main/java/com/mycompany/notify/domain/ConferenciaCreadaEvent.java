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
public class ConferenciaCreadaEvent {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private int cantidadMaxArticulos;

    // Constructor, getters y setters

    public ConferenciaCreadaEvent(int id, String nombre, int cantidadMaxArticulos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaxArticulos=cantidadMaxArticulos;
    }
}

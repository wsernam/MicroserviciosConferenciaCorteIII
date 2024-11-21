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
public class Conference {
     private static final long serialVersionUID = 1L;
    @Id
     private int id;
    private String nombre;
    private int cantidadMaxArticulos;
    private List<Articulo> articuloList= new ArrayList<>();

    public Conference() {
    }

    public Conference( String nombre, int cantidadMaxArticulos) {
        this.nombre = nombre;
        this.cantidadMaxArticulos = cantidadMaxArticulos;
    }

    @Override
    public String toString() {
        return "Conference{" + "id=" + id + ", nombre=" + nombre + ", cantidadMaxArticulos=" + cantidadMaxArticulos + '}';
    }
    
    public String toStringBasic(){
        return "Conferencia"; 
    }
}

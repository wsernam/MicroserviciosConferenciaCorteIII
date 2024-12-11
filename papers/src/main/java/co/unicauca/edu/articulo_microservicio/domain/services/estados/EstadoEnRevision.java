/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services.estados;

import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;

/**
 *
 * @author wsern
 */
public class EstadoEnRevision implements EstadoRevision {

    @Override
    public void iniciarRevision(Articulo articulo) {
        System.out.println("El artículo ya está en proceso de revisión.");
    }

    @Override
    public void completarRevision(Articulo articulo) {
        System.out.println("Revisión del artículo completada: " + articulo.getNombre());
        articulo.setEstadoActual((EstadoRevision) new EstadoRevisado());
    }

    @Override
    public void revisarEstado(Articulo articulo) {
        System.out.println("El artículo está siendo revisado.");
    }
}


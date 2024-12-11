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
public class EstadoRevisado implements EstadoRevision {

    @Override
    public void iniciarRevision(Articulo articulo) {
        System.out.println("No se puede iniciar revisión para un artículo ya revisado.");
    }

    @Override
    public void completarRevision(Articulo articulo) {
        System.out.println("El artículo ya ha sido revisado.");
    }

    @Override
    public void revisarEstado(Articulo articulo) {
        System.out.println("El artículo ha sido revisado.");
    }
}


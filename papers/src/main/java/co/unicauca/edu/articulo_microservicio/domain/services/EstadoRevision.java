/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;

/**
 *
 * @author wsern
 */
public interface EstadoRevision {
    void iniciarRevision(Articulo articulo);
    void completarRevision(Articulo articulo);
    void revisarEstado(Articulo articulo);
}


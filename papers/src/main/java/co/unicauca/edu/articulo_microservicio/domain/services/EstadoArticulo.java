/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.domain.services.estados.Resultado;
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;

/**
 *
 * @author wsern
 */
public interface EstadoArticulo {
    Resultado enviarAEvaluacion(Articulo articulo);
    Resultado formularConObservaciones(Articulo articulo);
    Resultado aprobar(Articulo articulo);
    Resultado rechazar(Articulo articulo);
}


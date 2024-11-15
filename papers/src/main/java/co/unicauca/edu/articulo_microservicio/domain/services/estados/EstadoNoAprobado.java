/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services.estados;

import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoArticulo;

/**
 *
 * @author wsern
 */
public class EstadoNoAprobado implements EstadoArticulo {
    @Override
    public Resultado enviarAEvaluacion(Articulo articulo) {
        return new Resultado(false, "No se puede cambiar el estado de un artículo no aprobado.");
    }

    @Override
    public Resultado aprobar(Articulo articulo) {
        return new Resultado(false, "No se puede cambiar el estado de un artículo no aprobado.");
    }

    @Override
    public Resultado formularConObservaciones(Articulo articulo) {
        return new Resultado(false, "No se puede cambiar el estado de un artículo no aprobado.");
    }

    @Override
    public Resultado rechazar(Articulo articulo) {
        return new Resultado(false, "El artículo ya está en estado de no aprobado.");
    }

    @Override
    public String toString() {
        return "No Aprobado";
    }
}

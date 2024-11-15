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
public class EstadoFormuladoConObservaciones implements EstadoArticulo {
    @Override
    public Resultado enviarAEvaluacion(Articulo articulo) {
        EstadoArticulo nuevoEstado = new EstadoEnEvaluacion();
        articulo.setEstado(nuevoEstado);
        return new Resultado(true, "Estado cambiado a evaluación de manera exitosa.");
    }

    @Override
    public Resultado aprobar(Articulo articulo) {
        return new Resultado(false, "Un artículo formulado con observaciones no puede directamente aprobarse.");
    }

    @Override
    public Resultado formularConObservaciones(Articulo articulo) {
        return new Resultado(false, "A un artículo formulado con observaciones no se le pueden fijar observaciones adicionales.");
    }

    @Override
    public Resultado rechazar(Articulo articulo) {
        EstadoArticulo nuevoEstado = new EstadoNoAprobado();
        articulo.setEstado(nuevoEstado);
        return new Resultado(true, "Estado cambiado a no aprobado de manera exitosa.");
    }

    @Override
    public String toString() {
        return "Formulado con Observaciones";
    }
}


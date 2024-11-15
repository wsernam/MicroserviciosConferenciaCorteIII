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
public class EstadoAprobado implements EstadoArticulo {
    @Override
    public Resultado enviarAEvaluacion(Articulo articulo) {
        return new Resultado(false, "Un artículo aprobado no se puede enviar a evaluación.");
    }

    @Override
    public Resultado aprobar(Articulo articulo) {
        return new Resultado(false, "Un artículo aprobado no puede volver a aprobarse.");
    }

    @Override
    public Resultado formularConObservaciones(Articulo articulo) {
        return new Resultado(false, "Un artículo aprobado no puede tener observaciones.");
    }

    @Override
    public Resultado rechazar(Articulo articulo) {
        return new Resultado(false, "Un artículo aprobado no puede no aprobarse.");
    }

    @Override
    public String toString() {
        return "Aprobado";
    }
}

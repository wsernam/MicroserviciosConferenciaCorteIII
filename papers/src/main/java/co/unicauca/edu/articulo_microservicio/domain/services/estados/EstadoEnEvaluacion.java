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
public class EstadoEnEvaluacion implements EstadoArticulo {
    @Override
    public Resultado enviarAEvaluacion(Articulo articulo) {
        return new Resultado(false, "Un artículo en evaluación no se puede enviar a evaluación nuevamente.");
    }

    @Override
    public Resultado aprobar(Articulo articulo) {
        EstadoArticulo nuevoEstado = new EstadoAprobado();
        articulo.setEstado(nuevoEstado);
        return new Resultado(true, "Estado cambiado a aprobado de manera exitosa.");
    }

    @Override
    public Resultado formularConObservaciones(Articulo articulo) {
        EstadoArticulo nuevoEstado = new EstadoFormuladoConObservaciones();
        articulo.setEstado(nuevoEstado);
        return new Resultado(true, "Estado cambiado a formulado con observaciones de manera exitosa.");
    }

    @Override
    public Resultado rechazar(Articulo articulo) {
        EstadoArticulo nuevoEstado = new EstadoNoAprobado();
        articulo.setEstado(nuevoEstado);
        return new Resultado(true, "Estado cambiado a no aprobado de manera exitosa.");
    }

    @Override
    public String toString() {
        return "En Evaluación";
    }
}

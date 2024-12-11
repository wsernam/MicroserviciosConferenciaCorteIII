/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.domain.models.Calificacion;
import java.util.List;

/**
 *
 * @author wsern
 */
public interface ICalificacionService {
    Calificacion registrarCalificacion(Calificacion calificacion);
    List<Calificacion> obtenerCalificacionesPorArticulo(int idArticulo);
    double calcularPromedio(int idArticulo);
    boolean evaluadorYaCalifico(int idEvaluador, int idArticulo); // Método adicional
}

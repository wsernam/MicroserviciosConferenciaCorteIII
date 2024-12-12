/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.api.controllers;
import co.unicauca.edu.articulo_microservicio.domain.services.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private ICalificacionService calificacionService;

    /*@PostMapping("/{idArticulo}/evaluadores/{idEvaluador}")
    public String registrarCalificacion(
        @PathVariable int idArticulo,
        @PathVariable int idEvaluador,
        @RequestParam String nombreEvaluador,
        @RequestParam int calificacion
    ) {
        // Buscar el artículo (esto depende de tu capa de persistencia)
        Articulo articulo = buscarArticuloPorId(idArticulo);

        if (articulo == null) {
            return "El artículo con ID " + idArticulo + " no existe.";
        }

        calificacionService.agregarCalificacion(articulo, idEvaluador, nombreEvaluador, calificacion);
        return "Calificación registrada exitosamente.";
    }

    @GetMapping("/{idArticulo}/promedio")
    public double obtenerPromedioCalificacion(@PathVariable int idArticulo) {
        Articulo articulo = buscarArticuloPorId(idArticulo);

        if (articulo == null) {
            throw new RuntimeException("El artículo con ID " + idArticulo + " no existe.");
        }

        return calificacionService.calcularPromedio(articulo);
    }

    //Simulación de búsqueda de artículos
     Articulo buscarArticuloPorId(int idArticulo) {
        // Aquí deberías implementar la búsqueda real desde la base de datos
        //return new Articulo(idArticulo, "Ejemplo", "Descripción del artículo");
    }*/
}


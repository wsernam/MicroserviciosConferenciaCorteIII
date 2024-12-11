package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.domain.models.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import co.unicauca.edu.articulo_microservicio.infrastructure.repositories.ICalificacionRepository;

@Service
public class CalificacionServicempl implements ICalificacionService {

    @Autowired
     private ICalificacionRepository calificacionRepository;
    @Override
    public Calificacion registrarCalificacion(Calificacion calificacion) {
        // Validar si el evaluador ya calificó el artículo
        if (evaluadorYaCalifico(calificacion.getIdEvaluador(), calificacion.getIdCalificacion())) {
            throw new IllegalArgumentException("El evaluador ya calificó este artículo y no puede volver a hacerlo.");
        }

        // Registrar la nueva calificación
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorArticulo(int idArticulo) {
        return calificacionRepository.findByArticuloId(idArticulo);
    }

    @Override
    public double calcularPromedio(int idArticulo) {
        List<Calificacion> calificaciones = calificacionRepository.findByArticuloId(idArticulo);
        return calificaciones.stream().mapToDouble(Calificacion::getCalificacion).average().orElse(0.0);
    }

    @Override
    public boolean evaluadorYaCalifico(int idEvaluador, int idArticulo) {
        return calificacionRepository.existsByIdEvaluadorAndArticuloId(idEvaluador, idArticulo);
    }
}

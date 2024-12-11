package co.unicauca.edu.articulo_microservicio.infrastructure.repositories;

import co.unicauca.edu.articulo_microservicio.domain.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ICalificacionRepository extends JpaRepository<Calificacion, Integer> {
    List<Calificacion> findByArticuloId(int idArticulo);
    boolean existsByIdEvaluadorAndArticuloId(int idEvaluador, int idArticulo);
}

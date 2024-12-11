package co.unicauca.edu.articulo_microservicio.infrastructure.repositories;

import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author sonhuila
 */

public interface IArticuloRepository extends JpaRepository<Articulo, Integer>{
}

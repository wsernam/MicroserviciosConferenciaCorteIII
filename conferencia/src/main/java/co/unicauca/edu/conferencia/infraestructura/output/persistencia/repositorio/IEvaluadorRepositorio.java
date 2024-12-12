package co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaEvaluador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sonhuila
 */
public interface IEvaluadorRepositorio extends JpaRepository<PersistenciaEvaluador, Integer> {
}

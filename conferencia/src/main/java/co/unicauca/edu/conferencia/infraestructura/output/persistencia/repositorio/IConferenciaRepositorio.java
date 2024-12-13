package co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;
import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaEvaluador;

public interface IConferenciaRepositorio extends JpaRepository<PersistenciaConferencia, Integer> {
   
}

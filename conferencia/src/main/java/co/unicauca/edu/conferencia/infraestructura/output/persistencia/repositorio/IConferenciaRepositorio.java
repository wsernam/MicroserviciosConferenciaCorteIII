package co.unicauca.edu.conferencia.infraestructura.output.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades.PersistenciaConferencia;

public interface IConferenciaRepositorio extends JpaRepository<PersistenciaConferencia, Integer> {
    
}

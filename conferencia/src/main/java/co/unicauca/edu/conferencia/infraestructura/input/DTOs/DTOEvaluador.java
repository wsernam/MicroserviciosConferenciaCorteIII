package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sonhuila
 */
@Getter
@Setter
@AllArgsConstructor
public class DTOEvaluador {

    private Integer idEvaluador;
    private String nombre;
    private String especialidad;
    private Integer idConferencia; // La conferencia a la que se postula

    public DTOEvaluador() {
    }
}

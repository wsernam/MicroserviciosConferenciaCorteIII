package co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades desconocidas
public class ConferenciaDTO {
    private Integer id;
    
    public ConferenciaDTO()
    {
    }
}


package co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO;

import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import java.util.List;

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
public class ArticuloConConferenciasDTO {
    private ArticuloDTO objArticuloDTO;
    private List<ConferenciaDTO> conferencias;
}

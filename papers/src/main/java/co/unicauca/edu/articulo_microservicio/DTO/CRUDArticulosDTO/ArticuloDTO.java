package co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author sonhuila
 */
@Getter 
@Setter 
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades desconocidas
public class ArticuloDTO {
    private static final long serialVersionUID = 1L;
    private Integer idArticulo;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
    private List<ConferenciaDTO> objConferencias;
    // Agregar lista de calificaciones
    private List<CalificacionDTO> calificaciones;
    
    public ArticuloDTO()
    {
    }
}

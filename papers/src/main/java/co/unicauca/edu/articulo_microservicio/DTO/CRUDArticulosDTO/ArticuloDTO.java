package co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO;

import co.unicauca.edu.articulo_microservicio.domain.models.AppUser;
import co.unicauca.edu.articulo_microservicio.domain.models.Calificacion;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
    private Integer id;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
    private List<Calificacion> calificaciones;
    private Long idConferencia;
    private EstadoRevision estadoActual;
    
    public ArticuloDTO()
    {
    }
}

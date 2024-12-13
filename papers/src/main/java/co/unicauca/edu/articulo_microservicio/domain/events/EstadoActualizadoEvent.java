package co.unicauca.edu.articulo_microservicio.domain.events;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wsern
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoActualizadoEvent implements Serializable{
    private int idArticulo;              // ID del artículo
    private String tituloArticulo;       // Título del artículo
    private String estadoAnterior;    // Estado anterior del artículo
    private String estadoActual;      // Estado actual del artículo
    private Integer idEvaluador;   // Lista de evaluadores asignados
    private String EvaluadorNombre;
    private String EvaluadorCorreo;
    private Integer idAutor;              // ID del autor del artículo
    private String nombreAutor;       // Nombre del autor del artículo
    private String correoAutor;       // Correo del autor
}
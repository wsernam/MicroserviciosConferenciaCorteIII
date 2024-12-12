package com.mycompany.notify.domain.Eventos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.notify.domain.Evaluador;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wsern
 */
/**
 * Evento que representa el cambio de estado de un artículo (paper).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticuloEstadoActualizadoEvent {
    private int idArticulo;              // ID del artículo
    private String tituloArticulo;       // Título del artículo
    private String estadoAnterior;    // Estado anterior del artículo
    private String estadoActual;      // Estado actual del artículo
    private List<Evaluador> evaluadores;   // Lista de evaluadores asignados
    private int idAutor;              // ID del autor del artículo
    private String nombreAutor;       // Nombre del autor del artículo
    private String correoAutor;       // Correo del autor
}

package co.unicauca.edu.articulo_microservicio.DTO;

import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class ArticuloDeConferenciaDTO {
    private Integer id;
    private Integer Conferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    private String estadoActual;
    public ArticuloDeConferenciaDTO() {
    }
    
    
}

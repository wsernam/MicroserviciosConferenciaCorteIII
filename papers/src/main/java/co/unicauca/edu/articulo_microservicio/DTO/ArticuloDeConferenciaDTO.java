package co.unicauca.edu.articulo_microservicio.DTO;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class ArticuloDeConferenciaDTO {
    private Integer id;
    private Long idConferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public ArticuloDeConferenciaDTO() {
    }
    
    
}

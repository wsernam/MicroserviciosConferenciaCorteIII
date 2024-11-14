package co.unicauca.edu.articulo_microservicio.domain.events;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ArticuloCreadoEvent implements Serializable{
    
    private Integer idArticulo;
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;
    
    public ArticuloCreadoEvent(){
    }
}

package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class DTOEntradaEvaluador {
    //Emplear los mismos campos que se usan en 
    //el usuario que llega desde el exterior al constructor
    //En el controlador esta entidad se mapea a Evaluador del dominio
  //El evaluaor se gyarda en jpa pero sin ningun tipo de relacion con otra entidad 
  //para evitar conflictos con el mapeo hacia el dominio

    private Long id;
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization; 
    private List<String> researchfields;
    public DTOEntradaEvaluador() {
    }
     
}

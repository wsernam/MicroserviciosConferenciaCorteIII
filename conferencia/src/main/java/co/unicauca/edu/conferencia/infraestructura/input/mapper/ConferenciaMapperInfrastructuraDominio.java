package co.unicauca.edu.conferencia.infraestructura.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOArticulo;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOEvaluador;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOPeticion;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTORespuesta;

@Mapper(componentModel = "spring")

public interface ConferenciaMapperInfrastructuraDominio {
 
    Conferencia mappearDePeticionAConferencia(DTOPeticion peticion);
 
    DTORespuesta mappearDeConferenciaARespuesta(Conferencia objConferencia);

    
    List<DTORespuesta> mappearDeConferenciasARespuesta(List<Conferencia> Conferencias);
 
  
    Articulo mappearDeDTOArticuloAArticulo(DTOArticulo articuloDTO);
    DTOArticulo mappearDeArticuloADTOArticulo(Articulo articuloDTO);
    Evaluador mappearDeDTOEntradaEvaluadorAEvaluador(DTOEvaluador evaluadorDTO);
    
   
     
    


}






    

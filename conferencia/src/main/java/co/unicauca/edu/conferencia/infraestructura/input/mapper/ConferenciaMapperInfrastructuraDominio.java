package co.unicauca.edu.conferencia.infraestructura.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Conferencia;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOArticulo;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOPeticion;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTORespuesta;

/**
 * Interfaz de mapeador para convertir entre el modelo de dominio y las representaciones DTO 
 * (Objetos de Transferencia de Datos) de la entidad Conferencia.
 * 
 * Esta interfaz proporciona métodos para mapear datos entre DTOs y modelos de dominio, 
 * facilitando la comunicación entre diferentes capas de la aplicación.
 * 
 * La anotación @Mapper se utiliza para generar automáticamente la implementación de esta interfaz 
 * en tiempo de compilación con MapStruct. 
 * 
 * - La implementación generada se registrará como un bean de Spring, lo que permite su inyección 
 *   como dependencia en otras clases.
 * - El atributo `componentModel = "spring"` especifica que el mapeador generado será administrado 
 *   por el contenedor de inyección de dependencias de Spring.
 */
@Mapper(componentModel = "spring")

public interface ConferenciaMapperInfrastructuraDominio {
   /**
     * Mapea un ConferenciaDTOPeticion (DTO de solicitud) al modelo de dominio Conferencia.
     * 
     * @param peticion El objeto ConferenciaDTOPeticion que representa la solicitud del cliente.
     * @return El objeto Conferencia que representa el modelo de dominio.
     */
    Conferencia mappearDePeticionAConferencia(DTOPeticion peticion);

    /**
     * Mapea un Conferencia (modelo de dominio) a un ConferenciaDTORespuesta (DTO de respuesta).
     * 
     * @param objConferencia El objeto Conferencia que representa el modelo de dominio.
     * @return El objeto ConferenciaDTORespuesta que representa la respuesta para enviar al cliente.
     */
    DTORespuesta mappearDeConferenciaARespuesta(Conferencia objConferencia);

    /**
     * Mapea una lista de modelos de dominio Conferencia a una lista de DTOs de respuesta ConferenciaDTORespuesta.
     * 
     * @param Conferencias La lista de objetos Conferencia que representan los modelos de dominio.
     * @return La lista de objetos ConferenciaDTORespuesta que representan la respuesta para enviar al cliente.
     */
    List<DTORespuesta> mappearDeConferenciasARespuesta(List<Conferencia> Conferencias);
 
    Articulo mappearDeDTOArticuloAArticulo(DTOArticulo articuloDTO);

   
     
    


}






    

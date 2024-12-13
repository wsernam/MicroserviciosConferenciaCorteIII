package co.unicauca.edu.articulo_microservicio.domain.services;

import java.util.List;

import org.modelmapper.ModelMapper;

import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import reactor.core.publisher.Mono;

public interface IConferenciaService {
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo);
       
    public void enviarArticuloAConferencia(ArticuloDTO articulo);
    
}

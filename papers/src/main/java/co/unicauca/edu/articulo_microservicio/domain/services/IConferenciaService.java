package co.unicauca.edu.articulo_microservicio.domain.services;

import java.util.List;


import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;

public interface IConferenciaService {
    
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo);
    public boolean verificarConferencia(Integer idConferencia);
    public void enviarArticuloAConferencia(ArticuloDTO articulo);
    
}

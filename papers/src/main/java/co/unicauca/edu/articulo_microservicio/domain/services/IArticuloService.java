package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ArticuloConConferenciasDTO;
import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.AppUserDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;

import java.util.List;

/**
 *
 * @author sonhuila
 */
public interface IArticuloService {

    public List<ArticuloDTO> findAll();

    public ArticuloDTO findById(Integer id);

    public boolean existsById(Integer id);

    public ArticuloDTO save(ArticuloDTO articulo);

    public ArticuloDTO update(Integer id, ArticuloDTO articulo);

    public boolean delete(Integer id);

    public List<ConferenciaDTO> ListarConferenciasDeArticulo(Integer idArticulo);

    public ArticuloConConferenciasDTO listarDatosrticuloConSusConferencias(Integer idArticulo);
    
    public void actualizarEstadoArticulo(Integer id, EstadoRevision nuevoEstado);
    
    public AppUserDTO obtenerUsuarioPorId(Integer idUsuario);
}

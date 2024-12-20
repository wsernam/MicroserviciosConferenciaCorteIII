package co.unicauca.edu.articulo_microservicio.api.controllers;

import co.unicauca.edu.articulo_microservicio.domain.models.AppUser;
import co.unicauca.edu.articulo_microservicio.domain.services.IArticuloService;
import co.unicauca.edu.articulo_microservicio.domain.services.IConferenciaService;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.domain.services.EstadoRevision;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author sonhuila
 */
@RestController
@RequestMapping("/api")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;
    @Autowired
    private IConferenciaService conferenciaService;

    /*Recibe articulo a registrar y retorna el articulo registrado*/
    @PostMapping("/articulos")
    public ResponseEntity<ArticuloDTO> crearArticulo(@RequestBody ArticuloDTO articulo) {
        // Verificar si la conferencia existe
        boolean existeConferencia = conferenciaService.verificarConferencia(articulo.getIdConferencia());
    
        if (!existeConferencia) {
            throw new RuntimeException("La conferencia con ID " + articulo.getIdConferencia() + " no existe.");
        }
    
        // Si la conferencia existe, guarda el artículo
        ArticuloDTO objArticulo = articuloService.save(articulo);
    
        // Asociar el artículo con la conferencia
        conferenciaService.enviarArticuloAConferencia(objArticulo);
    
        return ResponseEntity.ok(objArticulo);
    }

    /*Recibe ID de articulo y retorna el articulo que corresponde al ID*/
    @GetMapping("/articulos/{id}")
    public ArticuloDTO consultarArticulo(@PathVariable Integer id) {
        ArticuloDTO objArticulo = null;
        objArticulo = articuloService.findById(id);
        return objArticulo;
    }

    /*retorna una lista de articulos registrados*/
    @GetMapping("/articulos")
    public List<ArticuloDTO> listarArticulo() {
        return articuloService.findAll();
    }

    /*recibe el ID del articulo a actualizar y los nuevos datos, y retorna articulo actualizado*/
    @PutMapping("/articulos/{id}")
    public ArticuloDTO actualizarArticulo(@RequestBody ArticuloDTO articulo, @PathVariable Integer id) {
        ArticuloDTO objArticulo = null;
        ArticuloDTO articuloActual = articuloService.findById(id);
        if (articuloActual != null) {
            objArticulo = articuloService.update(id, articulo);
        }
        return objArticulo;
    }

    /*recibe ID del articulo a eliminar y retorna true o false si se elimino*/
    @DeleteMapping("/articulos/{id}")
    public Boolean eliminarArticulo(@PathVariable Integer id) {
        Boolean bandera = false;
        ArticuloDTO articuloActual = articuloService.findById(id);
        if (articuloActual != null) {
            bandera = articuloService.delete(id);
        }
        return bandera;
    }

    /*recibe el ID del articulo y retorna true o false si existe*/
    @GetMapping("/existe")
    public Boolean existeArticulo(@RequestParam Integer id) {
        Boolean bandera = articuloService.existsById(id);
        return bandera;
    }
    
    //actualiza estado de articulo
    @PutMapping("/{id}/estado")
    public ResponseEntity<Void> actualizarEstado(@PathVariable Integer id, @RequestParam EstadoRevision nuevoEstado) {
        articuloService.actualizarEstadoArticulo(id, nuevoEstado);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<AppUser> obtenerUsuarioPorId(@PathVariable Integer idUsuario) {
        try {
            // Llamar al servicio para obtener el usuario
            AppUser usuario = articuloService.obtenerUsuarioPorId(idUsuario);
            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            // Manejo de excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}

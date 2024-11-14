package co.unicauca.edu.articulo_microservicio;

import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.api.controllers.ArticuloController;
import co.unicauca.edu.articulo_microservicio.domain.services.IArticuloService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author sonhuila
 */
public class ArticuloControllerTest {

    @Mock
    private IArticuloService articuloService;

    @InjectMocks
    private ArticuloController articuloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearArticulo() {
        // Datos de entrada para el test
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setIdArticulo(1);
        articuloDTO.setNombre("Título del Artículo");
        articuloDTO.setAutores(new ArrayList<>(List.of("Autor 1", "Autor 2")));
        articuloDTO.setResumen("Este es un resumen del artículo.");
        articuloDTO.setPalabrasClaves("clave1, clave2");

        // Comportamiento esperado del servicio mock
        when(articuloService.save(articuloDTO)).thenReturn(articuloDTO);

        // Ejecución del método a probar
        ResponseEntity<ArticuloDTO> response = articuloController.crearArticulo(articuloDTO);

        // Verificaciones
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(articuloDTO, response.getBody());
    }

    @Test
    void consultarArticulo() {
        Integer idArticulo = 1;
        ArticuloDTO articulo = new ArticuloDTO();
        articulo.setIdArticulo(idArticulo);
        articulo.setNombre("Articulo Test");

        when(articuloService.findById(idArticulo)).thenReturn(articulo);

        ArticuloDTO response = articuloController.consultarArticulo(idArticulo);

        assertEquals(idArticulo, response.getIdArticulo());
        assertEquals("Articulo Test", response.getNombre());
    }
}

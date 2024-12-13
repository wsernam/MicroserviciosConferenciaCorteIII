package co.unicauca.edu.articulo_microservicio;

import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.api.controllers.ArticuloController;
import co.unicauca.edu.articulo_microservicio.domain.services.IArticuloService;
import co.unicauca.edu.articulo_microservicio.domain.services.ICalificacionService;
import co.unicauca.edu.articulo_microservicio.domain.services.IConferenciaService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ArticuloControllerTest {

    @Mock
    private IArticuloService articuloService; // Mock del servicio de artículos

    @Mock
    private ICalificacionService calificacionService; // Mock del servicio de calificaciones

    @Mock
    private IConferenciaService conferenciaService; // Mock del servicio de conferencias

    @InjectMocks
    private ArticuloController articuloController; // Inyección de mocks en el controlador

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicialización de mocks
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
        doNothing().when(conferenciaService).enviarArticuloAConferencia(articuloDTO);

        // Ejecución del método a probar
        ResponseEntity<ArticuloDTO> response = articuloController.crearArticulo(articuloDTO);

        // Verificaciones
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(articuloDTO, response.getBody());

        // Verificar que conferenciaService fue llamado
        verify(conferenciaService).enviarArticuloAConferencia(articuloDTO);
    }

    @Test
    void consultarArticulo() {
        Integer idArticulo = 1;
        ArticuloDTO articulo = new ArticuloDTO();
        articulo.setIdArticulo(idArticulo);
        articulo.setNombre("Articulo Test");

        // Comportamiento esperado del servicio mock
        when(articuloService.findById(idArticulo)).thenReturn(articulo);

        // Ejecución del método a probar
        ArticuloDTO response = articuloController.consultarArticulo(idArticulo);

        // Verificaciones
        assertEquals(idArticulo, response.getIdArticulo());
        assertEquals("Articulo Test", response.getNombre());
    }
}

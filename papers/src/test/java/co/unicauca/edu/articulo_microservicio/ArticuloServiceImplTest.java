package co.unicauca.edu.articulo_microservicio;

import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.domain.events.ArticuloCreadoEvent;
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;
import co.unicauca.edu.articulo_microservicio.domain.services.ArticuloServiceImpl;
import co.unicauca.edu.articulo_microservicio.infrastructure.rabbit.ConfigRabbitMQ;
import co.unicauca.edu.articulo_microservicio.infrastructure.repositories.IArticuloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author sonhuila
 */
public class ArticuloServiceImplTest {

    @Mock
    private IArticuloRepository servicioAccesoBaseDatos;

    @Mock
    private ModelMapper modelMapper;
    
    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private ArticuloServiceImpl articuloService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        // Crear el ArticuloDTO que se va a guardar
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setId(1);
        articuloDTO.setNombre("Título del Artículo");
        articuloDTO.setAutores(new ArrayList<>(List.of("Autor 1", "Autor 2")));
        articuloDTO.setResumen("Este es un resumen del artículo.");
        articuloDTO.setPalabrasClaves("clave1, clave2");

        // Crear el Articulo que se va a retornar del repositorio
        Articulo articuloEntity = new Articulo();
        articuloEntity.setId(1);
        articuloEntity.setNombre("Título del Artículo");
        articuloEntity.setAutores(new ArrayList<>(List.of("Autor 1", "Autor 2")));
        articuloEntity.setResumen("Este es un resumen del artículo.");
        articuloEntity.setPalabrasClaves("clave1, clave2");

        // Configurar el comportamiento del modelMapper y del repositorio
        when(modelMapper.map(articuloDTO, Articulo.class)).thenReturn(articuloEntity);
        when(servicioAccesoBaseDatos.save(articuloEntity)).thenReturn(articuloEntity);
        when(modelMapper.map(articuloEntity, ArticuloDTO.class)).thenReturn(articuloDTO);

        // Ejecutar el método a probar
        ArticuloDTO resultado = articuloService.save(articuloDTO);

        // Verificaciones
        assertEquals(articuloDTO, resultado);
        verify(servicioAccesoBaseDatos, times(1)).save(articuloEntity);

        // Verificar que se envió el evento a RabbitMQ
        ArticuloCreadoEvent eventoEsperado = new ArticuloCreadoEvent(
                articuloEntity.getId(),
                articuloEntity.getNombre(),
                articuloEntity.getAutores(),
                articuloEntity.getResumen(),
                articuloEntity.getPalabrasClaves()
        );
        verify(rabbitTemplate, times(1)).convertAndSend(
                ConfigRabbitMQ.ARTICULO_EXCHANGE,
                ConfigRabbitMQ.ARTICULO_ROUTING_KEY,
                eventoEsperado
        );
    }

    @Test
    void findById() {
        Integer idArticulo = 1;
        Articulo articulo = new Articulo();
        articulo.setId(idArticulo);
        articulo.setNombre("Articulo Test");

        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setId(idArticulo);
        articuloDTO.setNombre("Articulo Test");

        when(servicioAccesoBaseDatos.findById(idArticulo)).thenReturn(Optional.of(articulo));
        when(modelMapper.map(articulo, ArticuloDTO.class)).thenReturn(articuloDTO);

        ArticuloDTO result = articuloService.findById(idArticulo);

        assertEquals("Articulo Test", result.getNombre());
    }
}


import co.unicauca.edu.conferencia.aplicación.puertos.input.PuertoGestionConferencia;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import co.unicauca.edu.conferencia.infraestructura.input.DTOs.DTOEvaluador;
import co.unicauca.edu.conferencia.infraestructura.input.controladores.ControladorConferencia;
import co.unicauca.edu.conferencia.infraestructura.input.mapper.ConferenciaMapperInfrastructuraDominio;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PostularEvaluadorTest {

    private MockMvc mockMvc;

    @Mock
    private ConferenciaMapperInfrastructuraDominio objMapeador;

    @Mock
    private PuertoGestionConferencia objGestionConferenciaDom;

    @BeforeEach
    void setUp() {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

        // Crear instancia del controlador con mocks
        ControladorConferencia controlador = new ControladorConferencia(objMapeador, objGestionConferenciaDom);

        // Configurar MockMvc con controlador
        mockMvc = MockMvcBuilders.standaloneSetup(controlador).build();
    }

    @Test
    void testPostularEvaluador() throws Exception {
        // Configurar el comportamiento de los mocks
        DTOEvaluador evaluadorDTO = new DTOEvaluador(1L, "John", "Doe", "USA", "john.doe@example.com",
                "Tech University", List.of("Artificial Intelligence", "Machine Learning"), 101);

        Evaluador evaluador = new Evaluador(1L, "John", "Doe", "USA", "john.doe@example.com",
                "Tech University", List.of("Artificial Intelligence", "Machine Learning"), 101);

        when(objMapeador.mappearDeDTOEntradaEvaluadorAEvaluador(evaluadorDTO)).thenReturn(evaluador);
        doNothing().when(objGestionConferenciaDom).postularEvaluador(evaluador);

        // Ejecutar la solicitud HTTP y verificar el resultado
        mockMvc.perform(post("/api/Conferencia/PostularEvaluador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(evaluadorDTO)))
                .andExpect(status().isCreated());

        // Verificar que los mocks fueron llamados correctamente
        verify(objMapeador, times(1)).mappearDeDTOEntradaEvaluadorAEvaluador(evaluadorDTO);
        verify(objGestionConferenciaDom, times(1)).postularEvaluador(evaluador);
    }
}

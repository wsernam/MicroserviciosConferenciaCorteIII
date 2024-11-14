/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.notify;

import com.mycompany.notify.application.NotifyServices;
import com.mycompany.notify.controller.NotificacionController;
import com.mycompany.notify.domain.Notify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NotifyMicroserviceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private NotifyServices notifyServices;

    @InjectMocks
    private NotificacionController notificacionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEnviarCorreoSuccess() throws Exception {
        // Simulamos que el servicio de envío de correo no lanza excepciones
        doNothing().when(notifyServices).enviarNotificacion("test@example.com", "Test Subject", "Test Message");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/notificaciones/enviar-correo")
                .param("destinatario", "test@example.com")
                .param("asunto", "Test Subject")
                .param("mensaje", "Test Message")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Correo enviado exitosamente."));
    }
    

}

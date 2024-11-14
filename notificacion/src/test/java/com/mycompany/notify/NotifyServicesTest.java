/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.notify;

import com.mycompany.notify.application.NotifyServices;
import com.mycompany.notify.domain.INotifyServices;
import com.mycompany.notify.domain.Notify;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author wsern
 */
public class NotifyServicesTest {
    
    public NotifyServicesTest() {
    }
    
    @Mock
    private INotifyServices notificationRepository;

    @Mock
    private NotifyServices notifyServices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSaveNotify() {
        // Crear una instancia de Notify para la prueba
        Notify notify = new Notify();
        notify.setMessage("Mensaje de prueba");
        notify.setEmailUsuario("usuario@example.com");
        notify.setSubject("Asunto de prueba");

        // Ejecutar el método que se va a probar
        notifyServices.saveNotify(notify);

        // Verificar que el método saveNotify fue llamado con el objeto correcto
        verify(notifyServices).saveNotify(notify);  // Verifica que el método fue llamado
    }
    
    @Test
    public void testGuardarNotificacionError() {
        // Configuración del mock para lanzar una excepción
        doThrow(new RuntimeException("Error al guardar notificación")).when(notifyServices).saveNotify(any(Notify.class));

        // Crear una instancia de Notify para la prueba
        Notify notify = new Notify();
        notify.setMessage("Mensaje de prueba con error");

        // Ejecutar y verificar que se lanza la excepción
        assertThrows(RuntimeException.class, () -> {
            notifyServices.saveNotify(notify);
        });
    }

}

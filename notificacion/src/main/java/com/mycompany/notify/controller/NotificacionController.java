/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.controller;

import com.mycompany.notify.application.NotifyServices;
import com.mycompany.notify.domain.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wsern
 */
@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotifyServices notifyServices;
    
    @PostMapping("/enviar-correo")
    public ResponseEntity<String> enviarCorreo(@RequestParam String destinatario, @RequestParam String asunto, 
    @RequestParam String mensaje){
        try {
            notifyServices.enviarNotificacion(destinatario, asunto, asunto);
            return ResponseEntity.ok("Correo enviado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar el correo: " + e.getMessage());
        }
    }

    @PostMapping("/crear-notificacion")
    public ResponseEntity<String> createNotfy(@RequestParam String mensaje, 
    @RequestParam String emailUsuario, @RequestParam String asunto) {
        // Crear la notificación
        Notify notify = new Notify();
        notify.setMessage(mensaje);
        notify.setSubject(asunto);
        notify.setEmailUsuario(emailUsuario);    
        // Procesar la notificación (guardarla, enviarla, etc.)
        notifyServices.procesarNotificacion(notify);
        notifyServices.saveNotify(notify);
        // Devolver una respuesta de éxito
        return ResponseEntity.ok("Notificación enviada exitosamente");
    }

}

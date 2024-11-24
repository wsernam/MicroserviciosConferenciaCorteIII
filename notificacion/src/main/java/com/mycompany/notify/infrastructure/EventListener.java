/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.infrastructure;

import com.mycompany.notify.application.NotifyServices;
import com.mycompany.notify.domain.Eventos.ArticuloAsignadoEvent;
import com.mycompany.notify.domain.Eventos.ArticuloCreadoEvent;
import com.mycompany.notify.domain.Eventos.ConferenciaCreadaEvent;
import com.mycompany.notify.domain.Eventos.EvaluadorRegistradoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author William Andres
 */
@Component
public class EventListener {
    @Autowired
    private NotifyServices notifyServices;

    // Escuchar el evento de creación de conferencia
    @RabbitListener(queues = "conferencia-creada-queue")
    public void handleConferenciaCreada(ConferenciaCreadaEvent evento) {
        // Procesar el evento recibido y enviar la notificación
        String destinatario = evento.getCreador().getEmail(); // Notificar al creador
        String asunto = "Nueva conferencia creada: " + evento.getNombre();
        String cuerpo = String.format(
            "Hola %s, se ha creado la conferencia '%s' (ID: %d) con un máximo de %d artículos.",
            evento.getCreador().getName(),
            evento.getNombre(),
            evento.getId(),
            evento.getCantidadMaxArticulos()
        );

        System.out.println("Conferencia creada: " + evento.getNombre());

        // Enviar la notificación
        notifyServices.enviarNotificacion(destinatario, asunto, cuerpo);
    }

    // Escuchar el evento de creación de artículo
    @RabbitListener(queues = "articulo-creado-queue")
    public void handleArticuloCreado(ArticuloCreadoEvent evento) {
        // Procesar el evento recibido y enviar la notificación
        String destinatario = evento.getAutor().getEmail(); // Notificar al autor del artículo
        String asunto = "Nuevo artículo creado: " + evento.getNombre();
        String cuerpo = String.format(
            "Hola %s, se ha creado un nuevo artículo titulado '%s' (ID: %d). Resumen: %s",
            evento.getAutor().getName(),
            evento.getNombre(),
            evento.getIdArticulo(),
            evento.getResumen()
        );

        System.out.println("Artículo creado: " + evento.getNombre());

        // Enviar la notificación
        notifyServices.enviarNotificacion(destinatario, asunto, cuerpo);
    }
    
    @RabbitListener(queues = "evaluador-registrado-queue")
    public void handleEvaluadorRegistrado(EvaluadorRegistradoEvent evento) {
            // Construir el mensaje
            String mensaje = String.format(
            "Hola %s, te has registrado como evaluador en la conferencia '%s' (ID: %d). ¡Gracias por tu participación!",
            evento.getEvaluador().getName(),
            evento.getNombreConferencia(),
            evento.getIdConferencia()
        );

        // Delegar la notificación al servicio
        notifyServices.enviarNotificacion(evento.getEvaluador().getEmail(), "Registro como Evaluador", mensaje);
    }
    
    @RabbitListener(queues = "articulo-asignado-queue")
    public void handleArticuloAsignado(ArticuloAsignadoEvent evento) {
        // Construir el mensaje de notificación
        String mensaje = String.format(
            "Hola %s, %s te ha asignado el artículo '%s' (ID: %d) para evaluar en la conferencia '%s'.",
            evento.getNombreEvaluador(),
            evento.getAsignadoPor().getName(),
            evento.getTituloArticulo(),
            evento.getIdArticulo(),
            evento.getNombreConferencia()
        );

        // Enviar la notificación al evaluador
        notifyServices.enviarNotificacion(evento.getCorreoEvaluador(), "Asignación de Artículo", mensaje);
    }
}

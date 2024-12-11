/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.infrastructure;

import com.mycompany.notify.application.NotifyServices;
import com.mycompany.notify.domain.Evaluador;
import com.mycompany.notify.domain.Eventos.ArticuloAsignadoEvent;
import com.mycompany.notify.domain.Eventos.ArticuloCreadoEvent;
import com.mycompany.notify.domain.Eventos.ArticulosEstadoActualizadoEvent;
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
        String destinatario = evento.getCreador().getNombreUsuario(); // Notificar al creador
        String asunto = "Nueva conferencia creada: " + evento.getNombreConferencia();
        String cuerpo = String.format(
            "Hola %s, se ha creado la conferencia '%s' (ID: %d) con un máximo de %d artículos.",
            evento.getCreador().getNombreUsuario(),
            evento.getNombreConferencia(),
            evento.getIdConferencia(),
            evento.getCantidadMaxArticulos()
        );

        System.out.println("Conferencia creada: " + evento.getNombreConferencia());

        // Enviar la notificación
        notifyServices.enviarNotificacion(destinatario, asunto, cuerpo);
    }

    // Escuchar el evento de creación de artículo
    @RabbitListener(queues = "articulo-creado-queue")
    public void handleArticuloCreado(ArticuloCreadoEvent evento) {
        // Procesar el evento recibido y enviar la notificación
        String destinatario = evento.getAutor().getCorreoUsuario(); // Notificar al autor del artículo
        String asunto = "Nuevo artículo creado: " + evento.getNombre();
        String cuerpo = String.format(
            "Hola %s, se ha creado un nuevo artículo titulado '%s' (ID: %d). Resumen: %s",
            evento.getAutor().getNombreUsuario(),
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
            evento.getEvaluador().getNombreUsuario(),
            evento.getNombreConferencia(),
            evento.getIdConferencia()
        );

        // Delegar la notificación al servicio
        notifyServices.enviarNotificacion(evento.getEvaluador().getCorreoUsuario(), "Registro como Evaluador", mensaje);
    }
    
    @RabbitListener(queues = "articulo-asignado-queue")
    public void handleArticuloAsignado(ArticuloAsignadoEvent evento) {
        // Iterar sobre cada evaluador asignado
        for (Evaluador evaluador : evento.getEvaluadores()) {
            // Construir el mensaje de notificación para cada evaluador
            String mensaje = String.format(
                "Hola %s, %s te ha asignado el artículo '%s' (ID: %d) para evaluar en la conferencia '%s'.",
                evaluador.getNombreEvaluador(),
                evento.getAsignadoPor().getNombreUsuario(),
                evento.getTituloArticulo(),
                evento.getIdArticulo(),
                evento.getNombreConferencia()
            );

            // Enviar la notificación al evaluador
            notifyServices.enviarNotificacion(evaluador.getCorreoEvaluador(), "Asignación de Artículo", mensaje);
        }
    }

    
    @RabbitListener(queues = "paper-state-changed-queue")
    public void handleArticulosEstadoActualizadoEvent(ArticulosEstadoActualizadoEvent evento) {
        // Notificar a cada evaluador
        for (Evaluador evaluador : evento.getEvaluadores()) {
            String destinatario = evaluador.getCorreoEvaluador();
            String asunto = "Cambio de estado en el artículo: " + evento.getTituloArticulo();
            String cuerpo = String.format(
                "El artículo '%s' ha cambiado de estado: '%s' a '%s'. Comentario: %s",
                evento.getTituloArticulo(), evento.getEstadoAnterior(), evento.getEstadoActual(), evento.getComentario()
            );
            notifyServices.enviarNotificacion(destinatario, asunto, cuerpo);
        }

        // Notificar al autor
        String destinatarioAutor = evento.getCorreoAutor();
        String asuntoAutor = "Actualización en el estado de su artículo: " + evento.getTituloArticulo();
        String cuerpoAutor = String.format(
            "Su artículo '%s' ha cambiado de estado: '%s' a '%s'. Comentario: %s",
            evento.getTituloArticulo(), evento.getEstadoAnterior(), evento.getEstadoActual(), evento.getComentario()
        );
        notifyServices.enviarNotificacion(destinatarioAutor, asuntoAutor, cuerpoAutor);
    }
}

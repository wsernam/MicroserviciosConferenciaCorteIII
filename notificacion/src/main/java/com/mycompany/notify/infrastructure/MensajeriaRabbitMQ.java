/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.infrastructure;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author William Andres
 */
@Component
public class MensajeriaRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarMensaje(String queueName, Object mensaje) {
        rabbitTemplate.convertAndSend(queueName, mensaje);
        System.out.println("Mensaje enviado a la cola " + queueName);
    }
}

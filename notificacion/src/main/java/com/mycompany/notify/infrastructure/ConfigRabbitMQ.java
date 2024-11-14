/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.infrastructure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author William Andres
 */
@Configuration
public class ConfigRabbitMQ {

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
    
    @Bean
    public Queue conferenciaCreadaQueue() {
        return new Queue("conferencia-creada-queue", true);
    }
    
    @Bean
    public Queue articuloCreadoQueue() {
        return new Queue("articulo-creado-queue", true);
    }
    
    @Bean
    public DirectExchange articuloExchange() {
        return new DirectExchange("articulo-exchange");
    }
    // Intercambio para conferencias
    @Bean
    public DirectExchange conferenciaExchange() {
        return new DirectExchange("conferencia-exchange");
    }   

    // Enlace para artículos
    @Bean
    public Binding articuloBinding(@Qualifier("articuloCreadoQueue") Queue articuloCreadoQueue, 
                                   DirectExchange articuloExchange) {
        return BindingBuilder.bind(articuloCreadoQueue)
                             .to(articuloExchange)
                             .with("articulo.creado");
    }

    // Enlace para conferencias
    @Bean
    public Binding conferenciaBinding(@Qualifier("conferenciaCreadaQueue") Queue conferenciaCreadaQueue, 
                                      DirectExchange conferenciaExchange) {
        return BindingBuilder.bind(conferenciaCreadaQueue)
                             .to(conferenciaExchange)
                             .with("conferencia.creada");
    }
}

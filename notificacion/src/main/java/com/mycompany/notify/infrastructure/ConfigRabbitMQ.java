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

    // Colas existentes
    @Bean
    public Queue conferenciaCreadaQueue() {
        return new Queue("conferencia-creada-queue", true);
    }
    
    @Bean
    public Queue articuloAsignadoQueue() {
        return new Queue("articulo-asignado-queue", true);
    }

    @Bean
    public Queue articuloCreadoQueue() {
        return new Queue("articulo-creado-queue", true);
    }

    // Nueva cola para evaluadores registrados
    @Bean
    public Queue evaluadorRegistradoQueue() {
        return new Queue("evaluador-registrado-queue", true);
    }

    // Exchanges existentes
    @Bean
    public DirectExchange articuloExchange() {
        return new DirectExchange("articulo-exchange");
    }

    @Bean
    public DirectExchange conferenciaExchange() {
        return new DirectExchange("conferencia-exchange");
    }

    // Nuevo exchange para eventos relacionados con usuarios (opcional)
    @Bean
    public DirectExchange usuarioExchange() {
        return new DirectExchange("usuario-exchange");
    }

    // Enlaces existentes
    @Bean
    public Binding articuloBinding(@Qualifier("articuloCreadoQueue") Queue articuloCreadoQueue, 
                                   DirectExchange articuloExchange) {
        return BindingBuilder.bind(articuloCreadoQueue)
                             .to(articuloExchange)
                             .with("articulo.creado");
    }

    @Bean
    public Binding conferenciaBinding(@Qualifier("conferenciaCreadaQueue") Queue conferenciaCreadaQueue, 
                                      DirectExchange conferenciaExchange) {
        return BindingBuilder.bind(conferenciaCreadaQueue)
                             .to(conferenciaExchange)
                             .with("conferencia.creada");
    }

    // Nuevo binding para evaluadores registrados
    @Bean
    public Binding evaluadorBinding(@Qualifier("evaluadorRegistradoQueue") Queue evaluadorRegistradoQueue,
                                    @Qualifier("usuarioExchange") DirectExchange usuarioExchange) {
        return BindingBuilder.bind(evaluadorRegistradoQueue)
                             .to(usuarioExchange)
                             .with("evaluador.registrado");
    }
    
    @Bean
    public Binding articuloAsignadoBinding(@Qualifier("articuloAsignadoQueue") Queue articuloAsignadoQueue, 
                                           @Qualifier("usuarioExchange") DirectExchange usuarioExchange) {
        return BindingBuilder.bind(articuloAsignadoQueue)
                             .to(usuarioExchange)
                             .with("articulo.asignado");
    }
    
    @Bean
    public Queue paperStateChangedQueue() {
        return new Queue("paper-state-changed-queue", true);
    }

    @Bean
    public DirectExchange paperExchange() {
        return new DirectExchange("paper-exchange");
    }

    @Bean
    public Binding paperStateChangedBinding(@Qualifier("paperStateChangedQueue") Queue paperStateChangedQueue,
                                            DirectExchange paperExchange) {
        return BindingBuilder.bind(paperStateChangedQueue)
                             .to(paperExchange)
                             .with("paper.state.changed");
    }
}

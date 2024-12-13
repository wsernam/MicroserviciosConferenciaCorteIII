/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.conferencia.infraestructura.configuracion;

/**
 *
 * @author wsern
 */
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CONFERENCIA_EXCHANGE = "conferencia-exchange";
    public static final String POSTULAR_EVALUADOR_ROUTING_KEY = "conferencia.postular.evaluador";
    public static final String ASIGNAR_EVALUADORES_ROUTING_KEY = "conferencia.asignar.evaluadores";
    public static final String CONFERENCIA_CREADA_ROUTING_KEY = "conferencia.creada";
    
    @Bean
    public DirectExchange conferenciaExchange() {
        return new DirectExchange(CONFERENCIA_EXCHANGE);
    }

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
}


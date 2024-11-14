package co.unicauca.edu.articulo_microservicio.infrastructure.rabbit;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author wsern
 */
@Configuration
public class ConfigRabbitMQ {

    public static final String ARTICULO_EXCHANGE = "articulo-exchange";
    public static final String ARTICULO_ROUTING_KEY = "articulo.creado";

    @Bean
    public DirectExchange articuloExchange() {
        return new DirectExchange(ARTICULO_EXCHANGE);
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

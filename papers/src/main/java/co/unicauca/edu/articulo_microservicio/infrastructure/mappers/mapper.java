package co.unicauca.edu.articulo_microservicio.infrastructure.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sonhuila
 */
@Configuration
public class mapper {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}

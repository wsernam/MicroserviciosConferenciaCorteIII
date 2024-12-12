package co.unicauca.edu.conferencia.infraestructura.output.persistencia.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConferenciaMapperPersistenciaDominio {
    @Bean
    public ModelMapper crearProductoMapper() {
        return new ModelMapper();
    }
}
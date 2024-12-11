package co.unicauca.edu.conferencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.unicauca.edu.conferencia")
public class ConferenciaAplicacion {

	public static void main(String[] args) {
		SpringApplication.run(ConferenciaAplicacion.class, args);
	}

}

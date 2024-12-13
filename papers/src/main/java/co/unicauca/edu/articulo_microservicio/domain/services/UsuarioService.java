/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.domain.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author wsern
 */
@Service
public class UsuarioService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    public AppUser obtenerConferenciasDeArticulo(Integer idUsuario) {
    String url = String.format("http://localhost:8081/api/user/%d", idUsuario);

    Mono<AppUser> response = webClientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(AppUser.class);

    return response.block(); // Bloquea hasta obtener la respuesta
    }
}

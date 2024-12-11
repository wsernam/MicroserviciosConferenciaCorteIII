package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.DTO.ArticuloDeConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import co.unicauca.edu.articulo_microservicio.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.unicauca.edu.articulo_microservicio.domain.models.Articulo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
/**
 *
 * @author sonhuila
 */
@Service
public class ConferenciaService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        String url = "ttp://localhost:7777/api/conferencia/articulo/" + idArticulo;

        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);

        ConferenciaDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
      private ModelMapper modelMapper;

    public void enviarArticuloAConferencia(ArticuloDTO articulo) {
        // 1. Mapear el Articulo al DTO
        ArticuloDeConferenciaDTO articuloDTO = modelMapper.map(articulo, ArticuloDeConferenciaDTO.class);

        // 2. Realizar la llamada HTTP al microservicio conferencia
        String url = "http://localhost:7777/api/conferencia/GuardarArticulos";

        webClientBuilder.build()
                .post()
                .uri(url)
                .bodyValue(articuloDTO)
                .retrieve()
                .toBodilessEntity()
                .block(); // Ejecuta la llamada de manera sincrónica
    }


}

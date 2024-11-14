package co.unicauca.edu.articulo_microservicio.domain.services;

import co.unicauca.edu.articulo_microservicio.DTO.ArticulosConConferenciasDTO.ConferenciaDTO;
import java.util.List;
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
        String url = "ttp://localhost:7777/api/conferencias/articulo/" + idArticulo;

        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);

        ConferenciaDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}

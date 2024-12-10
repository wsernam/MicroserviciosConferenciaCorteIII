package com.conference.gui.article;

import com.conference.gui.entities.Articulo;
import com.conference.gui.presentation.infra.Subject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 *
 * @author sonhuila
 */

public class Article extends Subject implements IArticleRest {

    private static final String USER_AGENT = "GUIArticles";
    private final String urlArticleService = "http://localhost:7080/api";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
   public Articulo save(Articulo articulo) {
    Articulo savedArticle = null;
    try {
        // Convertir el objeto `Articulo` a JSON
        String jsonInputString = objectMapper.writeValueAsString(articulo);

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlArticleService.concat("/articulos")))
                .header("Content-Type", "application/json")
                .header("User-Agent", USER_AGENT)
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar y procesar la respuesta
        if (response.statusCode() == 200 || response.statusCode() == 201) {
            savedArticle = objectMapper.readValue(response.body(), Articulo.class);
            this.notifyAllObserves();
        } else {
            System.out.println("Error al guardar el artículo: Código " + response.statusCode());
        }
    } catch (Exception e) {
        System.out.println("Error de conexión al guardar el artículo: " + e.getMessage());
        e.printStackTrace();
    }
    return savedArticle;
}

    @Override

public List<Articulo> getArticulos() {
    List<Articulo> articulos = new ArrayList<>();
    try {
        // Crear la solicitud HTTP de tipo GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlArticleService.concat("/articulos"))) // Endpoint para obtener todos los artículos
                .header("User-Agent", USER_AGENT)
                .GET() // Método GET
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar y procesar la respuesta
        if (response.statusCode() == 200) {
            // Convertir la respuesta JSON en una lista de objetos Articulo
            articulos = objectMapper.readValue(response.body(), new TypeReference<List<Articulo>>() {});
        } else {
            System.out.println("Error al obtener los artículos: " + response.statusCode());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return articulos;
}

}

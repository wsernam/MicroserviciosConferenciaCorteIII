/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.entities.Articulo;
import com.conference.gui.entities.Usuario;
import com.conference.gui.presentation.infra.Subject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public class ArticleClient extends Subject implements IRestArticle{
    
    private static final String USER_AGENT = "GUIArticles";
    private final String urlArticleService = "http://localhost:7080/api";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Usuario usuario;
     
     public ArticleClient(Usuario us){
         this.usuario = us;
     }
    @Override
    public List<Articulo> getArticles() {
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

    @Override
    public List<Articulo> getArticlesUser() {
        List<Articulo> articulos = new ArrayList<>();
    try {
        // Crear la solicitud HTTP de tipo GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlArticleService + "/articulos/" + usuario.getId())) // Endpoint para obtener todos los artículos
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

    @Override
    public Articulo createArticle(Articulo ar) {
        Articulo savedArticle = null;
    try {
        // Convertir el objeto `Articulo` a JSON
        String jsonInputString = objectMapper.writeValueAsString(ar);

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
        } else {
            System.out.println("Error al guardar el artículo: Código " + response.statusCode());
        }
    } catch (Exception e) {
        System.out.println("Error de conexión al guardar el artículo: " + e.getMessage());
        e.printStackTrace();
    }
        return savedArticle;
    }
    
}

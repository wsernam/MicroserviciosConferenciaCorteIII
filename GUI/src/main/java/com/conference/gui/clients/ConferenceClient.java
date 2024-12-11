/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.entities.Conferencia;
import com.conference.gui.entities.Usuario_Autorizado;
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
public class ConferenceClient extends Subject implements IRestConference{
    private static final String USER_AGENT = "GUIConference";
    private final String urlSaveConference = "http://localhost:8081/EasyConference";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Usuario_Autorizado usuario; 
    
    
    public ConferenceClient(Usuario_Autorizado us){
        this.usuario = us;
    }
    @Override
    public List<Conferencia> getConferences(String token) {
        List<Conferencia> conferenceList = new ArrayList<>();
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/Conference"))) 
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .header("Authorization", "Bearer " + usuario.getToken())
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                // Convertir la respuesta JSON en una lista de objetos Conference
                conferenceList = objectMapper.readValue(response.body(), new TypeReference<List<Conferencia>>() {});
            } else {
                System.out.println("Error al listar las Conferencias: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conferenceList;
    }

    @Override
    public List<Conferencia> getConferenceUser(String username, String token) {
         List<Conferencia> conferenceList = new ArrayList<>();
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference + "/Conference/" + usuario.getUsername())) 
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .header("Authorization", "Bearer " + usuario.getToken())
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                // Convertir la respuesta JSON en una lista de objetos Conference
                conferenceList = objectMapper.readValue(response.body(), new TypeReference<List<Conferencia>>() {});
            } else {
                System.out.println("Error al listar las Conferencias: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conferenceList;
    }

    @Override
    public Conferencia createConference(Conferencia co, String token) {
        Conferencia savedConference = null;
        try {
            // Convertir el objeto `Articulo` a JSON
            String jsonInputString = objectMapper.writeValueAsString(co);

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/Conference"))) // Asume que tu endpoint es "/save"
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .header("Authorization", "Bearer " + usuario.getToken())
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                savedConference = objectMapper.readValue(response.body(), Conferencia.class);
            } else {
                System.out.println("Error al guardar la Conferencia: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedConference;
    }
    
}

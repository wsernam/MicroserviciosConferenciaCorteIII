/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.conference;

import com.conference.gui.entities.Conference;
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
 * @author Personal
 */
public class UserConference implements IUserRestConference {
      private static final String USER_AGENT = "GUIConference";
    private final String urlSaveConference = "http://localhost:7777/api";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Conference> getConferencias() {
        List<Conference> conferenceList = new ArrayList<>();
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/conferencias"))) 
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                // Convertir la respuesta JSON en una lista de objetos Conference
                conferenceList = objectMapper.readValue(response.body(), new TypeReference<List<Conference>>() {});
            } else {
                System.out.println("Error al listar las Conferencias: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conferenceList;
    }


    @Override
    public Conference setConferencia(Conference prmConferencia) {
          Conference savedConference = null;
        try {
            // Convertir el objeto `Articulo` a JSON
            String jsonInputString = objectMapper.writeValueAsString(prmConferencia);

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/registrarConferencia"))) // Asume que tu endpoint es "/save"
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                savedConference = objectMapper.readValue(response.body(), Conference.class);
            } else {
                System.out.println("Error al guardar la Conferencia: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedConference;
    
    }
    
}

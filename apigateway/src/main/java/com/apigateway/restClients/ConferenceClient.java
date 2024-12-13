/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.restClients;


import com.apigateway.DTOs.DTORespuesta;
import com.apigateway.entities.Conferencia;
import com.apigateway.mapper.DTOConferenciaMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;
/**
 *
 * @author Personal
 */
@Service
public class ConferenceClient implements IRestConference {
      private static final String USER_AGENT = "GUIConference";
    private final String urlSaveConference = "http://localhost:7777/api/Conferencia";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Conferencia> getConferencias() {
        List<Conferencia> conferenceList = new ArrayList<>();
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/ListarConferencias"))) 
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
    public Conferencia setConferencia(Conferencia prmConferencia) {
          Conferencia savedConference = null;
        try {
            // Convertir el objeto `Articulo` a JSON
            String jsonInputString = prmConferencia.toString();

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference.concat("/CrearConferencia"))) // Asume que tu endpoint es "/save"
                    .header("Content-Type", "application/json")
                    .header("User-Agent", USER_AGENT)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar y procesar la respuesta
            if (response.statusCode() == 200) {
                objectMapper.registerModule(new JavaTimeModule());
                System.out.println(response.body());
                DTORespuesta conferencia = objectMapper.readValue(response.body(), DTORespuesta.class);
                savedConference = DTOConferenciaMapper.mappearDTORespuesta(conferencia); 
            } else {
                System.out.println("Error al guardar la Conferencia: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedConference;
    
    }
    
}

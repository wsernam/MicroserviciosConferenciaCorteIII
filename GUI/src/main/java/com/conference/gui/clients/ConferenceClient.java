/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.DTOs.DTORespuesta;
import com.conference.gui.entities.Conferencia;
import com.conference.gui.entities.Usuario;
import com.conference.gui.mapper.DTOConferenciaMapper;
import com.conference.gui.presentation.infra.Subject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    private final String urlSaveConference = "http://localhost:7777/api/Conferencia";
    private final ObjectMapper objectMapper;
    private Usuario usuario; 
    
    
    public ConferenceClient(Usuario us){
        this.usuario = us;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }
    @Override
    public List<Conferencia> getConferences() {
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
                List<DTORespuesta> conferenciaDTO = objectMapper.readValue(response.body(), new TypeReference<List<DTORespuesta>>() {});
                for(DTORespuesta c:conferenciaDTO){
                    conferenceList.add(DTOConferenciaMapper.mappearDTORespuesta(c));
                }
            } else {
                System.out.println("Error al listar las Conferencias: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conferenceList;
    }

    @Override
    public List<Conferencia> getConferenceUser() {
         List<Conferencia> conferenceList = new ArrayList<>();
        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlSaveConference + "/ListarConferencias/" + usuario.getId())) 
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
                List<DTORespuesta> conferenciaDTO = objectMapper.readValue(response.body(), new TypeReference<List<DTORespuesta>>() {});
                for(DTORespuesta c:conferenciaDTO){
                    conferenceList.add(DTOConferenciaMapper.mappearDTORespuesta(c));
                }
                
            } else {
                System.out.println("Error al listar las Conferencias: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conferenceList;
    }

    @Override
    public Conferencia createConference(Conferencia co) {
        Conferencia savedConference = null;
        try {
            // Convertir el objeto `Articulo` a JSON
            String jsonInputString = co.toString();
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

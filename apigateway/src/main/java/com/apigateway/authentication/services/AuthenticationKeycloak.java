/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.authentication.services;

import com.apigateway.entities.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ashlee Campaz
 */
@Service
public class AuthenticationKeycloak implements IAuthentication{
    private final String client_id; 
    private final String URL; 
    private final String realm; 
    public AuthenticationKeycloak(){
        this.client_id = null;
        //TODO inicializar el client_id y URL
        this.URL = null;
        this.realm = "EasyConference";
    }
    @Override
    public Usuario login(String email, String password) {
       Usuario user = null; 
        String jsonInputString = String.format("{\"email\": \"%s\", \"password\": \"%s\"}",email,password);
        
         
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir la respuesta
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el JSON a un objeto Java
            if(response.statusCode()==200){
                user = objectMapper.readValue(response.body(), Usuario.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Usuario register(Usuario us) {
       Usuario user = null; 
        String jsonInputString = us.creationJSON(); 
        String admin_token = "";
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("application/json", admin_token)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir la respuesta
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el JSON a un objeto Java
            if(response.statusCode()==200){
                user = objectMapper.readValue(response.body(), Usuario.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
}

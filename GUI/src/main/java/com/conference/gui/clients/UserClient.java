/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.entities.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Ashlee Campaz
 */
public class UserClient implements IUserRestClient {
     private static final String USER_AGENT = "GUILogin";
     
     private String urlUserService = "http://localhost:8097/user";
     public UserClient (){
     
     }
     @Override
     public  Usuario login(String email, String password) throws Exception{
         
        Usuario user = null; 
        String jsonInputString = String.format("{\"email\": \"%s\", \"password\": \"%s\"}",email,password);
        
         
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlUserService.concat("/login")))
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
        String jsonInputString = us.toString();
        
         
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlUserService))
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
}

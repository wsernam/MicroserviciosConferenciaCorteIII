/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.authentication.services;

import com.apigateway.entities.Usuario;
import com.apigateway.entities.Usuario_Autorizado;
import com.apigateway.utilities.JWTDecoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    
    public AuthenticationKeycloak(){
        this.client_id = "EasyConference-front";
        //TODO inicializar el client_id y URL
        this.URL = "http://localhost:8080/";
        this.realm = "EasyConference";
    }
    @Override
    public Usuario_Autorizado login(String email, String password) {
       Usuario_Autorizado us = null;
        String jsonInputString = String.format("{\"email\": \"%s\", \"password\": \"%s\"}",email,password);
        String formData = "client_id=EasyConference-front"+
                    "&grant_type=password"
                    +"&client_secret=f26f7r9YteB7MEBfyPeYTSwzYXTGzGNE"
                    + "&username=" + email 
                    + "&password=" + password;
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL +"realms/" + realm + "/protocol/openid-connect/token"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(formData))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Login");
            // Imprimir la respuesta
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            
            // Convertir el JSON a un objeto Java
            if(response.statusCode()==200){
                
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> responseBody =mapper.readValue(response.body(), Map.class);
                String access_token = responseBody.get("access_token").toString(); 
                us = JWTDecoder.decode(access_token, URL, realm); 
                return us;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public Boolean register(Usuario us) {
        String jsonInputString = us.creationJSON(); 
        String admin_token = getAdminToken();
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + "admin/realms/" + realm + "/users"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + admin_token)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                    .build();
            System.out.println("Se construyo la solucitud");
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Se envio la solicitud");
            // Imprimir la respuesta
            System.out.println("Register");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            
            if(response.statusCode()==201){
                rabbitTemplate.convertAndSend(us);
                return true; 
            }
        } catch (Exception e) {
            System.out.println("Register");
            e.printStackTrace();
        }
        return false;
    }
    
    public String getAdminToken(){
        String adminToken = null;
        try {
            String tokenURL = URL + "realms/" + realm + "/protocol/openid-connect/token";
            String formData = "client_id=EasyConference-front"+
                    "&grant_type=client_credentials"
                    + "&client_secret=f26f7r9YteB7MEBfyPeYTSwzYXTGzGNE";
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(tokenURL))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(formData))
                    .build();
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Imprimir la respuesta
            System.out.println("Obtener admin token");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            

            // Convertir el JSON a un objeto Java
            if(response.statusCode()==200){
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> responseBody =mapper.readValue(response.body(), Map.class);
                return responseBody.get("access_token").toString();
            }
            else{
                throw new RuntimeException("Error al obtener el token: " + response.body());
            }
            
        } catch (Exception e) {
            System.out.println("Obtener admin token");
            e.printStackTrace();
        }
        return adminToken;
    }
}


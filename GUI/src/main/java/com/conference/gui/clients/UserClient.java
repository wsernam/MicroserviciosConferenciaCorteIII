package com.conference.gui.clients;

import com.conference.gui.entities.Usuario;
import com.conference.gui.entities.Usuario_Autorizado;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Ashlee Campaz
 */
public class UserClient implements IUserRestClient {
     private static final String USER_AGENT = "GUILogin";
     
     private String urlUserService = "http://localhost:8081/user";
     public UserClient (){
     
     }
     @Override
     public  Usuario_Autorizado login(String email, String password) throws Exception{
         
        Usuario_Autorizado user = null; 
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
                user = objectMapper.readValue(response.body(), Usuario_Autorizado.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;     
     }

    @Override
    public Boolean register(Usuario us) {
        Boolean bandera = false; 
        String jsonInputString = us.toString();
        
         
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlUserService + ""))
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
                bandera = true; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bandera; 
    }
}


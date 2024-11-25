/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.utilities;

import com.apigateway.entities.Usuario;
import com.apigateway.entities.Usuario_Autorizado;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ashlee Campaz
 */
public class JWTDecoder {
    
    public static Usuario_Autorizado decode(String token, String URL, String realm){
    
        // Decodificar y validar la firma
        RSAPublicKey key = generatePublicKey(URL,realm);
        if(key==null){
            return null; 
        }
        Algorithm algorithm = Algorithm.RSA256(key);
        DecodedJWT jwt = JWT.require(algorithm)
                            .build()
                            .verify(token);

        // Leer claims
        String username = jwt.getClaim("preferred_username").asString();
        String name = jwt.getClaim("given_name").asString();
        String lastname = jwt.getClaim("family_name").asString();
        String email = jwt.getClaim("email").asString();
        
        return new Usuario_Autorizado(token,username,name,lastname,email); 
   }
    
   private static RSAPublicKey generatePublicKey(String URL, String realm){
       try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL +"realms/" + realm + "/protocol/openid-connect/certs"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Imprimir la respuesta
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
            
            // Convertir el JSON a un objeto Java
            if(response.statusCode()==200){
                
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> responseBody = mapper.readValue(response.body(), Map.class);
                List<Map<String, Object>> keys = (List<Map<String, Object>>) responseBody.get("keys");
                 // Obtener el primer elemento del arreglo y su campo "n"
                Map<String, Object> firstKey = keys.get(0);
                String modulusBase64 = firstKey.get("n").toString(); 
                String exponentBase64 = firstKey.get("e").toString(); 
                
                // Decodificar Base64URL a BigInteger
                BigInteger modulus = new BigInteger(1, Base64.getUrlDecoder().decode(modulusBase64));
                BigInteger exponent = new BigInteger(1, Base64.getUrlDecoder().decode(exponentBase64));

                // Crear especificación de clave RSA
                RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);

                // Generar clave pública
                KeyFactory factory = KeyFactory.getInstance("RSA");
                return (RSAPublicKey) factory.generatePublic(spec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       return null;
   } 
}

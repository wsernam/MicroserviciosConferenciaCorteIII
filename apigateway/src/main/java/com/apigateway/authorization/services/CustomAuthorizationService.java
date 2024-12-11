/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.authorization.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("customAuthorizationService")
public class CustomAuthorizationService {

    public boolean checkUsername(Authentication authentication, HttpServletRequest request) {
        // Extraer username del token JWT
        String usernameFromToken = authentication.getName(); // O usa claims si es necesario

        // Extraer username de la URL
        String usernameFromPath = extractUsernameFromPath(request.getRequestURI());

        return usernameFromToken.equals(usernameFromPath);
    }

    private String extractUsernameFromPath(String uri) {
        // Suponiendo que el username está en la posición después de "/EasyConference/Article/"
        String[] parts = uri.split("/");
        return parts[parts.length - 1];
    }
}

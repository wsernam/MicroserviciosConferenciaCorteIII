/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.infrastructure;

import com.mycompany.notify.domain.AppUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author wsern
 */
import org.springframework.stereotype.Component;

@Component
public class UsuarioContexto {
    public AppUser extraerUsuarioDesdeCabeceras(HttpServletRequest request) {
        String userId = request.getHeader("X-User-Id");
        String userName = request.getHeader("X-User-Name");
        String userEmail = request.getHeader("X-User-Email");

        if (userId != null && userName != null && userEmail != null) {
            return new AppUser(Integer.parseInt(userId), userName, userEmail);
        }

        throw new RuntimeException("No se encontró información del usuario en las cabeceras");
    }
}

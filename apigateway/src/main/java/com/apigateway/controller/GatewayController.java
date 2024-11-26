/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.controller;

import com.apigateway.authentication.services.IAuthentication;
import com.apigateway.entities.Login;
import com.apigateway.entities.Usuario;
import com.apigateway.entities.Usuario_Autorizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashlee Campaz
 */
@RestController
@RequestMapping("/EasyConference")
public class GatewayController {
    @Autowired
    IAuthentication authentication;
    
    @PostMapping(value="/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> create(@RequestBody Usuario us) {
        Boolean bandera = authentication.register(us);
        if(bandera){
            return ResponseEntity.ok("El usuario se registro correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
     }
    
    @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario_Autorizado> login(@RequestBody Login log){
        Usuario_Autorizado us = authentication.login(log.getEmail(), log.getPassword());
        if(us!=null){
            return ResponseEntity.ok(us);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}



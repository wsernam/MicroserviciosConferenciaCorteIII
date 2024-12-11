/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.controller;

import com.apigateway.authentication.services.IAuthentication;
import com.apigateway.entities.Articulo;
import com.apigateway.entities.Conferencia;
import com.apigateway.entities.Login;
import com.apigateway.entities.Usuario;
import com.apigateway.entities.Usuario_Autorizado;
import com.apigateway.restClients.IRestArticle;
import com.apigateway.restClients.IRestConference;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    IRestArticle articleClient;
    
    IRestConference conferenceClient; 
    
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
    
    
    @PostMapping(value="/Conference", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Conferencia> createConference(@RequestBody Conferencia con){
       Conferencia conferencia =  conferenceClient.setConferencia(con); 
       if(conferencia!=null){
            return ResponseEntity.ok(conferencia);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
       
    }
    
    @GetMapping(value="/Conference/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Conferencia>> getConferencesByUsername(@PathVariable String username){
       List<Conferencia> conferenciasUser = conferenceClient.getConferencias();
       
       if(conferenciasUser!=null){
            return ResponseEntity.ok(conferenciasUser);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
    
    @GetMapping(value="/Conference", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Conferencia>> getConferences(){
       List<Conferencia> conferencias = conferenceClient.getConferencias();
       
       if(conferencias!=null){
            return ResponseEntity.ok(conferencias);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
    
    
    
    @GetMapping(value="/Article/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Articulo>> getArticlesByUsername(@PathVariable String username){
       
        List<Articulo> articulos = articleClient.getArticulos(); 
        
        if(articulos!=null){
            return ResponseEntity.ok(articulos);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        
    }
    
    @PostMapping(value="/Article", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Articulo> createArticle(@RequestBody Articulo ar){
       Articulo articulo = articleClient.save(ar); 
       if(articulo!=null){
            return ResponseEntity.ok(articulo);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
       
    }
  
}



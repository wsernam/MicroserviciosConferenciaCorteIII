/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.usuarios.presentation;

import com.conference.usuarios.domain.Login;
import com.conference.usuarios.domain.Usuario;
import com.conference.usuarios.services.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashlee Campaz
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    
    @RequestMapping(method = RequestMethod.GET, produces =
    "application/json")
     @ResponseBody
     public List<Usuario> findAll() {
        return userService.findAll();
     }
     
     @RequestMapping(method = RequestMethod.POST, produces =
    "application/json", consumes = "application/json")
     @ResponseBody
     public ResponseEntity<Usuario> create(@RequestBody Usuario us) {
        Usuario user = userService.register(us);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
     }
     /* Get a Event by ID */
     @GetMapping("/{id}")
     public Usuario getUserById(@PathVariable Long id) {
     return userService.findById(id);
    }
    @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> login(@RequestBody Login log){
        Usuario us = userService.login(log.getEmail(), log.getPassword());
        if(us!=null){
            return ResponseEntity.ok(us);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
     
}

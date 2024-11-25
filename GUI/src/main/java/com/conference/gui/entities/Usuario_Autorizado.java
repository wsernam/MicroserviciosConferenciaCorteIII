/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.entities;

/**
 *
 * @author Ashlee Campaz
 */
public class Usuario_Autorizado {
    private String token;
    private String username; 
    private String name;
    private String lastName;
    private String email; 
    
    public Usuario_Autorizado(){}

    public Usuario_Autorizado(String token, String username, String name, String lastName, String email) {
        this.token = token;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    
    
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Usuario_Autorizado{" + "username=" + username + ", name=" + name + ", lastName=" + lastName + ", email=" + email + '}';
    }
    
    
}

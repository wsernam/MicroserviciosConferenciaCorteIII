/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain;

import jakarta.persistence.*;
/**
 *
 * @author William Andres
 */
@Entity
public class Notify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message; 
    private String subject;
    @Column(name = "emailUsuario")
    private String emailUsuario;  // El correo electrónico del usuario que recibirá la notificación
    // Getters y Setters

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getEmailUsuario() {
        return emailUsuario;
    }
    
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {    
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}


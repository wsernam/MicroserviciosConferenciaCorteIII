/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apigateway.authentication.services;

import com.apigateway.entities.Usuario;
import com.apigateway.entities.Usuario_Autorizado;

/**
 *
 * @author Ashlee Campaz
 */
public interface IAuthentication {
    public Usuario_Autorizado login(String email, String password); 
    public Boolean register(Usuario us); 
}

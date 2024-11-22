/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apigateway.authentication.services;

import com.apigateway.entities.Usuario;

/**
 *
 * @author Ashlee Campaz
 */
public interface IAuthentication {
    public Usuario login(String email, String password); 
    public Usuario register(Usuario us); 
}

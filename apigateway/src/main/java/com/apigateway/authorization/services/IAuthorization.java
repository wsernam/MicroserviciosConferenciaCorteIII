/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apigateway.authorization.services;

/**
 *
 * @author Ashlee Campaz
 */
public interface IAuthorization {
    public boolean simpleAuthorization(String token);
    
    public boolean userAuthorization(String username, String token); 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.entities.Login;
import com.conference.gui.entities.Usuario;

/**
 *
 * @author Ashlee Campaz
 */
public interface IUserRestClient {
    public Usuario login(String email, String password)  throws Exception;
    public Usuario register(Usuario us); 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.gui.clients;
import com.conference.gui.entities.Usuario;
import com.conference.gui.entities.Usuario_Autorizado;

/**
 *
 * @author Ashlee Campaz
 */
public interface IUserRestClient {
    public Usuario_Autorizado login(String email, String password)  throws Exception;
    public Boolean register(Usuario us); 
}

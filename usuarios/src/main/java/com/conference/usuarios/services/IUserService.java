/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.usuarios.services;

import com.conference.usuarios.domain.Usuario;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IUserService {
    public Usuario login(String us,String password);
    public Usuario register(Usuario us); 
    public boolean isEmailRegistered(String email);
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario buscarPorCorreo(String correo);
}

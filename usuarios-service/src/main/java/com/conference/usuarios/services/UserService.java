/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.usuarios.services;
import com.conference.usuarios.access.IUserRepository;
import com.conference.usuarios.domain.Usuario;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Ashlee Campaz
 */

@Service
public class UserService implements IUserService {
    
    
    
    @Autowired
    IUserRepository userAccess; 
    
    @Override
    @Transactional
    public Usuario login(String us, String password) {
       List<Usuario> listado_usarios =(List<Usuario>) userAccess.findAll();
       for(Usuario u:listado_usarios){
           if(u.getEmail().equals(us)){
               if( u.getPassword().equals(password)){
                   return u;
               }
           }
       }
       return null; 
    }

    @Override
    @Transactional
    public Usuario register(Usuario us) {
        if(!isEmailRegistered(us.getEmail())){
            return userAccess.save(us); 
        }
        return null; 
    }
    
    @Override
    @Transactional
    public boolean isEmailRegistered(String email){
        List<Usuario> listado_usarios =(List<Usuario>) userAccess.findAll();
       for(Usuario u:listado_usarios){
           return u.getEmail().equals(email);
       }
       return false; 
    }

    @Override
    @Transactional
    public List<Usuario> findAll() {
        List<Usuario> listado_usarios =(List<Usuario>) userAccess.findAll();
        return listado_usarios;
    }

    @Override
    @Transactional
    public Usuario findById(Long id) {
        Usuario us = userAccess.findById(id).orElse(null);
        return us;
    }
   
}

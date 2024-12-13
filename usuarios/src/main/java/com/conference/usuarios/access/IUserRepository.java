/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.usuarios.access;

import com.conference.usuarios.domain.Usuario;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashlee Campaz
 */
@Repository
public interface IUserRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}

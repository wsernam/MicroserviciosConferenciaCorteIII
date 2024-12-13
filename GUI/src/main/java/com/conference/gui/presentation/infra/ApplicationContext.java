/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.presentation.infra;

import com.conference.gui.entities.Usuario_Autorizado;

/**
 *
 * @author Personal
 */
public class ApplicationContext {
    private static ApplicationContext instance;
    private Usuario_Autorizado usuarioLogueado;

    private ApplicationContext() {}

    public static synchronized ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Usuario_Autorizado getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario_Autorizado usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
}


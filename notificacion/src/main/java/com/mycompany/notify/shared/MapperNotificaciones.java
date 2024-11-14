/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.shared;

import com.mycompany.notify.domain.Notify;

/**
 *
 * @author William Andres
 */
public class MapperNotificaciones {

    public static Notify convertirEventoACreacionNotificacion(String userId, String message) {
        return new Notify();
    }
}

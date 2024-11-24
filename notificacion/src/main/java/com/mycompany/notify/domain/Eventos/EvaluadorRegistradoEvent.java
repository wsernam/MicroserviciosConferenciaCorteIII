/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain.Eventos;

import com.mycompany.notify.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wsern
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluadorRegistradoEvent {
    private AppUser evaluador;       // Usuario que se registró como evaluador
    private int idConferencia;      // ID de la conferencia
    private String nombreConferencia; // Nombre de la conferencia
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wsern
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluador {
    private int idEvaluador;           // ID del evaluador
    private String nombreEvaluador;   // Nombre del evaluador
    private String correoEvaluador;   // Correo del evaluador
}

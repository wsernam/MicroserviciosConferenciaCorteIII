/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain.Eventos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConferenciaCreadaEvent {
    private int id;                     // ID de la conferencia
    private String nombre;              // Nombre de la conferencia
    private int cantidadMaxArticulos;   // Máxima cantidad de artículos permitidos
    private AppUser creador;            // Usuario que creó la conferencia
}
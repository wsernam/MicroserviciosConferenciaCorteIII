/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notify.domain.Eventos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.notify.domain.AppUser;
import com.mycompany.notify.domain.Evaluador;
import java.util.List;
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
public class ArticuloAsignadoEvent {
    //private int idConferencia;
    private int idArticulo;          // ID del artículo asignado
    private String tituloArticulo;   // Título del artículo
    private List<Evaluador> evaluadores;
    private String nombreConferencia;// Nombre de la conferencia
    private AppUser asignadoPor;     // Usuario que asignó el artículo
}

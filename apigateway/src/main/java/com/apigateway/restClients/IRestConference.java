/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.restClients;
import com.apigateway.entities.Conferencia;
import java.util.List;

/**
 *
 * @author Personal
 */
public interface IRestConference {
    
   public List<Conferencia> getConferencias();
    public Conferencia setConferencia(Conferencia prmConferencia);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.gui.clients;


import com.conference.gui.entities.Conferencia;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IRestConference {
    public List<Conferencia> getConferences();
    
    public List<Conferencia>  getConferenceUser();
    
    public Conferencia createConference(Conferencia co); 
}

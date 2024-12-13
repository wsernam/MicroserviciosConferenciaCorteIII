/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.conference;
import com.conference.gui.entities.Conference;
import java.util.List;

/**
 *
 * @author Personal
 */
public interface IUserRestConference {
    
   public List<Conference> getConferencias();
   public Conference setConferencia(Conference prmConferencia);    
}

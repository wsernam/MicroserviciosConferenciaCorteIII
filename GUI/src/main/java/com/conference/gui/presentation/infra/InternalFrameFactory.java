/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.presentation.infra;

import com.conference.gui.presentation.GUIcreateArticle;
import com.conference.gui.presentation.GUIcreateConference;
import com.conference.gui.presentation.GUImisArticulos;
import com.conference.gui.presentation.GUImisConferencias;

/**
 *
 * @author Ashlee Campaz
 */
public class InternalFrameFactory {
   private static InternalFrameFactory instance; 
   
   private GUImisArticulos misArticulos;
   private GUImisConferencias misConferencias; 
   private GUIcreateConference createConference; 

   
   public static InternalFrameFactory getInstance(){
        if(instance==null){
            instance = new InternalFrameFactory();
        }
        
        return instance; 
   }
   
   public  javax.swing.JInternalFrame getJInternalFrame(String type){
       switch(type){
       
           case "MC":
               if(misConferencias==null){
                    misConferencias = new GUImisConferencias(RestClientManager.getConferenceClient()); 
               }
               return misConferencias; 
               
           case "MA":
               if( misArticulos==null){
                    misArticulos = new GUImisArticulos(RestClientManager.getArticleClient());  
                }
               return misArticulos; 
           case "CC":
               
               if(createConference == null){
                   createConference = new GUIcreateConference(RestClientManager.getConferenceClient());
               }
               return createConference;
               
       }
       //TODO cambiar por una excepcion
       return null; 
    
   }
   
}

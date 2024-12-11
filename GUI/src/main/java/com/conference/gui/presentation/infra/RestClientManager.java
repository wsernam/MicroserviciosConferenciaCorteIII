/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.presentation.infra;

import com.conference.gui.clients.ArticleClient;
import com.conference.gui.clients.ConferenceClient;
import com.conference.gui.clients.UserClient;
import com.conference.gui.entities.Usuario_Autorizado;

/**
 *
 * @author Ashlee Campaz
 */
public class RestClientManager {
    private static UserClient userClient;
    private static ConferenceClient conferenceClient;
    private static ArticleClient articleClient;
    
    private static Usuario_Autorizado usuario; 
    
    public static void createClientManager (Usuario_Autorizado us){
        usuario = us;
    }
    
    public static ConferenceClient getConferenceClient(){
        if(conferenceClient ==null){
            conferenceClient = new ConferenceClient(usuario);
            conferenceClient.addObserver((Observer) InternalFrameFactory.getInstance().getJInternalFrame("MC"));
        }
        return conferenceClient; 
    }
    
    public static UserClient getUserClient(){
        if(userClient == null){
            userClient = new UserClient();
        }
        return userClient; 
    }
    
    public static ArticleClient getArticleClient(){
        if(articleClient==null){
            articleClient = new ArticleClient(usuario); 
            articleClient.addObserver((Observer) InternalFrameFactory.getInstance().getJInternalFrame("MA"));
        }
        return articleClient; 
    }
}

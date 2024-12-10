/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.presentation.infra;

import com.conference.gui.article.Article;
import com.conference.gui.clients.UserClient;
import com.conference.gui.conference.UserConference;

/**
 *
 * @author Ashlee Campaz
 */
public class RestClientManager {
    private static UserClient userClient;
    private static UserConference conferenceClient;
    private static Article articleClient;
    
    
    public static UserConference getConferenceClient(){
        if(conferenceClient ==null){
            conferenceClient = new UserConference();
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
    
    public static Article getArticleClient(){
        if(articleClient==null){
            articleClient = new Article(); 
            articleClient.addObserver((Observer) InternalFrameFactory.getInstance().getJInternalFrame("MA"));
        }
        return articleClient; 
    }
}

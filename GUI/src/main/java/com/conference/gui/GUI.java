/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.conference.gui;

import com.conference.gui.clients.UserClient;
import com.conference.gui.conference.UserConference;
import com.conference.gui.presentation.GUIcontainer;
import com.conference.gui.presentation.GUIcreateConference;
import com.conference.gui.presentation.GUIlogin;

/**
 *
 * @author Ashlee Campaz
 */

public class GUI {
        
    public static void main(String[] args) {
        UserClient userclient = new UserClient(); 
        GUIlogin login = new GUIlogin(userclient);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
        
    
}

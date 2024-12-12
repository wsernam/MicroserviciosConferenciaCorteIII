package com.conference.gui;

import com.conference.gui.clients.UserClient;
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

package com.conference.gui.clients;
import com.conference.gui.entities.Usuario;
import com.conference.gui.entities.Usuario_Autorizado;

/**
 *
 * @author Ashlee Campaz
 */
public interface IUserRestClient {
    public Usuario_Autorizado login(String email, String password)  throws Exception;
    public Boolean register(Usuario us); 
}

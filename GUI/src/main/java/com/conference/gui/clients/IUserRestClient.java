package com.conference.gui.clients;
import com.conference.gui.entities.Usuario;

/**
 *
 * @author Ashlee Campaz
 */
public interface IUserRestClient {
    public Usuario login(String email, String password)  throws Exception;
    public Boolean register(Usuario us); 
}

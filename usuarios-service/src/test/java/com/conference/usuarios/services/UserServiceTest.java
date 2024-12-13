/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.conference.usuarios.services;

import com.conference.usuarios.access.IUserRepository;
import com.conference.usuarios.domain.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Ashlee Campaz
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userAccess; 
    
    @InjectMocks
    UserService instance;
    public UserServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of login method, of class UserService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String us = "ashlee@gmail.com";
        String password = "12345678";
        Usuario expResult = new Usuario();
        expResult.setEmail(us);
        expResult.setPassword(password);
        expResult.setId(1L);
        List<Usuario> listado = Arrays.asList(expResult); 
        Mockito.when(userAccess.findAll()).thenReturn(listado); 
        Usuario result = instance.login(us, password);
        assertEquals(result.getId(), expResult.getId());
        
    }

    /**
     * Test of register method, of class UserService.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Usuario us = new Usuario();
        us.setEmail("ashlee@gmail.com");
        us.setId(1L);
        Usuario expResult = us;
        Mockito.when(userAccess.save(us)).thenReturn(expResult);
        Usuario result = instance.register(us);   
        Mockito.verify(userAccess).findAll();
        assertEquals(us.getId(), result.getId());
        
    }
    @Test
    public void testExisting_Email_Register() {
        System.out.println("register");
        Usuario us = new Usuario();
        us.setEmail("ashlee@gmail.com");
        us.setId(1L);
        Usuario expResult = us;
        List<Usuario> listado = Arrays.asList(expResult); 
        Mockito.when(userAccess.findAll()).thenReturn(listado); 
        Usuario result = instance.register(us);   
        Mockito.verify(userAccess).findAll();
        assertEquals(null, result);
        
    }
    /**
     * Test of isEmailRegistered method, of class UserService.
     */
    @Test
    public void testIsEmailRegistered() {
        System.out.println("isEmailRegistered");
        String email = "ashlee@gmail.com";
        Usuario us = new Usuario();
        us.setEmail(email);
        us.setId(1L);
        List<Usuario> listado = Arrays.asList(us); 
        Mockito.when(userAccess.findAll()).thenReturn(listado); 
        boolean expResult = true;
        boolean result = instance.isEmailRegistered(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findAll method, of class UserService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        
        
        Usuario us = new Usuario();
        us.setEmail("ashlee@gmail.com");
        us.setId(1L);
        List<Usuario> listado = Arrays.asList(us); 
        List<Usuario> expResult = listado; 
        Mockito.when(userAccess.findAll()).thenReturn(listado); 
        List<Usuario> result = instance.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class UserService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = 1L;
        Usuario us = new Usuario();
        us.setEmail("ashlee@gmail.com");
        us.setId(id);
        Optional<Usuario> expResult = Optional.of(us);
        Mockito.when(userAccess.findById(id)).thenReturn(expResult); 
        Usuario result = instance.findById(id);
        assertEquals(expResult.get(), result);
    }
    
}

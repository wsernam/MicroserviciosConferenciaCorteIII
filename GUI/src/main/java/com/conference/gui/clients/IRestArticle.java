/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.conference.gui.clients;

import com.conference.gui.entities.Articulo;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IRestArticle {
    
    public List<Articulo> getArticles();
    
    public List<Articulo>  getArticlesUser();
    
    public Articulo createArticle(Articulo ar); 
}

package com.apigateway.restClients;

import com.apigateway.entities.Articulo;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public interface IRestArticle {
    public Articulo save(Articulo articulo);
     public List<Articulo> getArticulos();
}

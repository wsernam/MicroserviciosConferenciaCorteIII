package com.conference.gui.article;

import com.conference.gui.entities.Articulo;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public interface IArticleRest {
    public Articulo save(Articulo articulo);
     public List<Articulo> getArticulos();
}

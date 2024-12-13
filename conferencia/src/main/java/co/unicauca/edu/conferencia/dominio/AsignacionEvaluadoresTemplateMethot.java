package co.unicauca.edu.conferencia.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;

public abstract class AsignacionEvaluadoresTemplateMethot {
      public Map<Articulo,List<Evaluador>> AsignacionEvaluador (List<Articulo> Articulos, List<Evaluador> Evaluadors){
    
        Map<Articulo,List<Evaluador>> afines = AffinityAssignment(Articulos,Evaluadors);
        Map<Articulo,List<Evaluador>> balanceados = afines;
        
        balanceados = balanceAssignment(balanceados); 

        return balanceados;
    }
    
   public Map<Articulo,List<Evaluador>> AffinityAssignment (List<Articulo> Articulos, List<Evaluador> Evaluadors) {
       
       Map<Articulo,List<Evaluador>> afines = new HashMap(); 
       List<Evaluador> evaluadores_afines; 
       for(Articulo p:Articulos){
           evaluadores_afines = new ArrayList(); 
           for(Evaluador e:Evaluadors){
            List<String> listPalabrasClaves = new ArrayList<>(Arrays.asList(p.getPalabrasClaves().split(",")));
               if(TheresAffinity(listPalabrasClaves,e.getResearchfields())){
                   evaluadores_afines.add(e);
               }
           }
           afines.put(p, evaluadores_afines); 
       }
       return afines; 
    }
    
   private boolean TheresAffinity(List<String> keywords, List<String> researchFields){
        for(String kw:keywords){
            for(String rf:researchFields){
                if(kw.equals(rf))
                    return true; 
            }
        }
        
        return false; 
    }
   
   protected abstract Map<Articulo,List<Evaluador>> balanceAssignment(Map<Articulo,List<Evaluador>> b); 
   protected abstract boolean balanced(Map<Articulo,List<Evaluador>> b);
  
    
}

package co.unicauca.edu.conferencia.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;
import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;

    public class StrictAssignment extends AsignacionEvaluadoresTemplateMethot {
    
    private  int Evaluadors_per_Articulo;

    public StrictAssignment(int evaluators_per_paper) {
        this.Evaluadors_per_Articulo = evaluators_per_paper;
    }
    
    @Override
    protected Map<Articulo, List<Evaluador>> balanceAssignment(Map<Articulo, List<Evaluador>> b) {
        List<Evaluador> leftover_Evaluador = new ArrayList(); 
        Map<Articulo, List<Evaluador>> balancedMap = new HashMap(); 
        Articulo Articulo;
        List<Evaluador> Evaluadors; 
        int balanced; 
        for(Articulo p:b.keySet()){
            Articulo = p;
            Evaluadors = b.get(p);
            balanced = isBalanced(Evaluadors);
            if(balanced!=0){
                if(balanced==1){
                    leftover_Evaluador.addAll(extractExcessEvaluadors(Evaluadors)); 
                }
                else{
                    Evaluadors.addAll(addLeftOverEvaluadors(Articulo,Evaluadors.size(),leftover_Evaluador));
                }
            }
            balancedMap.put(Articulo, Evaluadors);
        }
        return balancedMap;
    }

    @Override
    protected boolean balanced(Map<Articulo, List<Evaluador>> b) {
        boolean balanced = true;
        for(Articulo p:b.keySet()){
            if(b.get(p).size()!=Evaluadors_per_Articulo){
                return false; 
            }
        }
        return balanced;
    }


  
    
    private int isBalanced(List<Evaluador> v){
        if(v.size() <Evaluadors_per_Articulo){
            return -1;
        }
        else{
            if(v.size() == Evaluadors_per_Articulo)
                return 0;
        }
        return 1; 
    }
    
    private List<Evaluador> extractExcessEvaluadors(List<Evaluador> e){
        int amount_excessEvaluadors = e.size() - Evaluadors_per_Articulo;
        List<Evaluador> excessEvaluadors = new ArrayList();
        
        for(int i=0; i<amount_excessEvaluadors; i++){
            excessEvaluadors.add(e.get(i));
            e.remove(i);
        }
        
        return excessEvaluadors; 
    }
    
    private List<Evaluador> addLeftOverEvaluadors(Articulo p, int EvaluadorListSize, List<Evaluador> e){
        int amount_missingEvaluadors = Evaluadors_per_Articulo - EvaluadorListSize;
         List<Evaluador> missingEvaluadors  = new ArrayList();
        
         for(int i=0; i<amount_missingEvaluadors && i<e.size(); i++){
             
                missingEvaluadors.add(e.get(i));
        }
        
         return missingEvaluadors;
         
    }

    
    

    
}

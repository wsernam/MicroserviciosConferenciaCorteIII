package co.unicauca.edu.conferencia.dominio.modelos;

import java.util.List;

public class Evaluador {

    private Long id;
    private String email; 
    private List<String> researchfields;
    public Evaluador() {
    }

    
    public Evaluador(Long id, String email, List<String> researchfields) {
        this.id = id;
        this.email = email;
        this.researchfields = researchfields;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<String> getResearchfields() {
        return researchfields;
    }
    public void setResearchfields(List<String> researchfields) {
        this.researchfields = researchfields;
    }


    
     
}

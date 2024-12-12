package com.conference.gui.entities;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ashlee Campaz
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Usuario {
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization;
    private String password; 
    private List<String> researchfields; 
    private Long id;
    
     public Usuario(String name, String lastName, String country, String email, String organization, String password, ArrayList<String> researcherfields) {
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.organization = organization;
        this.password = password;
        this.researchfields  = researcherfields;
    }
    
     @Override
    public String toString(){
        return String.format("{\"name\": \"%s\",\"lastName\": \"%s\",\"organization\": \"%s\",\"researchfields\": %s,\"country\": \"%s\", \"email\": \"%s\",\"password\": \"%s\"}",name,lastName,organization,toStringResearchFields(),country,email,password);
    
    }
    
    public String toStringResearchFields(){
        
        String researchFields = "[";
        for(int i=0;i<this.researchfields.size()-1;i++){
            researchFields += String.format("\"%s\", ", researchfields.get(i));
        }
        researchFields += String.format("\"%s\"]", researchfields.get(this.researchfields.size()-1));
        return researchFields;
    }

    public List<String> getResearchfields() {
        return researchfields;
    }

    public void setResearchfields(ArrayList<String> researchfields) {
        this.researchfields = researchfields;
    }    
}

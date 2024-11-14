/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conference.gui.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
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
     
     public Usuario(){}
     
    public List<String> getResearcherfields() {
        return researchfields;
    }

    public void setResearcherfields(List<String> researcherfields) {
        this.researchfields = researcherfields;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

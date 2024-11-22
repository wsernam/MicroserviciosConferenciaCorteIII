/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.entities; 

import java.io.Serializable;

import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */

public class Usuario implements Serializable{
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization;
    private String password; 
    private List<String> researchfields; 

    private Long id; 

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

    public List<String> getResearchfields() {
        return researchfields;
    }

    public void setResearchfields(List<String> researchfields) {
        this.researchfields = researchfields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   public String creationJSON() {
        return "{" + "\"username\": "+ email  +", \"firstName\":" + name + ", \"lastName\":" + lastName +
                ", \"email\":" + email + ", \"enabled\":"+ true + "\"credentials\": [ {"+
                                                 "\"type\": password" +
                                                 ",\"value\":" + password +
                                                 ",\"temporary\": " + false+ "}]}";
    }

    
    
    
}

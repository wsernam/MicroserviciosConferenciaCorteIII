package com.conference.gui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar campos no definidos
public class Usuario_Autorizado {
    private String token;
    private String username; 
    private String name;
    private String lastName;
    private String email; 


    @Override
    public String toString() {
        return "Usuario_Autorizado{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" +'}';
    }
}

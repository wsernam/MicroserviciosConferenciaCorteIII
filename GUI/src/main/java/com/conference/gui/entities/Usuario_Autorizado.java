package com.conference.gui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import java.util.List;
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
    private Long id; // Agregar ID
    private String country; // Agregar país
    private String organization; // Agregar organización
    private List<String> researchfields; // Agregar campos de investigación

    @Override
    public String toString() {
        return "Usuario_Autorizado{"
                + "token='" + token + '\''
                + ", username='" + username + '\''
                + ", name='" + name + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", id=" + id
                + ", country='" + country + '\''
                + ", organization='" + organization + '\''
                + ", researchfields=" + researchfields
                + '}';
    }
}

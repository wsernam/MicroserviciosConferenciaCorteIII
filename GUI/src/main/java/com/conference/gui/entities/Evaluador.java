package com.conference.gui.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonhuila
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades desconocidas
public class Evaluador {

    private Long id;
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization;
    private List<String> researchfields;
    private Integer idConferencia; // La conferencia a la que se postula

    public Evaluador(Long id, String name, String lastName, String country, String email, String organization, List<String> researchfields, Integer idConferencia) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.organization = organization;
        this.researchfields = researchfields;
        this.idConferencia = idConferencia;
    }
}

package co.unicauca.edu.conferencia.infraestructura.input.DTOs;

import java.util.List;

/**
 *
 * @author sonhuila
 */

public class DTOEvaluador {

    private Long id;
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization;
    private List<String> researchfields;
    private Integer idConferencia; // La conferencia a la que se postula

    public DTOEvaluador() {
    }

    public DTOEvaluador(Long id, String name, String lastName, String country, String email, String organization, List<String> researchfields, Integer idConferencia) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.organization = organization;
        this.researchfields = researchfields;
        this.idConferencia = idConferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getResearchfields() {
        return researchfields;
    }

    public void setResearchfields(List<String> researchfields) {
        this.researchfields = researchfields;
    }

    public Integer getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(Integer idConferencia) {
        this.idConferencia = idConferencia;
    }
  
}
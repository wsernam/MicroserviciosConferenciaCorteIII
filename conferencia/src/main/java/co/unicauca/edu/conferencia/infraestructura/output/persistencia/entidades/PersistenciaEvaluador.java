package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.List;

/**
 *
 * @author sonhuila
 */
@Entity
public class PersistenciaEvaluador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String country;
    private String email;
    private String organization;
    private List<String> researchfields;
    private Integer idConferencia; // La conferencia a la que se postula

    @ManyToOne
    private PersistenciaConferencia conferencia;

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

    public PersistenciaConferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(PersistenciaConferencia conferencia) {
        this.conferencia = conferencia;
    }
}

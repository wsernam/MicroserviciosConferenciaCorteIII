package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import co.unicauca.edu.conferencia.dominio.modelos.Articulo;

/**
 *
 * @author sonhuila
 */
@AllArgsConstructor
@Getter
@Setter
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
    @Version
    private int version;
     @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    private PersistenciaArticulo articuloAsignado;

    public PersistenciaEvaluador() {
    }


   
}

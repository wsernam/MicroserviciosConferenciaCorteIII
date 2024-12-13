package co.unicauca.edu.conferencia.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter

@Entity
public class PersistenciaArticulo {
    @Id
    private Integer id;
    private Integer conferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public PersistenciaArticulo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConferencia() {
        return conferencia;
    }

    public void setConferencia(Integer conferencia) {
        this.conferencia = conferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
}

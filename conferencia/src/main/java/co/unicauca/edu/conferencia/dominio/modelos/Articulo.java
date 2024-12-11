package co.unicauca.edu.conferencia.dominio.modelos;

import java.util.ArrayList;



public class Articulo {
    private Integer id;
    private Integer idConferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    public Articulo(Integer id, Integer conferencia, String nombre, ArrayList<String> autores,
            String palabrasClaves) {
        this.id = id;
        this.idConferencia = conferencia;
        this.nombre = nombre;
        this.autores = autores;
        this.palabrasClaves = palabrasClaves;
    }
    public Articulo() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getIdConferencia() {
        return idConferencia;
    }
    public void setIdConferencia(Integer idConferencia) {
        this.idConferencia = idConferencia;
    }
    
    
}

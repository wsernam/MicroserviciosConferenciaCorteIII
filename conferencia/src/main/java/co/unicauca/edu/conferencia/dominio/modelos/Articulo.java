package co.unicauca.edu.conferencia.dominio.modelos;

import java.util.ArrayList;



public class Articulo {
    private Integer id;
    private Integer conferencia;
    private String nombre;
    private ArrayList<String> autores;
    private String palabrasClaves;
    private String estadoActual;
    private Evaluador evaluadorAsignado;
    
    
    public Articulo() {
    }


   


    public Articulo(Integer id, Integer conferencia, String nombre, ArrayList<String> autores, String palabrasClaves, String estadoActual,
            Evaluador evaluadorAsignado) {
        this.id = id;
        this.conferencia = conferencia;
        this.nombre = nombre;
        this.autores = autores;
        this.palabrasClaves = palabrasClaves;
        this.evaluadorAsignado = evaluadorAsignado;
        this.estadoActual=estadoActual;
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


    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", idConferencia=" + conferencia +
                ", nombre='" + nombre + '\'' +
                ", autores=" + autores +
                ", palabrasClaves='" + palabrasClaves + '\'' +
                '}';
    }





    public Evaluador getEvaluadorAsignado() {
        return evaluadorAsignado;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }





    public void setEvaluadorAsignado(Evaluador evaluadorAsignado) {
        this.evaluadorAsignado = evaluadorAsignado;
    }
    
    
}

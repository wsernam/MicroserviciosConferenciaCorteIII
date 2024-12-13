/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.conferencia.dominio.eventos;

/**
 *
 * @author wsern
 */

public class EvaluadorPostuladoEvent {
    private Integer evaluadorId;
    private String nombre;
    private String correo;
    private Integer idConferencia;
    private String nombreConferencia;

    // Constructor
    public EvaluadorPostuladoEvent(Integer evaluadorId, String nombre, String correo, Integer idConferencia, String nombreConferencia) {
        this.evaluadorId = evaluadorId;
        this.nombre = nombre;
        this.correo = correo;
        this.idConferencia = idConferencia;
        this.nombreConferencia = nombreConferencia;
    }

    // Getters y Setters
    public Integer getEvaluadorId() {
        return evaluadorId;
    }

    public void setEvaluadorId(Integer evaluadorId) {
        this.evaluadorId = evaluadorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(Integer idConferencia) {
        this.idConferencia = idConferencia;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.conferencia.dominio.eventos;

import co.unicauca.edu.conferencia.dominio.modelos.Evaluador;
import java.util.List;

/**
 *
 * @author wsern
 */
public class AsginarEvaluadoresEvent {
    private Integer evaluadorId;
    private String nombre;
    private String correo;       // Usuario que se registró como evaluador
    private Integer idArticulo;          // ID del artículo asignado
    private String tituloArticulo;   // Título del artículo
    private List<Evaluador> evaluadores;
    private int idConferencia;      // ID de la conferencia
    private String nombreConferencia;// Nombre de la conferencia

    public AsginarEvaluadoresEvent(Integer evaluadorId, String nombre, String correo, Integer idArticulo, String tituloArticulo, List<Evaluador> evaluadores, int idConferencia, String nombreConferencia) {
        this.evaluadorId = evaluadorId;
        this.nombre = nombre;
        this.correo = correo;
        this.idArticulo = idArticulo;
        this.tituloArticulo = tituloArticulo;
        this.evaluadores = evaluadores;
        this.idConferencia = idConferencia;
        this.nombreConferencia = nombreConferencia;
    }

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

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTituloArticulo() {
        return tituloArticulo;
    }

    public void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo = tituloArticulo;
    }

    public List<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Evaluador> evaluadores) {
        this.evaluadores = evaluadores;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public String getNombreConferencia() {
        return nombreConferencia;
    }

    public void setNombreConferencia(String nombreConferencia) {
        this.nombreConferencia = nombreConferencia;
    }

    
    
}

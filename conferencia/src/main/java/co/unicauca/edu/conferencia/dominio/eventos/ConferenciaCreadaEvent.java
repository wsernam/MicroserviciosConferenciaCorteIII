/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.edu.conferencia.dominio.eventos;

/**
 *
 * @author wsern
 */
public class ConferenciaCreadaEvent {
    private int idConferencia;                     // ID de la conferencia
    private String correo;                         //correo creador
    private String nombreConferencia;              // Nombre de la conferencia
    private int cantidadMaxArticulos;   // Máxima cantidad de artículos permitidos

    public ConferenciaCreadaEvent(int idConferencia, String nombreConferencia, int cantidadMaxArticulos) {
        this.idConferencia = idConferencia;
        this.nombreConferencia = nombreConferencia;
        this.cantidadMaxArticulos = cantidadMaxArticulos;
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

    public int getCantidadMaxArticulos() {
        return cantidadMaxArticulos;
    }

    public void setCantidadMaxArticulos(int cantidadMaxArticulos) {
        this.cantidadMaxArticulos = cantidadMaxArticulos;
    }

    
}

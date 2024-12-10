package co.unicauca.edu.conferencia.dominio.modelos;

import java.util.List;

public class Conferencia {
    private String nombre;
    private String temas;
    private String entidadOrganizadora;
    private String pais;
    private String estado;
    private String ciudad;
    private String direccion;
    private Fecha fechaFin;
    private Fecha fechaInicio;
    private Fecha fechaFinRecepcion;
    private Fecha fechaFinEvaluacion;
    private int numMaxRecepcion;
    private int numMaxAceptacion;
    private float calificacionMinAceptable;
    private List<Integer> articulosAceptados;
    private List<Integer> articulosRecividos;

    public Conferencia(String nombre, String temas, String entidadOrganizadora, String pais, String estado,
            String ciudad, String direccion, Fecha fechaFin, Fecha fechaInicio, Fecha fechaFinRecepcion,
            Fecha fechaFinEvaluacion, int numMaxRecepcion, int numMaxAceptacion, float calificacionMinAceptable) {
        this.nombre = nombre;
        this.temas = temas;
        this.entidadOrganizadora = entidadOrganizadora;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFinRecepcion = fechaFinRecepcion;
        this.fechaFinEvaluacion = fechaFinEvaluacion;
        this.numMaxRecepcion = numMaxRecepcion;
        this.numMaxAceptacion = numMaxAceptacion;
        this.calificacionMinAceptable = calificacionMinAceptable;
    }






    public Conferencia() {
    }








    public String ValidarFechas() {
        // Validar que la fecha de inicio de la conferencia sea futura
        if (!this.fechaInicio.esMayorAFechaActual()) {
           
            return "La fecha de inicio debe ser mayor a la fecha actual";
        }

        // La fecha de recepción de artículos debe ser antes de la conferencia
        if (this.fechaFinRecepcion.esDespuesDe(fechaInicio)) {
           
           return "La fecha de recepción de artículos debe ser antes de la conferencia";
        }

        // La fecha de evaluación debe ser válida en el rango
        if (!this.fechaFinEvaluacion.estaEnRango(this.fechaFinRecepcion, fechaInicio)) {
            
            return "La fecha de evaluación debe ser después de la recepción y antes de la fecha de inicio de la conferencia";
        }
        return "ok";
    }

    public String MaxArticulosAceptados(){
        if(this.articulosAceptados.size()>this.numMaxAceptacion){
            return "No es posible recibir un nuevo articulo";
        }
        return "ok";    
    }    

    public String MaxArticulosRecividos(int numMaxRecividos){
        if(this.articulosRecividos.size()>this.numMaxRecepcion){
            return "No es posible aceptar mas articulos";
        }
        return "ok";    
    }    
    
}

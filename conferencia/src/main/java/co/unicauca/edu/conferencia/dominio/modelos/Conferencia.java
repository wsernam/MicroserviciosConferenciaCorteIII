package co.unicauca.edu.conferencia.dominio.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conferencia {

    public Integer id;
    public String organizador;
    public String nombre;
    public String temas;
    public String entidadOrganizadora;
    public String pais;
    public String estado;
    public String ciudad;
    public String direccion;
    public LocalDate fechaFin;
    public LocalDate fechaInicio;
    public LocalDate fechaFinRecepcion;
    public LocalDate fechaFinEvaluacion;
    public int numMaxEvaluadores;
    public int numMaxRecepcion;
    public int numMaxAceptacion;
    public float calificacionMinAceptable;
    public List<Articulo> articulosAceptados;
    public List<Articulo> articulosRecibidos;
    private List<Evaluador> evaluadores; // Lista con la información completa de los evaluadores

    

    public Conferencia(Integer id, String organizador, String nombre, String temas, String entidadOrganizadora,
            String pais, String estado, String ciudad, String direccion, LocalDate fechaFin, LocalDate fechaInicio,
            LocalDate fechaFinRecepcion, LocalDate fechaFinEvaluacion, int numMaxEvaluadores, int numMaxRecepcion,
            int numMaxAceptacion, float calificacionMinAceptable, List<Articulo> articulosAceptados,
            List<Articulo> articulosRecibidos, List<Evaluador> evaluadores) {
        this.id = id;
        this.organizador = organizador;
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
        this.numMaxEvaluadores = numMaxEvaluadores;
        this.numMaxRecepcion = numMaxRecepcion;
        this.numMaxAceptacion = numMaxAceptacion;
        this.calificacionMinAceptable = calificacionMinAceptable;
        this.articulosAceptados = articulosAceptados;
        this.articulosRecibidos = articulosRecibidos;
        this.evaluadores = evaluadores;
    }

    public Conferencia() {
        this.articulosAceptados = new ArrayList<>();
        this.articulosRecibidos = new ArrayList<>();
        this.evaluadores = new ArrayList<>();
    }

    public String validarFechas() {
        // Validar que la fecha de inicio sea futura
        if (fechaInicio.isBefore(LocalDate.now())) {
            return "La fecha de inicio debe ser mayor a la fecha actual";
        }

        // Validar que la fecha de recepción de artículos sea antes de la conferencia
        if (fechaFinRecepcion.isAfter(fechaInicio)) {
            return "La fecha de recepción de artículos debe ser antes de la conferencia";
        }

        // Validar que la fecha de evaluación esté en el rango correcto
        if (fechaFinEvaluacion.isBefore(fechaFinRecepcion) || fechaFinEvaluacion.isAfter(fechaInicio)) {
            return "La fecha de evaluación debe ser después de la recepción y antes de la fecha de inicio de la conferencia";
        }

        return "ok";
    }

    public String maxArticulosAceptados() {
        if (articulosAceptados.size() >= numMaxAceptacion) {
            return "No es posible aceptar más artículos";
        }
        return "ok";
    }
    

    public String maxArticulosRecibidos() {
        if (articulosRecibidos.size() >= numMaxRecepcion) {
            return "No es posible recibir más artículos";
        }
        return "ok";
    }

    public boolean puedeAceptarEvaluador() {
        // Verificar si ya se ha alcanzado el límite de evaluadores
        return evaluadores.size() < numMaxEvaluadores;
    }

    public String postularEvaluador(Evaluador evaluador) {
        // Verificar si el evaluador ya está registrado en la conferencia
        if (evaluadores.contains(evaluador)) {
            return "El evaluador ya está registrado en esta conferencia.";
        }

        // Verificar si la conferencia puede aceptar más evaluadores
        if (!puedeAceptarEvaluador()) {
            return "No es posible agregar más evaluadores, el límite ha sido alcanzado.";
        }

        // Agregar el evaluador a la lista de la conferencia
        evaluadores.add(evaluador);
        return "Evaluador postulado exitosamente.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getEntidadOrganizadora() {
        return entidadOrganizadora;
    }

    public void setEntidadOrganizadora(String entidadOrganizadora) {
        this.entidadOrganizadora = entidadOrganizadora;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaFinRecepcion() {
        return fechaFinRecepcion;
    }

    public void setFechaFinRecepcion(LocalDate fechaFinRecepcion) {
        this.fechaFinRecepcion = fechaFinRecepcion;
    }

    public LocalDate getFechaFinEvaluacion() {
        return fechaFinEvaluacion;
    }

    public void setFechaFinEvaluacion(LocalDate fechaFinEvaluacion) {
        this.fechaFinEvaluacion = fechaFinEvaluacion;
    }

    public int getNumMaxRecepcion() {
        return numMaxRecepcion;
    }

    public void setNumMaxRecepcion(int numMaxRecepcion) {
        this.numMaxRecepcion = numMaxRecepcion;
    }

    public int getNumMaxAceptacion() {
        return numMaxAceptacion;
    }

    public void setNumMaxAceptacion(int numMaxAceptacion) {
        this.numMaxAceptacion = numMaxAceptacion;
    }

    public float getCalificacionMinAceptable() {
        return calificacionMinAceptable;
    }

    public void setCalificacionMinAceptable(float calificacionMinAceptable) {
        this.calificacionMinAceptable = calificacionMinAceptable;
    }

    public List<Articulo> getArticulosAceptados() {
        return articulosAceptados;
    }

    public void setArticulosAceptados(List<Articulo> articulosAceptados) {
        this.articulosAceptados = articulosAceptados;
    }

    public List<Articulo> getArticulosRecibidos() {
        return articulosRecibidos;
    }

    public void setArticulosRecibidos(List<Articulo> articulosRecibidos) {
        this.articulosRecibidos = articulosRecibidos;
    }

    public List<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Evaluador> evaluadores) {
        this.evaluadores = evaluadores;
    }

    public int getNumMaxEvaluadores() {
        return numMaxEvaluadores;
    }

    public void setNumMaxEvaluadores(int numMaxEvaluadores) {
        this.numMaxEvaluadores = numMaxEvaluadores;
    }

    @Override
    public String toString() {
        return "Conferencia{"
                + "nombre='" + nombre + '\''
                + ", temas='" + temas + '\''
                + ", entidadOrganizadora='" + entidadOrganizadora + '\''
                + ", pais='" + pais + '\''
                + ", estado='" + estado + '\''
                + ", ciudad='" + ciudad + '\''
                + ", direccion='" + direccion + '\''
                + ", fechaFin=" + fechaFin
                + ", fechaInicio=" + fechaInicio
                + ", fechaFinRecepcion=" + fechaFinRecepcion
                + ", fechaFinEvaluacion=" + fechaFinEvaluacion
                + ", numMaxRecepcion=" + numMaxRecepcion
                + ", numMaxAceptacion=" + numMaxAceptacion
                + ", calificacionMinAceptable=" + calificacionMinAceptable
                + ", articulosAceptados=" + articulosAceptados
                + ", articulosRecibidos=" + articulosRecibidos
                + '}';
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

}

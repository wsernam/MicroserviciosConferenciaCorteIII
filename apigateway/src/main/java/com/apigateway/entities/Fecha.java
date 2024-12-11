package com.apigateway.entities;

import java.time.LocalDate;

public class Fecha implements Comparable<Fecha> {
    private final LocalDate fecha;//No cambia en el tiempo

    public Fecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Validaciones de negocio para las fechas
    public boolean esAntesDe(Fecha otraFecha) {
        return this.fecha.isBefore(otraFecha.getFecha());//retorna true si la fecha esta antes
    }

    public boolean esDespuesDe(Fecha otraFecha) {
        return this.fecha.isAfter(otraFecha.getFecha());//retorna false si la fecha esta antes
    }

    public boolean esIgualODespuesDe(Fecha otraFecha) {
        return !this.fecha.isBefore(otraFecha.getFecha());//retorna true si la fecha es igual o mayor
    }

    // Método para validar que la fecha es mayor que la fecha actual
    public boolean esMayorAFechaActual() {
        LocalDate hoy = LocalDate.now(); // Fecha actual
        return this.fecha.isAfter(hoy); // Devuelve true si this.fecha es posterior a hoy
    }

    // Método para validar que una fecha esté dentro de un rango
    public boolean estaEnRango(Fecha inicio, Fecha fin) {
        return (this.fecha.isAfter(inicio.getFecha()) || this.fecha.isEqual(inicio.getFecha())) &&
               (this.fecha.isBefore(fin.getFecha()) || this.fecha.isEqual(fin.getFecha()));
    }

    @Override
    public int compareTo(Fecha otraFecha) {
        return this.fecha.compareTo(otraFecha.getFecha());
    }

    // Otros métodos para comparar fechas (por ejemplo, validación de igualdad)
    public boolean esIgualA(Fecha otraFecha) {
        return this.fecha.isEqual(otraFecha.getFecha());
    }
}
 
    


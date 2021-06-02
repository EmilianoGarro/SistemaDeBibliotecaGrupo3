/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Emiliano
 */
public class Prestamo {
 private int id_Prestamo;
 private Ejemplar ejemplar;
 private Lector lector;
 private Multa multa=null;
 private LocalDate fechaPrestamo,fechaDevolucion;
 private boolean activo = false;
 
 public Prestamo(){};
 
    public Prestamo(Ejemplar ejemplar, Lector lector) {
        this.ejemplar = ejemplar;
        this.lector = lector;
        
    }

    public void solicitarEjemplar(){
    this.activo=true;
    this.fechaPrestamo=LocalDate.now();
    this.fechaDevolucion=fechaPrestamo.plusDays(30);
    this.ejemplar.setActivo(false);
    }
    
    public void devolverEjemplar(){
    this.activo=false;
    this.ejemplar.setActivo(true);
    }
    

    public int getId_Prestamo() {
        return id_Prestamo;
    }

    public void setId_Prestamo(int id_Prestamo) {
        this.id_Prestamo = id_Prestamo;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
 
}

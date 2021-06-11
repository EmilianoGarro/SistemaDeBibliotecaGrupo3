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
 private LocalDate fechaPrestamo=null,fechaDevolucion=null;
 private boolean activo = false;
// prestado, retraso, reparación, disponible en biblioteca
 public Prestamo(){};
 
    public Prestamo(Lector lector,Ejemplar ejemplar) {
        this.lector = lector;
        this.ejemplar=ejemplar;
        
    }

//    public void solicitarEjemplar(){
//    
//        this.activo=true;    
//    this.fechaPrestamo=LocalDate.now();
//    
//    this.ejemplar.setEstado("Prestado");
//
//
//    }
//    
//    public void devolverEjemplar(){
//    this.activo=false;
//    this.fechaDevolucion=LocalDate.now();
//    this.ejemplar.setEstado("Disponible en Biblioteca");
//    }
//    
//    public void solicitarEjemplar(Ejemplar ejemplar){
//    if(ejemplar!=null&&ejemplar.getEstado().equals("Disponible")&&ejemplar.isActivo()==true){
//    this.ejemplar=ejemplar;
//    this.fechaPrestamo=LocalDate.now();
//    this.ejemplar.setEstado("Prestado");
//    }
//        
//    }
//    
//    public void devolverEjemplar(Ejemplar ejemplar,Lector lector){
//    this.activo=false;
//    this.fechaDevolucion=LocalDate.now();
//    this.ejemplar.setEstado("Disponible en Biblioteca");
//    }

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

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }


}



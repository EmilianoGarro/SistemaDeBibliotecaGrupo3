/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import java.time.LocalDate;

/**
 *
 * @author Emiliano
 */
public class Multa {
private int id_Multa;
private LocalDate fechaInicio,fechaFin;
private boolean estado;

    public Multa(){};

    public Multa(LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public int getId_Multa() {
        return id_Multa;
    }

    public void setId_Multa(int id_Multa) {
        this.id_Multa = id_Multa;
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Inicio=" + fechaInicio + ", Fin=" + fechaFin;
    }
    
}

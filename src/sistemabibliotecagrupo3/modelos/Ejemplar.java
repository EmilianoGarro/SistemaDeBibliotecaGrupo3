/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

/**
 *
 * @author Emiliano
 */
public class Ejemplar {
 private int id_Ejemplar;
 private Libro libro;
 private String estado;
 private boolean activo;
 
 public Ejemplar(){};

    public Ejemplar(Libro libro, String estado, boolean activo) {
        this.libro = libro;
        this.estado = estado;
        this.activo = activo;
    }

    public Ejemplar(Libro libro, String estado) {
        this.libro = libro;
        this.estado = estado;
    }
    

    public int getId_Ejemplar() {
        return id_Ejemplar;
    }

    public void setId_Ejemplar(int id_Ejemplar) {
        this.id_Ejemplar = id_Ejemplar;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
 
}

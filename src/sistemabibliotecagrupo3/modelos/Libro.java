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
public class Libro {
private int id_Libro,anio;
private Autor autor;
private String ISBN;
private String nombre,tipo,editorial;
private boolean activo;

public Libro(){};

     public Libro(int id_Libro, int anio, Autor autor, String ISBN, String nombre, String tipo, String editorial, boolean activo) {
        this.id_Libro = id_Libro;
        this.anio = anio;
        this.autor = autor;
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.activo = activo;
    }

    public Libro(Autor autor, String ISBN, String nombre, String tipo, String editorial, int anio, boolean activo) {
        this.anio = anio;
        this.autor = autor;
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.activo = activo;
    }

    public int getId_Libro() {
        return id_Libro;
    }

    public void setId_Libro(int id_Libro) {
        this.id_Libro = id_Libro;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}

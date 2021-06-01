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
public class Lector {
    int id_Lector,dni;
    String apellido,nombre;
    boolean activo;
    
    public Lector(){};

    public int getId_Lector() {
        return id_Lector;
    }

    public void setId_Lector(int id_Lector) {
        this.id_Lector = id_Lector;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}

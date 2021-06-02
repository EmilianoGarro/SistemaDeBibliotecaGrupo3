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
    private int id_Lector,dni;
    private String apellido,nombre,email;
    private boolean activo;
    
    public Lector(){};

    public Lector(int dni, String apellido, String nombre, String email, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.activo = activo;
    }

    public Lector(int dni, String apellido, String nombre, String email) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
    }
    
    

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

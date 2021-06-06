/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Emiliano
 */public class Lector {
    private int id_Lector,dni;
    private String apellido,nombre,email;
    private boolean activo;
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public Lector(){};

     
    public Lector(int dni, String apellido, String nombre, String email, boolean activo) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        if(this.isValidEmail(email).find()==true){
        this.email=email;
        }
        else{this.email=null;}
        this.activo = activo;
    }

    public Lector(int dni, String apellido, String nombre, String email) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        if(this.isValidEmail(email).find()==true){
        this.email=email;
        }
        else{this.email=null;}
    }
    
    public Matcher isValidEmail(String email) {
      Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
      return pattern.matcher(email);
   }
    
      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.isValidEmail(email).find()==true){
        this.email=email;
        }
        else{this.email=null;}
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


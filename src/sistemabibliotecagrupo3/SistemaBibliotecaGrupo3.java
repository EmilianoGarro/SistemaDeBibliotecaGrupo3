/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemabibliotecagrupo3.modelos.Autor;
import sistemabibliotecagrupo3.modelos.AutorData;
import sistemabibliotecagrupo3.modelos.Conexion;
import sistemabibliotecagrupo3.modelos.Ejemplar;
import sistemabibliotecagrupo3.modelos.EjemplarData;
import sistemabibliotecagrupo3.modelos.Lector;
import sistemabibliotecagrupo3.modelos.LectorData;
import sistemabibliotecagrupo3.modelos.Libro;
import sistemabibliotecagrupo3.modelos.LibroData;

/**
 *
 * @author Emiliano
 */
public class SistemaBibliotecaGrupo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Conexion conexion;
        try {
            conexion = new Conexion();
            Connection con = conexion.getConexion();
            AutorData ad1 = new AutorData(conexion);
            LibroData libD1 = new LibroData(conexion);
            LectorData ld1 = new LectorData(conexion);
            EjemplarData eD = new EjemplarData(conexion);
            //Prueba autor
            
            //Autor a1 = new Autor(12345678, "Prueba", "Prueba", "Argentina", LocalDate.of(2000, 11, 13), true);
            //Autor a2 = new Autor(87654321, "Prueba", "Prueba", "Brasil", LocalDate.of(2001, 12, 25), false);
            
            //Prueba AutorData
            
            //ad1.guardarAutor(a1);
            //ad1.actualizarAutor(a2);
            //ad1.eliminarAutor(23);
            
            //Prueba libro
            
            //Libro lib1 = new Libro(a1, "4758-545654-6456", "Libro de Ejemplo", "Terror", "Prueba nose", 2010, true);
            //Libro lib2 = new Libro(a1, "5439-545121-6543", "Ejemplo de Libro", "Suspenso", "AeAee", 2009, true);
            
            //Prueba LibroData
            
            //libD1.guardarLibro(lib1);
            //libD1.actualizarLibro(lib2);
            //libD1.eliminarLibro(35);
            
            //Prueba Lector
            
            //Autor asd = ad1.buscarAutor(5);
            //System.out.println(asd.getFechaNac());
            //Libro a = libD1.buscarLibro(0);
            //System.out.println(a.getAutor().getApellido());
            //Ejemplar aux = eD.buscarEjemplar(1);
            
            //System.out.println(aux.getLibro().getAutor().getApellido());
            Lector l1 = new Lector(0077,"Pruebaaaa1","Prueb11a1","E-mail",true);
            //l1.setId_Lector(11);
            //Prueba LectorData
            //ld1.borrarLector(10);
            //System.out.println(ld1.buscarLector(11).getApellido());
            //ld1.guardarLector(l1);
            //ld1.actualizarLector(11,l1);
            //ld1.darAltaLector(11);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaBibliotecaGrupo3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SistemaBibliotecaGrupo3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

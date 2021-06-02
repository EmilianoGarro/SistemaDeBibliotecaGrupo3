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
            
            //Prueba autor
            
            Autor a1 = new Autor(12345678, "Prueba", "Prueba", "Argentina", LocalDate.of(2000, 11, 13), true);
            Autor a2 = new Autor(87654321, "Prueba", "Prueba", "Brasil", LocalDate.of(2001, 12, 25), false);
            
            //Prueba AutorData
            
            ad1.guardarAutor(a1);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaBibliotecaGrupo3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SistemaBibliotecaGrupo3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

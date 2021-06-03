/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class LibroData {
    private Connection con;
    private Conexion conexion;
    public LibroData(Conexion conexion){
        try {
            this.conexion=conexion;
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Libro buscarLibro(int id){
    Libro auxLibro = null;
    try{
        String sql = "SELECT * FROM libro WHERE idLibro=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        auxLibro = new Libro();
        auxLibro.setId_Libro(rs.getInt("idLibro"));
        auxLibro.setISBN(rs.getString("isbn"));
        auxLibro.setNombre(rs.getString("nombre"));
        Autor auxAutor = buscarAutor(rs.getInt("idAutor"));
        auxLibro.setAutor(auxAutor);
        auxLibro.setTipo(rs.getString("tipo"));
        auxLibro.setAnio(rs.getInt("anio"));
        auxLibro.setActivo(rs.getBoolean("activo"));
        auxLibro.setEditorial(rs.getString("editorial"));
        }
        ps.close();
        
    
    }   catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar el libro "+" "+ex.getMessage());
    }
    return auxLibro;
    }
    
    public Autor buscarAutor(int id){
        AutorData auxAutorData = new AutorData(conexion);
        Autor auxAutor = auxAutorData.buscarAutor(id);
        return auxAutor;
    }
    
    public void guardarLibro(Libro libro){
        
        try{
            String sql = "INSERT INTO libro(idAutor, isbn, nombre, tipo, editorial, anio, activo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getAutor().getId_Autor());
            ps.setString(2, libro.getISBN());
            ps.setString(3, libro.getNombre());
            ps.setString(4, libro.getTipo());
            ps.setString(5, libro.getEditorial());
            ps.setInt(6, libro.getAnio());
            ps.setBoolean(7, libro.isActivo());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    libro.setId_Libro(rs.getInt("idLibro"));
                }
            ps.close();
            
            //Avisa que se agrego...
            JOptionPane.showMessageDialog(null, "Se agrego correctamente el Libro " + libro.getNombre());
        } catch (SQLException ex) {
            //Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
            //avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error en la carga del libro " + libro.getNombre() + " " + ex.getMessage());
        } 
    }   
    
    public void eliminarLibro(int id){
        
        try{
            String sql = "UPDATE libro SET idLibro=0 WHERE idLibro=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            //Avisa que se elimino...
            JOptionPane.showMessageDialog(null, "El libro se elimino correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al eliminar el libro " + ex.getMessage());
        }
    }
    
    public void actualizarLibro(Libro libro){
        
        try{
            String sql = "UPDATE libro SET idAutor=?,isbn=?,nombre=?,tipo=?,editorial=?,anio=?,activo=? WHERE idLibro=?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getAutor().getId_Autor());
            ps.setString(2, libro.getISBN());
            ps.setString(3, libro.getNombre());
            ps.setString(4, libro.getTipo());
            ps.setString(5, libro.getEditorial());
            ps.setInt(6, libro.getAnio());
            ps.setBoolean(7, libro.isActivo());
            ps.setInt(8, libro.getId_Libro());
            
            ps.executeUpdate();
            
            ps.close();
            //Avisa que se actualizo...
            JOptionPane.showMessageDialog(null, "El libro " + libro.getNombre() + " se actualizo correctamente.");
        } catch (SQLException ex) {
            //Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error en la actualizacion del libro " + libro.getNombre() + " " + ex.getMessage());
        }
    }
}

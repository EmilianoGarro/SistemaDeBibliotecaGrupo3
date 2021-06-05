/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemabibliotecagrupo3.modelos.Autor;
import sistemabibliotecagrupo3.modelos.Conexion;

/**
 *
 * @author Asus
 */
public class AutorData {
    private Connection con;
    
    public AutorData(Conexion conexion){
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Autor buscarAutor(int id){
    Autor auxAutor = null;
    try{
        String sql = "SELECT * FROM autor WHERE idAutor=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        auxAutor = new Autor();
        auxAutor.setNombre(rs.getString("nombre"));
        auxAutor.setApellido(rs.getString("apellido"));
        auxAutor.setDni(rs.getInt("dni"));
        auxAutor.setFechaNac(rs.getDate("fechaNac").toLocalDate());
        auxAutor.setNacionalidad(rs.getString("nacionalidad"));
        auxAutor.setActivo(rs.getBoolean("activo"));
        auxAutor.setId_Autor(rs.getInt("idAutor"));
        }
        ps.close();
           
    }   catch (SQLException ex) {
            //Notificacion si falla
            JOptionPane.showMessageDialog(null, "Error al buscar el autor "+" "+ex.getMessage());
        }
    
    return auxAutor;    
    }
    
    public void guardarAutor(Autor autor){
        
        try{
        String sql="INSERT INTO autor(dni, apellido, nombre, nacionalidad, fechaNac, activo) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, autor.getDni());
        ps.setString(2, autor.getNombre());
        ps.setString(3, autor.getApellido());
        ps.setString(4, autor.getNacionalidad());
        ps.setDate(5, Date.valueOf(autor.getFechaNac()));
        ps.setBoolean(6, autor.isActivo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
            if (rs.next()){
                autor.setId_Autor(rs.getInt("idAutor"));
            }
        ps.close();
        //Aviso de que se guardo...
        JOptionPane.showMessageDialog(null, "El Autor " + autor.getApellido() + " se guardo correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el autor " + autor.getApellido() + " " + ex.getMessage());
        }
    }
    
    public void actualizarAutor(Autor autor){
        
        try{
        String sql = "UPDATE autor SET dni=?, apellido=?, nombre=?, nacionalidad=?, fechaNac=?, activo=? WHERE idAutor=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, autor.getDni());
        ps.setString(2, autor.getApellido());
        ps.setString(3, autor.getNombre());
        ps.setString(4, autor.getNacionalidad());
        ps.setDate(5, Date.valueOf(autor.getFechaNac()));
        ps.setBoolean(6, autor.isActivo());
        ps.setInt(7, autor.getId_Autor());
        
        ps.executeUpdate();
        ps.close();
        //avisa que se actualizo...
        JOptionPane.showMessageDialog(null, "Se pudo actualizar correctamente el Autor " + autor.getApellido());
        } catch (SQLException ex) {
            //Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde fue...
            JOptionPane.showMessageDialog(null, "Error al actualizar el Autor " + autor.getApellido() + " " + ex.getMessage());
        }
    }
    
    public void eliminarAutor(int id){
        
        try{
            String sql = "UPDATE autor SET activo=0 WHERE idAutor= ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            //Avisamos que se elimino...
            JOptionPane.showMessageDialog(null, "El Autor se elimino correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisamos el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error en la eliminacion del autor " + ex.getMessage());
        }
    }
    
    public List<Autor> obtenerAutores(){
    List<Autor> autores= new ArrayList<>();
        
        try{ 
          String sql= "SELECT * FROM autor"; 
          PreparedStatement ps= con.prepareStatement(sql);
          
          ResultSet rs=ps.executeQuery();  
          Autor autor;
          while (rs.next()){
            autor=new Autor();
            autor.setNombre(rs.getString("nombre"));
            autor.setApellido(rs.getString("apellido"));
            autor.setDni(rs.getInt("dni"));
            autor.setFechaNac(rs.getDate("fechaNac").toLocalDate());
            autor.setNacionalidad(rs.getString("nacionalidad"));
            autor.setActivo(rs.getBoolean("activo"));
            autor.setId_Autor(rs.getInt("idAutor"));
            autores.add(autor);
          }
                    
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al listar los autores. "+ex.getMessage());
        }
    
    return autores;
        
    }
    
    public List<Autor> obtenerAutoresSegunEstado(int estado){
    List<Autor> autores= new ArrayList<>();
        
        try{ 
          String sql= "SELECT * FROM autor WHERE activo=?"; 
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setInt(1, estado);
          ResultSet rs=ps.executeQuery();  
          Autor autor;
          while (rs.next()){
            autor=new Autor();
            autor.setNombre(rs.getString("nombre"));
            autor.setApellido(rs.getString("apellido"));
            autor.setDni(rs.getInt("dni"));
            autor.setFechaNac(rs.getDate("fechaNac").toLocalDate());
            autor.setNacionalidad(rs.getString("nacionalidad"));
            autor.setActivo(rs.getBoolean("activo"));
            autor.setId_Autor(rs.getInt("idAutor"));
            autores.add(autor);
          }
                    
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al listar los autores. "+ex.getMessage());
        }
    
    return autores;
        
    }
}

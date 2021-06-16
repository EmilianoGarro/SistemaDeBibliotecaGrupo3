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
            JOptionPane.showMessageDialog(null, "Error de conexion"+" "+ex.getMessage());
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
        ps.setString(2, autor.getApellido());
        ps.setString(3, autor.getNombre());
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
    Autor auxAutor = buscarAutor(autor.getId_Autor());
    if(auxAutor!=null){
        try{
        String sql = "UPDATE autor SET dni=?, apellido=?, nombre=?, nacionalidad=?, fechaNac=?, activo=? WHERE idAutor=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, autor.getDni());
        ps.setString(2, autor.getApellido());
        ps.setString(3, autor.getNombre());
        ps.setString(4, autor.getNacionalidad());
        ps.setDate(5, Date.valueOf(autor.getFechaNac()));
        ps.setBoolean(6, autor.isActivo());
        ps.setInt(7,autor.getId_Autor());
        
        ps.executeUpdate();
        ps.close();
        //avisa que se actualizo...
        JOptionPane.showMessageDialog(null, "Se pudo actualizar correctamente el Autor " + autor.getApellido());
        } catch (SQLException ex) {
            //Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde fue...
            JOptionPane.showMessageDialog(null, "Error al actualizar el Autor " + autor.getApellido() + " " + ex.getMessage());
        }
    }else{
    JOptionPane.showMessageDialog(null, "El autor que desea actualizar no esta en la base de datos");
    }
    }
    
    public void darBajaAutor(int id){
    Autor auxAutor = buscarAutor(id);
    if(auxAutor!=null&&auxAutor.isActivo()==true){
        try{
            String sql = "UPDATE autor SET activo=0 WHERE idAutor= ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            //Avisamos que se elimino...
            JOptionPane.showMessageDialog(null, "El Autor se dio de baja correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisamos el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al dar de baja al autor " + ex.getMessage());
        }}else if(auxAutor==null){
        JOptionPane.showMessageDialog(null, "El autor que desea dar de baja no esta en la base de datos");
        }else if(auxAutor.isActivo()==false){
        JOptionPane.showMessageDialog(null, "El autor ya esta dado de baja");
        }
    }
    
    public void darAltaAutor(int id){
    Autor auxAutor = buscarAutor(id);
    if(auxAutor!=null&&auxAutor.isActivo()==false){
        try{
            String sql = "UPDATE autor SET activo=1 WHERE idAutor= ?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            //Avisamos que se elimino...
            JOptionPane.showMessageDialog(null, "El Autor se dio de alta correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(AutorData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisamos el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al dar de alta al autor " + ex.getMessage());
        }
    }else if(auxAutor==null){
    JOptionPane.showMessageDialog(null, "El autor que desea dar de alta no esta en la base de datos");
    }else if(auxAutor.isActivo()==true){
    JOptionPane.showMessageDialog(null, "El autor ya esta dado de alta");
    }
    }
    
    public void eliminarAutor(int id){
    Autor auxAutor = buscarAutor(id);
    if(auxAutor!=null){
    try{
        String sql = "DELETE FROM autor WHERE idAutor=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El autor se elimino correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el autor "+" "+ex.getMessage());
        }
    }else{
    JOptionPane.showMessageDialog(null, "El autor que desea eliiminar no esta en la base de datos");
    }
    
    
    
    }
    
    public List<Autor> obtenerAutores(){
    List<Autor> autores = new ArrayList<>();
    try{
        String sql = "SELECT * FROM autor";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Autor auxAutor;
        while(rs.next()){
        auxAutor = new Autor();
        auxAutor.setId_Autor(rs.getInt("idAutor"));
        auxAutor.setActivo(rs.getBoolean("activo"));
        auxAutor.setDni(rs.getInt("dni"));
        auxAutor.setNacionalidad(rs.getString("nacionalidad"));
        auxAutor.setFechaNac(rs.getDate("fechaNac").toLocalDate());
        auxAutor.setNombre(rs.getString("nombre"));
        auxAutor.setApellido(rs.getString("apellido"));
        autores.add(auxAutor);
        }
        ps.close();
        
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los autores"+" "+ex.getMessage());
        }
    
    return autores;
    }
    
    public List<Autor> obtenerAutoresSegunEstado(boolean activo){
    List<Autor> autores= new ArrayList<>();
        
        try{ 
          String sql= "SELECT * FROM autor WHERE activo=?"; 
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, activo);
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
            JOptionPane.showMessageDialog(null, "error al obtener los autores. "+ex.getMessage());
        }
    
    return autores;
        
    }
}

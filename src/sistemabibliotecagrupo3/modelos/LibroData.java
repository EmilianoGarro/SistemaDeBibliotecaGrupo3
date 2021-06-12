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
import java.util.ArrayList;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "Error de conexion"+" "+ex.getMessage());
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
    
    public List<Autor> ListarAutores(){
        AutorData auxAutorData = new AutorData(conexion);
        List<Autor> autores = auxAutorData.obtenerAutoresSegunEstado(true);
        return autores;
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
    
    public void darBajaLibro(int id){
    Libro auxLibro = buscarLibro(id);
    if(auxLibro!=null&&auxLibro.isActivo()==true){
        try{
            String sql = "UPDATE libro SET activo=0 WHERE idLibro=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            //Avisa que se elimino...
            JOptionPane.showMessageDialog(null, "El libro se dio de baja correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al dar de baja el libro " + ex.getMessage());
        }
    }else if(auxLibro==null){
    JOptionPane.showMessageDialog(null, "El libro que desea dar de baja no esta en la base de datos");
    }else if(auxLibro.isActivo()==false){
    JOptionPane.showMessageDialog(null, "El libro ya esta dado de baja");
    }
    }
 
    public void darAltaLibro(int id){
    Libro auxLibro = buscarLibro(id);
    if(auxLibro!=null&&auxLibro.isActivo()==false){
        try{
            String sql = "UPDATE libro SET activo=1 WHERE idLibro=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            
            JOptionPane.showMessageDialog(null, "El libro se dio de alta correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al dar de alta el libro " + ex.getMessage());
        }
    }else if(auxLibro==null){
    JOptionPane.showMessageDialog(null, "El libro que desea dar de alta no esta en la base de datos");
    }else if(auxLibro.isActivo()==true){
    JOptionPane.showMessageDialog(null, "El libro ya esta dado de alta");
    }
    }
    
    public void eliminarLibro(int id){
    Libro auxLibro = buscarLibro(id);
    if(auxLibro!=null){
    try{
        String sql = "DELETE FROM libro WHERE idLibro=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El libro se elimino correctamente");
    
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar el libro "+" "+ex.getMessage());
        }
    
    
    }else{
    JOptionPane.showMessageDialog(null, "El libro que desea borrar no esta en la base de datos");
    }
    }
    
    public void actualizarLibro(Libro libro){
    Libro auxLibro = buscarLibro(libro.getId_Libro());
    if(auxLibro!=null){
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
    }else{
    JOptionPane.showMessageDialog(null, "El libro que desea actualizar no esta en la base de datos");
}}

    public List<Libro> obtenerLibros(){
    List<Libro> libros = new ArrayList<>();
    try{
        String sql = "SELECT * FROM libro";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Libro auxLibro;
        while(rs.next()){
        auxLibro = new Libro();
        auxLibro.setId_Libro(rs.getInt("idLibro"));
        auxLibro.setAnio(rs.getInt("anio"));
        Autor auxAutor = buscarAutor(rs.getInt("idAutor"));
        auxLibro.setAutor(auxAutor);
        auxLibro.setISBN(rs.getString("isbn"));
        auxLibro.setEditorial(rs.getString("editorial"));
        auxLibro.setActivo(rs.getBoolean("activo"));
        auxLibro.setNombre(rs.getString("nombre"));
        auxLibro.setTipo(rs.getString("tipo"));
        libros.add(auxLibro);
        }
        ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los libros "+" "+ex.getMessage());
        }
    return libros;
    }
    
    public List<Libro> obtenerLibrosSegunEstado(boolean activo){
    List<Libro> libros= new ArrayList<>();
        
        try{ 
          String sql= "SELECT * FROM libro WHERE activo=?"; 
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, activo);
          ResultSet rs=ps.executeQuery();  
          Libro libro;
          while (rs.next()){
            libro = new Libro();
            libro.setId_Libro(rs.getInt("idLibro"));
            libro.setISBN(rs.getString("isbn"));
            libro.setNombre(rs.getString("nombre"));
            libro.setAutor(buscarAutor(rs.getInt("idAutor")));
            libro.setTipo(rs.getString("tipo"));
            libro.setAnio(rs.getInt("anio"));
            libro.setActivo(rs.getBoolean("activo"));
            libro.setEditorial(rs.getString("editorial"));
            libros.add(libro);
          }
                    
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al listar los libros. "+ex.getMessage());
        }
    return libros;  
    }
}


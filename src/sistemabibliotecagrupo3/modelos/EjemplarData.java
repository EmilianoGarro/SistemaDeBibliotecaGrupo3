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
 * @author Emiliano
 */
public class EjemplarData {
    private Connection con;
    private Conexion conexion;
    public EjemplarData(Conexion conexion){
        try {
            this.conexion=conexion;
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
    public Libro buscarLibro(int id){
    LibroData auxLibroData = new LibroData(conexion);
    Libro auxLibro = auxLibroData.buscarLibro(id);
    return auxLibro;
    }
    
    public void guardarEjemplar(Ejemplar ejemplar){
    try{
     String sql = "INSERT INTO `ejemplar`(`idLibro`, `estado`, `activo`) VALUES (?,?,?)";
         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1,ejemplar.getLibro().getId_Libro());
         ps.setString(2,ejemplar.getEstado());
         ps.setBoolean(3, ejemplar.isActivo());
         ps.executeUpdate();
         ResultSet rs = ps.getGeneratedKeys();
         if(rs.next()){
         ejemplar.setId_Ejemplar(rs.getInt("idEjemplar"));
         }
         ps.close();
         //Notificacion de guardado
         JOptionPane.showMessageDialog(null, "Ejemplar guardado correctamente");
    }  catch (SQLException ex) {
           //Notificaion si falla
           JOptionPane.showMessageDialog(null,"Error al guardar el ejemplar "+ " "+ex.getMessage());
        }
     }
    
    public void darBajaEjemplar(int id){
    Ejemplar auxEjemplar = buscarEjemplar(id);
    if(auxEjemplar!=null&&auxEjemplar.isActivo()==true){
        try{
        String sql = "UPDATE ejemplar SET activo=0 WHERE idEjemplar=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El ejemplar se dio de baja correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar el ejemplar "+" "+ex.getMessage());
        }}else if (auxEjemplar==null){
        JOptionPane.showMessageDialog(null, "El ejemplar que desea borrar no esta en la base de datos");
        }else if (auxEjemplar.isActivo()==false){
        JOptionPane.showMessageDialog(null, "EL ejemplar ya se encuentra dado de baja");
        }
    
    }
    
    public void darAltaEjemplar(int id){
    Ejemplar auxEjemplar = buscarEjemplar(id);
    if(auxEjemplar!=null&&auxEjemplar.isActivo()==false){
    try{
        String sql = "UPDATE ejemplar SET activo=1 WHERE idEjemplar=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El ejemplar se dio de alta correctamente");
    }   catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al dar de alta el ejemplar "+" "+ex.getMessage());
    }}else if(auxEjemplar==null){
    JOptionPane.showMessageDialog(null, "El ejemplar que desea dar de alta no esta en la base de datos");
    }else if(auxEjemplar.isActivo()==true){
    JOptionPane.showMessageDialog(null, "El ejemplar ya esta dado de alta");
    }
    }
    
    public Ejemplar buscarEjemplar(int id){
    Ejemplar auxEjemplar = null;    
        try{
       String sql = "SELECT * FROM ejemplar WHERE idEjemplar=?";
       PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       ps.setInt(1, id);
       ResultSet rs=ps.executeQuery();
       if(rs.next()){
       auxEjemplar = new Ejemplar();
       auxEjemplar.setId_Ejemplar(rs.getInt("idEjemplar"));
       Libro auxLibro = buscarLibro(rs.getInt("idLibro"));
       auxEjemplar.setLibro(auxLibro);
       auxEjemplar.setEstado(rs.getString("estado"));
       auxEjemplar.setActivo(rs.getBoolean("activo"));
       }
       ps.close();
   
   }    catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al buscar el ejemplar "+" "+ex.getMessage());
   }
        
    return auxEjemplar;
    }
    
    public void eliminarEjemplar(int id){
    Ejemplar auxEjemplar = buscarEjemplar(id);
    if(auxEjemplar!=null){
    try{
        String sql = "DELETE FROM ejemplar WHERE idEjemplar=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Ejemplar eliminado correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el ejemplar "+" "+ex.getMessage());
        }
    }else if(auxEjemplar==null){
    JOptionPane.showMessageDialog(null, "El ejemplar que desea eliminar no esta en la base de datos");
    }
    }
    
    public List<Ejemplar> obtenerEjemplares(){
    List<Ejemplar> ejemplares = new ArrayList<>();
    try{
        String sql = "SELECT * FROM ejemplar";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Ejemplar auxEjemplar;
        while(rs.next()){
        auxEjemplar = new Ejemplar();
        auxEjemplar.setActivo(rs.getBoolean("activo"));
        auxEjemplar.setEstado(rs.getString("estado"));
        auxEjemplar.setId_Ejemplar(rs.getInt("idEjemplar"));
        Libro auxLibro = buscarLibro(rs.getInt("idLibro"));
        auxEjemplar.setLibro(auxLibro);
        ejemplares.add(auxEjemplar);
        }
        ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los ejempares "+ex.getMessage());
        }
    return ejemplares;
    }
    public List<Ejemplar> obtenerEjemplaresSegunEstado(int estado){
    List<Ejemplar> ejemplares = new ArrayList<>();
    try{
        String sql = "SELECT * FROM ejemplar WHERE activo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, estado);
        ResultSet rs = ps.executeQuery();
        Ejemplar auxEjemplar;
        while(rs.next()){
        auxEjemplar = new Ejemplar();
        auxEjemplar.setActivo(rs.getBoolean("activo"));
        auxEjemplar.setEstado(rs.getString("estado"));
        auxEjemplar.setId_Ejemplar(rs.getInt("idEjemplar"));
        Libro auxLibro = buscarLibro(rs.getInt("idLibro"));
        auxEjemplar.setLibro(auxLibro);
        ejemplares.add(auxEjemplar);
        }
        ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los ejempares "+ex.getMessage());
        }
    return ejemplares;
    }
}
    


        

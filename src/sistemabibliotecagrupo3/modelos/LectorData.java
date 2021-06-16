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
public class LectorData {
     private Conexion conexion;
     private Connection con;
    
    public LectorData(Conexion conexion){
        try {
            this.conexion=conexion;
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
    public void guardarLector(Lector lector){
    try{
        String sql = "INSERT INTO lector(dni, apellido, nombre,email,estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,lector.getDni());
        ps.setString(2,lector.getApellido());
        ps.setString(3, lector.getNombre());
        ps.setString(4, lector.getEmail());
        ps.setBoolean(5, true);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            lector.setId_Lector(rs.getInt("idLector"));
            }
        ps.close();
        //Notificacion de Guardado
        JOptionPane.showMessageDialog(null,"El lector se guardo correctamente");
    }    catch (SQLException ex) {
             //Notificacion si falla
             JOptionPane.showMessageDialog(null,"Error a guardar al lector "+lector.getApellido()+" "+ex.getMessage());
         }
    
    }
    
    public Lector buscarLector(int id){
    Lector lector=null;
        try{
        String sql = "SELECT * FROM lector WHERE idLector=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        lector = new Lector();
        lector.setId_Lector(rs.getInt("idLector"));
        lector.setDni(rs.getInt("dni"));
        lector.setApellido(rs.getString("apellido"));
        lector.setNombre(rs.getString("nombre"));
        lector.setEmail(rs.getString("email"));
        lector.setActivo(rs.getBoolean("estado"));
        }
        ps.close();
   }     catch (SQLException ex) {
             //notificacion si falla
             JOptionPane.showMessageDialog(null,"Error al buscar le lector");
         }
    return lector;
    }
    
    public void actualizarLector(Lector lector){
        Lector lectorA = this.buscarLector(lector.getId_Lector());
        if(lectorA!=null){
    try{
        String sql = "UPDATE lector SET dni=?, apellido=?, nombre=?,email=?,estado=? WHERE idLector=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,lector.getDni());
        ps.setString(2,lector.getApellido());
        ps.setString(3,lector.getNombre());
        ps.setString(4, lector.getEmail());
            
                ps.setBoolean(5, lector.isActivo());
        ps.setInt(6, lector.getId_Lector());
        ps.executeUpdate();
        ps.close();
        //Notificamos la actualizacion
        JOptionPane.showMessageDialog(null, "El lector se actualizo correctamente");
    }    catch (SQLException ex) {
                //Notificacion si falla
             JOptionPane.showMessageDialog(null, "Error al actualizar el lector "+lector.getApellido()+" "+ex.getMessage());
         }}else{JOptionPane.showMessageDialog(null, "El lector que quiere actualizar no se encuentra en la base de datos");}
    
    }
    
    protected List<Prestamo> obtenerPrestamos(){
    PrestamoData prestamoData = new PrestamoData(conexion);
    ArrayList<Prestamo>auxP=(ArrayList)prestamoData.obtenerPrestamos();
    return auxP;
    }
    
    protected ArrayList<Lector> obtenerLectoresConMultas(){
    PrestamoData prestamoData = new PrestamoData(conexion);
    ArrayList<Lector>auxL=(ArrayList)prestamoData.obtenerLectoresConMultas();
    return auxL;
    }
    
    protected List<Lector> obtenerPrestamosVencidos(){
    PrestamoData prestamoData = new PrestamoData(conexion);
    List<Lector>auxP=prestamoData.obtenerLectoresConPrestamosVencidos();
    return auxP;
    }
    
    public void darBajaLector(int id){
    Lector lectorA = this.buscarLector(id);

    if(lectorA!=null&&lectorA.isActivo()==true){
        try{
        String sql = "UPDATE lector SET estado=0 WHERE idLector=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        //Noticacion de borrado
        JOptionPane.showMessageDialog(null, "EL lector se dio de baja correctamente");
    
    }    catch (SQLException ex) {
        //Notificacion si falla
        JOptionPane.showMessageDialog(null, "Error al dar de baja el lector "+ex.getMessage());
    }
    }else if(lectorA==null){
        JOptionPane.showMessageDialog(null, "El lector que desea dar de baja no se encuentra en la base de datos");
    }else if(lectorA.isActivo()==false){
        JOptionPane.showMessageDialog(null,"El lector ya esta dado de baja");}
    }
    
    public void darAltaLector(int id){
    Lector lectorA = this.buscarLector(id);    
    boolean auxB = false;
    ArrayList<Lector>p=(ArrayList)obtenerPrestamosVencidos();
    ArrayList<Lector>m=(ArrayList)this.obtenerLectoresConMultas();
    int a = 0;
    for(Lector l:m){
        if(l.getDni()==lectorA.getDni());
        a++;
    }
    if(p.isEmpty()&&a==0){
    auxB=true;
    } 
        ////////
//         Lector lectorA = this.buscarLector(id);
    if(lectorA!=null&&lectorA.isActivo()==false&&auxB==true){
    try{
        String sql = "UPDATE lector SET estado=1 WHERE idLector=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
        //Notificacion de alta
        JOptionPane.showMessageDialog(null, "El lector se dio de alta correctamente");
        
    }   catch (SQLException ex) {
        //Notificacion si falla
        JOptionPane.showMessageDialog(null, "Error al dar de alta el lector " + ex.getMessage());
    }
   }else if(lectorA==null){
   JOptionPane.showMessageDialog(null, "El lector que desea dar de alta no se encuentra en la base de datos");
   }else if(lectorA.isActivo()==true){
   JOptionPane.showMessageDialog(null, "El lector ya esta dado de alta");
   }else if(a!=0){JOptionPane.showMessageDialog(null, "El lector no se puede dar de alta por que tiene "+m+" multa/s");
   }else if(!p.isEmpty()){JOptionPane.showMessageDialog(null, "El lector no se puede dar de alta por que posee "+p.size()+" prestamo/s vencidos");}
   } 
 
    public void eliminarLector(int id){
    Lector auxLector = buscarLector(id);
    if(auxLector!=null){
    try{
        String sql = "DELETE FROM lector WHERE idLector=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El lector se elimino correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el lector"+" "+ex.getMessage());
        }
    }else if(auxLector==null){
    JOptionPane.showMessageDialog(null, "El lector que desea eliminar no esta en la base de datos");
    }
   }
    
    public List<Lector> obtenerLectores(){
    List<Lector> lectores = new ArrayList<>();
    try{
        String sql = "SELECT * FROM lector";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Lector auxLector;
        while(rs.next()){
        auxLector = new Lector();
        auxLector.setId_Lector(rs.getInt("idLector"));
        auxLector.setNombre(rs.getString("nombre"));
        auxLector.setApellido(rs.getString("apellido"));
        auxLector.setDni(rs.getInt("dni"));
        auxLector.setActivo(rs.getBoolean("estado"));
        auxLector.setEmail(rs.getString("email"));
        lectores.add(auxLector);
        }
    
    }    catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al obtener los lectores "+" "+ex.getMessage());
         }
    return lectores;
    }
    
    public List<Lector> obtenerLectoresSegunEstado(boolean estado){
    List<Lector> lectores= new ArrayList<>();
        
        try{ 
          String sql= "SELECT * FROM lector WHERE estado=?"; 
          PreparedStatement ps= con.prepareStatement(sql);
          ps.setBoolean(1, estado);
          ResultSet rs=ps.executeQuery();  
          Lector lector;
          while (rs.next()){
            lector = new Lector();
            lector.setId_Lector(rs.getInt("idLector"));
            lector.setApellido(rs.getString("apellido"));
            lector.setNombre(rs.getString("nombre"));
            lector.setEmail(rs.getString("email"));
            lector.setActivo(rs.getBoolean("estado"));
            lectores.add(lector);
          }
                    
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al listar los lectores. "+ex.getMessage());
        }
    return lectores;  
    }
}

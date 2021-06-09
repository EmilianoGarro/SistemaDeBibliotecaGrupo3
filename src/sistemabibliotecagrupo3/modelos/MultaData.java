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
import sistemabibliotecagrupo3.modelos.Conexion;

/**
 *
 * @author Asus
 */
public class MultaData {
   private Connection con;
    
    public MultaData(Conexion conexion){
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
    public void guardarMulta(Multa multa){
    
    try{
        String sql = "INSERT INTO multa(fechaInicio,fechaDevolucion,activo) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1,Date.valueOf(multa.getFechaInicio()));
        ps.setDate(2,Date.valueOf(multa.getFechaFin()));
        ps.setBoolean(3,multa.isEstado());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
        
            multa.setId_Multa(rs.getInt("idMulta"));
        
        }
        ps.close();
        JOptionPane.showMessageDialog(null, "La multa se guardo correctamente");
    }  catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro al guardar la multa"+" "+ex.getMessage());
       }
    
    
    }
    
    public Multa buscarMulta(int id){
    Multa auxMulta = null;
    try{
            String sql = "SELECT * FROM multa WHERE idMulta=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            auxMulta=new Multa();
            auxMulta.setId_Multa(rs.getInt("idMulta"));
            auxMulta.setEstado(rs.getBoolean("activo"));
            auxMulta.setFechaFin(rs.getDate("fechaDevolucion").toLocalDate());
            auxMulta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            }
            ps.close();
        }  catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al obtener la multa");
       }
    return auxMulta;
    }
    
    public void darBajaMulta(int id){
    Multa auxMulta = buscarMulta(id);
    if(auxMulta!=null&&auxMulta.isEstado()==true){
    try{
        String sql = "UPDATE multa SET activo=0 WHERE idMulta=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "La multa se dio de baja correctamente");
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al dar de baja la multa");
        }
    }else if(auxMulta==null){JOptionPane.showMessageDialog(null, "La multa que desea dar de baja no esta en la base de datos");}
    else if(auxMulta.isEstado()==false){JOptionPane.showMessageDialog(null, "La multa ya esta dada de baja");}
    }
    
    public void darAltaMulta(int id){
    Multa auxMulta = buscarMulta(id);
    if(auxMulta!=null&&auxMulta.isEstado()==false){
    try{
        String sql = "UPDATE multa SET activo=1 WHERE idMulta=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "La multa se dio de alta correctamente");
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al dar de alta la multa");
        }
    }else if(auxMulta==null){JOptionPane.showMessageDialog(null, "La multa que desea dar de alta no esta en la base de datos");}
    else if(auxMulta.isEstado()==true){JOptionPane.showMessageDialog(null, "La multa ya esta dada de alta");}
    }
    
    public void actualizarMulta(Multa multa){
    Multa auxMulta = buscarMulta(multa.getId_Multa());
    if(auxMulta!=null){
    try{
        String sql = "UPDATE multa SET fechaInicio=?,fechaDevolucion=?,activo=? WHERE idMulta=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1,Date.valueOf(multa.getFechaInicio()));
        ps.setDate(2, Date.valueOf(multa.getFechaFin()));
        ps.setBoolean(3, multa.isEstado());
        ps.setInt(4,multa.getId_Multa());
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "La multa se actualizo correctamente");
        
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la multa");
        }
    
    }else{JOptionPane.showMessageDialog(null, "La multa que desea actualizar no esta en la base de datos");}
        
   }
    
    public void eliminarMulta(int id){
    Multa auxMulta = buscarMulta(id);
    if(auxMulta!=null){
    try{
        String sql = "DELETE FROM multa WHERE idMulta=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "La multa se elimino correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la multa");
        }
    }else{JOptionPane.showMessageDialog(null, "La multa que desea eliminar no esta en la base de datos");}
   }
    
    public List<Multa> obtenerMultas(){
    List<Multa>multas=new ArrayList<>();
    try{
        String sql = "SELECT * FROM multa";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Multa auxMulta;
        while(rs.next()){
        auxMulta = new Multa();
        auxMulta.setId_Multa(rs.getInt("idMulta"));
        auxMulta.setEstado(rs.getBoolean("activo"));
        auxMulta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
        auxMulta.setFechaFin(rs.getDate("fechaDevolucion").toLocalDate());
        multas.add(auxMulta);
        }
        ps.close();
    
    
    }  catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al obtener las multas " + ex.getMessage());
       }
     return multas;
    }
    
    public List<Multa> obtenerMultasSegunEstado(boolean estado){
    List<Multa>multas=new ArrayList<>();
    try{
        String sql = "SELECT * FROM multa WHERE activo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setBoolean(1, estado);
        ResultSet rs = ps.executeQuery();
        Multa auxMulta;
        while(rs.next()){
        auxMulta = new Multa();
        auxMulta.setId_Multa(rs.getInt("idMulta"));
        auxMulta.setEstado(rs.getBoolean("activo"));
        auxMulta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
        auxMulta.setFechaFin(rs.getDate("fechaDevolucion").toLocalDate());
        multas.add(auxMulta);
        }
        ps.close();
    
    
    }  catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al obtener las multas");
       }
     return multas;
    }
}


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
            Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarMulta(Multa multa){
        Multa auxMulta1 = buscarMulta(multa.getId_Multa());
        if(auxMulta1 == null){
            try{
                String sql= "INSERT INTO multa(idMulta, idPrestamo, fechaInicio, fechaFin, estado) VALUES (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, multa.getPrestamo().getId_Prestamo());
                ps.setDate(2, Date.valueOf(multa.getFechaInicio()));
                ps.setDate(3, Date.valueOf(multa.getFechaFin()));
                ps.setBoolean(4, multa.isEstado());
                ps.executeUpdate();
            
                ResultSet rs = ps.getGeneratedKeys();
                    if(rs.next()){
                        multa.setId_Multa(rs.getInt("idMulta"));
                    }
                ps.close();
                //Avisa que se guardo la multa...
                JOptionPane.showMessageDialog(null, "La multa se guardo correctamente.");
            } catch (SQLException ex) {
                //Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
                //Avisa el error y donde se encuentra
                JOptionPane.showMessageDialog(null, "Error al guardar la multa " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La multa ya se encuentra cargada.");
        }
    }
    
    public void anularMulta(int id){
        Multa auxMulta = buscarMulta(id);
        if(auxMulta != null && auxMulta.isEstado()==true){
            try{
                String sql="UPDATE multa SET estado=0 WHERE idMulta=?";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
            
                ps.executeUpdate();
            
               ps.close();
                //Avisamos que se anulo...
               JOptionPane.showMessageDialog(null, "La multa se anulo con exito.");
            } catch (SQLException ex) {
                //Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
                //Avisamos el error y donde se encuentra...
                JOptionPane.showMessageDialog(null, "Error al anular la multa " + ex.getMessage());
            }
        } else if(auxMulta == null){
            JOptionPane.showMessageDialog(null, "La multa no se encuentra en la base de datos.");
        } else {
            JOptionPane.showMessageDialog(null, "La multa se encuentra dada de baja.");
        }
    }
    
    public void darAltaMulta(int id){
        Multa auxMulta2 = buscarMulta(id);
        if(auxMulta2 !=null && auxMulta2.isEstado() == false){
            try {
                String sql = "UPDATE multa SET estado=1 WHERE idMulta=?";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
            
                ps.executeUpdate();
            
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (auxMulta2 == null){
            JOptionPane.showMessageDialog(null, "La multa no se encuentra cargada.");
        } else {
            JOptionPane.showMessageDialog(null, "La multa ya se encuentra dada de alta.");
        }
    }
    
    public void modificarMulta(Multa multa){
        
        try{
            String sql= "UPDATE multa SET idPrestamo=?,fechaInicio=?,fechaFin=?,estado=? WHERE idMulta=?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, multa.getPrestamo().getId_Prestamo());
            ps.setDate(2, Date.valueOf(multa.getFechaInicio()));
            ps.setDate(3, Date.valueOf(multa.getFechaFin()));
            ps.setBoolean(4, multa.isEstado());
            ps.setInt(5, multa.getId_Multa());
            
            ps.executeUpdate();
            
            ps.close();
            //Avisa que se pudo modificar...
            JOptionPane.showMessageDialog(null, "La multa se modifico con exito.");
        } catch (SQLException ex) {
            //Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al actualizar la multa " + ex.getMessage());
        }
    }
    
    public Multa buscarMulta(int id){
            Multa auxMulta = null;
            try{
                String sql = "SELECT * FROM multa WHERE idMulta = ?";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    auxMulta = new Multa();
                    auxMulta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                    auxMulta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                    auxMulta.setEstado(rs.getBoolean("estado"));
                }
                ps.close();
            } catch (SQLException ex) {
                //Avisa si falla...
                JOptionPane.showMessageDialog(null, "Error al buscar Multa " + ex.getMessage());
        }
        return auxMulta;
    }
    
    List<Multa> obtenerMultas(){
        List<Multa> multas = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM multa";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            Multa multa;
            while(rs.next()){
                multa = new Multa();
                multa.setId_Multa(rs.getInt("idMulta"));
                multa.getPrestamo().setId_Prestamo(rs.getInt("idPrestamo"));
                multa.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                multa.setFechaInicio(rs.getDate("fechaFin").toLocalDate());
                multa.setEstado(rs.getBoolean("estado"));
                multas.add(multa);
            }
            ps.close();
            
        } catch (SQLException ex) {
            //Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
            //Avisa el error y donde se encuentra...
            JOptionPane.showMessageDialog(null, "Error al obtener multas " + ex.getMessage());
        }
        
        return multas;
    }
    
    List<Multa> obtenerMultasSegunEstado(int estado){
        List<Multa> multas = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM multa WHERE estado=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ResultSet rs = ps.executeQuery();
            Multa multa;
            while (rs.next()){
                multa = new Multa();
                multa.setId_Multa(rs.getInt("idMulta"));
                multa.getPrestamo().setId_Prestamo(rs.getInt("idPrestamo"));
                multa.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                multa.setFechaInicio(rs.getDate("fechaFin").toLocalDate());
                multa.setEstado(rs.getBoolean("estado"));
                multas.add(multa);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MultaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return multas;
    }
}

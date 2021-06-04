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
        
        try{
            String sql= "INSERT INTO multa(idMulta, idPrestamo, fechaInicio, fechaFin, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, multa.getIdPrestamo());
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
    }
    
    public void anularMulta(int id){
        
        try{
            String sql="UPDATE multa SET estado=0 WHERE idMulta=?;";
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
    }
    
    public void modificarMulta(Multa multa){
        
        try{
            String sql= "UPDATE multa SET idPrestamo=?,fechaInicio=?,fechaFin=?,estado=? WHERE idMulta=?";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, multa.getIdPrestamo());
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
}

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

/**
 *
 * @author Emiliano
 */
public class PrestamoData {
    private Connection con;
    private Conexion conexion;
    
    public PrestamoData(Conexion conexion){
        try {
            this.conexion=conexion;
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion"+" "+ex.getMessage());
        }
    }
    
    public Lector buscarLector(int id){
        LectorData auxLectorData = new LectorData(conexion);
        Lector auxLector = auxLectorData.buscarLector(id);
    return auxLector;
    }
    
    public Ejemplar buscarEjemplar(int id){
        EjemplarData auxEjemplarData = new EjemplarData(conexion);
        Ejemplar auxEjemplar = auxEjemplarData.buscarEjemplar(id);
        return auxEjemplar;
    }
    
    public Multa buscarMulta(int id){
        MultaData auxMultaData = new MultaData(conexion);
        Multa auxMulta = auxMultaData.buscarMulta(id);
        return auxMulta;
    }
    
//    public void guardarPrestamo(Prestamo prestamo){
//    try{
//        String sql = "INSERT INTO prestamo (idEjemplar,idLector,idMulta,fechaPrestamo,fechaDevolucion,activo) VALUES (?,?,?,?,?,?)";
//        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//        Ejemplar auxE = buscarEjemplar(prestamo.getEjemplar().getId_Ejemplar());
//        ps.setInt(1,auxE.getId_Ejemplar());
//        Lector auxL = buscarLector(prestamo.getLector().getId_Lector());
//        ps.setInt(2, auxL.getId_Lector());
//        Multa auxM = buscarMulta(prestamo.getMulta().getId_Multa());
//        ps.setInt(3, auxM.getId_Multa());
//        ps.setDate(4, Date.valueOf(prestamo.getFechaPrestamo()));
//        ps.setDate(5, Date.valueOf(prestamo.getFechaDevolucion()));
//        ps.setBoolean(6, prestamo.isActivo());
//        ps.executeUpdate();
//        ResultSet rs = ps.getGeneratedKeys();
//        if(rs.next()){
//        prestamo.setId_Prestamo(rs.getInt("idPrestamo"));
//        }
//        ps.close();
//        JOptionPane.showMessageDialog(null,"El prestamo se guardo correctamente");
//    }   catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null, "Error al guardar el prestamo "+ " "+ex.getMessage());
//        } 
//    
    public void guardarPrestamo(Prestamo prestamo){
    try{
        String sql="INSERT INTO prestamo (idEjemplar,idLector,activo) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1,prestamo.getEjemplar().getId_Ejemplar());
        ps.setInt(2,prestamo.getLector().getId_Lector());
        ps.setBoolean(3,prestamo.isActivo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
        prestamo.setId_Prestamo(rs.getInt("idPrestamo"));
        }
        ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el prestamo "+" "+ex.getMessage());
        }
    
    }

}
   
    
    
    
    
    


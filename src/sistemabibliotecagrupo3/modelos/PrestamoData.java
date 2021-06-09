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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    public void actualizarEjemplar(Ejemplar ejemplar){
    EjemplarData aux = new EjemplarData(conexion);
    aux.actualizarEjemplar(ejemplar);
    }
    
    public Multa buscarMulta(int id){
        MultaData auxMultaData = new MultaData(conexion);
        Multa auxMulta = auxMultaData.buscarMulta(id);
        return auxMulta;
    }
    
    public void guardarMulta(Multa multa){
    MultaData aux = new MultaData(conexion);
    aux.guardarMulta(multa);
    }
    
    public void guardarPrestamo(Prestamo prestamo){
        if(prestamo.getMulta()!=null&&prestamo.getFechaPrestamo()!=null&&prestamo.getFechaDevolucion()!=null){
    try{
        String sql="INSERT INTO prestamo (idEjemplar,idLector,idMulta,fechaPrestamo,fechaDevolucion,activo) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1,prestamo.getEjemplar().getId_Ejemplar());
        ps.setInt(2,prestamo.getLector().getId_Lector());
        ps.setInt(3, prestamo.getMulta().getId_Multa());
        ps.setDate(4,Date.valueOf(prestamo.getFechaPrestamo()));
        ps.setDate(5,Date.valueOf(prestamo.getFechaDevolucion()));
        ps.setBoolean(6,prestamo.isActivo());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
        prestamo.setId_Prestamo(rs.getInt("idPrestamo"));
        }
        ps.close();
        JOptionPane.showMessageDialog(null, "El prestamo se guardo correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el prestamo "+" "+ex.getMessage());
        }}else{
        try{
            String sql = "INSERT INTO prestamo (idEjemplar,idLEctor,activo) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            ps.setBoolean(3, prestamo.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            prestamo.setId_Prestamo(rs.getInt("idPrestamo"));
            }
            ps.close();
            JOptionPane.showMessageDialog(null, "El prestamo se guardo correctamente");
        }   catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al guardar el prestamo");
            }
        
        }
    
    }
    
    public Prestamo buscarPrestamo(int id){
    Prestamo auxPrestamo=null;
    try{
        String sql = "SELECT * FROM prestamo WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
        auxPrestamo = new Prestamo();
        auxPrestamo.setId_Prestamo(rs.getInt("idPrestamo"));
        auxPrestamo.setActivo(rs.getBoolean("activo")); 
        auxPrestamo.setLector(this.buscarLector(rs.getInt("idLector")));
        auxPrestamo.setEjemplar(this.buscarEjemplar(rs.getInt("idEjemplar")));
        auxPrestamo.setMulta(this.buscarMulta(rs.getInt("idMulta")));
        if(rs.getDate("fechaPrestamo")!=null){
        auxPrestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
        }
        if(rs.getDate("fechaDevolucion")!=null){
        auxPrestamo.setFechaDevolucion(rs.getDate("fechaDevolucion").toLocalDate());
        }
        }
    ps.close();
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al buscar el prestamo "+" "+ex.getMessage());
        }
    return auxPrestamo;
    }
    
    public List<Prestamo> obtenerPrestamosPorFecha(LocalDate fecha){
    List<Prestamo> prestamos = new ArrayList<>();
    try{
            String sql = "SELECT * FROM `prestamo` WHERE fechaPrestamo = ?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1,Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            Prestamo auxPrestamo;
            while(rs.next()){
            auxPrestamo = new Prestamo();
            auxPrestamo.setActivo(rs.getBoolean("activo"));
            auxPrestamo.setEjemplar(buscarEjemplar(rs.getInt("idEjemplar")));
            if(rs.getDate("fechaDevolucion")!=null){
            auxPrestamo.setFechaDevolucion(rs.getDate("fechaDevolucion").toLocalDate());
            }
            auxPrestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
            auxPrestamo.setLector(buscarLector(rs.getInt("idLector")));
            auxPrestamo.setId_Prestamo(rs.getInt("idPrestamo"));
            auxPrestamo.setMulta(buscarMulta(rs.getInt("idMulta")));
            prestamos.add(auxPrestamo);
            }
            ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener prestamos por fecha "+" "+ex.getMessage());
        }
    return prestamos;
    }
    
    public List<Prestamo> obtenerPrestamosVigentesPorLector(Lector lector){
    List<Prestamo>prestamos=new ArrayList<>();
    try{
    String sql = "SELECT * FROM `prestamo` WHERE idLector=? AND activo=?";
    PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,lector.getId_Lector());
    ps.setBoolean(2,lector.isActivo());
    ResultSet rs = ps.executeQuery();
    Prestamo auxPrestamo;
    while(rs.next()){
     auxPrestamo = new Prestamo();
            auxPrestamo.setActivo(rs.getBoolean("activo"));
            auxPrestamo.setEjemplar(buscarEjemplar(rs.getInt("idEjemplar")));
            if(rs.getDate("fechaDevolucion")!=null){
            auxPrestamo.setFechaDevolucion(rs.getDate("fechaDevolucion").toLocalDate());
            }
            auxPrestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
            auxPrestamo.setLector(buscarLector(rs.getInt("idLector")));
            auxPrestamo.setId_Prestamo(rs.getInt("idPrestamo"));
            auxPrestamo.setMulta(buscarMulta(rs.getInt("idMulta")));
            prestamos.add(auxPrestamo);
    }
    ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los prestamos por lector "+" "+ex.getMessage());
        }
    return prestamos;
    }
    
    public List<Lector> obtenerLectoresConPrestamosVencidos(){
    List<Lector>lectores=new ArrayList<>();
    try{
        String sql = "SELECT idLector FROM `prestamo` WHERE `idMulta`IS NOT NULL";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Lector lector;
        while(rs.next()){
        lector = buscarLector(rs.getInt("idLector"));
        lectores.add(lector);
        }
        ps.close();
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al obtener los lectores con prestamos vencidos");
    }
    return lectores;
    }
    
    public List<Lector> obtenerLectoresConMultasDentroDeUnMes(){
    List<Lector> lectores = new ArrayList<>();
    LocalDate fecha = LocalDate.now();
    int auxM = fecha.getMonthValue();
    int auxA = fecha.getYear();
    LocalDate auxF1  = LocalDate.of(auxA, auxM, 1);
    LocalDate auxF2 = auxF1.plusMonths(1);
    try{
        String sql = "SELECT idLector FROM prestamo WHERE idMulta IS NOT null AND fechaPrestamo BETWEEN ? and ?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1,Date.valueOf(auxF1));
        ps.setDate(2,Date.valueOf(auxF2));
        ResultSet rs = ps.executeQuery();
        Lector lector;
        while(rs.next()){
        lector = buscarLector(rs.getInt("idLector"));
        lectores.add(lector);
        }
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los lectores con multas "+" "+ex.getMessage());
        }
    return lectores;
    }
    
    public List<Prestamo> obtenerPrestamos(){
     List<Prestamo> prestamos = new ArrayList<>();
    try{
            String sql = "SELECT * FROM prestamo";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            Prestamo auxPrestamo;
            while(rs.next()){
            auxPrestamo = buscarPrestamo(rs.getInt("idPrestamo"));
            prestamos.add(auxPrestamo);
            }
            ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener los prestamos "+" "+ex.getMessage());
        }
    return prestamos;
    }
    
    public void darBajaPrestamo(int id){
    Prestamo prestamo = buscarPrestamo(id);
    if(prestamo!=null&&prestamo.isActivo()==true){
    try{
        String sql = "UPDATE prestamo SET activo=0 WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El prestamo se dio de baja correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al dar de baja el prestamo "+" "+ex.getMessage());
        }
    }else if(prestamo==null){JOptionPane.showMessageDialog(null, "El prestamo que desea dar de baja no esta en la base de datos");}
    else if(!prestamo.isActivo()){JOptionPane.showMessageDialog(null, "El prestamo ya se encuentra dado de baja");}
    }
    
    public void darAltaPrestamo(int id){
     Prestamo prestamo = buscarPrestamo(id);
    if(prestamo!=null&&!prestamo.isActivo()){
    try{
        String sql = "UPDATE prestamo SET activo=1 WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El prestamo se dio de alta correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al dar de alta el prestamo "+" "+ex.getMessage());
        }
    }else if(prestamo==null){JOptionPane.showMessageDialog(null, "El prestamo que desea dar de alta no esta en la base de datos");}
    else if(prestamo.isActivo()){JOptionPane.showMessageDialog(null, "El prestamo ya se encuentra dado de alta");}
    }
    
    public void eliminarPrestamo(int id){
    Prestamo prestamo = buscarPrestamo(id);
    if(prestamo!=null){
    try{
        String sql = "DELETE FROM `prestamo` WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "El prestamo se elimino correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el prestamo "+" "+ex.getMessage());
        }
   }else{JOptionPane.showMessageDialog(null, "El prestamo que desea eliminar no esta en la base de datos");}
   }
    
    public void actualizarPrestamo(Prestamo prestamo){
    Prestamo auxPrestamo=buscarPrestamo(prestamo.getId_Prestamo());
    
    if(auxPrestamo!=null&&auxPrestamo.getMulta()!=null&&auxPrestamo.getFechaPrestamo()!=null&&auxPrestamo.getFechaDevolucion()!=null){
        try{
            String sql = "UPDATE prestamo SET idEjemplar=?,idLector=?,idMulta=?,fechaPrestamo=?,fechaDevolucion=?,activo=? WHERE idPrestamo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            ps.setInt(3, prestamo.getMulta().getId_Multa());
            ps.setDate(4,Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(5,Date.valueOf(prestamo.getFechaDevolucion()));
            ps.setBoolean(6, prestamo.isActivo());
            ps.setInt(7, prestamo.getId_Prestamo());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "El prestamo se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el prestamo "+" "+ex.getMessage());
        }
    }else if(auxPrestamo!=null&&auxPrestamo.getFechaPrestamo()!=null&&auxPrestamo.getMulta()==null&&auxPrestamo.getFechaDevolucion()==null){
        try{
            String sql = "UPDATE prestamo SET idEjemplar=?,idLector=?,fechaPrestamo=?,activo=? WHERE idPrestamo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            ps.setDate(3,Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setBoolean(4, prestamo.isActivo());
            ps.setInt(5, prestamo.getId_Prestamo());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "El prestamo se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el prestamo "+" "+ex.getMessage());
        }
    }else if(auxPrestamo!=null&&auxPrestamo.getFechaPrestamo()==null){
     try{
            String sql = "UPDATE prestamo SET idEjemplar=?,idLector=?,activo=? WHERE idPrestamo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            ps.setBoolean(3, prestamo.isActivo());
            ps.setInt(4, prestamo.getId_Prestamo());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "El prestamo se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el prestamo "+" "+ex.getMessage());
        }
   }else if(auxPrestamo==null){JOptionPane.showMessageDialog(null, "El prestamo que desea actualizar no esta en la base de datos");}
    }
    
    public void solicitarPrestamo(Prestamo prestamo){
    Prestamo ap = buscarPrestamo(prestamo.getId_Prestamo());
    if(ap != null && ap.getEjemplar().isActivo() && ap.isActivo()== false){
    try{
        String sql = "UPDATE `prestamo` SET `fechaPrestamo`=?,`activo`=1 WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        Ejemplar auxE = buscarEjemplar(prestamo.getEjemplar().getId_Ejemplar());
        auxE.setEstado("Prestado");
        auxE.setActivo(false);
        actualizarEjemplar(auxE);
        ps.setDate(1,Date.valueOf(LocalDate.now()));
        ps.setInt(2,prestamo.getId_Prestamo());
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Prestamo solicitado correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo "+" "+ex.getMessage());
        }
    }else{JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo");}
}

    public void devolverPrestamo(Prestamo prestamo){
     Prestamo auxPrestamo=buscarPrestamo(prestamo.getId_Prestamo());
    if(auxPrestamo!=null&&auxPrestamo.getEjemplar().isActivo()==false&&auxPrestamo.isActivo()==true){
    try{
        String sql = "UPDATE prestamo SET idMulta=?,fechaDevolucion=?,activo=0 WHERE idPrestamo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        Ejemplar auxE = buscarEjemplar(prestamo.getEjemplar().getId_Ejemplar());
        auxE.setEstado("Disponible");
        auxE.setActivo(true);
        actualizarEjemplar(auxE);
        ps.setDate(2,Date.valueOf(LocalDate.now()));
        ps.setInt(3,prestamo.getId_Prestamo());
        if(prestamo.getFechaPrestamo().plusDays(30).isAfter(LocalDate.now())){
        Multa multa = new Multa(LocalDate.now(),LocalDate.now().plusDays(2),true);
        guardarMulta(multa);
        ps.setInt(1,multa.getId_Multa());
        }else{
            Integer i = null;
            ps.setInt(1,i);
        }
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Prestamo devuelto correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver el prestamo "+" "+ex.getMessage());
        }
    }else{JOptionPane.showMessageDialog(null, "Error al devolver el prestamo");}
    }


}
   
    
    
    
    
    


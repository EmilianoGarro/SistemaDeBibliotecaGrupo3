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
    
    public void darBajaLector(Lector lector){
    LectorData aux = new LectorData(conexion);
    aux.darBajaLector(lector.getId_Lector());
    }
    
    public void darAltaLector(Lector lector){
    LectorData aux = new LectorData(conexion);
    aux.darAltaLector(lector.getId_Lector());
    }
    
    public Multa buscarMulta(int id){
        MultaData auxMultaData = new MultaData(conexion);
        Multa auxMulta = auxMultaData.buscarMulta(id);
        return auxMulta;
    }
    
    public void actualizarMulta(Multa multa){
    MultaData auxMultaData = new MultaData(conexion);
    auxMultaData.actualizarMulta(multa);
    }
    
    public void guardarMulta(Multa multa){
    MultaData aux = new MultaData(conexion);
    aux.guardarMulta(multa);
    }
    
    public void solicitarPrestamo(Ejemplar ejemplar, Lector lector){
    Lector auxLector = buscarLector(lector.getId_Lector());
    Ejemplar auxEjemplar = buscarEjemplar(ejemplar.getId_Ejemplar());
    ArrayList<Prestamo> auxP = (ArrayList)obtenerPrestamosVigentesPorLector(lector);
    ArrayList<Lector> auxLectores = (ArrayList)this.obtenerLectoresConPrestamosVencidos();
    int v = 0;
    int a = 0;
    for(Prestamo p : auxP){
        if(auxP.size()>=0&&p.getMulta()!=null){
        if(p.getMulta().isEstado()){
        a++;
        }
        }
    }
    for(Lector l:auxLectores){
    if(lector.getId_Lector()==l.getId_Lector()){
    v++;
    }
    }
    if(auxLector!=null&&auxLector.isActivo()&&auxEjemplar!=null&&auxEjemplar.getEstado().equals("Disponible")&&auxEjemplar.isActivo()&&auxP.size()<3&&a==0&&v==0){
        try{
            String sql = "INSERT INTO  prestamo(idEjemplar,idLector,fechaPrestamo,activo)VALUES (?,?,?,?)"; 
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,ejemplar.getId_Ejemplar());
            ps.setInt(2, lector.getId_Lector());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setBoolean(4,true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            Prestamo prestamo = new Prestamo(lector,ejemplar);
            prestamo.setId_Prestamo(rs.getInt("idPrestamo"));
            }
            ps.close();
            auxEjemplar.setEstado("Prestado");
            actualizarEjemplar(auxEjemplar);
            
            JOptionPane.showMessageDialog(null, "El prestamo se solicito correctamente");
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo "+" "+ex.getMessage());
        }
    }else if(auxLector==null){JOptionPane.showMessageDialog(null, "Error al solictar el prestamo, el lector no esta en la base de datos");}
    else if(!auxLector.isActivo()){JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo, el lector esta dado de baja");}
    else if(auxP.size()>=3){JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo, el lector ya tiene tres ejemplares prestados");}
    else if(a>0){JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo, El lector tiene "+a+" multas");}
    else if(v>0){JOptionPane.showMessageDialog(null,"Error al solicitar el prestamo, El lector tiene: "+v+" Prestamos vencidos");}
    else if(auxEjemplar==null){JOptionPane.showConfirmDialog(null,"Error al solicitar el prestamo, El ejemplar no esta en la base de datos");}
    else if(!auxEjemplar.isActivo()){JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo, El ejemplar esta dado de baja ");}
    else if(!auxEjemplar.equals("Disponible")){JOptionPane.showMessageDialog(null, "Error al solicitar el prestamo, El ejemplar no esta disponible");}
   
    
    
    }//listo
    
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
    String sql = "SELECT * FROM `prestamo` WHERE idLector=? AND activo=? AND idMulta IS NULL";
    PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1,lector.getId_Lector());
    ps.setBoolean(2,lector.isActivo());
    ResultSet rs = ps.executeQuery();
    Prestamo auxPrestamo;
    while(rs.next()){
     auxPrestamo = new Prestamo();
            auxPrestamo.setActivo(rs.getBoolean("activo"));
            auxPrestamo.setEjemplar(buscarEjemplar(rs.getInt("idEjemplar")));
            auxPrestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
            auxPrestamo.setLector(buscarLector(rs.getInt("idLector")));
            auxPrestamo.setId_Prestamo(rs.getInt("idPrestamo"));
            prestamos.add(auxPrestamo);
    }
    ps.close();
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los prestamos por lector "+" "+ex.getMessage());
        }
    return prestamos;
    }
    
    public List<Lector> obtenerLectoresConMultas(){
    List<Lector>lectores=new ArrayList<>();
    try{
        String sql = "SELECT * FROM `prestamo` WHERE `idMulta`IS NOT NULL";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Lector lector;
        while(rs.next()){
        Multa aux = this.buscarMulta(rs.getInt("idMulta"));
            if(aux.isEstado()){
            lector = buscarLector(rs.getInt("idLector"));
            lectores.add(lector);}
        }
        ps.close();
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al obtener los lectores con multas"+" "+ex.getMessage());
    }
    return lectores;
    }
    
    public void revisionDePrestamosSinDevolucion(){
     ArrayList<Prestamo>prestamos=(ArrayList)obtenerPrestamos();
        
        for(Prestamo p:prestamos){
        
        LocalDate inicioYFin = p.getFechaPrestamo().plusDays(30);
        LocalDate aux = LocalDate.now();
        LocalDate auxL = inicioYFin.plusMonths(3);
        Multa auxM=null;
        Lector auxLector=null;
        if(p.getMulta()==null&&p.getFechaDevolucion()==null&&aux.isAfter(inicioYFin)){
           auxM = new Multa(aux,aux.plusDays(2),true);
           this.guardarMulta(auxM);
           p.setMulta(auxM);
           this.actualizarPrestamo(p);
           Ejemplar auxE = p.getEjemplar();
           auxE.setEstado("Retraso");
           this.actualizarEjemplar(auxE);
        }else if(p.getMulta()!=null&&p.getFechaDevolucion()==null&&!aux.isAfter(inicioYFin)){
        auxM = this.buscarMulta(p.getMulta().getId_Multa());
        LocalDate auxFin = auxM.getFechaFin();
        auxM.setFechaFin(auxFin.plusDays(2));
        this.actualizarMulta(auxM);
        Ejemplar auxE = p.getEjemplar();
           auxE.setEstado("Retraso");
           this.actualizarEjemplar(auxE);
        }
        
        if(aux.isAfter(auxL)&&p.getFechaDevolucion()==null){
        auxLector = this.buscarLector(p.getLector().getId_Lector());
        this.darBajaLector(auxLector);
        Ejemplar auxE = p.getEjemplar();
         auxE.setEstado("Retraso");
        this.actualizarEjemplar(auxE);
        }
        
        
        
        }
    
    }
    
    public List<Lector> obtenerLectoresConPrestamosVencidos(){
    ArrayList<Lector>auxLectores=new ArrayList<>();
    ArrayList<Integer>auxI = new ArrayList<>();
    try{
        String sql = "SELECT * FROM prestamo WHERE fechaPrestamo IS NOT NULL AND fechaDevolucion IS NULL";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        Lector auxLector;
        Prestamo auxPrestamo;
        while(rs.next()){
            LocalDate auxL = rs.getDate("fechaPrestamo").toLocalDate().plusDays(30);
            if(LocalDate.now().isAfter(auxL)){
            auxLector = this.buscarLector(rs.getInt("idLector"));
                if(!auxI.contains(auxLector.getId_Lector())){
                auxI.add(auxLector.getId_Lector());
                }
        }}
        ps.close();
       auxI.forEach((a) -> auxLectores.add(this.buscarLector(a)));
        
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los lectores con prestamos vencidos "+" "+ex.getMessage());
        }
    return auxLectores;
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
                auxPrestamo = new Prestamo();
                auxPrestamo.setActivo(rs.getBoolean("activo"));
                Ejemplar ejemplar = buscarEjemplar(rs.getInt("idEjemplar"));
                auxPrestamo.setEjemplar(ejemplar);
                auxPrestamo.setFechaPrestamo(rs.getDate("fechaPrestamo").toLocalDate());
                auxPrestamo.setFechaDevolucion(rs.getDate("fechaDevolucion").toLocalDate());
                auxPrestamo.setId_Prestamo(rs.getInt("idPrestamo"));
                Lector lector = buscarLector(rs.getInt("idLector"));
                auxPrestamo.setLector(lector);
                Multa multa = buscarMulta(rs.getInt("idMulta"));
                auxPrestamo.setMulta(multa);          
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
            String sql = "UPDATE prestamo SET idEjemplar=?,idLector=?,idMulta=?,fechaPrestamo=?,activo=? WHERE idPrestamo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            if(prestamo.getMulta()!=null){  //parte nueva para null
                ps.setInt(3, prestamo.getMulta().getId_Multa());
            } else{
                ps.setNull(3, java.sql.Types.NULL);
            }
            
            ps.setDate(4,Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setBoolean(5, prestamo.isActivo());
            ps.setInt(6, prestamo.getId_Prestamo());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "El prestamo se actualizo correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el prestamo "+" "+ex.getMessage());
        }
    }else if(auxPrestamo!=null&&auxPrestamo.getFechaPrestamo()!=null&&auxPrestamo.getMulta()==null&&auxPrestamo.getFechaDevolucion()!=null){
        try{
            String sql = "UPDATE prestamo SET idEjemplar=?,idLector=?,fechaPrestamo=?,fechaDevolucion=?,activo=? WHERE idPrestamo=?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getEjemplar().getId_Ejemplar());
            ps.setInt(2, prestamo.getLector().getId_Lector());
            ps.setDate(3,Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(4, Date.valueOf(prestamo.getFechaDevolucion()));
            ps.setBoolean(5, prestamo.isActivo());
            ps.setInt(6, prestamo.getId_Prestamo());
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
    
    public void devolverPrestamo(Prestamo prestamo){///////////////////////////////////////////
     Prestamo auxPrestamo = buscarPrestamo(prestamo.getId_Prestamo());
        
     
     if(auxPrestamo!=null&&auxPrestamo.getFechaDevolucion()==null){
        try{
         String sql = "UPDATE prestamo SET fechaDevolucion=?,activo=0 WHERE idPrestamo=?";
         PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setDate(1, Date.valueOf(LocalDate.now()));
         ps.setInt(2,prestamo.getId_Prestamo());
         ps.executeUpdate();
         ps.close();
         
         Ejemplar auxE = buscarEjemplar(prestamo.getEjemplar().getId_Ejemplar());
         auxE.setEstado("Disponible");
         actualizarEjemplar(auxE);
         
         LocalDate inicio = prestamo.getFechaPrestamo().plusDays(30);
         LocalDate fin = LocalDate.now();
         
         if(fin.isAfter(inicio)&&prestamo.getMulta()==null){
          Multa auxMulta = new Multa(fin,LocalDate.now().plusDays(2),true);
          auxPrestamo.setMulta(auxMulta);
          actualizarPrestamo(auxPrestamo);
         }else if(fin.isAfter(inicio)&&prestamo.getMulta()!=null){
         Multa auxMulta = this.buscarMulta(prestamo.getMulta().getId_Multa());
         auxMulta.setEstado(false);
         this.actualizarMulta(auxMulta);
         }
         
         JOptionPane.showMessageDialog(null, "El ejemplar se delvolvio correctamente");
     
     
     }  catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al devolver el prestamo "+" "+ex.getMessage());
        }
    
     }
        
        
    
    }

    public void revisarAltaLector(Lector lector){
       this.darAltaLector(lector);
}
    
    public Prestamo buscarPrestamo(Lector lector,Ejemplar ejemplar,boolean estado){
    Prestamo auxPrestamo=null;
    try{
        String sql = "SELECT * FROM prestamo WHERE idLector=? AND idEjemplar=? AND activo=?";
        PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,lector.getId_Lector());
        ps.setInt(2, ejemplar.getId_Ejemplar());
        ps.setBoolean(3, estado);
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
            JOptionPane.showMessageDialog(null, "Error  al buscar el prestamo "+" "+ex.getMessage());
        }
    
    
    
    
    return auxPrestamo;
    }
    
    
    

}
   
    
    
   
    
    
    
    
    


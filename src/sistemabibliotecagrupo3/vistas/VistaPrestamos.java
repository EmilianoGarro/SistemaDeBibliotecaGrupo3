/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.vistas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemabibliotecagrupo3.modelos.*;

/**
 *
 * @author Emiliano
 */
public class VistaPrestamos extends javax.swing.JInternalFrame {
    private PrestamoData prestamoData;
    private EjemplarData ejemplarData;
    private LectorData lectorData;
    private ArrayList<Prestamo> prestamos;
    
    private Conexion conexion=null;
    /**
     * Creates new form VistaAlumnos
     */
    public VistaPrestamos() {
        initComponents();
        
        
         try {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        prestamoData = new PrestamoData(conexion);
        ejemplarData = new EjemplarData(conexion);
        lectorData = new LectorData(conexion);
        
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "Error con los drivers de conexion");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Problema de conexion con la base de datos");
    }
         cargarEjemplares();
         cargarLectores();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTID = new javax.swing.JTextField();
        jCEstado = new javax.swing.JCheckBox();
        jBSolicitar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBDevolver = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jCEjemplar = new javax.swing.JComboBox<>();
        jCLector = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDFechaPrestamo = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jDFechaDevolucion = new com.toedter.calendar.JDateChooser();
        jTMulta = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Altas, bajas, modificaciones");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("PRESTAMOS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Lector:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Estado:");

        jTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIDActionPerformed(evt);
            }
        });
        jTID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTIDKeyTyped(evt);
            }
        });

        jCEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCEstadoKeyReleased(evt);
            }
        });

        jBSolicitar.setText("Solicitar");
        jBSolicitar.setEnabled(false);
        jBSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSolicitarActionPerformed(evt);
            }
        });

        jBBorrar.setText("Borrar");
        jBBorrar.setEnabled(false);
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        jBDevolver.setText("Devolver");
        jBDevolver.setEnabled(false);
        jBDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolverActionPerformed(evt);
            }
        });

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.setEnabled(false);
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Ejemplar:");

        jCEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEjemplarActionPerformed(evt);
            }
        });

        jCLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCLectorActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Multa:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Fecha De Prestamo:");

        jDFechaPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDFechaPrestamoKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Fecha De Devolución:");

        jDFechaDevolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDFechaDevolucionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jTID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBSolicitar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBBorrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBDevolver)))
                                .addGap(18, 18, 18)
                                .addComponent(jBLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCEjemplar, 0, 318, Short.MAX_VALUE)
                            .addComponent(jCLector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTMulta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDFechaDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jDFechaPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 52, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jCEstado))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jDFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBSolicitar)
                            .addComponent(jBBorrar)
                            .addComponent(jBDevolver)
                            .addComponent(jBLimpiar))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void habilitarBotonGuardar(){
        
        
        if(jCLector.getSelectedItem()!=null&&jCEjemplar.getSelectedItem()!=null){
        jBSolicitar.setEnabled(true);
        }else{jBSolicitar.setEnabled(false);}
    }
    
    private void habilitarBotonBuscar(){
                 if(!jTID.getText().isEmpty()){
                 jBBuscar.setEnabled(true);
                 }else{jBBuscar.setEnabled(false);}   
    }
    
    public void habilitarBotonBorrar(){
        if(!jTID.getText().isEmpty()){
        int aux = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(aux);
        if(ejemplar!=null && ejemplar.isActivo()!=false){
        jBBorrar.setEnabled(true);
        }else{jBBorrar.setEnabled(false);}
        }
       
      
    }
    
    private void habilitarBotonActualizar(){
    
        if(jCLector.getSelectedItem()!=null&&jCEjemplar.getSelectedItem()!=null){
        jBDevolver.setEnabled(true);
        }else{jBDevolver.setEnabled(false);}
    
    }
    
    private void jBSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSolicitarActionPerformed
        // TODO add your handling code here:
//        Boolean estado = jCEstado.isSelected();
//        String multa = jTMulta.getText();
//        LocalDate fechaPrestamo =jDFechaPrestamo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate fechaDevolucion =jDFechaDevolucion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Ejemplar ejemplar = (Ejemplar)jCEjemplar.getSelectedItem();
        Lector lector = (Lector)jCLector.getSelectedItem();
        prestamoData.solicitarPrestamo(ejemplar,lector);
        
//        jTID.setText(String.valueOf(ejemplar.getId_Ejemplar()));
        jTID.setEnabled(false);
        jBSolicitar.setEnabled(false);

        jCEstado.setEnabled(false);
        jCLector.setEnabled(false);
        jCEjemplar.setEnabled(false);
        jDFechaPrestamo.setEnabled(false);
        jDFechaDevolucion.setEnabled(false);
        jTMulta.setEnabled(false);
        
    }//GEN-LAST:event_jBSolicitarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null){
        
        ejemplarData.darBajaEjemplar(id);
        jCEjemplar.setSelectedItem(ejemplar.getLibro());
        jCLector.setSelectedItem(ejemplar.getEstado());
        jCEstado.setSelected(ejemplar.isActivo());
        
        jCEstado.setEnabled(false);
        jTID.setEnabled(false);
        jCLector.setEnabled(false);
        jCEjemplar.setEnabled(false);
        
        jBBorrar.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBDevolver.setEnabled(false);
        }
        else{JOptionPane.showMessageDialog(this, "El ejemplar que intenta borrar, no se encuentra en la base de datos");}
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolverActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null){
        ejemplar.setActivo(jCEstado.isSelected());
        ejemplar.setLibro((Libro)jCEjemplar.getSelectedItem());
        ejemplar.setEstado((String)jCLector.getSelectedItem());
        ejemplarData.actualizarEjemplar(ejemplar);    

        jTID.setEnabled(false);
        jCLector.setEnabled(false);
        jCEstado.setEnabled(false);
        jCEjemplar.setEnabled(false);
        
        jBBuscar.setEnabled(false);
        jBDevolver.setEnabled(false);
        jBBorrar.setEnabled(false);
        jBSolicitar.setEnabled(false);
        }else{JOptionPane.showMessageDialog(this,"El ejemplar que quiere actualizar no esta en la base de datos");}
    }//GEN-LAST:event_jBDevolverActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        jTID.setText("");
        jTMulta.setText("");
        jDFechaPrestamo.setDate(null);
        jDFechaDevolucion.setDate(null);
        jCLector.removeAllItems();
        jCEjemplar.removeAllItems();
        cargarEjemplares();
        cargarLectores();
        jCLector.setSelectedItem(null);
        jCEjemplar.setSelectedItem(null);
        jCEstado.setSelected(false);
            
        jTID.setEnabled(true);
        jCLector.setEnabled(true);
        jCEstado.setEnabled(true);
        jCEjemplar.setEnabled(true);
        
        jBDevolver.setEnabled(false);
        jBSolicitar.setEnabled(false);
        jBBorrar.setEnabled(false);
        
        
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Prestamo prestamo = prestamoData.buscarPrestamo(id);
        if(prestamo!=null){
 
        jCLector.removeAllItems();  
        jCLector.addItem(prestamo.getLector());
        jCEjemplar.removeAllItems();
        jCEjemplar.addItem(prestamo.getEjemplar());
        jCEstado.setSelected(prestamo.isActivo());
        jTMulta.setText(String.valueOf(prestamo.getMulta()));
        jDFechaPrestamo.setDate(Date.valueOf(prestamo.getFechaPrestamo()));
        jDFechaDevolucion.setDate(Date.valueOf(prestamo.getFechaDevolucion()));
        
        jBBuscar.setEnabled(false);
        jBSolicitar.setEnabled(false);
        jBDevolver.setEnabled(true);
        jBSolicitar.setEnabled(false);
        }
        else{JOptionPane.showMessageDialog(this, "El id que ingreso no esta registrado en la base de datos");}
        
        
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIDKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
        getToolkit().beep();
        evt.consume();
        JOptionPane.showMessageDialog(this,"Solo puede ingresar numeros");
        }
    }//GEN-LAST:event_jTIDKeyTyped

    private void jTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIDActionPerformed

    private void jTIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIDKeyReleased
        // TODO add your handling code here:
        habilitarBotonBuscar();
        habilitarBotonBorrar();
        habilitarBotonActualizar();
    }//GEN-LAST:event_jTIDKeyReleased

    private void jCEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEjemplarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEjemplarActionPerformed

    private void jCLectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCLectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCLectorActionPerformed

    private void jCEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCEstadoKeyReleased
        // TODO add your handling code here:
        habilitarBotonGuardar();
    }//GEN-LAST:event_jCEstadoKeyReleased

    private void jDFechaPrestamoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDFechaPrestamoKeyReleased
        // TODO add your handling code here:
        habilitarBotonGuardar();
        habilitarBotonActualizar();
    }//GEN-LAST:event_jDFechaPrestamoKeyReleased

    private void jDFechaDevolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDFechaDevolucionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDFechaDevolucionKeyReleased
    public void cargarEjemplares(){
        List<Ejemplar> ejemplares = ejemplarData.obtenerEjemplaresSegunEstado(true); 
        for(Ejemplar e:ejemplares){
        jCEjemplar.addItem(e);
        }
        jCEjemplar.setSelectedItem(null);
    }
    public void cargarLectores() {
        List<Lector> lectores = lectorData.obtenerLectoresSegunEstado(true); 
        for(Lector l:lectores){
        jCLector.addItem(l);
        }
        jCLector.setSelectedItem(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBDevolver;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSolicitar;
    private javax.swing.JComboBox<Ejemplar> jCEjemplar;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JComboBox<Lector> jCLector;
    private com.toedter.calendar.JDateChooser jDFechaDevolucion;
    private com.toedter.calendar.JDateChooser jDFechaPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTID;
    private javax.swing.JTextField jTMulta;
    // End of variables declaration//GEN-END:variables
}

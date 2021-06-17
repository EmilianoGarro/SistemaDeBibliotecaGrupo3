/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.vistas;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import sistemabibliotecagrupo3.modelos.*;

/**
 *
 * @author Emiliano
 */
public class VistaPrestamos extends javax.swing.JInternalFrame {
    PrestamoData prestamoData;
    Conexion conexion=null;
    /**
     * Creates new form VistaPrestamos
     */
    public VistaPrestamos() {
          initComponents();
        
        
         try {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        prestamoData = new PrestamoData(conexion);
        jTPrestamo.setEditable(false);
        jTDevolucion.setEditable(false);
        jTMulta.setEditable(false);
        jBBuscar.setEnabled(false);
        prestamoData.revisionDePrestamosSinDevolucion();
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "Error con los drivers de conexion");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Problema de conexion con la base de datos");
    }
         
    
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jTPrestamo = new javax.swing.JTextField();
        jTMulta = new javax.swing.JTextField();
        jTDevolucion = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jTEjemplar = new javax.swing.JTextField();
        jTLector = new javax.swing.JTextField();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jCActivo = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("PRESTAMO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setText("Ejemplar:");

        jLabel4.setText("Lector:");

        jLabel5.setText("Multa:");

        jLabel6.setText("Fecha prestamo:");

        jLabel7.setText("Fecha Devolucion");

        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });
        jTId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTIdKeyTyped(evt);
            }
        });

        jTPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrestamoActionPerformed(evt);
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

        jBAlta.setText("Dar Alta");
        jBAlta.setEnabled(false);
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBBaja.setText("Dar baja");
        jBBaja.setEnabled(false);
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado:");

        jCActivo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTLector, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTEjemplar, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(107, 107, 107))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(jBBuscar)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTDevolucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addComponent(jTPrestamo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTMulta))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCActivo))
                            .addComponent(jBBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBLimpiar)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jTDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpiar)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        int auxI = Integer.parseInt(jTId.getText());
        Prestamo auxP = prestamoData.buscarPrestamo(auxI);
        if(auxP!=null){
            jTLector.setText(auxP.getLector().toString());
            jTEjemplar.setText(auxP.getEjemplar().toString());
            jCActivo.setSelected(auxP.isActivo());
            Multa m = auxP.getMulta();
            if(m!=null){
            jTMulta.setText(String.valueOf(m.getId_Multa()));
            }else{jTMulta.setText("No registra multa");}
            if(auxP.getFechaPrestamo()!=null){
            jTPrestamo.setText(auxP.getFechaPrestamo().toString());}
            else{jTPrestamo.setText("No registra fecha de prestamo");}
            if(auxP.getFechaDevolucion()!=null){
            jTDevolucion.setText(auxP.getFechaDevolucion().toString());}
            else{jTDevolucion.setText("No registra fecha de devolucion");}
        }else{JOptionPane.showMessageDialog(null, "el prestamo no esta en la base de datos");}
        
       
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTIdActionPerformed

    private void jTIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIdKeyTyped
        // TODO add your handling code here:
        
        char validar = evt.getKeyChar();
        if(!Character.isDigit(validar)){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_jTIdKeyTyped

    private void jTIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIdKeyReleased
        // TODO add your handling code here:
        habilitarBotonBuscar();
        habilitarBotonDarAlta();
        habilitarBotonDarBaja();
    }//GEN-LAST:event_jTIdKeyReleased

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        jTLector.setText("");
        jTEjemplar.setText("");
        jTId.setText("");
        jTMulta.setText("");
        jTPrestamo.setText("");
        jTDevolucion.setText("");

    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrestamoActionPerformed

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        jBAlta.setEnabled(false);
       int id = Integer.parseInt(jTId.getText());
      
     
        prestamoData.darAltaPrestamo(id);
      
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
        jBBaja.setEnabled(false);
        int id = Integer.parseInt(jTId.getText());
        prestamoData.darBajaPrestamo(id);
    }//GEN-LAST:event_jBBajaActionPerformed

    
    private void habilitarBotonBuscar(){
                 if(!jTId.getText().isEmpty()){
                     int auxI = Integer.parseInt(jTId.getText());
                     Prestamo auxP = prestamoData.buscarPrestamo(auxI);
                     if(auxP!=null){
                     jBBuscar.setEnabled(true);}
                     else{jBBuscar.setEnabled(false);}
                 }else{jBBuscar.setEnabled(false);}   
    }
    
private void habilitarBotonDarAlta(){
    if(!jTId.getText().isEmpty()){
                     int auxI = Integer.parseInt(jTId.getText());
                     Prestamo auxP = prestamoData.buscarPrestamo(auxI);
                     if(auxP!=null&&!auxP.isActivo()){
                     jBAlta.setEnabled(true);}
                     else{jBAlta.setEnabled(false);}
                 }else{jBAlta.setEnabled(false);}   
    

}

private void habilitarBotonDarBaja(){
    if(!jTId.getText().isEmpty()){
                     int auxI = Integer.parseInt(jTId.getText());
                     Prestamo auxP = prestamoData.buscarPrestamo(auxI);
                     if(auxP!=null&&auxP.isActivo()){
                     jBBaja.setEnabled(true);}
                     else{jBBaja.setEnabled(false);}
                 }else{jBBaja.setEnabled(false);}   
    

}

    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JCheckBox jCActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTDevolucion;
    private javax.swing.JTextField jTEjemplar;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTLector;
    private javax.swing.JTextField jTMulta;
    private javax.swing.JTextField jTPrestamo;
    // End of variables declaration//GEN-END:variables
}

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
import sistemabibliotecagrupo3.modelos.Conexion;
import sistemabibliotecagrupo3.modelos.Ejemplar;
import sistemabibliotecagrupo3.modelos.EjemplarData;
import sistemabibliotecagrupo3.modelos.Lector;
import sistemabibliotecagrupo3.modelos.LectorData;
import sistemabibliotecagrupo3.modelos.Prestamo;
import sistemabibliotecagrupo3.modelos.PrestamoData;

/**
 *
 * @author Emiliano
 */
public class VistaSolicitarPrestamo extends javax.swing.JInternalFrame {
PrestamoData prestamoData;
    Conexion conexion=null;
    /**
     * Creates new form VistaSolicitarPrestamo
     */
    public VistaSolicitarPrestamo() {
              initComponents();
        
        
         try {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        prestamoData = new PrestamoData(conexion);
        cargarEjemplar();
        cargarLectores();
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
        jCEjemplar = new javax.swing.JComboBox<>();
        jCLector = new javax.swing.JComboBox<>();
        jBSolicitar = new javax.swing.JButton();
        jBDevolver = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("SOLICITUD O DEVOLUCION DE PRESTAMO");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("EJEMPLAR:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("LECTOR:");

        jBSolicitar.setText("SOLICITAR");
        jBSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSolicitarActionPerformed(evt);
            }
        });

        jBDevolver.setText("DEVOLVER");
        jBDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCLector, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSolicitar)
                .addGap(28, 28, 28)
                .addComponent(jBDevolver)
                .addGap(241, 241, 241))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jCEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jCLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSolicitar)
                    .addComponent(jBDevolver))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarEjemplar(){
        EjemplarData auxE = new EjemplarData(conexion);
        ArrayList<Ejemplar>ejemplares=(ArrayList)auxE.obtenerEjemplares();
        for(Ejemplar a:ejemplares){
            jCEjemplar.addItem(a);
        } 
        jCEjemplar.setSelectedItem(null);
        }
    
    
    public void cargarLectores(){
        LectorData auxL = new LectorData(conexion);
        ArrayList<Lector> lectores = (ArrayList)auxL.obtenerLectores();
        for(Lector l:lectores){
            jCLector.addItem(l);
        } 
        jCLector.setSelectedItem(null);
    }
    
    
    private void jBSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSolicitarActionPerformed
        // TODO add your handling code here:
//        prestamoData.revisionDePrestamosSinDevolucion();
        prestamoData.revisionDePrestamosSinDevolucion();        
        Lector auxL = (Lector)jCLector.getSelectedItem();
        prestamoData.revisarAltaLector(auxL);
        Ejemplar auxE = (Ejemplar)jCEjemplar.getSelectedItem();
        if(auxL!=null&&auxE!=null){
        prestamoData.solicitarPrestamo(auxE, auxL);
        Prestamo auxP = prestamoData.buscarPrestamo(auxL,auxE,true);
        
        }else{JOptionPane.showMessageDialog(null, "Tiene que seleccionar un lector y un ejemplar");}  
    }//GEN-LAST:event_jBSolicitarActionPerformed

    private void jBDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolverActionPerformed
        // TODO add your handling code here:
           Lector auxL = (Lector)jCLector.getSelectedItem();
        Ejemplar auxE =(Ejemplar)jCEjemplar.getSelectedItem();
        if(auxL!=null&&auxE!=null){
            Prestamo auxP = prestamoData.buscarPrestamo(auxL, auxE,true);
            if(auxP!=null&&auxP.getFechaDevolucion()==null){
            prestamoData.devolverPrestamo(auxP);
            }
            else if(auxP==null){
                JOptionPane.showMessageDialog(null, "El prestamo que desea devolver no esta en la base de datos");
            }else if(auxP.getFechaDevolucion()!=null){JOptionPane.showMessageDialog(null, "El prestamo ya fue devuelto anteriormente");}
        }else{JOptionPane.showMessageDialog(null, "Tiene que seleccionar un lector y un ejemplar");}
    }//GEN-LAST:event_jBDevolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDevolver;
    private javax.swing.JButton jBSolicitar;
    private javax.swing.JComboBox<Ejemplar> jCEjemplar;
    private javax.swing.JComboBox<Lector> jCLector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

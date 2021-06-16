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
import sun.security.jca.JCAUtil;

/**
 *
 * @author Emiliano
 */
public class VistaEjemplares extends javax.swing.JInternalFrame {
    private EjemplarData ejemplarData;
    private ArrayList<Libro> libros;
    
    private Conexion conexion=null;
    /**
     * Creates new form VistaAlumnos
     */
    public VistaEjemplares() {
        initComponents();
        
        
         try {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        ejemplarData = new EjemplarData(conexion);
        jBAlta.setEnabled(false);
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "Error con los drivers de conexion");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Problema de conexion con la base de datos");
    }
         cargarLibros();
         cargarStatus();
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
        jBGuardar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jCLibro = new javax.swing.JComboBox<>();
        jCStatus = new javax.swing.JComboBox<>();
        jBAlta = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Altas, bajas, modificaciones");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("EJEMPLARES");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Status:");

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

        jCEstado.setEnabled(false);
        jCEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCEstadoKeyReleased(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBBorrar.setText("Borrar");
        jBBorrar.setEnabled(false);
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.setEnabled(false);
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
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
        jLabel9.setText("Libro:");

        jCLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCLibroActionPerformed(evt);
            }
        });
        jCLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCLibroKeyReleased(evt);
            }
        });

        jCStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCStatusActionPerformed(evt);
            }
        });
        jCStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jCStatusKeyReleased(evt);
            }
        });

        jBAlta.setText("Dar alta");
        jBAlta.setEnabled(false);
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jBBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBBorrar)
                                .addGap(18, 18, 18)
                                .addComponent(jBActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jBAlta)))
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54)
                        .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCLibro, 0, 296, Short.MAX_VALUE)
                            .addComponent(jCStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
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
                    .addComponent(jCLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jCEstado))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBBorrar)
                    .addComponent(jBActualizar)
                    .addComponent(jBLimpiar)
                    .addComponent(jBAlta))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //private void habilitarBotonGuardar(){
        
        
//        if(jCStatus.getSelectedItem()!=null){
//        jBGuardar.setEnabled(true);
//        }else{jBGuardar.setEnabled(false);}
//    }
    
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
        jBAlta.setEnabled(false);
        }else{jBBorrar.setEnabled(false);
          jBAlta.setEnabled(true);  
        }
        }
       
      
    }
    
    private void habilitarBotonActualizar(){
    
        if(jCStatus.getSelectedItem()!=null&&jCLibro.getSelectedItem()!=null){
        jBActualizar.setEnabled(true);
        }else{jBActualizar.setEnabled(false);}
    
    }
    
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        Boolean estado = jCEstado.isSelected();
        Libro libro = (Libro)jCLibro.getSelectedItem();
        String status = (String)jCStatus.getSelectedItem();
        Ejemplar ejemplar = new Ejemplar(libro, status, estado);
        ejemplarData.guardarEjemplar(ejemplar);
        
        jTID.setText(String.valueOf(ejemplar.getId_Ejemplar()));
        jTID.setEnabled(false);
        jBGuardar.setEnabled(false);
        jBAlta.setEnabled(false);
        jCEstado.setEnabled(false);
        jCStatus.setEnabled(false);
        jCLibro.setEnabled(false);
        
        
        
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null&&!"Prestado".equals(ejemplar.getEstado())){
        
        ejemplarData.darBajaEjemplar(id);
        jCLibro.setSelectedItem(ejemplar.getLibro());
        jCStatus.setSelectedItem(ejemplar.getEstado());
        jCEstado.setSelected(ejemplar.isActivo());
        
        jCEstado.setEnabled(false);
        jTID.setEnabled(false);
        jCStatus.setEnabled(false);
        jCLibro.setEnabled(false);
        jBAlta.setEnabled(false);
        jBBorrar.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        }
        else if(ejemplar==null){JOptionPane.showMessageDialog(this, "El ejemplar que intenta borrar, no se encuentra en la base de datos");
        }else if("Prestado".equals(ejemplar.getEstado())){JOptionPane.showMessageDialog(null, "El ejemplar no se puede dar de baja por que esta prestado");}
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null){
        ejemplar.setActivo(jCEstado.isSelected());
        ejemplar.setLibro((Libro)jCLibro.getSelectedItem());
        ejemplar.setEstado((String)jCStatus.getSelectedItem());
        ejemplarData.actualizarEjemplar(ejemplar);    

        jTID.setEnabled(false);
        jCStatus.setEnabled(false);
        jCEstado.setEnabled(false);
        jCLibro.setEnabled(false);
        jBAlta.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        jBBorrar.setEnabled(false);
        jBGuardar.setEnabled(false);
        }else{JOptionPane.showMessageDialog(this,"El ejemplar que quiere actualizar no esta en la base de datos");}
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        jTID.setText("");
        jCStatus.removeAllItems();
        jCLibro.removeAllItems();
        cargarLibros();
        cargarStatus();
        jCStatus.setSelectedItem(null);
        jCLibro.setSelectedItem(null);
        jCEstado.setSelected(false);
            
        jTID.setEnabled(true);
        jCStatus.setEnabled(true);
        jCEstado.setEnabled(true);
        jCLibro.setEnabled(true);
        jBAlta.setEnabled(false);
        jBActualizar.setEnabled(false);
        jBGuardar.setEnabled(true);
        jBBorrar.setEnabled(false);
        
        
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null){
 
        jCStatus.removeAllItems();  
        jCStatus.addItem(ejemplar.getEstado());
        jCLibro.removeAllItems();
        jCLibro.addItem(ejemplar.getLibro());
        jCEstado.setSelected(ejemplar.isActivo());
        
        jBBuscar.setEnabled(false);
        jBGuardar.setEnabled(false);
        jBActualizar.setEnabled(true);
        jBGuardar.setEnabled(false);
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

    private void jCLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCLibroActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_jCLibroActionPerformed

    private void jCStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCStatusActionPerformed

    private void jCEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCEstadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEstadoKeyReleased

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Ejemplar ejemplar = ejemplarData.buscarEjemplar(id);
        if(ejemplar!=null){
        
        ejemplarData.darAltaEjemplar(id);
        jCLibro.setSelectedItem(ejemplar.getLibro());
        jCStatus.setSelectedItem(ejemplar.getEstado());
        jCEstado.setSelected(ejemplar.isActivo());
        
        jCEstado.setEnabled(false);
        jTID.setEnabled(false);
        jCStatus.setEnabled(false);
        jCLibro.setEnabled(false);
            jBAlta.setEnabled(false);
        jBBorrar.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        }
        else if(ejemplar==null){JOptionPane.showMessageDialog(this, "El ejemplar que intenta dar de alta, no se encuentra en la base de datos");
        }
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jCLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCLibroKeyReleased
        // TODO add your handling code here:\
    }//GEN-LAST:event_jCLibroKeyReleased

    private void jCStatusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCStatusKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jCStatusKeyReleased
    public void cargarLibros(){
        libros = ejemplarData.listarLibros(); 
        for(Libro l:libros){
        jCLibro.addItem(l);
        }
        jCLibro.setSelectedItem(null);
    }
    public void cargarStatus() {
        jCStatus.addItem("Prestado");
        jCStatus.addItem("Retraso");
        jCStatus.addItem("Reparación");
        jCStatus.addItem("Disponible");
        jCStatus.setSelectedItem(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JComboBox<Libro> jCLibro;
    private javax.swing.JComboBox<String> jCStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTID;
    // End of variables declaration//GEN-END:variables
}

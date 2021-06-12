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
public class VistaLibros extends javax.swing.JInternalFrame {
    private LibroData libroData;
    private ArrayList<Autor> autores;
    
    private Conexion conexion=null;
    /**
     * Creates new form VistaAlumnos
     */
    public VistaLibros() {
        initComponents();
//        autores = (ArrayList)libroData.ListarAutores(); 
//        cargarAutores();
         try {
        conexion = new Conexion();
        Connection con = conexion.getConexion();
        libroData = new LibroData(conexion);
        
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
        jTID = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTIsbn = new javax.swing.JTextField();
        jCEstado = new javax.swing.JCheckBox();
        jBGuardar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jTEditorial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTTipo = new javax.swing.JTextField();
        jYearAnio = new com.toedter.calendar.JYearChooser();
        jCAutor = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Altas, bajas, modificaciones");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("LIBROS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Año ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("ISBN");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Tipo");

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

        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });

        jTIsbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTIsbnKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTIsbnKeyTyped(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.setEnabled(false);
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

        jTEditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTEditorialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEditorialKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Editorial");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Autor");

        jTTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTipoKeyTyped(evt);
            }
        });

        jCAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBBuscar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBGuardar))
                                        .addGap(18, 18, 18)
                                        .addComponent(jBBorrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBActualizar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(jTEditorial)
                                    .addComponent(jTTipo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jYearAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addComponent(jCAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jBLimpiar)))
                .addContainerGap(67, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jYearAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jCEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBBorrar)
                    .addComponent(jBActualizar)
                    .addComponent(jBLimpiar))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void habilitarBotonGuardar(){
        
        
        if(!jTTipo.getText().isEmpty()&&!jTNombre.getText().isEmpty()&&!jTIsbn.getText().isEmpty()&&!jTEditorial.getText().isEmpty()&&jCAutor.getSelectedItem()!=null){
        jBGuardar.setEnabled(true);
        }else{jBGuardar.setEnabled(false);}
    }
    
    private void habilitarBotonBuscar(){
                 if(!jTID.getText().isEmpty()){
                 jBBuscar.setEnabled(true);
                 }else{jBBuscar.setEnabled(false);}   
    }
    
    public void habilitarBotonBorrar(){
        if(!jTID.getText().isEmpty()){
        int aux = Integer.parseInt(jTID.getText());
        Libro libro = libroData.buscarLibro(aux);
        if(libro!=null && libro.isActivo()!=false){
        jBBorrar.setEnabled(true);
        }else{jBBorrar.setEnabled(false);}
        }
       
      
    }
    
    private void habilitarBotonActualizar(){
    
        if(!jTTipo.getText().isEmpty()&&!jTNombre.getText().isEmpty()&&!jTIsbn.getText().isEmpty()&&!jTEditorial.getText().isEmpty()&&jCAutor.getSelectedItem()!=null){
        jBActualizar.setEnabled(true);
        }else{jBActualizar.setEnabled(false);}
    
    }
    
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if(jYearAnio.getValue()<0){
        String nombre=jTNombre.getText();
        String isbn=jTIsbn.getText();
        int anio = jYearAnio.getValue();
        String tipo=jTTipo.getText();
        String editorial=jTEditorial.getText();
        Boolean estado = jCEstado.isEnabled();
        Autor autor = (Autor)jCAutor.getSelectedItem();
        Libro libro = new Libro(autor, isbn, nombre, tipo, editorial, anio, estado);
        libroData.guardarLibro(libro);
        
        jTID.setText(String.valueOf(autor.getId_Autor()));
        jTID.setEnabled(false);
        jTNombre.setEnabled(false);
        jBGuardar.setEnabled(false);
        jTIsbn.setEnabled(false);
        jYearAnio.setEnabled(false);
        jTTipo.setEnabled(false);
        jCEstado.setEnabled(false);
        jTEditorial.setEnabled(false);
        jCAutor.setEnabled(false);
        }else{JOptionPane.showMessageDialog(this, "Ingrese una año valido");}
        
        
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Libro libro = libroData.buscarLibro(id);
        if(libro!=null){
        
        libroData.darBajaLibro(id);
        jCAutor.setSelectedItem(libro.getAutor());
        jYearAnio.setValue(libro.getAnio());
        jTNombre.setText(libro.getNombre());
        jTIsbn.setText(libro.getISBN());
        jTEditorial.setText(libro.getEditorial());
        jTTipo.setText(libro.getTipo());
        
        jCEstado.setEnabled(false);
        jTID.setEnabled(false);
        jTNombre.setEnabled(false);
        jTIsbn.setEnabled(false);
        jYearAnio.setEnabled(false);
        jTTipo.setEnabled(false);
        jTEditorial.setEnabled(false);
        jCAutor.setEnabled(false);
        
        jBBorrar.setEnabled(false);
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        }
        else{JOptionPane.showMessageDialog(this, "El autor que intenta borrar, no se encuentra en la base de datos");}
    }//GEN-LAST:event_jBBorrarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Libro aux = libroData.buscarLibro(id);
        if(aux!=null){
        String nombre=jTNombre.getText();
        String isbn=jTIsbn.getText();
        int anio = jYearAnio.getValue();
        String editorial=jTEditorial.getText();
        String tipo=jTTipo.getText();
        Boolean estado = jCEstado.isEnabled();
        Autor autor = (Autor)jCAutor.getSelectedItem();
        Libro libro = new Libro(autor, isbn, nombre, tipo, editorial, anio, estado);
        libroData.actualizarLibro(libro);
        jTID.setEnabled(false);
        jTNombre.setEnabled(false);
        jTIsbn.setEnabled(false);
        jYearAnio.setEnabled(false);
        jTTipo.setEnabled(false);
        jTEditorial.setEnabled(false);
        jCEstado.setEnabled(false);
        jCAutor.setEnabled(false);
        
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        jBBorrar.setEnabled(false);
        jBGuardar.setEnabled(false);
        }else{JOptionPane.showMessageDialog(this,"El autor que quiere actualizar no esta en la base de datos");}
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
        jTID.setText("");
        jTNombre.setText("");
        jTIsbn.setText("");
        jYearAnio.setValue(2021);
        jTEditorial.setText("");
        jTTipo.setText("");
        jCAutor.setSelectedItem(null);
        jCEstado.setSelected(false);
            
        jTID.setEnabled(true);
        jTNombre.setEnabled(true);
        jTIsbn.setEnabled(true);
        jTTipo.setEnabled(true);
        jYearAnio.setEnabled(true);
        jCEstado.setEnabled(true);
        jTEditorial.setEnabled(true);
        jCAutor.setEnabled(true);
        
        jBActualizar.setEnabled(false);
        jBGuardar.setEnabled(false);
        jBBorrar.setEnabled(false);
        
        
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jTID.getText());
        Libro libro = libroData.buscarLibro(id);
        if(libro!=null){
        jYearAnio.setValue(libro.getAnio());
        jTNombre.setText(libro.getNombre());
        jTIsbn.setText(libro.getISBN());
        jTTipo.setText(libro.getTipo());
        jTEditorial.setText(libro.getEditorial());
        jCAutor.setSelectedItem(libro.getAutor());
        jCEstado.setSelected(libro.isActivo());
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

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
        getToolkit().beep();
        evt.consume();
        JOptionPane.showMessageDialog(this,"solo puede ingresar letras");
        }
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTIsbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIsbnKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
        getToolkit().beep();
        evt.consume();
        JOptionPane.showMessageDialog(this,"solo puede ingresar letras");
        }
    }//GEN-LAST:event_jTIsbnKeyTyped

    private void jTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIDActionPerformed

    private void jTNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyReleased
        // TODO add your handling code here:
        habilitarBotonGuardar();
        habilitarBotonActualizar();
    }//GEN-LAST:event_jTNombreKeyReleased

    private void jTIsbnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIsbnKeyReleased
        // TODO add your handling code here:
        habilitarBotonGuardar();
        habilitarBotonActualizar();
    }//GEN-LAST:event_jTIsbnKeyReleased

    private void jTIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIDKeyReleased
        // TODO add your handling code here:
        habilitarBotonBuscar();
        habilitarBotonBorrar();
        habilitarBotonActualizar();
    }//GEN-LAST:event_jTIDKeyReleased

    private void jTEditorialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEditorialKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEditorialKeyReleased

    private void jTEditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEditorialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEditorialKeyTyped

    private void jTTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTipoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTipoKeyReleased

    private void jTTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTipoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTipoKeyTyped

    private void jCAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAutorActionPerformed
    public void cargarAutores(){
        for(Autor a:autores){
        jCAutor.addItem(a);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JComboBox<Autor> jCAutor;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTEditorial;
    private javax.swing.JTextField jTID;
    private javax.swing.JTextField jTIsbn;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTTipo;
    private com.toedter.calendar.JYearChooser jYearAnio;
    // End of variables declaration//GEN-END:variables
}

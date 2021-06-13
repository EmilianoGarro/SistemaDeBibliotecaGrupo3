/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemabibliotecagrupo3.modelos.*;



/**
 *
 * @author Asus
 */
public class ListadoAutores extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private AutorData autorData;
    private ArrayList<Autor> autores;
    private Conexion conexion;
    /**
     * Creates new form ListadoAlumnosXMaterias
     */
    public ListadoAutores()  {
        initComponents();
        try {
            conexion = new Conexion();
            modelo = new DefaultTableModel();
            autorData = new AutorData(conexion);
            
            armarCabeceraTabla();
            cargaDatos();
        } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Problema de conexion con la base de datos");
        }
    }
    

    
    public void armarCabeceraTabla(){
        ArrayList<Object> cabecera = new ArrayList<Object>();
        cabecera.add("Id");
        cabecera.add("Dni");
        cabecera.add("Apellido");
        cabecera.add("Nombre");
        cabecera.add("Nacionalidad");
        cabecera.add("Fecha nacimiento");
        cabecera.add("Estado");
        
        for (Object ol : cabecera){
            modelo.addColumn(ol);
        }

        tAutores.setModel(modelo);
    } 
    
    public void borrarFilasTabla(){
        int g = modelo.getRowCount()-1;
        for(int i=g; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void cargaDatos(){
        borrarFilasTabla();
        String opcion = (String)cbEstado.getSelectedItem();
        
        switch (opcion) {
            case "activos" : autores = (ArrayList)autorData.obtenerAutoresSegunEstado(true); break;
            case "inactivos" : autores = (ArrayList)autorData.obtenerAutoresSegunEstado(false); break;
            case "todos" : autores = (ArrayList)autorData.obtenerAutores(); break;
        }
 
        for (Autor autor : autores) {       
            modelo.addRow(new Object[]{autor.getId_Autor(), autor.getDni(), autor.getApellido(), autor.getNombre(), autor.getNacionalidad(), autor.getFechaNac(), autor.isActivo()});
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

        jdpEscritorio = new javax.swing.JDesktopPane();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAutores = new javax.swing.JTable();
        cbEstado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jdpEscritorio.setBackground(new java.awt.Color(255, 204, 153));

        label1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 29)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setText("Listado de Autores");

        label2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setText("ESTADO:");

        tAutores.setBackground(new java.awt.Color(255, 255, 204));
        tAutores.setForeground(new java.awt.Color(51, 51, 51));
        tAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Title 2", "Title 3", "Title 4"
            }
        ));
        tAutores.setToolTipText("");
        jScrollPane1.setViewportView(tAutores);

        cbEstado.setBackground(new java.awt.Color(255, 255, 204));
        cbEstado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbEstado.setForeground(new java.awt.Color(51, 51, 51));
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "todos", "activos", "inactivos" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jdpEscritorio.setLayer(label1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(label2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorio.setLayer(cbEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpEscritorioLayout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jdpEscritorioLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
        cargaDatos();
    }//GEN-LAST:event_cbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane jdpEscritorio;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tAutores;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.vistas;

import java.awt.Dimension;

/**
 *
 * @author Asus
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMSolicitar = new javax.swing.JMenuItem();
        jMBuscarPrestamo = new javax.swing.JMenuItem();
        jMPrestamosVencidos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMListarMultas = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMAutores = new javax.swing.JMenuItem();
        jMEjemplares = new javax.swing.JMenuItem();
        jMLectores = new javax.swing.JMenuItem();
        jMLibros = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMListadoAutores = new javax.swing.JMenuItem();
        jMListadoEjemplares = new javax.swing.JMenuItem();
        jMListadoLectores = new javax.swing.JMenuItem();
        jMListadoLibros = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1191, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        jMenu6.setText("Opciones Prestamos");

        jMSolicitar.setText("Solicitar  o Devolver Libro");
        jMSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSolicitarActionPerformed(evt);
            }
        });
        jMenu6.add(jMSolicitar);

        jMBuscarPrestamo.setText("Buscar Prestamo");
        jMenu6.add(jMBuscarPrestamo);

        jMPrestamosVencidos.setText("Prestamos Vencidos");
        jMPrestamosVencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPrestamosVencidosActionPerformed(evt);
            }
        });
        jMenu6.add(jMPrestamosVencidos);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Opciones Multa");

        jMListarMultas.setText("Buscar Multas");
        jMListarMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarMultasActionPerformed(evt);
            }
        });
        jMenu7.add(jMListarMultas);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Salir");

        jMenuItem18.setText("Exit");
        jMenu8.add(jMenuItem18);

        jMenuBar1.add(jMenu8);

        jMenu1.setText("Altas, Bajas y Modificaciones");

        jMAutores.setText("Autores");
        jMAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAutoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMAutores);

        jMEjemplares.setText("Ejemplares");
        jMEjemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMEjemplaresActionPerformed(evt);
            }
        });
        jMenu1.add(jMEjemplares);

        jMLectores.setText("Lectores");
        jMLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMLectoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMLectores);

        jMLibros.setText("Libros");
        jMLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMLibrosActionPerformed(evt);
            }
        });
        jMenu1.add(jMLibros);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Listados");

        jMListadoAutores.setText("Autores");
        jMListadoAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoAutoresActionPerformed(evt);
            }
        });
        jMenu2.add(jMListadoAutores);

        jMListadoEjemplares.setText("Ejemplares");
        jMListadoEjemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoEjemplaresActionPerformed(evt);
            }
        });
        jMenu2.add(jMListadoEjemplares);

        jMListadoLectores.setText("Lectores");
        jMListadoLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoLectoresActionPerformed(evt);
            }
        });
        jMenu2.add(jMListadoLectores);

        jMListadoLibros.setText("Libros");
        jMListadoLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoLibrosActionPerformed(evt);
            }
        });
        jMenu2.add(jMListadoLibros);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAutoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaAutores va = new VistaAutores();
        va.setVisible(true);
        escritorio.add(va);
        escritorio.moveToFront(va);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = va.getSize();
        va.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        va.show();
    }//GEN-LAST:event_jMAutoresActionPerformed
//    public void agregarVentanaAutores() {
//        VistaAutores va = new VistaAutores();
//        escritorio.add(va);
//        escritorio.moveToFront(va);
//        va.setVisible(true);
//        va.show();
//    }
    private void jMLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMLibrosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaLibros vl = new VistaLibros();
        vl.setVisible(true);
        escritorio.add(vl);
        escritorio.moveToFront(vl);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vl.getSize();
        vl.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vl.show();
    }//GEN-LAST:event_jMLibrosActionPerformed

    private void jMEjemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMEjemplaresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaEjemplares ve = new VistaEjemplares();
        ve.setVisible(true);
        escritorio.add(ve);
        escritorio.moveToFront(ve);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ve.getSize();
        ve.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ve.show();
    }//GEN-LAST:event_jMEjemplaresActionPerformed

    private void jMLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMLectoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaLectores vle = new VistaLectores();
        vle.setVisible(true);
        escritorio.add(vle);
        escritorio.moveToFront(vle);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vle.getSize();
        vle.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vle.show();
    }//GEN-LAST:event_jMLectoresActionPerformed

    private void jMListadoAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoAutoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListadoAutores la = new ListadoAutores();
        la.setVisible(true);
        escritorio.add(la);
        escritorio.moveToFront(la);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = la.getSize();
        la.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        la.show();
    }//GEN-LAST:event_jMListadoAutoresActionPerformed

    private void jMListadoEjemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoEjemplaresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListadoEjemplares le = new ListadoEjemplares();
        le.setVisible(true);
        escritorio.add(le);
        escritorio.moveToFront(le);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = le.getSize();
        le.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        le.show();
    }//GEN-LAST:event_jMListadoEjemplaresActionPerformed

    private void jMListadoLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoLectoresActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListadoLectores ll = new ListadoLectores();
        ll.setVisible(true);
        escritorio.add(ll);
        escritorio.moveToFront(ll);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ll.getSize();
        ll.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ll.show();
    }//GEN-LAST:event_jMListadoLectoresActionPerformed

    private void jMListadoLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoLibrosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListadoLibros lli = new ListadoLibros();
        lli.setVisible(true);
        escritorio.add(lli);
        escritorio.moveToFront(lli);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = lli.getSize();
        lli.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        lli.show();
    }//GEN-LAST:event_jMListadoLibrosActionPerformed

    private void jMPrestamosVencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPrestamosVencidosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ListadoPrestamos lp = new ListadoPrestamos();
        lp.setVisible(true);
        escritorio.add(lp);
        escritorio.moveToFront(lp);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = lp.getSize();
        lp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        lp.show();
    }//GEN-LAST:event_jMPrestamosVencidosActionPerformed

    private void jMSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSolicitarActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaPrestamos vp = new VistaPrestamos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vp.getSize();
        vp.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vp.show();
    }//GEN-LAST:event_jMSolicitarActionPerformed

    private void jMListarMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarMultasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ListadoMulta lm = new ListadoMulta();
        lm.setVisible(true);
        escritorio.add(lm);
        escritorio.moveToFront(lm);
         Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = lm.getSize();
        lm.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        lm.show();
    }//GEN-LAST:event_jMListarMultasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMAutores;
    private javax.swing.JMenuItem jMBuscarPrestamo;
    private javax.swing.JMenuItem jMEjemplares;
    private javax.swing.JMenuItem jMLectores;
    private javax.swing.JMenuItem jMLibros;
    private javax.swing.JMenuItem jMListadoAutores;
    private javax.swing.JMenuItem jMListadoEjemplares;
    private javax.swing.JMenuItem jMListadoLectores;
    private javax.swing.JMenuItem jMListadoLibros;
    private javax.swing.JMenuItem jMListarMultas;
    private javax.swing.JMenuItem jMPrestamosVencidos;
    private javax.swing.JMenuItem jMSolicitar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem18;
    // End of variables declaration//GEN-END:variables
}

package interfazxml;

import ReportesFi.*;
import xml.VentanaFacXML;


public class Organizador extends javax.swing.JFrame{
    public String Usuario;
    public String Nombre;
    public Organizador(String us,String nombre){
        Usuario=us;
        Nombre=nombre;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("ORGANIZADOR DE FACTURAS-"+nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Proveedor");
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("JMenu1");

        jMenu2.setText("Gastos Personales");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu6.setText("Gastos Negocio");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Reportes");

        jMenu8.setText("Personales");

        jMenu10.setText("Anual");
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenu8.add(jMenu10);

        jMenu11.setText("Mensual");
        jMenu11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu11MouseClicked(evt);
            }
        });
        jMenu8.add(jMenu11);

        jMenu12.setText("Proveedor");
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu8.add(jMenu12);

        jMenu7.add(jMenu8);

        jMenu9.setText("Negocio");

        jMenu15.setText("Mensual");
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu9.add(jMenu15);

        jMenu16.setText("Proveedor");
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenu9.add(jMenu16);

        jMenu7.add(jMenu9);

        jMenuBar1.add(jMenu7);

        jMenu5.setText("Xml");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu4.setText("Salir");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu4MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
          /*      Proveedor nuevo=new Proveedor();
        nuevo.setVisible(true);*/

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed

    }//GEN-LAST:event_jMenu1KeyPressed

    private void jMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu1MenuKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1MenuKeyPressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
         Proveedor pro = new Proveedor(Nombre);
         pro.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        System.out.println(Usuario);
        Factura fact=new Factura(Usuario,Nombre);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        xml.VentanaFacXML pro = new VentanaFacXML(Usuario,Nombre);
        pro.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu4MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu4MenuKeyPressed
        // TODO add your handling code here:
               
    
    }//GEN-LAST:event_jMenu4MenuKeyPressed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        Factura_Negocio fact=new Factura_Negocio(Usuario,Nombre);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        GPersonalesMensual fact=new GPersonalesMensual(Usuario);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        GPersonalesProveedor fact=new GPersonalesProveedor(Usuario);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        GNegocioMensual fact=new GNegocioMensual(Usuario);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        GNegocioProveedor fact=new GNegocioProveedor(Usuario);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu16MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        GPersonalesAnual fact=new GPersonalesAnual(Usuario);
        fact.setVisible(true);
    }//GEN-LAST:event_jMenu10MouseClicked

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
            java.util.logging.Logger.getLogger(Organizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Organizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Organizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Organizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Organizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

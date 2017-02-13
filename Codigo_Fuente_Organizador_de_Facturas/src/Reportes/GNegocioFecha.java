/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import interfazxml.ConexionBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robert
 */
public class GNegocioFecha extends javax.swing.JFrame {
    private DefaultTableModel model;
    private String Comprador="";
    public GNegocioFecha(String usuario) {
        Comprador=usuario;
        initComponents();
        setTitle("Gastos Negocio por Fecha");
        setLocationRelativeTo(null);
        Date dato = new Date();
        jDateChooser1.setMaxSelectableDate(dato);
        jDateChooser2.setMaxSelectableDate(dato);
    }

    public void formatot() {
        String datos[][] = {};
        String Col[] = {"Tipo Negocio", "Valor sin IVA", "IVA", "VAlor con IVA"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }
    public void obtenerTabla(String fecha1, String fecha2) throws SQLException {
        String sinIva,Iva,conIva;
        formatot();
        ConexionBase cont = new ConexionBase();
        for(int i=1;i<=6;i++){
            model.insertRow(i-1, new Object[]{});
        String sentencia = "select (select Nombre_Tipo_Negocio from tipo_Negocio where Cod_Tipo_Negocio='"+i+"'),sum(Detalle_Factura_Negocio.Valor_Sin_IVA),sum(Detalle_Factura_Negocio.IVA),sum(Detalle_Factura_Negocio.Valor_Con_IVA) from Detalle_Factura_Negocio,Tipo_Gasto_Negocio,Factura_Negocio where Detalle_Factura_Negocio.Cod_Tipo_Negocio='"+i+"'"
                + " and Detalle_Factura_Negocio.Cod_Factura_Negocio=Factura_Negocio.Cod_Factura_Negocio and "
                + "Detalle_Factura_Negocio.RUC_Proveedor=Factura_Negocio.RUC_Proveedor and "
                + "Factura_Negocio.Fecha_Factura  BETWEEN '"+ fecha1 +"'  AND '"
                + fecha2 +"' and Factura_Negocio.RUCoCI_Comprador='"+Comprador+"';";
        //System.out.println(sentencia);
        ResultSet resultado = cont.SelectDB1(sentencia);
        while (resultado.next()){
            model.setValueAt(resultado.getString("(select Nombre_Tipo_Negocio from tipo_Negocio where Cod_Tipo_Negocio='"+i+"')"),i-1,0);
            sinIva=(resultado.getString("sum(Detalle_Factura_Negocio.Valor_Sin_IVA)"));
            Iva=(resultado.getString("sum(Detalle_Factura_Negocio.IVA)"));
            conIva=(resultado.getString("sum(Detalle_Factura_Negocio.Valor_Con_IVA)"));
            if(sinIva!=null)
                model.setValueAt(sinIva,i-1,1);
            else
                model.setValueAt("0",i-1,1);
            if(Iva!=null)
                model.setValueAt(Iva,i-1,2);
            else
                model.setValueAt("0",i-1,2);
            if(conIva!=null)
                model.setValueAt(conIva,i-1,3);
            else
                model.setValueAt("0",i-1,3);
        }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha Inicio");

        jLabel2.setText("Fecha FIn");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton2))
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("entrooo");
        System.out.println("fecha: "+jDateChooser1.getDate());
        String fecha1= "",fecha2="";
        try {
            if(jDateChooser1.getDate()!=null && jDateChooser2.getDate()!=null){
            fecha1 += jDateChooser1.getCalendar().get(Calendar.YEAR) + "-"
                    + (jDateChooser1.getCalendar().get(Calendar.MONTH) + 1) + "-" + jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
            fecha2 += jDateChooser2.getCalendar().get(Calendar.YEAR) + "-"
                    + (jDateChooser2.getCalendar().get(Calendar.MONTH) + 1) + "-" + jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH);    
            if(jDateChooser2.getDate().compareTo(jDateChooser1.getDate())>=0)    
                obtenerTabla(fecha1,fecha2);
            else   
                JOptionPane.showMessageDialog(null, "Ingresar un intervalo corecto");
            }else
                JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        } catch (SQLException ex) {
            Logger.getLogger(GPersonalesMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ExportarExcel exportar=new ExportarExcel(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GNegocioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GNegocioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNegocioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GNegocioFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GPersonalesFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

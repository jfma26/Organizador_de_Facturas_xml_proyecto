/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import interfazxml.ConexionBase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robert
 */
public class GNegocioMensual extends javax.swing.JFrame {

    private DefaultTableModel model;
    private String Comprador="";
    public GNegocioMensual(String usuario) {
        Comprador=usuario;
        try {
            initComponents();
            setLocationRelativeTo(null);
            setTitle("Gastos Negocio Mensual");
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(GNegocioMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCombo() throws SQLException {
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM Limite_Gasto;";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            jComboBox2.addItem(resultado.getString("Año"));
            codigo++;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<String>();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel1.setText("Mes");

        jLabel2.setText("Ano");

        jScrollPane2.setViewportView(jTable1);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jButton5)
                        .addGap(81, 81, 81)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            obtenerTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GNegocioMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // LeerArchivo();
       ExportarExcel exportar=new ExportarExcel(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void formatot() {
        String datos[][] = {};
        String Col[] = {"Tipo Negocio", "Valor sin IVA", "IVA", "Valor con IVA"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }
    public void obtenerTabla() throws SQLException {
        String sinIva,Iva,conIva;
        formatot();
        ConexionBase cont = new ConexionBase();
        for(int i=1;i<=6;i++){
            model.insertRow(i-1, new Object[]{});
        String sentencia = "select (select Nombre_Tipo_Negocio from tipo_Negocio where Cod_Tipo_Negocio='"+i+"'),sum(Detalle_Factura_Negocio.Valor_Sin_IVA),sum(Detalle_Factura_Negocio.IVA),sum(Detalle_Factura_Negocio.Valor_Con_IVA) from Detalle_Factura_Negocio,Tipo_Negocio,Factura_Negocio where Detalle_Factura_Negocio.Cod_Tipo_Negocio='"+i+"'"
                + " and Detalle_Factura_Negocio.Cod_Factura_Negocio=Factura_Negocio.Cod_Factura_Negocio and "
                + "Detalle_Factura_Negocio.RUC_Proveedor=Factura_Negocio.RUC_Proveedor and "
                + "Factura_Negocio.Fecha_Factura  BETWEEN '"+jComboBox2.getSelectedItem().toString()+"-"+(jComboBox1.getSelectedIndex()+1)+"-01'  AND '"
                +jComboBox2.getSelectedItem().toString()+"-"+(jComboBox1.getSelectedIndex()+1)+"-31' and Factura_Negocio.RUCoCI_Comprador='"+Comprador+"';";
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
            java.util.logging.Logger.getLogger(GNegocioMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GNegocioMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GNegocioMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GNegocioMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GPersonalesMensual().setVisible(true);
            }
        });
    }

    private void LeerArchivo() {
            try {
                File fe = new File("Reporte.xls");
                BufferedWriter salida;
                salida = new BufferedWriter(new FileWriter(fe));
                salida.write("Vivienda,Educacion,Salud,Vestido,Alimentacion,Otro,Negocio");
                salida.newLine();
                salida.write("");
                salida.close();
            } catch (IOException ex) {
                // Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import interfazxml.ConexionBase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author robert
 */
public class GTotalesAnual extends javax.swing.JFrame {

    private String Comprador="";
    public GTotalesAnual(String usuario) {
        Comprador=usuario;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gasto Total Anual");
        try {
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(GTotalesAnual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCombo() throws SQLException {
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM limite_gasto;";
        ResultSet resultado = cont.SelectDB1(sentencia);
        System.out.println(sentencia);
        int codigo = 2010;
        while (resultado.next()) {
            //System.out.println(resultado.getString("Año"));
            jComboBox3.addItem(resultado.getString("Año"));
           // codigo++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox3 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Año");

        jLabel2.setText("Gastos en el año");

        jLabel3.setText("Limite de Gasto");

        jLabel4.setText("Gastos faltante");

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jButton5.setText("cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2)))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButton5)
                        .addGap(89, 89, 89)
                        .addComponent(jButton1)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        jTextField1.setText(String.valueOf(GastoPersonal()+GastosNegocio()));
        jTextField2.setText(String.valueOf(LimiteGasto()));
        jTextField3.setText(String.valueOf(LimiteGasto()-(GastoPersonal()+GastosNegocio())));
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LeerArchivo();
        JOptionPane.showMessageDialog(null, "Guardado exitosamente");
    }//GEN-LAST:event_jButton1ActionPerformed

    private double GastoPersonal(){
        String val="";
        ConexionBase cont = new ConexionBase();
        for(int i=1;i<=7;i++){
            try {
                String sentencia = "select sum(Detalle_Factura.Valor_Con_IVA) from Detalle_Factura, Factura where "
                        +" Detalle_Factura.Cod_Factura=Factura.Cod_Factura and "
                        + "Detalle_Factura.RUC_Proveedor=Factura.RUC_Proveedor and "
                        + "Factura.Fecha_Factura  BETWEEN '"+jComboBox3.getSelectedItem().toString()+"-01-01'  AND '"
                        +jComboBox3.getSelectedItem().toString()+"-12-31' and Factura.RUCoCI_Comprador='"+Comprador+"';";
                System.out.println("Personales "+sentencia);
                ResultSet resultado = cont.SelectDB1(sentencia);
                while (resultado.next())
                    val=resultado.getString("sum(Detalle_Factura.Valor_Con_IVA)");
                if(val!=null)
                    return Double.parseDouble(val);
            } catch (SQLException ex) {
                Logger.getLogger(GTotalesAnual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    private double GastosNegocio(){
        ConexionBase cont = new ConexionBase();
        String val="";
        for(int i=1;i<=7;i++){
            try {
                String sentencia = "select sum(Detalle_Factura_Negocio.Valor_Con_IVA) from Detalle_Factura_Negocio, Factura_Negocio where "
                        +" Detalle_Factura_Negocio.Cod_Factura_Negocio=Factura_Negocio.Cod_Factura_Negocio and "
                        + "Detalle_Factura_Negocio.RUC_Proveedor=Factura_Negocio.RUC_Proveedor and "
                        + "Factura_Negocio.Fecha_Factura  BETWEEN '"+jComboBox3.getSelectedItem().toString()+"-01-01'  AND '"
                        +jComboBox3.getSelectedItem().toString()+"-12-31' and Factura_Negocio.RUCoCI_Comprador='"+Comprador+"';";
                System.out.println("Personales "+sentencia);
                ResultSet resultado = cont.SelectDB1(sentencia);
                while (resultado.next())
                    val=resultado.getString("sum(Detalle_Factura_Negocio.Valor_Con_IVA)");
                if(val!=null)
                    return Double.parseDouble(val);
            } catch (SQLException ex) {
                Logger.getLogger(GTotalesAnual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
    private double LimiteGasto(){
        try {
            ConexionBase cont = new ConexionBase();
            String sentencia = "SELECT * FROM Limite_Gasto where Año='"+jComboBox3.getSelectedItem().toString()+"';";
            System.out.println("Personales "+sentencia);
            ResultSet resultado = cont.SelectDB1(sentencia);
            int codigo = 0;
            while (resultado.next()) {
                return (
                Double.parseDouble(resultado.getString("Valor_Vivienda"))+
                Double.parseDouble(resultado.getString("Valor_Educacion"))+
                Double.parseDouble(resultado.getString("Valor_Salud"))+
                Double.parseDouble(resultado.getString("Valor_Vestido"))+
                Double.parseDouble(resultado.getString("Valor_Alimentacion"))+
                Double.parseDouble(resultado.getString("Valor_Otro"))+
                Double.parseDouble(resultado.getString("Valor_Total_Año")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GTotalesAnual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
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
            java.util.logging.Logger.getLogger(GTotalesAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GTotalesAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GTotalesAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GTotalesAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GPersonalesAnual().setVisible(true);
            }
        });
    }
    private void LeerArchivo() {
            try {
                File fe = new File("Reporte.xls");
                BufferedWriter salida;
                salida = new BufferedWriter(new FileWriter(fe));
                salida.write("Gasto Total,Limite Gasto, Diferencia,");
                salida.newLine();
                salida.write(jTextField1.getText()+";"+jTextField1.getText()+";"+jTextField1.getText()+";");
                salida.close();
            } catch (IOException ex) {
                // Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

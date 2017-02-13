/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportesFi;

import Reportes.*;
import interfazxml.ConexionBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class GNegocioMensual extends javax.swing.JFrame {
    private DefaultTableModel model;
    private String Comprador="";
    private String VMeses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
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
            jComboBox1.addItem(resultado.getString("Año"));
            codigo++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Año");

        jScrollPane2.setViewportView(jTable1);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    ExportarExcel exportar=new ExportarExcel(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            obtenerTabla();
        } catch (SQLException ex) {
            Logger.getLogger(GNegocioMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    public void formatot() {
        String sinIva,Iva,conIva;
        String datos[][] = {};
        String Col[] = {"MES","Mercaderia","Arriendo"
                ,"Servicios Basicos","Sueldos","Movilizacion Viaticos","Capacitacion"
                ,"Suministro de Oficina","Herramienta de Trabajo","Otros"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }
    
    private void obtenerTabla() throws SQLException {
        String conIva;
        double total[]={0,0,0,0,0,0,0,0,0};
        formatot();
        ConexionBase cont = new ConexionBase();
        for(int j=1;j<=12;j++)
        { model.insertRow(j-1, new Object[]{});
        for(int i=1;i<=9;i++){
        String sentencia = "select sum(Detalle_Factura_Negocio.Valor_Con_IVA)"
                +" from Detalle_Factura_Negocio,Factura_Negocio where Detalle_Factura_Negocio.Cod_Tipo_Negocio='"+i+"'"
                +" and Detalle_Factura_Negocio.Cod_Factura_Negocio=Factura_Negocio.Cod_Factura_Negocio and "
                + "Detalle_Factura_Negocio.RUC_Proveedor=Factura_Negocio.RUC_Proveedor and "
                + "Factura_Negocio.Fecha_Factura  BETWEEN '"+jComboBox1.getSelectedItem().toString()+"-"+j+"-01'  AND '"
                +jComboBox1.getSelectedItem().toString()+"-"+j+"-31' and Factura_Negocio.RUCoCI_Comprador='"+Comprador+"';";
        //System.out.println(sentencia);
        ResultSet resultado = cont.SelectDB1(sentencia);
        while (resultado.next()){
            model.setValueAt(VMeses[j-1],j-1,0);
            conIva=(resultado.getString("sum(Detalle_Factura_Negocio.Valor_Con_IVA)"));
            if(conIva==null)
                conIva="0";
            total[i-1]+=Double.parseDouble(conIva);
            model.setValueAt(conIva,j-1,i);
            }
        }
        }
        model.insertRow(12, new Object[]{});
        model.setValueAt("TOTAL",12,0);
        for(int i=0;i<9;i++)
            model.setValueAt(total[i],12,i+1);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GPersonalesAnual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

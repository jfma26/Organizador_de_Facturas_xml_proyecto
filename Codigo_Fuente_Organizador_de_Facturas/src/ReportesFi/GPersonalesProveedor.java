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
public class GPersonalesProveedor extends javax.swing.JFrame {
    private DefaultTableModel model;
    private String Comprador="";
    private String VDatos[];
    private int conta=0;
    public GPersonalesProveedor(String usuario) {
        try {
            VDatos=new String[12];
            Comprador=usuario;
            initComponents();
            setLocationRelativeTo(null);
            setTitle("Gasto Personal por Fecha y Proveedor");
            Date dato = new Date();
            jDateChooser1.setMaxSelectableDate(dato);
            jDateChooser2.setMaxSelectableDate(dato);
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(GPersonalesProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarCombo() throws SQLException {

        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.proveedor;";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            jComboBox1.addItem(resultado.getString("Nombre_Proveedor"));
            codigo++;
        }
    }

    public void formatot() {
        String datos[][] = {};
        String Col[] = {"Num Factura", "Proveedor","Fecha","Vivienda","Educación"
                ,"Salud","Vestimenta","Alimentacion","Otros", "IVA","Total sin IVA","Total con IVA"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }
    public void ExtrearFactura(String fecha1, String fecha2,String Proveedor) throws SQLException {
        String conIva="";
        ConexionBase cont = new ConexionBase();
        for(int i=1;i<=6;i++){
        String sentencia = "select Detalle_Factura.Valor_Con_IVA from Detalle_Factura,Factura where Detalle_Factura.Cod_Tipo_Gasto='"+i+"'"
                + " and Detalle_Factura.Cod_Factura=Factura.Cod_Factura and "
                +" Detalle_Factura.Cod_Factura='"+VDatos[0]
                + "' and Detalle_Factura.RUC_Proveedor=Factura.RUC_Proveedor and "
                + "Factura.Fecha_Factura  BETWEEN '"+ fecha1 +"'  AND '"
                + fecha2 +"' and Detalle_Factura.RUC_Proveedor='"+Proveedor+"' and Factura.RUCoCI_Comprador='"+Comprador+"';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        while (resultado.next()){
            conIva=(resultado.getString("Detalle_Factura.Valor_Con_IVA"));
        }
        if(conIva==null || conIva.equals(""))
                conIva="0";
        VDatos[i+2]=conIva;
        conIva="";
        }
        model.insertRow(conta++, VDatos);
    }
    
    private void obtenerTabla(String fecha1, String fecha2,String Proveedor){
        formatot();
        conta=0;
        String sinIva,Iva,conIva;
        try {
            ConexionBase cont = new ConexionBase();
            String sentencia = "select Cod_Factura,RUC_Proveedor,Fecha_Factura,Valor_Sin_IVA,IVA,Valor_Con_IVA from Factura where "
                    + "Fecha_Factura  BETWEEN '"+ fecha1 +"'  AND '"
                    + fecha2 +"' and RUC_Proveedor='"+Proveedor+"' and  RUCoCI_Comprador='"+Comprador+"';";
            ResultSet resultado = cont.SelectDB1(sentencia);
            while (resultado.next()){
                VDatos[0]=resultado.getString("Cod_Factura");
                VDatos[1]=resultado.getString("RUC_Proveedor");
                VDatos[2]=resultado.getString("Fecha_Factura");
                sinIva=(resultado.getString("Valor_Sin_IVA"));
                Iva=(resultado.getString("IVA"));
                conIva=(resultado.getString("Valor_Con_IVA"));
                if(sinIva==null)
                    sinIva="0";
                if(Iva==null)
                    Iva="0";
                if(conIva==null)
                    conIva="0";
                VDatos[9]=Iva;
                VDatos[10]=sinIva;
                VDatos[11]=conIva;
                if(VDatos[0]!=null)
                    ExtrearFactura(fecha1,fecha2,Proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GPersonalesProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha Inicio");

        jLabel2.setText("Fecha FIn");

        jButton1.setText("Consultar");
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

        jLabel3.setText("Proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addContainerGap())
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
                obtenerTabla(fecha1,fecha2,getcombopro(jComboBox1.getSelectedItem().toString()));
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
        //LeerArchivo();
        ExportarExcel exportar=new ExportarExcel(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    public String getcombopro(String nproveedor) throws SQLException {
        String rucpro = "";
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.proveedor where Nombre_Proveedor='" + nproveedor + "';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        while (resultado.next())
            rucpro = resultado.getString("RUC_Proveedor");
        return rucpro;
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
            java.util.logging.Logger.getLogger(GPersonalesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GPersonalesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GPersonalesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GPersonalesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

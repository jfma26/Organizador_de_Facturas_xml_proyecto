/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazxml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Detalle_Factura extends javax.swing.JFrame {

    private String textoSql = "";
    private String tipoGasto = "";
    private String Factura = "";
    private String Proveedor = "";
    private String Comprador = "";
    private DefaultTableModel model;
    private ConexionBase con = new ConexionBase();
    private int n = 0;
    private double totalSinIVA = 0, totalIVA = 0, totalConIVA = 0;

    private void setTotalSinIVA(double a) {
        this.totalSinIVA += a;
    }

    private void setTotalIVA(double a) {
        this.totalIVA += a;
    }

    private void setTotalConIVA(double a) {
        this.totalConIVA += a;
    }

    public double getTotalSinIVA() {
        return this.totalSinIVA;
    }

    public double getTotalIVA() {
        return this.totalIVA;
    }

    public double getTotalConIVA() {
        return this.totalConIVA;
    }

    public Detalle_Factura(String factura, String proveedor, String comprador) {
        initComponents();
        setLocationRelativeTo(null);
        Factura = factura;
        Proveedor = proveedor;
        Comprador = comprador;
        jTextField1.setText(Factura);
        jTextField2.setText(Proveedor);
        try {
            obtenerTabla();
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Detalle_Factura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ///llenar tabla 
    public void formatot() {
        String datos[][] = {};
        String Col[] = {"Cod_factura", "RUC_Proveedor", "Cod_Tipo_Gasto", "Valor_Sin_IVA", "IVA", "Valor_Con_IVA"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }

    //llenar tabla en el inicio
    public void obtenerTabla() throws SQLException {
        this.totalSinIVA = 0;
        this.totalIVA = 0;
        this.totalConIVA = 0;
        formatot();
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.detalle_factura where Cod_Factura='" + Factura + "' and RUC_Proveedor='" + Proveedor + "';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            //System.out.println(codigo);
            model.insertRow(codigo, new Object[]{});
            model.setValueAt(resultado.getString("Cod_Factura"), codigo, 0);
            model.setValueAt(resultado.getString("RUC_Proveedor"), codigo, 1);
            model.setValueAt(resultado.getString("Cod_Tipo_Gasto"), codigo, 2);
            model.setValueAt(resultado.getString("Valor_Sin_IVA"), codigo, 3);
            model.setValueAt(resultado.getString("IVA"), codigo, 4);
            model.setValueAt(resultado.getString("Valor_Con_IVA"), codigo, 5);
            setTotalSinIVA(Double.parseDouble(resultado.getString("Valor_Sin_IVA")));
            setTotalIVA(Double.parseDouble(resultado.getString("IVA")));
            setTotalConIVA(Double.parseDouble(resultado.getString("Valor_Con_IVA")));
            codigo++;
        }
        System.out.println(getTotalSinIVA());
        ActualizarFactura();
    }

    private void ActualizarFactura() {
        textoSql = "update organizador_facturas.Factura set"
                + " Valor_Sin_IVA='" + getTotalSinIVA()
                + "' , IVA='" + getTotalIVA()
                + "' , Valor_Con_IVA='" + getTotalConIVA()
                + "' where Cod_Factura='" + jTextField1.getText()
                + "' and RUC_Proveedor='" + jTextField2.getText() + "';";
        con.UpdateDB(textoSql);
    }

    public void setcombogasto(String combog) {
        if (combog.contains("1")) {
            jComboBox1.setSelectedIndex(0);
        }
        if (combog.contains("2")) {
            jComboBox1.setSelectedIndex(1);
        }
        if (combog.contains("3")) {
            jComboBox1.setSelectedIndex(2);
        }
        if (combog.contains("4")) {
            jComboBox1.setSelectedIndex(3);
        }
        if (combog.contains("5")) {
            jComboBox1.setSelectedIndex(4);
        }
        if (combog.contains("6")) {
            jComboBox1.setSelectedIndex(5);
        }
        if (combog.contains("7")) {
            jComboBox1.setSelectedIndex(6);
        }
    }

    private boolean consultarTipo() throws SQLException {
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.detalle_factura where Cod_Factura='" + Factura + "' and RUC_Proveedor='" + Proveedor + "';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            if (resultado.getString("Cod_Tipo_Gasto").equals(String.valueOf(jComboBox1.getSelectedIndex() + 1))) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel6.setText("Tipo de Gastos");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vivienda", "Educacion", "Salud", "Vestido", "Alimentación", "Negocio", "Otro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor sin IVA");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel5.setText("Valor total");

        jTextField5.setEnabled(false);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel4.setText("Valor IVA");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel1.setText("Nro Factura");

        jTextField1.setEnabled(false);

        jLabel7.setText("Proveedor");

        jTextField2.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 225, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("grabar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        //        char c = evt.getKeyChar();
        //        System.out.println(c+"\n");
        //          String num=evt.toString();
        //        System.out.println("numero"+num);
        //        System.out.println(jTextField3.getText().toString());
        //        jTextField4.addKeyListener(setText(evt.setKeyCode(39)));
        //    jTextField4.setText(iva(jTextField3.getText().toString()));
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int filas = jTable1.getSelectedRow();
        jTextField3.setText(jTable1.getValueAt(filas, 3).toString());
        jTextField4.setText(jTable1.getValueAt(filas, 4).toString());
        jTextField5.setText(jTable1.getValueAt(filas, 5).toString());
        setcombogasto(jTable1.getValueAt(filas, 2).toString());
        tipoGasto = jTable1.getValueAt(filas, 2).toString();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LimpiarVentana();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConexionBase con=new ConexionBase();
        if (CamposLLenos()) {
            textoSql = "update organizador_facturas.detalle_factura set"
                    + " Valor_Sin_IVA='" + jTextField3.getText()
                    + "' , IVA='" + jTextField4.getText()
                    + "' , Valor_Con_IVA='" + jTextField5.getText()
                    + "' , Cod_Tipo_Gasto='" + (jComboBox1.getSelectedIndex() + 1) + "' where Cod_Factura='" + jTextField1.getText() + "' and RUC_Proveedor='" + jTextField2.getText()
                    + "' and Cod_Tipo_Gasto='" +  (jComboBox1.getSelectedIndex() + 1) + "';";
            System.out.println(textoSql);
            con.UpdateDB(textoSql);
            LimpiarVentana();
            try {
                obtenerTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.getText().equals("") && !jTextField2.getText().equals("") && !tipoGasto.equals("")) {
            textoSql = "delete From detalle_factura where Cod_Factura='" + jTextField1.getText() + "' and RUC_Proveedor='" + jTextField2.getText() + "' and Cod_Tipo_Gasto='" + tipoGasto + "';";
            System.out.println(textoSql);
            con.DeleteDB(textoSql);
            LimpiarVentana();
            try {
                obtenerTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione que elemento desea eliminar");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ConexionBase conexion=new ConexionBase();
 if (CamposLLenos()) {
            try {
                if(consultarTipo()){
                    textoSql = "insert into detalle_factura values('" + jTextField1.getText() + "','" + jTextField2.getText() + "','"
                            + (jComboBox1.getSelectedIndex()+1) + "','" + jTextField3.getText() + "','" + jTextField4.getText() + "','"
                            + jTextField5.getText() + "')";
                    conexion.Insertar1(textoSql);
                }else{
                    
                    textoSql = "update organizador_facturas.detalle_factura set"
                            + " Valor_Sin_IVA=Valor_Sin_IVA+" + jTextField3.getText()
                            + " , IVA=IVA+" + jTextField4.getText()
                            + " , Valor_Con_IVA=Valor_Con_IVA+" + jTextField5.getText()
                            + " , Cod_Tipo_Gasto='" + (jComboBox1.getSelectedIndex()+1) + "' where Cod_Factura='" + jTextField1.getText() +"' and RUC_Proveedor='"+jTextField2.getText()
                            +"' and Cod_Tipo_Gasto='"+(jComboBox1.getSelectedIndex()+1)+"';";
                    System.out.println(textoSql);
                    con.UpdateDB(textoSql);
                }
            } catch (SQLException ex) {
                Logger.getLogger(xml.Detalle_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
            LimpiarVentana();
            try {
                obtenerTabla();
                LLenarValorTotal();
            } catch (SQLException ex) {
                Logger.getLogger(xml.Detalle_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Factura fac = new Factura(Comprador);
        fac.setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");

        }
        LLenarValorTotal();
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");

        }
        LLenarValorTotal();
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");

        }

    }//GEN-LAST:event_jTextField5KeyTyped

    private void LLenarValorTotal() {
        if (!jTextField3.getText().equals("") && !jTextField4.getText().equals("") && !jTextField3.getText().equals("")) {
            jTextField5.setText(String.valueOf(Double.parseDouble(jTextField3.getText()) + Double.parseDouble(jTextField4.getText())));
        } else {
            jTextField5.setText("");
        }
    }

    private void LimpiarVentana() {
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jComboBox1.setSelectedIndex(0);
        tipoGasto = "";
    }

    private boolean CamposLLenos() {
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")
                || jTextField4.getText().equals("") || jTextField5.getText().equals("")) {
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(Detalle_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalle_Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}

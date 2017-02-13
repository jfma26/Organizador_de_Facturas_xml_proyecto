/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import interfazxml.ConexionBase;
import interfazxml.Organizador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Detalle_Factura_Negocio extends javax.swing.JFrame {

    private String textoSql = "";
    private String tipoGasto="";
    private String Factura="";
    private String Proveedor="";
    private String Comprador="";
    private int incre=0;
    private DefaultTableModel model;
    private ConexionBase con = new ConexionBase();
    private int n = 0;
    private double totalSinIVA=0,totalIVA=0,totalConIVA=0;
    private List<String> lista;
    private boolean booleanSimple=true;
    
    private void setTotalSinIVA(double a){
        this.totalSinIVA+=a;
    }
    private void setTotalIVA(double a){
        this.totalIVA+=a;
    }
    private void setTotalConIVA(double a){
        this.totalConIVA+=a;
    }
    public double getTotalSinIVA(){
        return this.totalSinIVA;
    }
    public double getTotalIVA(){
        return this.totalIVA;
    }
    public double getTotalConIVA(){
        return this.totalConIVA;
    }
    public Detalle_Factura_Negocio(String factura, String proveedor,String comprador, List<String> lis) {
        lista=lis;
        initComponents();
        setLocationRelativeTo(null);
        Factura=factura; Proveedor=proveedor;Comprador=comprador;
        jTextField1.setText(Factura);
        jTextField2.setText(Proveedor);
        LLenarCampos(incre++);
        try {
            obtenerTabla();
            llenarCombo();
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Detalle_Factura_Negocio(String factura, String proveedor,String comprador, String sinIva,String IVA,String conIva) {
        booleanSimple=false;
         initComponents();
        setLocationRelativeTo(null);
        Factura=factura; Proveedor=proveedor;Comprador=comprador;
        jTextField1.setText(Factura);
        jTextField2.setText(Proveedor);
        jTextField3.setText(sinIva);
        jTextField4.setText(IVA);
        jTextField5.setText(conIva);
        try {
            llenarCombo();
            obtenerTabla();            
        } catch (SQLException ex) {
            Logger.getLogger(Detalle_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void llenarCombo() throws SQLException {
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM Tipo_Negocio";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            jComboBox1.addItem(resultado.getString("Nombre_Tipo_Negocio"));
            codigo++;
        }
    }
    
    private void LLenarCampos(int a){
        String contenido[]=new String[4];
        int num=0;
        if(lista.size()>a)
        {
            StringTokenizer tokens=new StringTokenizer(lista.get(a), ";");
            while(tokens.hasMoreTokens())
                contenido[num++]=tokens.nextToken();
            jTextField6.setText(contenido[0]);
            jTextField3.setText(contenido[1]);
            jTextField4.setText(contenido[2]);
            jTextField5.setText(contenido[3]);
        }
    }
    

    private Detalle_Factura_Negocio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ///llenar tabla 
    public void formatot() {
        String datos[][] = {};
        String Col[] = {"Cod_factura_Negocio","RUC_Proveedor","Cod_Tipo_Negocio","Valor_Sin_IVA","IVA","Valor_Con_IVA"};
        model = new DefaultTableModel(datos, Col);
        jTable1.setModel(model);
    }

    private boolean consultarTipo() throws SQLException{
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.detalle_factura_Negocio where Cod_Factura_Negocio='"+Factura+"' and RUC_Proveedor='"+Proveedor+"';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next())
            if(resultado.getString("Cod_Tipo_Negocio").equals(String.valueOf(jComboBox1.getSelectedIndex()+1)))
                return false;
        return true;
    }
    
    //llenar tabla en el inicio
    public void obtenerTabla() throws SQLException {
        this.totalSinIVA=0;
        this.totalIVA=0;
        this.totalConIVA=0;
        formatot();
        ConexionBase cont = new ConexionBase();
        String sentencia = "SELECT * FROM organizador_facturas.detalle_factura_Negocio where Cod_Factura_Negocio='"+Factura+"' and RUC_Proveedor='"+Proveedor+"';";
        ResultSet resultado = cont.SelectDB1(sentencia);
        int codigo = 0;
        while (resultado.next()) {
            //System.out.println(codigo);
            model.insertRow(codigo, new Object[]{});
            model.setValueAt(resultado.getString("Cod_Factura_Negocio"), codigo, 0);
            model.setValueAt(resultado.getString("RUC_Proveedor"), codigo, 1);
            model.setValueAt(resultado.getString("Cod_Tipo_Negocio"), codigo, 2);
            model.setValueAt(resultado.getString("Valor_Sin_IVA"), codigo, 3);
            model.setValueAt(resultado.getString("IVA"), codigo, 4);
            model.setValueAt(resultado.getString("Valor_Con_IVA"), codigo, 5);
            setTotalSinIVA(Double.parseDouble(resultado.getString("Valor_Sin_IVA")));
            setTotalIVA(Double.parseDouble(resultado.getString("IVA")));
            setTotalConIVA(Double.parseDouble(resultado.getString("Valor_Con_IVA")));
            codigo++;
        }
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
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
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel6.setText("Tipo de Negocio");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor sin IVA");

        jTextField3.setEnabled(false);
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

        jTextField4.setEnabled(false);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel1.setText("Nro Factura");

        jTextField1.setEnabled(false);

        jLabel7.setText("Proveedor");

        jTextField2.setEnabled(false);

        jLabel8.setText("Descripcion");

        jTextField6.setEnabled(false);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(140, 140, 140))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton2.setText("editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton2)
                        .addGap(47, 47, 47)
                        .addComponent(jButton4)
                        .addGap(51, 51, 51)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jButton2)
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
        tipoGasto=jTable1.getValueAt(filas, 2).toString();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (CamposLLenos()) {
                textoSql = "update organizador_facturas.detalle_factura_Negocio set"
                + " Valor_Sin_IVA='" + jTextField3.getText()
                + "' , IVA='" + jTextField4.getText()
                + "' , Valor_Con_IVA='" + jTextField5.getText()
                + "' , Cod_Tipo_Negocio='" + (jComboBox1.getSelectedIndex()+1) + "' where Cod_Factura_Negocio='" + jTextField1.getText() +"' and RUC_Proveedor='"+jTextField2.getText()
                +"' and Cod_Tipo_Negocio='"+tipoGasto+"';";
            System.out.println(textoSql);
            con.UpdateDB(textoSql);
            LimpiarVentana();
            try {
                obtenerTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ConexionBase conexion=new ConexionBase();
        if (CamposLLenos()) {
            try {
                if(consultarTipo()){
                    textoSql = "insert into detalle_factura_Negocio values('" + jTextField1.getText() + "','" + jTextField2.getText() + "','"
                            + (jComboBox1.getSelectedIndex()+1) + "','" + jTextField3.getText() + "','" + jTextField4.getText() + "','"
                            + jTextField5.getText() + "')";
                    conexion.Insertar(textoSql);
                }else{
                    
                    textoSql = "update organizador_facturas.detalle_factura_Negocio set"
                            + " Valor_Sin_IVA=Valor_Sin_IVA+" + jTextField3.getText()
                            + " , IVA=IVA+" + jTextField4.getText()
                            + " , Valor_Con_IVA=Valor_Con_IVA+" + jTextField5.getText()
                            + " , Cod_Tipo_Negocio='" + (jComboBox1.getSelectedIndex()+1) + "' where Cod_Factura_Negocio='" + jTextField1.getText() +"' and RUC_Proveedor='"+jTextField2.getText()
                            +"' and Cod_Tipo_Negocio='"+(jComboBox1.getSelectedIndex()+1)+"';";
                    System.out.println(textoSql);
                    con.UpdateDB(textoSql);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(Level.SEVERE, null, ex);
            }
            LimpiarVentana();
            try {
                obtenerTabla();
                if(booleanSimple)
                    LLenarCampos(incre++);
            } catch (SQLException ex) {
                Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llenar todos los campos");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

        
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

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void LLenarValorTotal(){
        if(!jTextField3.getText().equals("") && !jTextField4.getText().equals("") && !jTextField3.getText().equals(""))
            jTextField5.setText(String.valueOf(Double.parseDouble(jTextField3.getText())+Double.parseDouble(jTextField4.getText())));
        else
            jTextField5.setText("");
    }
    
    private void LimpiarVentana() {
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox1.setSelectedIndex(0);
        tipoGasto="";
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
            java.util.logging.Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalle_Factura_Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalle_Factura_Negocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}

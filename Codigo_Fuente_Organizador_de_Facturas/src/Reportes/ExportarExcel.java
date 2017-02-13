/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Jorge
 */
public class ExportarExcel {

    public ExportarExcel(JTable tabla)
    {
        JFileChooser seleccionar = new JFileChooser();
        File archivo;
        if (seleccionar.showDialog(null, "Exportar Excel") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();            
            int cantFila = tabla.getRowCount();
            int cantColumna = tabla.getColumnCount();
            Workbook wb;
            wb = new XSSFWorkbook();
            Sheet hoja = wb.createSheet("  ");

            try {
                for (int i = -1; i < cantFila; i++) {
                    Row fila = hoja.createRow(i + 1);
                    for (int j = 0; j < cantColumna; j++) {
                        Cell celda = fila.createCell(j);
                        if (i == -1) {
                           celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                        } else {
                            celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                        }
                        wb.write(new FileOutputStream(archivo + ".xlsx"));
                    }
                }
                JOptionPane.showMessageDialog(null, "Exportacion exitosa");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vuelve a intentarlo");
            }
            
        } else {

        }
    }
}

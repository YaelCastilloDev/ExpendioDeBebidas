package modelos.utiles.exportacion;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportarExcel {
    public static boolean exportarJTableAExcel(JTable tabla, String nombreArchivo) {
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet("Reporte");

        try {
            TableModel modelo = tabla.getModel();

            Row filaEncabezado = hoja.createRow(0);
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                Cell celda = filaEncabezado.createCell(i);
                celda.setCellValue(modelo.getColumnName(i));
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    Cell celda = fila.createCell(j);
                    Object valor = modelo.getValueAt(i, j);
                    celda.setCellValue(valor != null ? valor.toString() : "");
                }
            }

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                hoja.autoSizeColumn(i);
            }

            FileOutputStream salida = new FileOutputStream(nombreArchivo);
            libro.write(salida);
            salida.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

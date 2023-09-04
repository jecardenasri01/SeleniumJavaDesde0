package Recursos.Data.Excel;


import org.apache.poi.ss.usermodel.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dat_Excel {
    private DefaultTableModel dataTable;
    FileInputStream excelFile;
    Workbook workbook;
    Sheet sheet;
    FileOutputStream fos;
    String sheetName = "Hoja1"; // Nombre de la hoja a actualizar
    public String excelFilePath = "D:/git/SeleniumJavaDesde0/src/main/java/Recursos/Data/Insumos/Testing.xlsx"; // Ruta del archivo Excel a actualizar
    int numerofila = 0; // Número de fila a actualizar (índice 0)

    // conexion excel
    //region
    public void excelAbrirConexion(boolean actualizar){
        try {
            excelFile = new FileInputStream(excelFilePath);
            workbook = new XSSFWorkbook(excelFile);
            //   Sheet sheet = workbook.getSheetAt(0); // Obtén la primera hoja del libro
            sheet= workbook.getSheet(sheetName);
            if(actualizar){
                fos = new FileOutputStream(excelFilePath);
            }
        }catch (Exception fallo){
            System.out.println(fallo.getMessage());
        }
    }
    public void excelCerrarConexion(){
        try {
            workbook.close();
            excelFile.close();
        }catch (Exception fallo){
            System.out.println(fallo.getMessage());
        }
    }
    //endregion
    // obtener informacion excel
    //region
    public DefaultTableModel excelTabla(){
        dataTable = new DefaultTableModel(); // Instancia el DataTable

        // Obtiene la hoja con el nombre sheetName del archivo Excel
        Iterator<Row> rowIterator = sheet.iterator();

        // Obtén las cabeceras (encabezados) de las columnas
        Row headerRow = rowIterator.next();
        Iterator<Cell> headerCellIterator = headerRow.cellIterator();
        while (headerCellIterator.hasNext()) {
            Cell cell = headerCellIterator.next();
            dataTable.addColumn(cell.getStringCellValue());
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Object[] rowData = new Object[dataTable.getColumnCount()];
            Iterator<Cell> cellIterator = row.cellIterator();
            int columnIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(CellType.STRING); // Cambia el tipo de celda a String
                rowData[columnIndex] = cell.getStringCellValue();
                columnIndex++;
            }
            dataTable.addRow(rowData);

        }

        return dataTable;
    }
    //endregion
}

package Recursos.Data.Excel;


import org.apache.poi.ss.usermodel.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

    //region conexion excel
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
    //region obtener cantidad filas excel
    public int obtenerFilas(){
        excelAbrirConexion(false);
        int cantidadFilas = 0;
        // Iterar a través de las filas en la hoja
        for (Row row : sheet) {
            // Verificar si la fila no está vacía
            if (row != null)
            {
                // Iterar a través de las celdas en la fila
                boolean rowHasData = false;
                for (Cell cell : row) {
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        // La celda no está vacía o nula
                        rowHasData = true;
                        break;
                    }
                }
                // Si la fila tiene al menos una celda con datos, incrementa el contador
                if (rowHasData) {
                    cantidadFilas++;
                }
            }
        }
        cantidadFilas--;
        excelCerrarConexion();
        return cantidadFilas;
    }
    //endregion
    //region obtener informacion excel
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
    // Método para obtener el valor de una celda específica basado en el número de fila y el nombre de columna
    public Object obtenerValorColumna(int rowIndex, String columnName) {
        int columnIndex = dataTable.findColumn(columnName);

        if (columnIndex == -1) {
            System.out.println("Column not found: " + columnName);
            return null;
        }

        return dataTable.getValueAt(rowIndex, columnIndex);
    }
    //endregion

    public void EscrituraDatos(Integer numeroFila){
        excelAbrirConexion(true);

        Integer posicionCelda=0;
        numeroFila++;
        String valorNuevo = "ok";
        String columnaSetear = "resultado";

        XSSFSheet hojaExcel = (XSSFSheet) sheet;
        XSSFRow filaEncabezado = hojaExcel.getRow(numeroFila - 1);
        XSSFRow filaActualizar = hojaExcel.getRow(numeroFila );

        for (int i = 0; i < filaEncabezado.getLastCellNum(); i++) {
          //  String pruebas hojaExcel.  _rows.get(1)._cells.get(0).toString()
            String prueba = hojaExcel.getRow(0).getCell(i).toString();
            if (prueba.equals(columnaSetear))
            {
                posicionCelda = i;
                break;
            }
        }
        if (posicionCelda != 0) {

            // Buscamos la celda "resultado"
            XSSFCell celda= filaActualizar.createCell(posicionCelda++);
            // Actualizamos el valor de la celda con "exitoso" o "fallido"
            celda.setCellValue(valorNuevo);

            try{
            // Guardamos los cambios en el archivo si es necesario
            if (fos != null) {
                workbook.write(fos);
                fos.close();
            }
            }catch (Exception fallo )
            {

            }
            System.out.println("Celda actualizada exitosamente.");
        } else {
            System.out.println("No se encontró la celda 'resultado' en la fila especificada.");
        }

        excelCerrarConexion();
    }
}

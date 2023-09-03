package Recursos.Data.Excel;
import dev.failsafe.internal.util.Assert;
import org.apache.poi.ss.usermodel.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


    public void excelAbrirConexion(){
        try {
            excelFile = new FileInputStream(excelFilePath);
            workbook = new XSSFWorkbook(excelFile);
            //   Sheet sheet = workbook.getSheetAt(0); // Obtén la primera hoja del libro
            sheet= workbook.getSheet(sheetName);
            fos = new FileOutputStream(excelFilePath);
        }catch (Exception fallo){
            System.out.println(fallo.getMessage());
        }
    }

}

package Video_11_ManejoExcel.Video_11_2;

import Recursos.Data.Excel.Dat_Excel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.swing.table.DefaultTableModel;

public class V11_2_EjecucionExcel {
    public static WebDriver driver;
    Dat_Excel dat_excel;


    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador

    }

    @After
    public void PostEjecucion() {
        //driver.close();
        //driver.quit();
    }

    public void InstanciasBasicas(){

        LecturaDatos();
        dat_excel = new Dat_Excel();

    }

    public void LecturaDatos() {


    }
    private DefaultTableModel dataTable;

    @Test
    public void ModificarElementos() {


        InstanciasBasicas();
        dat_excel.excelAbrirConexion(false);
        dataTable = dat_excel.excelTabla();

        dat_excel.excelCerrarConexion();

    }
}

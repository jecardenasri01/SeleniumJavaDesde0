package Video_11;

import Escenarios.demoQa.V10_Elementos;
import Recursos.Data.Excel.Dat_Excel;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V11_EjecucionExcel {
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

    @Test
    public void ModificarElementos() {
        InstanciasBasicas();
        dat_excel.excelAbrirConexion();

    }
}

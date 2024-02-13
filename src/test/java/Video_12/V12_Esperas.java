package Video_12;

import Escenarios.demoQa.V10_Elementos;
import Escenarios.demoQa.V12_EsperasExplicitas;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V12_Esperas {
    public static WebDriver driver;
    V12_EsperasExplicitas V12_esperasexplicitas;

    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador("https://demoqa.com/elements");
    }

    @After
    public void PostEjecucion() {
        //driver.close();
        //driver.quit();
    }

    public void InstanciasBasicas(){

        LecturaDatos();
        V12_esperasexplicitas = new V12_EsperasExplicitas(driver);
    }

    public void LecturaDatos() {


    }

    @Test
    public void ModificarElementos() {
        InstanciasBasicas();
        V12_esperasexplicitas.EsperarElementosNcantidadTiempo();

    }
}

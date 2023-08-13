package Video_3;

import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V3_BusquedaGoogle {
    WebDriver driver;

    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador();
    }

    @After
    public void PostEjecucion() {
        driver.close();
        driver.quit();
    }

    @Test
    public void RealizarConsultasGoogle() {

    }
}

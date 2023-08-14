package Video_5;

import Escenarios.Mvn.V3_Esc_ConsultarLibrerias;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V5_BusquedaGoogle {
    WebDriver driver;

    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador("https://mvnrepository.com/");
    }

    @After
    public void PostEjecucion() {
        driver.close();
        driver.quit();
    }

    @Test
    public void RealizarConsultasGoogle() {
        V3_Esc_ConsultarLibrerias esc_consultarLibrerias = new V3_Esc_ConsultarLibrerias(driver);
        esc_consultarLibrerias.ConsultarLibreriasMvn(driver);
        try{
            Thread.sleep(2000);
        }catch (Exception fallo){

        }
    }
}

package Video_6;

import Escenarios.TicketesBaratos.Video_6.V6_Esc_PaginaInicio;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V6_BusquedaTicketes {
    WebDriver driver;

    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador("https://www.tiquetesbaratos.com/");
    }

    @After
    public void PostEjecucion() {
        //driver.close();
        //driver.quit();
    }

    @Test
    public void RealizarBusquedaTicketes() {
        V6_Esc_PaginaInicio v6Esc_paginainicio = new V6_Esc_PaginaInicio(driver);

        v6Esc_paginainicio.ConsultarVuelos(driver);
        try{
            Thread.sleep(2000);
        }catch (Exception fallo){

        }
    }
}

package Video_10;

import Entidades.Facebook.Video_7.V7_Ent_RegistroFacebook;
import Escenarios.Facebook.Video_9.V9_Esc_PaginaInicioFacebook;
import Escenarios.demoQa.V10_Elementos;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V10_ModificarPropiedadesWeb {
    public static WebDriver driver;
    V10_Elementos v10_elementos;

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
        v10_elementos = new V10_Elementos(driver);
    }

    public void LecturaDatos() {


    }

    @Test
    public void ModificarElementos() {
        InstanciasBasicas();
        v10_elementos.ModificacionElementos();

    }
}

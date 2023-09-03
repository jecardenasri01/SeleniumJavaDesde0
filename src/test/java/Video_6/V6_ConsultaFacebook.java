package Video_6;

import Entidades.Facebook.Video_6.V6_Ent_LoginFacebook;
import Escenarios.Facebook.Video_6.V6_Esc_PaginaInicioFacebook;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V6_ConsultaFacebook {
    WebDriver driver;
    V6_Ent_LoginFacebook v6_ent_loginfacebook;
    V6_Esc_PaginaInicioFacebook v6_esc_paginaIniciofacebook;

    @Before
    public void PreEjecucion() {
        // realizamos una instancia para que nuestro metodo pueda acceder ala clase Pag_Navegador
        Pag_Navegador pag_navegador = new Pag_Navegador(driver);
        driver = pag_navegador.AbrirNavegador("https://es-la.facebook.com/");
    }

    @After
    public void PostEjecucion() {
        //driver.close();
        //driver.quit();
    }
    public void InstanciasBasicas(){
        v6_ent_loginfacebook = new V6_Ent_LoginFacebook();
        v6_esc_paginaIniciofacebook = new V6_Esc_PaginaInicioFacebook(driver);
        LecturaDatos();
    }

    public void LecturaDatos() {

        v6_ent_loginfacebook.usuario = "jeizz0n";
        v6_ent_loginfacebook.clave ="123";
    }

    @Test
    public void RealizarBusquedaTicketes() {
        InstanciasBasicas();
        v6_esc_paginaIniciofacebook.ConsultarIngresoFacebook(driver,v6_ent_loginfacebook.usuario,v6_ent_loginfacebook.clave);

    }
}

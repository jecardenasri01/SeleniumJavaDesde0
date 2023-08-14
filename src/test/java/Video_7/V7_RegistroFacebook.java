package Video_7;

import Entidades.Facebook.V6_Ent_LoginFacebook;
import Entidades.Facebook.V7_Ent_RegistroFacebook;
import Escenarios.Facebook.V6_Esc_PaginaInicioFacebook;
import Escenarios.Facebook.V7_Esc_PaginaInicioFacebook;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V7_RegistroFacebook {
    public static WebDriver driver;

    V7_Esc_PaginaInicioFacebook v7_esc_paginaIniciofacebook;

    V7_Ent_RegistroFacebook v7_ent_registroFacebook;
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
        v7_esc_paginaIniciofacebook = new V7_Esc_PaginaInicioFacebook(driver);
        v7_ent_registroFacebook = new V7_Ent_RegistroFacebook();
        LecturaDatos();
    }

    public void LecturaDatos() {

        v7_ent_registroFacebook.nombre = "jeisson";
        v7_ent_registroFacebook.apellido ="cardenas";
        v7_ent_registroFacebook.correo ="jeisson@gmail.com";
        v7_ent_registroFacebook.clave ="1234";
    }

    @Test
    public void RealizarRegistroIngreso() {
        InstanciasBasicas();
        v7_esc_paginaIniciofacebook.RegistroFacebook(v7_ent_registroFacebook);

    }
}

package Video_9;

import Entidades.Facebook.Video_7.V7_Ent_RegistroFacebook;
import Escenarios.Facebook.Video_9.V9_Esc_PaginaInicioFacebook;
import Recursos.Navegador.Pag_Navegador;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class V9_RegistroFacebook {
    public static WebDriver driver;

    V9_Esc_PaginaInicioFacebook V9_esc_paginaInicioFacebook;

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
        V9_esc_paginaInicioFacebook = new V9_Esc_PaginaInicioFacebook(driver);
        v7_ent_registroFacebook = new V7_Ent_RegistroFacebook();
        LecturaDatos();
    }

    public void LecturaDatos() {

        v7_ent_registroFacebook.nombre = "jeisson";
        v7_ent_registroFacebook.apellido ="cardenas";
        v7_ent_registroFacebook.correo ="jeisson@gmail.com";
        v7_ent_registroFacebook.clave ="1234";
        v7_ent_registroFacebook.dia ="21";
        v7_ent_registroFacebook.ano ="1997";
        v7_ent_registroFacebook.mes ="mar";
        v7_ent_registroFacebook.sexo ="personalizado";

    }

    @Test
    public void RealizarRegistroIngreso() {
        InstanciasBasicas();
        V9_esc_paginaInicioFacebook.RegistroFacebook(v7_ent_registroFacebook);
    }
}

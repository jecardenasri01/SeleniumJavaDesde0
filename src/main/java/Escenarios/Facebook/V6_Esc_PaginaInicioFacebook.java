package Escenarios.Facebook;

import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V6_Esc_PaginaInicioFacebook {
    WebDriver driver;

    public V6_Esc_PaginaInicioFacebook(WebDriver _driver) {
        driver = _driver;
    }

    public void ConsultarIngresoFacebook(WebDriver driver,String usuario,String clave) {
        Rec_Global rec_global = new Rec_Global(driver);
        String ciudadOrigen = "//*[@name='email']";
        String ciudadDestino = "//*[@name='pass']";

        rec_global.Escribir(usuario, ciudadOrigen);
        rec_global.Escribir(clave, ciudadDestino);

    }
}

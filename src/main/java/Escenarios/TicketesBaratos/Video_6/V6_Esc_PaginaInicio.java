package Escenarios.TicketesBaratos.Video_6;

import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V6_Esc_PaginaInicio {
    WebDriver driver;

    public V6_Esc_PaginaInicio(WebDriver _driver) {
        driver = _driver;
    }

    public void ConsultarVuelos(WebDriver driver) {
        Rec_Global rec_global = new Rec_Global(driver);
        String ciudadOrigen = "//*[@name='origenName']";
        String ciudadDestino = "//*[@name='destinoName']";

        rec_global.Escribir("Medellin - Colombia(MDE)", ciudadOrigen);
        rec_global.Escribir("Bogota - Colombia(BOG)", ciudadDestino);

    }
}

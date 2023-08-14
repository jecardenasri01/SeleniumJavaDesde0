package Escenarios.Mvn;

import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V3_Esc_ConsultarLibrerias {
    WebDriver driver;

    public V3_Esc_ConsultarLibrerias(WebDriver _driver) {
        driver = _driver;
    }

    public void ConsultarLibreriasMvn(WebDriver driver) {
        Rec_Global rec_global = new Rec_Global(driver);
        rec_global.Escribir("selenium", "//*[@name='q']");
        rec_global.Click("//*[@type='submit']");
    }
}

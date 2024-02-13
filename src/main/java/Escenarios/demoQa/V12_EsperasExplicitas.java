package Escenarios.demoQa;

import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V12_EsperasExplicitas {

    public static WebDriver driver;
    public V12_EsperasExplicitas(WebDriver _driver) {
        driver = _driver;
    }

    public void EsperarElementosNcantidadTiempo() {
        Rec_Global rec_global = new Rec_Global(driver);
        String div_PracticeForm = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li";


        rec_global.waitExplicitClick(div_PracticeForm,10);
        rec_global.JsModificarAtributo(div_PracticeForm,"style","background: rgb(255, 0, 0);");

    }

}

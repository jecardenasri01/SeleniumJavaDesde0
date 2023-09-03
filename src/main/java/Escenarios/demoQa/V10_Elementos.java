package Escenarios.demoQa;

import Entidades.Facebook.Video_7.V7_Ent_RegistroFacebook;
import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V10_Elementos {

    public static WebDriver driver;
    public V10_Elementos(WebDriver _driver) {
        driver = _driver;
    }

    public void ModificacionElementos() {
        Rec_Global rec_global = new Rec_Global(driver);
        String div_Elements = "//*[@id='app']/div/div/div[2]/div[1]/div/div/div[1]/span/div";
        String span_WebTables = "//span[text()='Web Tables']";
        String inp_FiltroTabla = "//*[@id='searchBox']";

        rec_global.Click(div_Elements);
        rec_global.JsModificarAtributo(div_Elements,"style","background: rgb(255, 0, 0);");
        rec_global.Click(span_WebTables);
        rec_global.JsRemoverAtributo(inp_FiltroTabla,"autocomplete");
        rec_global.JsRemoverAtributo(inp_FiltroTabla,"placeholder");
    }

}

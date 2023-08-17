package Escenarios.Facebook;

import Entidades.Facebook.V7_Ent_RegistroFacebook;
import Recursos.Utilidades.Rec_Global;
import org.openqa.selenium.WebDriver;

public class V8_Esc_PaginaInicioFacebook {
    public static WebDriver driver;
    public V8_Esc_PaginaInicioFacebook(WebDriver _driver) {
        driver = _driver;
    }

    public void RegistroFacebook(V7_Ent_RegistroFacebook ent_registrofacebook) {
        Rec_Global rec_global = new Rec_Global(driver);

        String inp_nombre = "//*[@name='firstname']";
        String inp_apellido = "//*[@name='lastname']";
        String inp_correo = "//*[@name='reg_email__']";
        String inp_correoconfirmar = "//*[@name='reg_email_confirmation__']";
        String inp_clave = "//*[@name='reg_passwd__']";
        String btn_crearcuenta ="//*[contains(text(),'Crear cuenta nueva')]";
        String list_dia = "//*[@name='birthday_day']";
        String list_mes = "//*[@name='birthday_month']";
        String list_ano = "//*[@name='birthday_year']";


        rec_global.Click(btn_crearcuenta);
        rec_global.Escribir(ent_registrofacebook.nombre, inp_nombre);
        rec_global.Escribir(ent_registrofacebook.apellido, inp_apellido);
        rec_global.Escribir(ent_registrofacebook.correo, inp_correo);
        rec_global.Escribir(ent_registrofacebook.correo, inp_correoconfirmar);
        rec_global.Escribir(ent_registrofacebook.clave, inp_clave);
        rec_global.ListaValor(ent_registrofacebook.dia,list_dia);
        rec_global.ListaTexto(ent_registrofacebook.mes,list_mes);
        rec_global.ListaTexto(ent_registrofacebook.ano,list_ano);
    }
}

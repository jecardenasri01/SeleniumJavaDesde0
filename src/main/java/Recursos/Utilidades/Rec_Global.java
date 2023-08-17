package Recursos.Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Rec_Global {
    WebDriver driver;

    public Rec_Global(WebDriver _driver){
        driver=_driver;
    }
    public void Click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public void Escribir(String texto,String xpath){
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(texto);
    }
    public void ListaValor(String valor,String xpath){
        Select lista = new Select(driver.findElement(By.xpath(xpath)));
        lista.selectByValue(valor);
    }
    public void ListaTexto(String valor,String xpath){
        Select lista = new Select(driver.findElement(By.xpath(xpath)));
        lista.selectByVisibleText(valor);
    }
    public void ListaPosicion(Integer valor,String xpath){
        Select lista = new Select(driver.findElement(By.xpath(xpath)));
        lista.selectByIndex(valor);
    }
}

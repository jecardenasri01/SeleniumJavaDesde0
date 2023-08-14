package Recursos.Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}

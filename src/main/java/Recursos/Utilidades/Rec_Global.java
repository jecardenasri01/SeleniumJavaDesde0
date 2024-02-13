package Recursos.Utilidades;

import Recursos.Evidencias.Rec_Evidencias;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rec_Global {
    WebDriver driver;

    public Rec_Global(WebDriver _driver){
        driver=_driver;
    }
    public void Click(String xpath){
        Rec_Evidencias rec_evidencias = new Rec_Evidencias(driver);
        try{
            rec_evidencias.ResaltarElementos(xpath,"r");
            driver.findElement(By.xpath(xpath)).click();
            rec_evidencias.ResaltarElementos(xpath,"n");

        } catch (Exception Fallo){
            rec_evidencias.ResaltarElementos(xpath,"r");
            WebElement elemento = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();",elemento);
            rec_evidencias.ResaltarElementos(xpath,"n");
        }

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
    public void JsModificarAtributo(String xpath,String atributo,String variable){
        WebElement elemento = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('"+atributo+"','"+variable+"')",elemento);
    }
    public void JsRemoverAtributo(String xpath,String atributo){
        WebElement elemento = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].removeAttribute('"+atributo+"')",elemento);
    }
    public void waitExplicitClick(String xpath,Integer minutos){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMinutes(minutos));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

}

package Recursos.Navegador;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Pag_Navegador {
    WebDriver driver;

    public Pag_Navegador(WebDriver _driver){
    driver = _driver;
    }
    public WebDriver AbrirNavegador(){
        //damos la ubicación del driver
        System.setProperty("webdriver.chrome.driver","D:/driver/chrome/chromedriver.exe");
        //condiciones que nosotros queremos al momento en que se ejecuta nuestro navegador
        //si lo queremos incognito - agregar un plugin - que se ejecute en pantalla completa
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // intanciamos el chrome driver para abrir el navegador
        driver = new ChromeDriver(options);
        // url a la que se quiere automatizar
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.11.0");
        //tiempo implicito el cual el navegador va a esperar que los elementos esten presentes
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        return  driver;
    }
}

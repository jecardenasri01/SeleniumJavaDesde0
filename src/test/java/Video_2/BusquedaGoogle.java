package Video_2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BusquedaGoogle {
    WebDriver driver;
    @Test
    public void RealizarConsultasGoogle(){
        System.setProperty("webdriver.chrome.driver","D:/driver/chrome/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.11.0");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
    }
}

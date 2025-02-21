package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Cookie;

public class WCFail {
    public static void main(String[] args) {
        // Configurar ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\marco\\\\Documents\\\\chromedriver.exe");

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);

        try {
           
        	
        	// Abrir la página de Wallapop
            driver.get("https://es.wallapop.com/app/search?filters_source=search_box&keywords=iphone&longitude=-3.69196&latitude=40.41956");

           
            
            // Esperar a que la página se cargue completamente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           
            
            // Aceptar cookies si el botón está presente
            try {
                WebElement acceptCookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                		By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]") // Cambia este selector
                ));
                acceptCookiesButton.click();
                
                
                
                System.out.println("Cookies aceptadas.");
                
                
            } catch (Exception e) {
                System.out.println("No se encontró el botón de aceptar cookies o ya están aceptadas.");
            }
        } finally {
            // Cerrar el navegador
           // driver.quit();
        }
    }
}

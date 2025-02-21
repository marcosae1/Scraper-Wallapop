package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Wallapop2 {
    public static void main(String[] args) {
        // Configurar ChromeDriver (ajusta la ruta según tu instalación)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marco\\Documents\\chromedriver.exe");

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); // Ejecución sin interfaz gráfica
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        options.addArguments("--disable-extensions");
        
        //cosas para ser indetectable (pueden ser prescindibles)
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
        	
        	try {
        		// Navegar a la página de Wikipedia sobre Web Scraping
        		driver.get("https://es.wallapop.com/app/search?filters_source=search_box&keywords=iphone&longitude=-3.69196&latitude=40.41956");
            
        		
        		
            
        		// Simula el desplazamiento para cargar más contenido
        		
        		// Espera a que los elementos estén presentes
        		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-title, h1, h2")));
            
            
        		// Localiza el botón de aceptar cookies (cambia el selector según la página)
        		WebElement acceptCookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
            		By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]") // Cambia este selector
        				));

        		// Haz clic en el botón
        		acceptCookiesButton.click();
        		System.out.println("Cookies aceptadas.");
        		
        		
        		System.out.println(driver.getPageSource());
        		

        		
        		
        		 wait.until(ExpectedConditions.invisibilityOfElementLocated(
        			        By.xpath("//*[@id=\"onetrust-banner-sdk\"]/div/div[1]/div") // Cambia este selector si es necesario
        			    ));
        		
        		
        		
        		
        		} catch (Exception e) {
        			System.out.println("No se encontró el botón de aceptar cookies o ya están aceptadas.");
        			 e.printStackTrace();
        			}
        	} finally {
            // Cerrar el navegador
        		driver.quit();
        	}
        		
    }
}


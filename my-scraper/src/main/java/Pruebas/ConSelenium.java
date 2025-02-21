package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;

public class ConSelenium {
    public static void main(String[] args) {
        // Configurar ChromeDriver (ajusta la ruta según tu instalación)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marco\\Documents\\chromedriver.exe");

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecución sin interfaz gráfica
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Navegar a la página de Wikipedia sobre Web Scraping
            driver.get("https://en.wikipedia.org/wiki/Web_scraping");

            // Extraer el título de la página
            String pageTitle = driver.getTitle();
            System.out.println("Título de la página: " + pageTitle);

            // Extraer todos los encabezados (h1, h2, h3, etc.)
            List<WebElement> headers = driver.findElements(By.cssSelector("h1, h2, h3, h4, h5, h6"));

            System.out.println("\nEncabezados encontrados:");
            for (WebElement header : headers) {
                System.out.println(header.getTagName() + ": " + header.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}
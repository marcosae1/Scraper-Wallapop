package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

public class WallapopCookies2 {
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
            driver.get("https://es.wallapop.com/app/search?filters_source=search_box&keywords=iphone&longitude=-3.69196&latitude=40.41956&order_by=most_relevance");

           
            
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

            // Verificar la URL después de aceptar las cookies
            String expectedUrl = "https://es.wallapop.com/app/search?filters_source=search_box&keywords=iphone&longitude=-3.69196&latitude=40.41956&order_by=most_relevance"; // Cambia la URL esperada
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            // Si la URL no es la esperada, navegar manualmente
            if (!driver.getCurrentUrl().equals(expectedUrl)) {
                driver.get(expectedUrl);
            }

            // Esperar a que el contenido dinámico se cargue
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1, h2, h3"))); // Cambia este selector

            // Imprimir el HTML de la página
            //System.out.println(driver.getPageSource());
            
            Thread.sleep(1000);
            
            List<WebElement> headers = driver.findElements(By.cssSelector("h1, h2, h3, h4, h5 ,h6"));
            
            for (WebElement header : headers) {
                System.out.println(header.getTagName() + ": " + header.getText());
            }
            
         // Localizar el botón "Relevancia" por el texto dentro del span
            WebElement relevanciaButton = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/div/span"));

            // Hacer clic en el botón
            relevanciaButton.click();
            
            Thread.sleep(1000);

            WebElement novedadesButton = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/walla-dialog/div[2]/div/tsl-select-form/div[5]/tsl-select-option/div/div/span"));
            novedadesButton.click();
            Thread.sleep(1000);
            
            
          //  WebElement iphones = driver.findElement(By.cssSelector(".ItemCard__price"));
            
            
          //  System.out.println(iphones);
            
            
            
            

            
            //WebElement cargarMas= driver.findElement(By.xpath("//*[@id=\"btn-load-more\"]//button/div/span"));
            
           ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            
            Thread.sleep(1000);
            
            
            //WebElement boton = wait.until(
            //        ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btn-load-more\"]//button/div/span"))
            //    );
            
            
            WebElement cargarMas= driver.findElement(By.xpath("//*[@id=\"btn-load-more\"]"));
            cargarMas.click();
            
            
            
            
            
             
            
            
    
            
            Thread.sleep(1000);
            
          //*[@id="btn-load-more"]//button/div/span 
            
         //   ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            
          List<WebElement> iphonesPrecios = driver.findElements(By.cssSelector(".ItemCard__price.ItemCard__price--bold"));
          List<WebElement> iphonesNombres = driver.findElements(By.cssSelector(".ItemCard__title.my-1"));
          
          int contador= 3;
          
          BuclePrecios bucle = new BuclePrecios();
          
          //bucle.procesarIphones(iphonesNombres,iphonesPrecios );
          
          
          
          
       /*   for (int i = 0; i < iphonesNombres.size(); i++) {
        	    WebElement nombre = iphonesNombres.get(i); // Obtener el elemento en la posición i
        	    WebElement precio= iphonesPrecios.get(i);
        	    
        	    System.out.println(nombre.getTagName() + ": " + nombre.getText()  + ": " + precio.getText());
        	 
        	    System.out.println("---");
        	    contador = contador + 1; // Incrementar el contador (si es necesario)
        	}
        	
        	*/
          
          
         
            
           // if ()
          System.out.println(contador);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
           // driver.quit();
        }
    }
}
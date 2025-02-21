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

public class Wallapop {
    public static void main(String[] args) {
        // Configurar ChromeDriver (ajusta la ruta según tu instalación)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\marco\\Documents\\chromedriver.exe");

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Ejecución sin interfaz gráfica
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
        		JavascriptExecutor js = (JavascriptExecutor) driver;
        		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        		Thread.sleep(2000); // Espera a que se cargue el contenido
            
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
        		
        		
        		
        		 wait.until(ExpectedConditions.invisibilityOfElementLocated(
        			        By.xpath("//*[@id=\"onetrust-banner-sdk\"]/div/div[1]/div") // Cambia este selector si es necesario
        			    ));
        		
        		 System.out.println(driver.getPageSource());
        		
        		
        		} catch (Exception e) {
        			System.out.println("No se encontró el botón de aceptar cookies o ya están aceptadas.");
        			 e.printStackTrace();
        		}

        	
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
        	    By.cssSelector("hydrated") // Cambia este selector
        	));
        	
        	
        	
            // Extraer el título de la página
            String pageTitle = driver.getTitle();
            System.out.println("Título de la página: " + pageTitle);
            
            

            // Extraer todos los encabezados (h1, h2, h3, etc.)
            List<WebElement> headers = driver.findElements(By.cssSelector(".product-title, SidebarFilters__title"));
           // List<WebElement> elements2 = driver.findElements(By.className("TreeListOption__label TreeListOption__label--selected"));
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"top-bar-signin\"]//button/div/span"));
            // /html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/tsl-search-unified/div/tsl-search-layout-sidebar/div/div[1]/tsl-sidebar-filters/div/tsl-filter-group/div[1]/tsl-sidebar-filter-collapsible/div/tsl-filter-host/div/tsl-tree-list-filter/div/tsl-filter-template/div/form/tsl-tree-list-form/tsl-tree-list-container/ul/li[2]/tsl-tree-list-option/div/span
            
            

            System.out.println("\nEncabezados encontrados:");
            for (WebElement element : elements) {
                System.out.println(element.getTagName() + ": " + element.getText());
                System.out.println("---");
            }
            
            for (WebElement header : headers) {
                System.out.println(header.getTagName() + ": " + header.getText());
            }
            //System.out.println(driver.getPageSource());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}
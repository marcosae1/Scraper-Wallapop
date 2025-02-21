package Pruebas;

import org.openqa.selenium.By;
import java.util.Scanner;
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
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.Keys;

public class ClicarImagen {
    public static void main(String[] args) {
    	
    	//scanner
    	Scanner sc = new Scanner (System.in);
    	
    	//Atributos
    	double precioMaximo;
    	double precioMinimo;
    	double precioDoubleConvertido;
    	String tipoDeProducto ;
    	boolean novedades = false;
    	String novedadesSc;
    	
    	String nombreProducto;
    	String link;
    	
    	String precioAislado;
    	String precioAisladoTrim;
    	
    	
        WebElement elemento;
        
        String texto;
        
        String textoSinSaltos€; 
        
        String textoSinSaltos; 
        
        String precioString;
        
        int precioInt;
    					
    	String ruta ="C:\\Users\\marco\\Desktop\\Java txt\\Iphones.txt"; //adjuntar ruta para el copiado de información
    	
    	
    	
    	System.out.println("Introduce el nombre del producto");
    	
    	
    	tipoDeProducto= sc.nextLine();
    	
        
        
    	
    	System.out.println("Introduce el precio máximo");
    	precioMaximo = sc.nextDouble() ;
    	
    	System.out.println("Introduce el precio mínimo");
    	
    	
    	precioMinimo = sc.nextDouble();
    	
    	System.out.println("Quieres buscar novedades? Escribe Sí o No");
    	
    	novedadesSc = sc.next();
    	
    	
    	if (novedadesSc.equals("Sí") || novedadesSc.equals("Si") || novedadesSc.equals("sí") || novedadesSc.equals("si") ) {
    		novedades= true;
    	}
    		
    	
    
    			
    	
    	
    	
    	
    	
    	
    	
        // Configurar ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\marco\\\\Documents\\\\chromedriver.exe");

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);
        
        //Inicializar clase
        
         BuclePrecios metodo = new BuclePrecios();
         
         metodo.productoFecha(ruta, tipoDeProducto);
         
         metodo.novedades(ruta, novedades);

        try {
           
        	
        	// Abrir la página de Wallapop
            driver.get("https://es.wallapop.com/");
            
            

           
            
            // Esperar a que la página se cargue completamente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           
            
            // Aceptar cookies si el botón está presente
            try {
                WebElement acceptCookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                		By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]") // ruta xpath
                ));
                acceptCookiesButton.click();
                
                
                
                System.out.println("Cookies aceptadas.");
                
                
            } catch (Exception e) {
                System.out.println("No se encontró el botón de aceptar cookies o ya están aceptadas.");
            }

            // Verificar la URL después de aceptar las cookies
          
            
            /*String expectedUrl = "https://es.wallapop.com/"; // Cambia la URL esperada
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            */

            // Si la URL no es la esperada, navegar manualmente
            /*if (!driver.getCurrentUrl().equals(expectedUrl)) {
                driver.get(expectedUrl);
            }*/

            // Esperar a que el contenido dinámico se cargue
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1, h2, h3"))); // Cambia este selector

           
            
            Thread.sleep(2000);
            
            
            //Buscar
            
           metodo.buscar(tipoDeProducto, driver);
            
           /* WebElement buscador = driver.findElement(By.xpath("//*[@id=\"searchbox-form-input\"]"));
            Thread.sleep(1000);
            buscador.sendKeys(tipoDeProducto);
            Thread.sleep(1000);
            buscador.sendKeys(Keys.ENTER);*/
            
            Thread.sleep(3000);
           
           
         // Localizar el botón "Relevancia" por el texto dentro del span
            WebElement botonRelevancia = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/div/span"));
            
           
            
            if (novedades== true) {
            // Hacer clic en el botón
            botonRelevancia.click();
            Thread.sleep(1000);
            //botón novedades
            WebElement novedadesButton = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/walla-dialog/div[2]/div/tsl-select-form/div[5]/tsl-select-option/div/div/span"));
            novedadesButton.click();
          
            Thread.sleep(2000);
           }else {
        	   
           }
            
            Thread.sleep(2000);

            
            
           
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //gestion de archivos.txt
            
            String rutaTxt = "C:\\Users\\marco\\Desktop\\Java txt\\Iphones.txt";
            
            
            
            
            
            
            //Obtener elementos <a>
            
            List<WebElement> iphonesA = driver.findElements(By.tagName("a"));
            
            
           
            
            
            
           /* for (WebElement a: iphonesA) {
            	
            	//System.out.println(a.getTagName() + ": " + a.getText() + " link: "  +  a.getAttribute("href"));
            	
            	System.out.println(a.getText() );
            }*/
            
            Thread.sleep(1000);
            
            
         /*
            WebElement elemento;
            
            String texto;
            
            String textoSinSaltos€; 
            
            String textoSinSaltos; 
            
            String precioString;
            
            int precioInt;
            
            */
            
           
            
            for (int i=0; i<iphonesA.size(); i++) {
            	 
            	
            	elemento = iphonesA.get(i);
            	
            	texto = elemento.getText() + "  -  " + elemento.getAttribute("href") ;
            	
            	textoSinSaltos€= texto.replaceAll("\\r|\\n", " _ ");
            	
            	textoSinSaltos= texto.replaceAll("\\r|\\n|€", "_");
            	
            	String[] partes = textoSinSaltos.split ("_");
            	
            	/*try {
            	System.out.println(partes [0]);
            	System.out.println(partes [1]);
            
            	System.out.println(partes [2]);
            	System.out.println(partes [3]);
            	
            	System.out.println(partes [4]);
            	System.out.println(partes [5]);
            	System.out.println(partes [6]);
            	}
            	catch (ArrayIndexOutOfBoundsException e) {
            		 System.out.println("Mensaje de la excepción: " + e.getMessage()) ;
            		}*/
            	
            	System.out.println("Elemento" + i);
            	
         
            	System.out.println("---------------------");
            	
            	
            	/*System.out.println(textoSinSaltos€);
            	System.out.println(textoSinSaltos);
            	
           
            	System.out.println("---------------------");*/
            	
            	
            	if (textoSinSaltos€.contains("€") ) {
            	
		            	try {
		            		
		            		for (int k=0; k<3; k++) {
		            			
		            		// Cada parte del array
		            		precioAislado = partes [k];
		               	
		            		precioAisladoTrim= precioAislado.trim();
		            		
		            		//System.out.println(precioAisladoTrim+"xxxxx" + partes [k] );
		            		
		            		
		            		//Si contiene S el array significa que, o bien aparece un Slide, o un Siguiente. De esta forma los saltamos
		            	
		            		if (precioAislado.contains("S")) {
		            			
		            			//System.out.println("Contiene S");
		            			
		            			continue;
		            		
		            			
		            			//cuando no contiene S, significa que hemos llegado al precio, ya que antes solo puede tener un Slide o un Siguiente
		            		} else {
		            			
		            			
		            			try {
				            			//System.out.println(precioAisladoTrim + " posicion: " + k  );
				            			
				            			String numeroFormateado = precioAisladoTrim.replace(",", ".");
				            			
				            			//precio convertido a double
				            			precioDoubleConvertido = Double.parseDouble(numeroFormateado);
				            			
				            			//System.out.println(precioDoubleConvertido + " Este es el numero que luego se compara");
				            			
				            			if(precioMaximo>precioDoubleConvertido && precioDoubleConvertido>precioMinimo) {
				            				
				            				/*System.out.println("El precio es más bajo al esperado: compra");
				            				
				            				System.out.println(textoSinSaltos€);
				                        	System.out.println(textoSinSaltos);
				                        	
				                        	System.out.println(partes [k + 2]);
				                        	System.out.println(partes [k + 3]);*/
				                        	
				                        	nombreProducto = partes [k + 2];
				                        	link = partes [k + 3];
				                        	
				                        	metodo.copiarDatos(ruta, precioDoubleConvertido, nombreProducto,link );
				            				
				            				break; 
				            			} else { 
				            			
				            			
				            			break;
				            			}
				            			
		            				}catch (NumberFormatException e) {
		            				System.out.println("Error: No se pudo convertir a double - " + precioAisladoTrim);
		            				// Continuar con la siguiente iteración si no es un número válido
		            				continue;
		            				}
		            		
		            		
		            		}
		            		//for
		            		}
		            		
		            	//try
		            	
		            			
		            			
		            	}catch(ArrayIndexOutOfBoundsException e) {
		            		System.out.println("Mensaje de la excepción para el metodo: " + e.getMessage()) ;
		            	}
		            	
		          //if  	
		          }
            	System.out.println("---------------------");
            	
            	 //textoSinSaltos.split("-");
            	
            	
        		
             //for	
            }
            
            
        
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
           // driver.quit();
        }
    }
}
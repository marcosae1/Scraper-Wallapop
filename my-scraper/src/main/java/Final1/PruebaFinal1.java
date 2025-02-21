package Final1;

import org.openqa.selenium.By;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;




public class PruebaFinal1 {
    public static void main(String[] args) {
    	
    	//Scanner
    	Scanner sc = new Scanner (System.in);
    	
    	//Atributos
    	double precioMaximo = 0;
    	double precioMinimo= 0;
    	double precioDoubleConvertido;
    	String tipoDeProducto ;
    	boolean novedades = false;
    	String novedadesSc;    	
    	String nombreProducto;
    	String link;    	
    	String precioAislado;
    	String precioAisladoTrim;   
    	String numeroFormateado;
        WebElement elemento;       
        String texto;       
        boolean repetir;
        String textoSinSaltos€;         
        String textoSinSaltos;        
    	String ruta ="C:\\Users\\marco\\Desktop\\Java txt\\ProductosWallapop.txt"; //Adjuntar ruta para el copiado de información
    	
    	 
    	//Introducción de parámetros
    	
    	System.out.println("Introduce el nombre del producto");
    	tipoDeProducto= sc.nextLine();
    	
    	//Precio máximo
    	do {
    		System.out.println("Introduce el precio máximo");
	    	if (sc.hasNextDouble()) {
	    	precioMaximo = sc.nextDouble() ;
	    	repetir = false;
	    	} else {
	    		System.out.print("Error: ");
	    		sc.next();
	    		repetir = true;
	    	}
    	} while (repetir == true);
    	
    	
    	do {
    		System.out.println("Introduce el precio mínimo");   
	    	if (sc.hasNextDouble()) {
	    	precioMinimo = sc.nextDouble();
	    	repetir = false;
	    	} else {
	    		System.out.print("Error: ");
	    		sc.next();
	    		repetir = true;
	    	}
    	} while (repetir == true);
    	
    	
    	System.out.println("Quieres buscar novedades? Escribe Sí o No");
    	novedadesSc = sc.next();
    	
    	
    	if (novedadesSc.equals("Sí") || novedadesSc.equals("Si") || novedadesSc.equals("sí") || novedadesSc.equals("si") ) {
    		novedades= true;
    	}
    		
   
        // Configuración del ChromeDriver, adjuntando ruta
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\marco\\\\Documents\\\\chromedriver.exe");
        

        // Configurar opciones del navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);
        
        
        //Instancia clase
        Clase1 metodo = new Clase1 ();
         
         
        //Escribe en el archivo txt la fecha y hora de la búsqueda
        metodo.productoFecha(ruta, tipoDeProducto);
        
         
         //Escribe en el archivo txt si la búsqueda se realiza por novedades o por relevancia
         metodo.novedades(ruta, novedades, precioMaximo, precioMinimo);

       
         try {              
	        	// Abrir la página de Wallapop
	            driver.get("https://es.wallapop.com/");
	            
	                                   
	            // Esperar a que la página se cargue completamente
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	                       
	            // Aceptar cookies si el botón está presente
	            try {	            
	                WebElement acceptCookiesButton = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"))); // ruta xpath  
	                acceptCookiesButton.click();                                                
	                System.out.println("Cookies aceptadas.");     
	                
	            } catch (Exception e) {
	            	System.out.println("No se encontró el botón de aceptar cookies o ya están aceptadas.");
	            }
	
	           	
	            // Esperar a que el contenido dinámico se cargue
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1, h2, h3"))); 
	            Thread.sleep(2000);
	            
           
	            //Buscamos el producto
	            metodo.buscar(tipoDeProducto, driver);
	            Thread.sleep(3000);
	            
	           
	            //Localizamos el botón "Relevancia" con su ruta xpath
	            WebElement botonRelevancia = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/div/span"));
	            
	           //Condición para buscar con "novedades"
	            if (novedades== true) {
	            	
	            	// Hacer clic en el botón
	            	botonRelevancia.click();
	            	Thread.sleep(1000);
	            	
	            	
	            	//botón novedades
	            	WebElement novedadesButton = driver.findElement(By.xpath("/html/body/tsl-root/tsl-public/div/div/tsl-search-root/div/div/tsl-single-access/div/div/div[2]/tsl-sort-filter/walla-dialog/div[2]/div/tsl-select-form/div[5]/tsl-select-option/div/div/span"));
	            	novedadesButton.click();
	            	Thread.sleep(2000);
	            	
	            	} else{
		            Thread.sleep(2000);
	            	}
	            
	            	
	            
	            //Obtener elementos <a> 
	            
	            List<WebElement> etiquetasA = driver.findElements(By.tagName("a"));
	 
	            Thread.sleep(1000);
	
	           System.out.println("Estos son los productos añadidos: ");
	           
	            //Bucle para cada elemento de la lista iphonesA
	            
	            for (int i=0; i<etiquetasA.size(); i++) {
	            		
	            	elemento = etiquetasA.get(i);
	            	
	            	//Conversión del elemento en el formato "texto - link"
	            	texto = elemento.getText() + "  -  " + elemento.getAttribute("href") ;
	            	
	            	
	            	//Sustituir los saltos de línea por "_" de la variable texto
	            	textoSinSaltos€= texto.replaceAll("\\n", " _ ");
	            	
	            	
	            	//Sustituir los saltos de línea y "€" por "_" de la variable texto
	            	textoSinSaltos= texto.replaceAll("\\n|€", "_");
	            	
	            	/*System.out de prueba
	            	System.out.println(textoSinSaltos€);
	            	System.out.println(textoSinSaltos);*/
	            	
	            	//Almacenamos en un array cada fragmento de textoSinSaltos separado por "_" 
	            	String[] partes = textoSinSaltos.split ("_");
	            	
	            	//Prueba: System.out.println("Elemento" + i);
	            	
	            	
	            	/*Condición: verificar si el String contiene €, indicando que es una etiqueta <a> de un producto y no de otra cosa. Si no se cumple, se vuelve al bucle for de arriba
	            	Solo los productos llevan en su información el símbolo "€" (en el precio, incluido en elemento.getText()), por lo que es buena forma de discriminar*/
	          
	            	if (textoSinSaltos€.contains("€") ) {
	            	
			            	try {
			            		
			            		/*Bucle para repasar cada elemento del array, con  k < 3 porque estamos buscando el precio, que estará como mucho en el elemento partes[2]
			            		pudiendo estar en el 0 o en el 1 o en el 2, dependerá de si hay más de una imagen del producto, o si sale un "Siguiente" */
			            		
			            		for (int k=0; k<3; k++) {
			            			
				            		//Almacenamos el elemento del array
				            		precioAislado = partes [k];
				               	
				            		//Le quitams los espacios
				            		precioAisladoTrim= precioAislado.trim();
				            		
				            		
				            		//Si contiene S el array significa que, o bien aparece un Slide, o un Siguiente. De esta forma los saltamos
				            	
				            		if (precioAislado.contains("S")) {
				            			continue;
				            		
				            			//Cuando no contiene S, significa que hemos llegado al precio, ya que antes solo puede tener un "Slide" o un "Siguiente"
					            		} else {
					            			
					            				try {
					            					
					            					//Cambio de formato en el precio, uso de "." para decimales
							            			//String numeroFormateado = precioAisladoTrim.replace(",", ".");
					            					numeroFormateado = metodo.numeroFormateado(precioAisladoTrim);
							            			
							            			//Precio convertido a double
							            			precioDoubleConvertido = Double.parseDouble(numeroFormateado);
							            			
							            			
							            			//Comparamos los precios introducidos al principio del programa con el real del producto
							            			
							            			if(precioMaximo>precioDoubleConvertido && precioDoubleConvertido>precioMinimo) {
							            				
							            				//Guardamos en variable el nombre del producto, siempre después del precio y el espacio entre "__"
							                        	nombreProducto = partes [k + 2];
							                        	
							                        	
							                        	try {
							                        	//Guardamos el link, justo después del nombre
							                        		
							                        	link = partes [k + 3];
							                        	
							                        	//Utilizamos el método para copiar datos
							                        	metodo.copiarDatos(ruta, precioDoubleConvertido, nombreProducto, link );
							                        	
							                        	} catch (ArrayIndexOutOfBoundsException e) {
										            		//System.out.println("Mensaje de la excepción para el array: el nombre del producto y el link van juntos ") ;
										            		metodo.copiarDatosSinLink(ruta, precioDoubleConvertido, nombreProducto);
										            	}
							                        	
							            				break; 
							            				
							            				} else { 
							            				break;
							            				}
							            			
					            				}catch (NumberFormatException e) {
					            				//Cuando salta este error, suele significar que está reservado	
					            				System.out.println("Error: No se pudo convertir a double - " + precioAisladoTrim);
					            				
					            				//Continuar con la siguiente iteración si no es un número válido
					            				continue;
					            				}
					            		
					            		//else
					            		}
			            		//for
			            		}
			            		
			            	//try
			            	}catch(ArrayIndexOutOfBoundsException e) {
			            		System.out.println("Mensaje de la excepción para el array: " + e.getMessage()) ;
			            	}
			            	
			          //if  	
			          }
	            	//System.out.println("---------------------");
	          	
	             //for	
	            }
	    //try       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
           // driver.quit();
        }
    }
}
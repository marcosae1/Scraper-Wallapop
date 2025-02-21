package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import org.openqa.selenium.WebDriver;


public class BuclePrecios {

	/* Método para procesar las listas de nombres y precios
    public void procesarIphones(List<WebElement> iphonesNombres, List<WebElement> iphonesPrecios) {
        int contador = 0; // Contador opcional

        // Bucle para recorrer las listas
        for (int i = 0; i < iphonesNombres.size(); i++) {
            WebElement nombre = iphonesNombres.get(i); // Obtener el nombre en la posición i
            WebElement precio = iphonesPrecios.get(i); // Obtener el precio en la posición i

            // Mostrar la información
            System.out.println(nombre.getTagName() + ": " + nombre.getText() + ": " + precio.getText());
            System.out.println("---");

            contador = contador + 1; // Incrementar el contador (si es necesario)
            System.out.println("Total de iPhones procesados: " + contador);
        }

    }  
        
    /* public String aislarPrecio (String [] partes) {
    	
    	 
    	 String precioAislado = partes [1];
    	 String precioAisladoTrim= precioAislado.trim();
    	 return precioAisladoTrim;
    	
    	 
     	}*/
     
     public void copiarDatos (String ruta, double precio, String nombreProducto, String link) {
         // Usamos FileWriter en modo append (true)
         try (FileWriter writer = new FileWriter(ruta, true)) {
        	 
        	 String contenidoTxt = Files.readString(Paths.get(ruta));
        	 
        	 if (contenidoTxt.contains(link)) {
        		 
        	 }else {
             writer.write("-->  " + nombreProducto + " - " + precio + "€ - "  + link); // Escribir el texto en el archivo
             writer.write("\n");
        	 }
             System.out.println("Texto añadido al archivo: " + ruta);
         } catch (IOException e) {
             System.err.println("Error al escribir en el archivo: " + e.getMessage());
         }
     }
     
     public void productoFecha (String ruta, String producto) {
    	 
    	 try (FileWriter writer = new FileWriter(ruta, true)) {
    		 LocalDateTime fechaHoraActual = LocalDateTime.now();
    		 
    		 writer.write("\n");
    		 
    		 writer.write("Producto: " + producto + " - Fecha y hora: " + fechaHoraActual);
    		 
    		 
    		 
    	 } catch (IOException e) {
             System.err.println("Error al escribir en el archivo: " + e.getMessage());
         }
    	 
     }
     
     public void novedades (String ruta,boolean novedades) {
    	 
    	 try (FileWriter writer = new FileWriter(ruta, true)) {
    		 
    		 
    		if (novedades) {
    			writer.write("\n");
    		 writer.write("Producto ordenado por novedades" );
    		 
    		 writer.write("\n" + "");
    		 writer.write("\n");
    		}else {
    			writer.write("\n");
    			writer.write("Producto ordenado por relevancia" );
    			 writer.write("\n" + "");
        		 writer.write("\n");
    		}
    		
    		
    	 } catch (IOException e) {
             System.err.println("Error al escribir en el archivo: " + e.getMessage());
         }
    	 
    	 
     }
     
     public void buscar(String tipoDeProducto, WebDriver driver) {
    	 
    	
    	 
    	 WebElement buscador = driver.findElement(By.xpath("//*[@id=\"searchbox-form-input\"]"));
    	 try {
    		    Thread.sleep(1000);
    		} catch (InterruptedException e) {
    		    e.printStackTrace();
    		}
         buscador.sendKeys(tipoDeProducto);
         try {
        	    Thread.sleep(1000);
        	} catch (InterruptedException e) {
        	    e.printStackTrace();
        	}
         buscador.sendKeys(Keys.ENTER);
     }
     	
        
     
     
    }
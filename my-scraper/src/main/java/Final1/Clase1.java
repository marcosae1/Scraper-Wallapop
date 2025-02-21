package Final1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import org.openqa.selenium.WebDriver;


public class Clase1 {
	
	
	public String numeroFormateado (String precioAisladoTrim) {
		
		//Si tiene "." y "," reemplazamos el "." por un vacío, y la "," por un "."
		if (precioAisladoTrim.contains(".")  && precioAisladoTrim.contains(",")){
			String numeroSinPunto = precioAisladoTrim.replace(".", "");
			String numeroFormateado = numeroSinPunto.replace(",", ".");
			return numeroFormateado;
		//De lo contrario solo reemplazamos la "," por un "."	
		} else {
			String numeroFormateado = precioAisladoTrim.replace(",", ".");
			return numeroFormateado;

		}
	
		
	}

	
     
     public void copiarDatos (String ruta, double precio, String nombreProducto, String link) {
        
    	 // Usamos FileWriter en modo append (true) para no se borren los datos anteriores
         try (FileWriter writer = new FileWriter(ruta, true)) {
        	 
        	 String contenidoTxt = Files.readString(Paths.get(ruta));
        	 
        	 //Si se comprueba que el link ya estaba en el archivo, no se copia la info, ya que se duplicaría al ser el mismo producto
        	 if (contenidoTxt.contains(link)) {
        		 
        	 }else {
             writer.write("-->  " + nombreProducto + " - " + precio + "€ - "  + link); // Escribe el texto en el archivo
             writer.write("\n");
             System.out.println("-->  " + nombreProducto + " - " + precio + "€ - "  + link); // Escribe el texto en pantalla

        	 }
         } catch (IOException e) {
             System.err.println("Error al escribir en el archivo: " + e.getMessage());
         }
     }
     
     public void copiarDatosSinLink (String ruta, double precio, String nombreProducto) {
         
    	 // Usamos FileWriter en modo append (true) para no se borren los datos anteriores
         try (FileWriter writer = new FileWriter(ruta, true)) {
        	 
        	 String contenidoTxt = Files.readString(Paths.get(ruta));
        	 
        	 //Si se comprueba que el link ya estaba en el archivo, no se copia la info, ya que se duplicaría al ser el mismo producto
        	 if (contenidoTxt.contains(nombreProducto)) {
        		 
        	 }else {
             writer.write("-->  " + nombreProducto + " - " + precio + "€ - " ); // Escribe el texto en el archivo
             writer.write("\n");
             System.out.println("-->  " + nombreProducto + " - " + precio + "€ - " ); // Escribe el texto en pantalla

        	 }
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
     
     public void novedades (String ruta,boolean novedades, double precioMaximo, double precioMinimo) {
    	 
    	 try (FileWriter writer = new FileWriter(ruta, true)) {
    		 
    		 
    		if (novedades) {
    			writer.write("\n");
    		 writer.write("Producto ordenado por novedades. Precio máximo:" +  precioMaximo + "€ Precio mínimo:" + precioMinimo + "€");
    		 
    		 writer.write("\n" + "");
    		 writer.write("\n");
    		}else {
    			writer.write("\n");
    			writer.write("Producto ordenado por relevancia. Precio máximo: " +  precioMaximo + "€ Precio mínimo:" + precioMinimo + "€" );
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
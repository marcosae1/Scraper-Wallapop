package Pruebas;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Prueba {

    public static void main(String[] args) {
        final String URL = "http://books.toscrape.com/";
        
        try {
            // 1. Conectar y obtener el HTML
            Document doc = Jsoup.connect(URL)
                               .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/107.0.0.0")
                               .timeout(10000)
                               .get();

            // 2. Seleccionar todos los artículos de libros
            Elements libros = doc.select("article.product_pod");

            // 3. Iterar sobre cada libro
            for (Element libro : libros) {
                String titulo = libro.select("h3 a").attr("title");
                String precio = libro.select("p.price_color").text();
                String disponibilidad = libro.select("p.availability").text().replaceAll("\\s+", " ");

                System.out.println("Título: " + titulo);
                System.out.println("Precio: " + precio);
                System.out.println("Disponibilidad: " + disponibilidad);
                System.out.println("-----------------------------------");
            }

            System.out.println("¡Scraping completado! Libros encontrados: " + libros.size());

        } catch (IOException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
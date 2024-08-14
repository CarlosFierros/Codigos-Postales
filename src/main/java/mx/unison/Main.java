package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Ruta al archivo CSV en el proyecto
        String rutaArchivo = "codigos_postales.csv";

        int asentamientosUrbanos = 0;
        int asentamientosRurales = 0;

        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer la primera línea que contiene los encabezados
            linea = br.readLine();

            // Leer cada línea subsiguiente
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                String tipoAsentamiento = columnas[2];

                if (tipoAsentamiento.equalsIgnoreCase("urbano")) {
                    asentamientosUrbanos++;
                } else if (tipoAsentamiento.equalsIgnoreCase("rural")) {
                    asentamientosRurales++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo. Por favor, inténtelo de nuevo.");
        }

        // Imprimir los resultados
        System.out.println("Asentamientos Urbanos en Hermosillo: " + asentamientosUrbanos);
        System.out.println("Asentamientos Rurales en Hermosillo: " + asentamientosRurales);
    }
}
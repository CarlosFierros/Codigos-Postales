package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncontrarCodigo {
    public static void main(String[] args) {
        // Verificar si se pasaron argumentos
        if (args.length == 0) {
            System.out.println("Por favor, proporciona al menos un código postal como argumento.");
            return;
        }

        // Ruta al archivo CSV en el proyecto
        String rutaArchivo = "codigos_postales.csv";

        // Crear un mapa para almacenar los códigos postales y sus asentamientos
        Map<String, List<String>> codigosPostales = new HashMap<>();

        try {
            // Abrir el archivo CSV
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            // Leer la primera línea (encabezados) y descartarla
            String linea = br.readLine();

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en columnas
                String[] columnas = linea.split(",");

                // Obtener el código postal y el nombre del asentamiento
                String codigoPostal = columnas[0];
                String asentamiento = columnas[1];

                // Ver si ya existe el código postal en el mapa
                if (!codigosPostales.containsKey(codigoPostal)) {
                    // Si no existe, creamos una nueva lista para este código postal
                    codigosPostales.put(codigoPostal, new ArrayList<String>());
                }

                // Añadir el asentamiento a la lista correspondiente al código postal
                codigosPostales.get(codigoPostal).add(asentamiento);
            }

            // Cerrar el archivo
            br.close();

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            return;
        }

        // Mostrar los asentamientos para cada código postal pasado como argumento
        for (String codigo : args) {
            if (codigosPostales.containsKey(codigo)) {
                System.out.println("Código Postal: " + codigo + " - Asentamientos:");
                for (String asentamiento : codigosPostales.get(codigo)) {
                    System.out.println("  - " + asentamiento);
                }
            } else {
                System.out.println("Código Postal: " + codigo + " no encontrado.");
            }
        }
    }
}
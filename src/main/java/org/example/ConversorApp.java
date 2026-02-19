package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.Scanner;

public class ConversorApp {

    // Metodo modular para realizar la conversión
    public static double convertirMoneda(double cantidad, double tasaDeCambio) {
        return cantidad * tasaDeCambio;
    }

    static void main() {
        // Define la URL exacta que usaste en Postman (reemplaza TU_CLAVE_API)
        String direccion = "https://v6.exchangerate-api.com/v6/f0c8c87f20abd145afc0f84e/latest/USD";

        try {
            // Construimos el Cliente (El Mensajero)
            HttpClient client = HttpClient.newHttpClient();

            // Construimos la Solicitud (La Carta)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            // Enviamos la solicitud y guardamos la Respuesta (El Paquete)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimimos el cuerpo de la respuesta en la consola
            // System.out.println("Respuesta de la API:");
            // System.out.println(response.body());

            // Creamos la instancia de Gson
            Gson gson = new Gson();

            // Convertimos el JSON (String) a nuestro objeto Java
            TasasDeCambio misTasas = gson.fromJson(response.body(), TasasDeCambio.class);

            // Filtramos y obtenemos las monedas
            double tasaUSD = misTasas.conversion_rates().get("USD");
            double tasaCOP = misTasas.conversion_rates().get("COP");
            double tasaARS = misTasas.conversion_rates().get("ARS");
            double tasaBRL = misTasas.conversion_rates().get("BRL");


            Scanner teclado = new Scanner(System.in);
            int opcion;

            while (true) {
                // Imprimimos el menú usando tu bloque de texto
                System.out.println("""
                        *********************************************************
                        Sea bienvenido/a al Conversor de Moneda =]
                        
                        1) Dólar =>> Peso argentino
                        2) Peso argentino =>> Dólar
                        3) Dólar =>> Real brasileño
                        4) Real brasileño =>> Dólar
                        5) Dólar =>> Peso colombiano
                        6) Peso colombiano =>> Dólar
                        7) Salir
                        *********************************************************
                        
                        Elija una opción válida:
                        """);

                // Capturamos la opción elegida
                opcion = teclado.nextInt();

                // Verificamos si quiere salir antes de pedirle dinero
                if (opcion == 7) {
                    System.out.println("¡Gracias por usar el conversor! Cerrando programa...");
                    break; // Rompe el bucle while
                }

                // Validación básica de opciones
                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    continue; // Vuelve al inicio del bucle
                }

                // Si llegó hasta aquí, la opción es válida (1-6). Le pedimos la cantidad.
                System.out.println("Ingrese el valor que deseas convertir:");
                double cantidad = teclado.nextDouble();
                double resultado;

                // Lógica de conversión según la opción
                switch (opcion) {
                    case 1:
                        resultado = convertirMoneda(cantidad, tasaARS);
                        System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + resultado + " [ARS]");
                        break;
                    case 2:
                        // Para convertir de otra moneda a USD, dividimos por la tasa
                        resultado = cantidad / tasaARS;
                        System.out.println("El valor " + cantidad + " [ARS] corresponde al valor final de =>>> " + resultado + " [USD]");
                        break;
                    case 3:
                        resultado = convertirMoneda(cantidad, tasaBRL);
                        System.out.println("El valor " + cantidad + "[USD] corresponde al valor final de =>>> " + resultado + " [BRL]");
                        break;
                    case 4:
                        resultado = cantidad / tasaBRL;
                        System.out.println("El valor " + cantidad + "[BRL] corresponde al valor final de =>>> " + resultado + " [USD]");
                        break;
                    case 5:
                        resultado = convertirMoneda(cantidad, tasaCOP);
                        System.out.println("El valor " + cantidad + " [USD] corresponde al valor final de =>>> " + resultado + " [COP]");
                        break;
                    case 6:
                        resultado = cantidad / tasaCOP;
                        System.out.println("El valor " + cantidad + " [COP] corresponde al valor final de =>>> " + resultado + " [USD]");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la petición: " + e.getMessage());
        }
    }
}

package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConversorApp {

    // Metodo modular para realizar la conversión
    public static double convertirMoneda(double cantidad, double tasaDeCambio) {
        return cantidad * tasaDeCambio;
    }

    static void main() {
        // 1. Define la URL exacta que usaste en Postman (reemplaza TU_CLAVE_API)
        String direccion = "https://v6.exchangerate-api.com/v6/f0c8c87f20abd145afc0f84e/latest/USD";

        try {
            // 2. Construimos el Cliente (El Mensajero)
            HttpClient client = HttpClient.newHttpClient();

            // 3. Construimos la Solicitud (La Carta)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            // 4. Enviamos la solicitud y guardamos la Respuesta (El Paquete)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // 5. Imprimimos el cuerpo de la respuesta en la consola
            System.out.println("Respuesta de la API:");
            System.out.println(response.body());

            // 1. Creamos la instancia de Gson
            Gson gson = new Gson();

            // 2. Convertimos el JSON (String) a nuestro objeto Java
            TasasDeCambio misTasas = gson.fromJson(response.body(), TasasDeCambio.class);

            // 3. Filtramos y obtenemos las monedas
            double tasaUSD = misTasas.conversion_rates().get("USD");
            double tasaCOP = misTasas.conversion_rates().get("COP");
            double tasaBRL = misTasas.conversion_rates().get("BRL");

            // Simulamos un valor ingresado por el usuario
            double cantidadAConvertir = 50.0;

            // Llamamos a nuestro nuevo metodo para hacer los cálculos
            double resultadoCOP = convertirMoneda(cantidadAConvertir, tasaCOP);
            double resultadoBRL = convertirMoneda(cantidadAConvertir, tasaBRL);

            // Mostramos los resultados finales
            System.out.println(cantidadAConvertir + " USD equivalen a " + resultadoCOP + " COP");
            System.out.println(cantidadAConvertir + " USD equivalen a " + resultadoBRL + " BRL");

        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la petición: " + e.getMessage());
        }
    }
}

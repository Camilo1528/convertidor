package com.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    // Clave API directa (no recomendado en producción)
    private static final String API_KEY = "78bb6dc79186f41d1191df90";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    /**
     * Obtiene la tasa de cambio entre dos monedas.
     *
     * @param fromCurrency Moneda de origen (ejemplo: "USD").
     * @param toCurrency   Moneda de destino (ejemplo: "EUR").
     * @return La tasa de cambio entre las monedas.
     * @throws Exception Si ocurre un error al consultar la API.
     */
    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        // Construir la URL con la moneda de origen
        String url = BASE_URL + API_KEY + "/latest/" + fromCurrency;

        // Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el estado de la respuesta
        if (response.statusCode() == 200) {
            // Parsear la respuesta JSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Verificar si la moneda destino está disponible
            if (conversionRates.has(toCurrency)) {
                return conversionRates.get(toCurrency).getAsDouble();
            } else {
                throw new Exception("La moneda destino '" + toCurrency + "' no está disponible en la respuesta de la API.");
            }
        } else {
            // Lanzar una excepción si el estado no es 200
            throw new Exception("Error en la API. Código de respuesta: " + response.statusCode());
        }
    }
}

package Core.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

import Service.Entities.Habitacion;

import java.net.http.HttpResponse;

public class HttpUtils {

    private static final String BASE_URL = "http://localhost:3004/api/v1/habitacion";

    public static HttpResponse<String> getAllHabitaciones(String token) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
            // System.out.println("Response code: " + response.statusCode());
            // System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static HttpResponse<String> createHabitacion(Habitacion habitacion, String token) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String json = "{"
                    + "\"titulo\": \"" + habitacion.getTitulo() + "\","
                    + "\"descripcion\": \"" + habitacion.getDescripcion() + "\","
                    + "\"pais\": \"" + habitacion.getPais() + "\","
                    + "\"ciudad\": \"" + habitacion.getCiudad() + "\","
                    + "\"imagen\": \"" + habitacion.getImagen() + "\","
                    + "\"servicios\": \"" + habitacion.getServicios() + "\""
                    + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .POST(BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

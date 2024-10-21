package Service.Logic;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Core.http.HttpUtils;
import Service.Entities.Habitacion;

public class HabitacionService {
    public static List<Habitacion> parseHabitaciones(String jsonResponse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, new TypeReference<List<Habitacion>>() {
        });
    }

    public static List<Habitacion> getHabitaciones(String token) {
        try {
            return parseHabitaciones(HttpUtils.getAllHabitaciones(token).body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveHabitacion(Habitacion habitacion, String token) {
        try {
            HttpUtils.createHabitacion(habitacion, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

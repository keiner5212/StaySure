package Service.Logic;

import java.util.List;

import Persistence.HabitacionPersistance;
import Service.Entities.Habitacion;

public class HabitacionService {
    public static List<Habitacion> getHabitaciones() {
        return HabitacionPersistance.getHabitaciones();
    }

    public static void saveHabitacion(Habitacion habitacion) {
        HabitacionPersistance.saveHabitacion(habitacion);
    }
}

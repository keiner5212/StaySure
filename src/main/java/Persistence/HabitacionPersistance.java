package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Core.Entities.Callback;
import Service.Entities.Habitacion;

public class HabitacionPersistance {
    public static List<Habitacion> getHabitaciones() {
        List<Habitacion> result=new ArrayList<>();
        new DataBase();
        DataBase.SelectEntities(Habitacion.TABLE_STATICS.GetSelectQuery(), new Callback() {
            ResultSet rs=null;
            @Override
            public void setResultSet(ResultSet resultSet) {
                rs=resultSet;
            }

            @Override
            public void run() {
                try {
                    result.add(Habitacion.builder().id(rs.getLong("id"))
                    .imagen(rs.getString("imagen"))
                    .pais(rs.getString("pais"))
                    .titulo(rs.getString("titulo"))
                    .ciudad(rs.getString("ciudad"))
                    .descripcion(rs.getString("descripcion")).build()
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        } );
        return result;
    }

    public static void saveHabitacion(Habitacion habitacion) {
        new DataBase();
        DataBase.SaveEntity(Habitacion.TABLE_STATICS.GetCreateQuery(), habitacion);
    }
}

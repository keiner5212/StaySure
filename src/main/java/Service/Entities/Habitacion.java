
package Service.Entities;

import java.io.Serializable;
import java.util.List;

import Core.Entities.Table;
import Core.Entities.TableStatics;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Habitacion implements Serializable, Table {
    private Long id;
    private String titulo;
    private String descripcion;
    private String pais;
    private String ciudad;
    private String imagen;

    public static TableStatics TABLE_STATICS = new TableStatics() {

        @Override
        public String GetCreateQuery() {
            return "INSERT INTO " + tableName() + " (titulo, descripcion, pais, ciudad, imagen) VALUES (?, ?, ?, ?, ?)";
        }

        @Override
        public String GetSelectQuery() {
            return "SELECT (titulo, descripcion, pais, ciudad, imagen) FROM " + tableName();
        }

        @Override
        public String tableName() {
            return "habitacion";
        }

    };

    @Override
    public List<Object> toJPA() {
        return List.of(titulo, descripcion, pais, ciudad, imagen);
    }

}

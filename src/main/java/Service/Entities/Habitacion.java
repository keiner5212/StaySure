
package Service.Entities;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Habitacion implements Serializable {
    private Long id;
    private String titulo;
    private String descripcion;
    private String pais;
    private String ciudad;
    private String imagen;
    private String servicios;

}

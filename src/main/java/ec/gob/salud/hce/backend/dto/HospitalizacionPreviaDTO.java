package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class HospitalizacionPreviaDTO {
    private Integer idHospitalizacionPrevia;
    private String causa;
    private Date fecha;
    private Integer idAntecedentePatologicoPersonal;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
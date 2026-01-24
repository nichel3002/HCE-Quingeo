package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HospitalizacionPreviaDTO {
    private Integer idHospitalizacionPrevia;
    private String causa;
    private LocalDate fecha;
    
    // ID Relación
    private Integer idAntecedentePatologicoPersonal;
    
    private String usuario;
    private Integer idPersonal;
    
    // Auditoría
    private String uuidOffline;
    private String syncStatus;
    private LocalDateTime lastModified;
    private String origin;
}
package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PlanTerapeuticoDTO {
    private Integer idPlanTerapeutico;
    private String aspectosTerapeuticos;
    private String receta;
    private String indicaciones;
    
    // ID para la relación
    private Integer idConsulta;
    
    private String usuario;
    private Integer idPersonal;
    
    // Auditoría
    private String uuidOffline;
    private String syncStatus;
    private LocalDateTime lastModified;
    private String origin;
}
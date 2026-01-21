package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DesarrolloPsicomotorDTO {
    private Integer idDesarrolloPsicomotor;
    private String sostenCefalo;
    private String sedestacion;
    private String deambulacion;
    private String lenguaje;
    private String observacion;
    private Integer idHistoriaClinica;
    private Integer idPaciente;
    
    // Auditoría y Sincronización
    private String uuidOffline;
    private String syncStatus;
    private LocalDateTime lastModified;
    private String origin;

    
}
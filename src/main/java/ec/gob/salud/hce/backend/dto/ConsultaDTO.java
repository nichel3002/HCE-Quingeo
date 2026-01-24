package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime; // Importante

@Data
public class ConsultaDTO {
    private Integer idConsulta;
    private String motivoConsulta;
    private String enfermedadActual;
    
    // CORRECCIÓN: Usamos LocalDateTime para incluir la hora de atención
    private LocalDateTime fechaAtencion; 
    private LocalDate fechaProximaConsulta; // Esta sí puede ser solo fecha

    private Integer idHistoriaClinica;
    private Integer idPersonal;

    // Auditoría
    private String usuario;
    private String uuidOffline;
    private String syncStatus;
    private LocalDateTime lastModified;
    private String origin;
}
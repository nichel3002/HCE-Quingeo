package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EstudioLaboratorioDTO {
    private Integer idEstudioLaboratorio;
    private String solicitados;
    private String resultadosRelevantes;
    private LocalDate fecha;
    
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
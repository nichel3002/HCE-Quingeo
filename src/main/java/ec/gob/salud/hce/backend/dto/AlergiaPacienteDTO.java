package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AlergiaPacienteDTO {
    private Integer idAlergiaPaciente; // id_alergia_paciente
    private String reaccion;           // reaccion (20)
    private String observaciones;      // observaciones (100)
    private Integer idPaciente;        // id_paciente
    private Integer idAlergia;         // id_alergia
    private Integer idAntecedentePatologicoPersonal; // id_antecedente_patologico_personal
    
    // Campos de auditoría y sincronización
    private LocalDate fechaCreacion;
    private String uuidOffline;
    private String syncStatus;
    private LocalDateTime lastModified;
    private String origin;
}
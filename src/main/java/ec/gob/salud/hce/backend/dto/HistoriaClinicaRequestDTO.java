package ec.gob.salud.hce.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinicaRequestDTO {

    @NotNull(message = "El id del paciente es obligatorio")
    private Long idPaciente;

    @NotNull(message = "El usuario es obligatorio")
    private String usuario;

    private String uuidOffline;
    private String syncStatus;
    private String origin;
}

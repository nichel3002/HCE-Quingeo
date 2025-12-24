package ec.gob.salud.hce.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {

    // =========================
    // DATOS PERSONALES
    // =========================
    @NotBlank
    private String primerNombre;

    private String segundoNombre;

    @NotBlank
    private String apellidoPaterno;

    private String apellidoMaterno;

    @NotBlank
    private String sexo;

    @NotNull
    @Past
    private LocalDate fechaNacimiento;

    private String tipoSangre;

    // =========================
    // DEMOGRAFÍA
    // =========================
    private Long idGrupoEtnico;
    private Long idPrqParroquia;
    private Long idPrqCanton;
    private Long idPrqProvincia;

    // =========================
    // AUDITORÍA / SINCRONIZACIÓN
    // =========================
    private String usuario;
    private String uuidOnline;
    private String syncStatus;
    private String origin;
}

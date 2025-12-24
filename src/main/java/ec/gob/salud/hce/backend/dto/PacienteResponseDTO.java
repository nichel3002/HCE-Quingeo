package ec.gob.salud.hce.backend.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDTO {

    private Long idPaciente;

    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String sexo;
    private LocalDate fechaNacimiento;
    private Integer edad; // ✅ AQUÍ
    private String tipoSangre;

    private Long idGrupoEtnico;
    private Long idPrqParroquia;
    private Long idPrqCanton;
    private Long idPrqProvincia;

    private String usuario;
    private LocalDateTime fechaCreacion;
    private LocalDateTime lastModified;

    private String uuidOnline;
    private String syncStatus;
    private String origin;
}

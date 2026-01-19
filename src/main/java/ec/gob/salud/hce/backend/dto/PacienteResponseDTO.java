package ec.gob.salud.hce.backend.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDTO {

    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String sexo;

    private Integer edad;
    private String tipoSangre;
private Integer idPaciente;
private Integer idGrupoEtnico;
private Integer idPrqParroquia;
private Integer idPrqCanton;
private Integer idPrqProvincia;

private LocalDate fechaCreacion;
private LocalDate fechaNacimiento;

}

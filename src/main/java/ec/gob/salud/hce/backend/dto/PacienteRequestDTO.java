package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data // Esto genera los métodos getIdPsicomotor, etc., automáticamente
public class PacienteRequestDTO {
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String tipoSangre;
    private Integer edad;
    // --- ESTOS SON LOS CAMPOS QUE LE FALTAN A TU DTO ---
    private Integer idPsicomotor;
    private Integer idAntecedenteFamiliar;
    private Integer idExamenFisico;
    private Integer idDiagnosticoPlanManejo;
    private Integer idParroquia;
    private Integer idPrqCntProvincia;
    // --------------------------------------------------

    private Integer idGrupoEtnico;
    private Integer idPrqParroquia;
    private Integer idPrqCanton;
    private Integer idPrqProvincia;
}
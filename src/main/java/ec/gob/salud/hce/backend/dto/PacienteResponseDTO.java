package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PacienteResponseDTO {
    private Integer idPaciente;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private String tipoSangre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaCreacion;
    private Integer edad;

    // Ubicación
    private Integer idGrupoEtnico;
    private Integer idPrqParroquia;
    private Integer idPrqCanton;
    private Integer idPrqProvincia;

    // --- AQUÍ ESTÁ LA UNIÓN DE INFORMACIÓN ---
    // En lugar de IDs, enviamos las listas de datos completos
    private List<DesarrolloPsicomotorDTO> desarrollosPsicomotores;
    private List<AntecedenteFamiliarDTO> antecedentesFamiliares;
    private List<ExamenFisicoDTO> examenesFisicos;
    private List<AlergiaPacienteDTO> alergias; 
}
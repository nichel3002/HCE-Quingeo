package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.Paciente;

import java.time.LocalDate;
import java.time.Period;

public class PacienteMapper {

    private PacienteMapper() { }

    public static Paciente toEntity(PacienteRequestDTO dto) {
        if (dto == null) return null;

        Paciente paciente = new Paciente();
        paciente.setPrimerNombre(dto.getPrimerNombre());
        paciente.setSegundoNombre(dto.getSegundoNombre());
        paciente.setApellidoPaterno(dto.getApellidoPaterno());
        paciente.setApellidoMaterno(dto.getApellidoMaterno());
        paciente.setSexo(dto.getSexo());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setTipoSangre(dto.getTipoSangre());

        // Mapeo de IDs obligatorios
        
        
        paciente.setIdDiagnosticoPlanManejo(dto.getIdDiagnosticoPlanManejo());
        paciente.setIdParroquia(dto.getIdParroquia());
        paciente.setIdGrupoEtnico(dto.getIdGrupoEtnico());
        paciente.setIdPrqParroquia(dto.getIdPrqParroquia());
        paciente.setIdPrqCanton(dto.getIdPrqCanton());
        paciente.setIdPrqProvincia(dto.getIdPrqProvincia());
        paciente.setIdPrqCntProvincia(dto.getIdPrqCntProvincia());

        return paciente;
    }

    public static PacienteResponseDTO toResponse(Paciente paciente) {
    if (paciente == null) return null;

    PacienteResponseDTO dto = new PacienteResponseDTO();
    // ... (mapeo de campos básicos que ya tenías)
    dto.setIdPaciente(paciente.getIdPaciente());
    dto.setPrimerNombre(paciente.getPrimerNombre());
    // ... etc.

    // MAPEANDO LAS LISTAS DE INFORMACIÓN VINCULADA
    if (paciente.getDesarrollosPsicomotores() != null) {
        dto.setDesarrollosPsicomotores(paciente.getDesarrollosPsicomotores()
            .stream()
            .map(DesarrolloPsicomotorMapper::toDto) // Usamos el mapper de esa entidad
            .toList());
    }

    if (paciente.getAntecedentesFamiliares() != null) {
        dto.setAntecedentesFamiliares(paciente.getAntecedentesFamiliares()
            .stream()
            .map(AntecedenteFamiliarMapper::toDto)
            .toList());
    }

    // Cálculo de edad
    if (paciente.getFechaNacimiento() != null) {
        dto.setEdad(Period.between(paciente.getFechaNacimiento(), LocalDate.now()).getYears());
    }

    return dto;
}
    // Método completo para calcular la edad exacta en años
    private static Integer calcularEdad(LocalDate nacimiento) {
        if (nacimiento == null) {
            return null;
        }
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
}
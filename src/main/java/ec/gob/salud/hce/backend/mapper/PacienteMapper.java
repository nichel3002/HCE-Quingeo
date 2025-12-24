package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.Paciente;

import java.time.Period;

public class PacienteMapper {

    private PacienteMapper() {
        // Evita instanciación
    }

    // =========================
    // DTO → ENTITY
    // =========================
    public static Paciente toEntity(PacienteRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setPrimerNombre(dto.getPrimerNombre());
        paciente.setSegundoNombre(dto.getSegundoNombre());
        paciente.setApellidoPaterno(dto.getApellidoPaterno());
        paciente.setApellidoMaterno(dto.getApellidoMaterno());
        paciente.setSexo(dto.getSexo());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setTipoSangre(dto.getTipoSangre());

        paciente.setIdGrupoEtnico(dto.getIdGrupoEtnico());
        paciente.setIdPrqParroquia(dto.getIdPrqParroquia());
        paciente.setIdPrqCanton(dto.getIdPrqCanton());
        paciente.setIdPrqProvincia(dto.getIdPrqProvincia());

        paciente.setUsuario(dto.getUsuario());

        return paciente;
    }

    // =========================
    // ENTITY → RESPONSE DTO
    // =========================
    public static PacienteResponseDTO toResponse(Paciente paciente) {

        if (paciente == null) {
            return null;
        }

        PacienteResponseDTO dto = new PacienteResponseDTO();

        dto.setIdPaciente(paciente.getIdPaciente());

        dto.setPrimerNombre(paciente.getPrimerNombre());
        dto.setSegundoNombre(paciente.getSegundoNombre());
        dto.setApellidoPaterno(paciente.getApellidoPaterno());
        dto.setApellidoMaterno(paciente.getApellidoMaterno());

        dto.setSexo(paciente.getSexo());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setTipoSangre(paciente.getTipoSangre());

        dto.setIdGrupoEtnico(paciente.getIdGrupoEtnico());
        dto.setIdPrqParroquia(paciente.getIdPrqParroquia());
        dto.setIdPrqCanton(paciente.getIdPrqCanton());
        dto.setIdPrqProvincia(paciente.getIdPrqProvincia());

        dto.setUsuario(paciente.getUsuario());
        dto.setFechaCreacion(paciente.getFechaCreacion());
        dto.setLastModified(paciente.getLastModified());

        dto.setUuidOnline(paciente.getUuidOnline());
        dto.setSyncStatus(paciente.getSyncStatus());
        dto.setOrigin(paciente.getOrigin());

        // Edad calculada
        dto.setEdad(calcularEdad(
                paciente.getFechaNacimiento(),
                paciente.getFechaCreacion()
        ));

        return dto;
    }

    // =========================
    // UTILIDAD EDAD
    // =========================
    private static Integer calcularEdad(
            java.time.LocalDate nacimiento,
            java.time.LocalDateTime fechaCreacion) {

        if (nacimiento == null || fechaCreacion == null) {
            return null;
        }

        return Period.between(
                nacimiento,
                fechaCreacion.toLocalDate()
        ).getYears();
    }
}

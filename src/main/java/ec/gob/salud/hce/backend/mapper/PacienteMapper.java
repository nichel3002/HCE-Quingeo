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
        paciente.setIdPsicomotor(dto.getIdPsicomotor());
        paciente.setIdAntecedenteFamiliar(dto.getIdAntecedenteFamiliar());
        paciente.setIdExamenFisico(dto.getIdExamenFisico());
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
        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setPrimerNombre(paciente.getPrimerNombre());
        dto.setSegundoNombre(paciente.getSegundoNombre());
        dto.setApellidoPaterno(paciente.getApellidoPaterno());
        dto.setApellidoMaterno(paciente.getApellidoMaterno());
        dto.setSexo(paciente.getSexo());
        dto.setTipoSangre(paciente.getTipoSangre());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setFechaCreacion(paciente.getFechaCreacion());

        // Mapeo de IDs para la respuesta
        dto.setIdGrupoEtnico(paciente.getIdGrupoEtnico());
        dto.setIdPrqParroquia(paciente.getIdPrqParroquia());
        dto.setIdPrqCanton(paciente.getIdPrqCanton());
        dto.setIdPrqProvincia(paciente.getIdPrqProvincia());

        // Lógica de EDAD: Se calcula comparando Nacimiento vs Fecha Actual
        if (paciente.getFechaNacimiento() != null) {
            dto.setEdad(calcularEdad(paciente.getFechaNacimiento()));
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
package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.Paciente;
import ec.gob.salud.hce.backend.util.EdadUtil;

public class PacienteMapper {

    private PacienteMapper() {
        // Evita instanciación
    }

    // ============================
    // RequestDTO → Entity
    // ============================
    public static Paciente toEntity(PacienteRequestDTO dto) {

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
        paciente.setUuidOnline(dto.getUuidOnline());
        paciente.setSyncStatus(dto.getSyncStatus());
        paciente.setOrigin(dto.getOrigin());

        return paciente;
    }

    // ============================
    // Entity → ResponseDTO
    // ============================
    public static PacienteResponseDTO toResponseDTO(Paciente paciente) {

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

        // ✅ EDAD CALCULADA
        dto.setEdad(
                EdadUtil.calcularEdad(
                        paciente.getFechaNacimiento(),
                        paciente.getFechaCreacion()
                )
        );

        return dto;
    }
}

package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.AlergiaPacienteDTO;
import ec.gob.salud.hce.backend.entity.AlergiaPaciente;

public class AlergiaPacienteMapper {

    private AlergiaPacienteMapper() { }

    public static AlergiaPacienteDTO toDto(AlergiaPaciente entity) {
        if (entity == null) return null;

        AlergiaPacienteDTO dto = new AlergiaPacienteDTO();
        dto.setIdAlergiaPaciente(entity.getIdAlergiaPaciente());
        dto.setReaccion(entity.getReaccion());
        dto.setObservaciones(entity.getObservaciones());
        
        if (entity.getPaciente() != null) {
            dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        }
        
        // LÓGICA DE UNIÓN: Conversión de Long a Integer usando .intValue()
        if (entity.getAlergia() != null && entity.getAlergia().getIdAlergia() != null) {
            dto.setIdAlergia(entity.getAlergia().getIdAlergia().intValue());
        }

        dto.setIdAntecedentePatologicoPersonal(entity.getIdAntecedentePatologicoPersonal());
        
        // Auditoría
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }
}
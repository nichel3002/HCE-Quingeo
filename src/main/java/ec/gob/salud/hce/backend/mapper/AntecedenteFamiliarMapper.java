package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.AntecedenteFamiliarDTO;
import ec.gob.salud.hce.backend.entity.AntecedenteFamiliar;
import java.util.List;
import java.util.stream.Collectors;

public class AntecedenteFamiliarMapper {

    private AntecedenteFamiliarMapper() { }

    public static AntecedenteFamiliarDTO toDto(AntecedenteFamiliar entity) {
        if (entity == null) return null;

        AntecedenteFamiliarDTO dto = new AntecedenteFamiliarDTO();
        dto.setIdAntecedenteFamiliar(entity.getIdAntecedenteFamiliar());
        
        // Mapeo exacto de tus campos de entidad
        dto.setEnfermedadHereditaria(entity.getEnfermedadHereditaria());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFecha(entity.getFecha());
        dto.setIdEnfermedad(entity.getIdEnfermedad());
        
        // Extracción del ID del paciente para la unión
        if (entity.getPaciente() != null) {
            dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        }

        // Auditoría
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public static List<AntecedenteFamiliarDTO> toDtoList(List<AntecedenteFamiliar> entities) {
        if (entities == null) return null;
        return entities.stream()
                       .map(AntecedenteFamiliarMapper::toDto)
                       .collect(Collectors.toList());
    }
}
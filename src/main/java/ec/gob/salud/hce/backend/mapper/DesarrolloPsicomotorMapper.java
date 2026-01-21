package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.DesarrolloPsicomotorDTO;
import ec.gob.salud.hce.backend.entity.DesarrolloPsicomotor;
import java.util.List;
import java.util.stream.Collectors;

public class DesarrolloPsicomotorMapper {

    private DesarrolloPsicomotorMapper() { }

    public static DesarrolloPsicomotorDTO toDto(DesarrolloPsicomotor entity) {
        if (entity == null) return null;

        DesarrolloPsicomotorDTO dto = new DesarrolloPsicomotorDTO();
        dto.setIdDesarrolloPsicomotor(entity.getIdDesarrolloPsicomotor());
        dto.setSostenCefalo(entity.getSostenCefalo());
        dto.setSedestacion(entity.getSedestacion());
        dto.setDeambulacion(entity.getDeambulacion());
        dto.setLenguaje(entity.getLenguaje());
        dto.setObservacion(entity.getObservacion());
        
        // Unión de información: Extraemos IDs de los objetos relacionados
        if (entity.getPaciente() != null) {
            dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        }
        
        // id_historia_clinica (ajustar si es relación u objeto en tu entidad)
        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());

        // Auditoría
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public static List<DesarrolloPsicomotorDTO> toDtoList(List<DesarrolloPsicomotor> entities) {
        if (entities == null) return null;
        return entities.stream()
                       .map(DesarrolloPsicomotorMapper::toDto)
                       .collect(Collectors.toList());
    }
}
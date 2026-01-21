package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.ExamenFisicoDTO;
import ec.gob.salud.hce.backend.entity.ExamenFisico;
import java.util.List;
import java.util.stream.Collectors;

public class ExamenFisicoMapper {

    private ExamenFisicoMapper() { }

    public static ExamenFisicoDTO toDto(ExamenFisico entity) {
        if (entity == null) return null;

        ExamenFisicoDTO dto = new ExamenFisicoDTO();
        dto.setIdExamenFisico(entity.getIdExamenFisico());

        // Lógica de Unión: Si en la Entidad son Objetos, extraemos sus IDs
        // Ajusta los nombres de los métodos según tus relaciones en la Entidad
        if (entity.getSignoVital() != null) {
            dto.setIdSignoVital(entity.getSignoVital().getIdSignoVital());
        }
        
        if (entity.getExamenFisicoSegmentario() != null) {
            dto.setIdExamenFisicoSegmentario(entity.getExamenFisicoSegmentario().getIdExamenFisicoSegmentario());
        }

        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());

        // Campos de sincronización
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public static List<ExamenFisicoDTO> toDtoList(List<ExamenFisico> entities) {
        if (entities == null) return null;
        return entities.stream()
                       .map(ExamenFisicoMapper::toDto)
                       .collect(Collectors.toList());
    }
}
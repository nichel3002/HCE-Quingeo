package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.GrupoEtnicoDTO;
import ec.gob.salud.hce.backend.entity.GrupoEtnico;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GrupoEtnicoMapper {

    public GrupoEtnicoDTO toDTO(GrupoEtnico entity) {
        if (entity == null) return null;

        GrupoEtnicoDTO dto = new GrupoEtnicoDTO();
        dto.setIdGrupoEtnico(entity.getIdGrupoEtnico());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFecha(entity.getFecha());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        return dto;
    }

    public GrupoEtnico toEntity(GrupoEtnicoDTO dto) {
        if (dto == null) return null;

        GrupoEtnico entity = new GrupoEtnico();
        entity.setIdGrupoEtnico(dto.getIdGrupoEtnico());
        entity.setDescripcion(dto.getDescripcion());
        entity.setFecha(dto.getFecha());
        
        // Lógica estándar de auditoría
        entity.setUuidOffline(dto.getUuidOffline() != null ? dto.getUuidOffline() : UUID.randomUUID().toString());
        entity.setSyncStatus(dto.getSyncStatus() != null ? dto.getSyncStatus() : "PENDING");

        return entity;
    }

    public List<GrupoEtnicoDTO> toDTOList(List<GrupoEtnico> list) {
        if (list == null || list.isEmpty()) return Collections.emptyList();
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
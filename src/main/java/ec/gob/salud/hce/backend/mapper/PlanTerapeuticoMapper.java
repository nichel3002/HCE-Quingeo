package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PlanTerapeuticoDTO;
import ec.gob.salud.hce.backend.entity.Consulta;
import ec.gob.salud.hce.backend.entity.PlanTerapeutico;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

@Component
public class PlanTerapeuticoMapper {

    public PlanTerapeuticoDTO toDTO(PlanTerapeutico entity) {
        if (entity == null) return null;

        PlanTerapeuticoDTO dto = new PlanTerapeuticoDTO();
        dto.setIdPlanTerapeutico(entity.getIdPlanTerapeutico());
        dto.setAspectosTerapeuticos(entity.getAspectosTerapeuticos());
        dto.setReceta(entity.getReceta());
        dto.setIndicaciones(entity.getIndicaciones());
        
        // Mapeo del ID de la relación
        if (entity.getConsulta() != null) {
            dto.setIdConsulta(entity.getConsulta().getIdConsulta());
        }

        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public PlanTerapeutico toEntity(PlanTerapeuticoDTO dto) {
        if (dto == null) return null;

        PlanTerapeutico entity = new PlanTerapeutico();
        entity.setIdPlanTerapeutico(dto.getIdPlanTerapeutico());
        entity.setAspectosTerapeuticos(dto.getAspectosTerapeuticos());
        entity.setReceta(dto.getReceta());
        entity.setIndicaciones(dto.getIndicaciones());

        // Creación del Proxy para la relación
        if (dto.getIdConsulta() != null) {
            Consulta c = new Consulta();
            c.setIdConsulta(dto.getIdConsulta());
            entity.setConsulta(c);
        }

        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setUuidOffline(dto.getUuidOffline() != null ? dto.getUuidOffline() : UUID.randomUUID().toString());
        entity.setSyncStatus(dto.getSyncStatus() != null ? dto.getSyncStatus() : "PENDING");
        entity.setOrigin(dto.getOrigin() != null ? dto.getOrigin() : "WEB");

        return entity;
    }

    public List<PlanTerapeuticoDTO> toDTOList(List<PlanTerapeutico> list) {
        if (list == null || list.isEmpty()) return Collections.emptyList();
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
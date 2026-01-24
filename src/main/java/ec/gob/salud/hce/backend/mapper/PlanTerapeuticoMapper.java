package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PlanTerapeuticoDTO;
import ec.gob.salud.hce.backend.entity.PlanTerapeutico;

import java.util.List;

public interface PlanTerapeuticoMapper {
    PlanTerapeuticoDTO toDTO(PlanTerapeutico entity);
    PlanTerapeutico toEntity(PlanTerapeuticoDTO dto);
    List<PlanTerapeuticoDTO> toDTOList(List<PlanTerapeutico> list);
}
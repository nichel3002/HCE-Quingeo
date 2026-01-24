package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HitoDesarrolloDTO;
import ec.gob.salud.hce.backend.entity.HitoDesarrollo;

import java.util.List;

public interface HitoDesarrolloMapper {
    HitoDesarrolloDTO toDTO(HitoDesarrollo entity);
    HitoDesarrollo toEntity(HitoDesarrolloDTO dto);
    List<HitoDesarrolloDTO> toDTOList(List<HitoDesarrollo> list);
}
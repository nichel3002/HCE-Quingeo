package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PielFaneraDTO;
import ec.gob.salud.hce.backend.entity.PielFanera;

import java.util.List;

public interface PielFaneraMapper {
    PielFaneraDTO toDTO(PielFanera entity);
    PielFanera toEntity(PielFaneraDTO dto);
    List<PielFaneraDTO> toDTOList(List<PielFanera> list);
}
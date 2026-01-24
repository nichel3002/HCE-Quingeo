package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.GrupoEtnicoDTO;
import ec.gob.salud.hce.backend.entity.GrupoEtnico;

import java.util.List;

public interface GrupoEtnicoMapper {
    GrupoEtnicoDTO toDTO(GrupoEtnico entity);
    GrupoEtnico toEntity(GrupoEtnicoDTO dto);
    List<GrupoEtnicoDTO> toDTOList(List<GrupoEtnico> list);
}
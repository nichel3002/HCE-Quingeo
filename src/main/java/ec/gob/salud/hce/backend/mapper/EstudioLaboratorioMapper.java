package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.EstudioLaboratorioDTO;
import ec.gob.salud.hce.backend.entity.EstudioLaboratorio;

import java.util.List;

public interface EstudioLaboratorioMapper {
    EstudioLaboratorioDTO toDTO(EstudioLaboratorio entity);
    EstudioLaboratorio toEntity(EstudioLaboratorioDTO dto);
    List<EstudioLaboratorioDTO> toDTOList(List<EstudioLaboratorio> list);
}
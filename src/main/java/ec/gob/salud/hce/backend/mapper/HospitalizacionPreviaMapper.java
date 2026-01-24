package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HospitalizacionPreviaDTO;
import ec.gob.salud.hce.backend.entity.HospitalizacionPrevia;

import java.util.List;


public interface HospitalizacionPreviaMapper {
    HospitalizacionPreviaDTO toDTO(HospitalizacionPrevia entity);
    HospitalizacionPrevia toEntity(HospitalizacionPreviaDTO dto);
    List<HospitalizacionPreviaDTO> toDTOList(List<HospitalizacionPrevia> list);
}
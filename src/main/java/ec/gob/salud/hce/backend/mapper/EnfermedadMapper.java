package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.EnfermedadDTO;
import ec.gob.salud.hce.backend.entity.Enfermedad;

import java.util.List;


public interface EnfermedadMapper {
    EnfermedadDTO toDTO(Enfermedad entity);
    Enfermedad toEntity(EnfermedadDTO dto);
    List<EnfermedadDTO> toDTOList(List<Enfermedad> list);
}
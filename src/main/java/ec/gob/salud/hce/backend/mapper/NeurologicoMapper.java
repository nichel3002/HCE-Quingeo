package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.NeurologicoDTO;
import ec.gob.salud.hce.backend.entity.Neurologico;

import java.util.List;

public interface NeurologicoMapper {
    NeurologicoDTO toDTO(Neurologico entity);
    Neurologico toEntity(NeurologicoDTO dto);
    List<NeurologicoDTO> toDTOList(List<Neurologico> list);
}
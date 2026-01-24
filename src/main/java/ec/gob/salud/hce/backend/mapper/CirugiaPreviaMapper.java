package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.CirugiaPreviaDTO;
import ec.gob.salud.hce.backend.entity.CirugiaPrevia;
import java.util.List;
import java.util.stream.Collectors;

public class CirugiaPreviaMapper {

    public static CirugiaPreviaDTO toDto(CirugiaPrevia entity) {
        if (entity == null) return null;
        CirugiaPreviaDTO dto = new CirugiaPreviaDTO();
        dto.setIdCirugiaPrevia(entity.getIdCirugiaPrevia());
        dto.setTipo(entity.getTipo());
        dto.setFecha(entity.getFecha());
        dto.setIdAntecedentePatologicoPersonal(entity.getIdAntecedentePatologicoPersonal());
        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());
        return dto;
    }

    public static CirugiaPrevia toEntity(CirugiaPreviaDTO dto) {
        if (dto == null) return null;
        CirugiaPrevia entity = new CirugiaPrevia();
        entity.setTipo(dto.getTipo());
        entity.setFecha(dto.getFecha());
        entity.setIdAntecedentePatologicoPersonal(dto.getIdAntecedentePatologicoPersonal());
        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setOrigin(dto.getOrigin());
        return entity;
    }

    public static List<CirugiaPreviaDTO> toDtoList(List<CirugiaPrevia> entities) {
        return entities.stream().map(CirugiaPreviaMapper::toDto).collect(Collectors.toList());
    }
}
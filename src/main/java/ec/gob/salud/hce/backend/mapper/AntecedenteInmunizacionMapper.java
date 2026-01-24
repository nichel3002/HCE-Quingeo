package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.AntecedenteInmunizacionDTO;
import ec.gob.salud.hce.backend.entity.AntecedenteInmunizacion;
import java.util.List;
import java.util.stream.Collectors;

public class AntecedenteInmunizacionMapper {

    public static AntecedenteInmunizacionDTO toDto(AntecedenteInmunizacion entity) {
        if (entity == null) return null;
        AntecedenteInmunizacionDTO dto = new AntecedenteInmunizacionDTO();
        dto.setIdAntecedenteInmunizacion(entity.getIdAntecedenteInmunizacion());
        dto.setEstadoVacunacion(entity.getEstadoVacunacion());
        dto.setFechaVacunacion(entity.getFechaVacunacion());
        dto.setDescripcion(entity.getDescripcion());
        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());
        dto.setIdAntecedentePerinatal(entity.getIdAntecedentePerinatal());
        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());
        return dto;
    }

    public static AntecedenteInmunizacion toEntity(AntecedenteInmunizacionDTO dto) {
        if (dto == null) return null;
        AntecedenteInmunizacion entity = new AntecedenteInmunizacion();
        entity.setEstadoVacunacion(dto.getEstadoVacunacion());
        entity.setFechaVacunacion(dto.getFechaVacunacion());
        entity.setDescripcion(dto.getDescripcion());
        entity.setIdHistoriaClinica(dto.getIdHistoriaClinica());
        entity.setIdAntecedentePerinatal(dto.getIdAntecedentePerinatal());
        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setOrigin(dto.getOrigin());
        return entity;
    }

    public static List<AntecedenteInmunizacionDTO> toDtoList(List<AntecedenteInmunizacion> entities) {
        return entities.stream().map(AntecedenteInmunizacionMapper::toDto).collect(Collectors.toList());
    }
}
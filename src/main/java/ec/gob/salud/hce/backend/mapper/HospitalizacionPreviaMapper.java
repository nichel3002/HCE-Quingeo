package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HospitalizacionPreviaDTO;
import ec.gob.salud.hce.backend.entity.AntecedentePatologicoPersonal;
import ec.gob.salud.hce.backend.entity.HospitalizacionPrevia;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class HospitalizacionPreviaMapper {

    public HospitalizacionPreviaDTO toDTO(HospitalizacionPrevia entity) {
        if (entity == null) return null;

        HospitalizacionPreviaDTO dto = new HospitalizacionPreviaDTO();
        dto.setIdHospitalizacionPrevia(entity.getIdHospitalizacionPrevia());
        dto.setCausa(entity.getCausa());
        dto.setFecha(entity.getFecha());

        // Mapeo seguro de la relación
        if (entity.getAntecedentePatologicoPersonal() != null) {
            dto.setIdAntecedentePatologicoPersonal(entity.getAntecedentePatologicoPersonal().getIdAntecedentePatologicoPersonal());
        }

        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public HospitalizacionPrevia toEntity(HospitalizacionPreviaDTO dto) {
        if (dto == null) return null;

        HospitalizacionPrevia entity = new HospitalizacionPrevia();
        entity.setIdHospitalizacionPrevia(dto.getIdHospitalizacionPrevia());
        entity.setCausa(dto.getCausa());
        entity.setFecha(dto.getFecha());

        // Creación del Proxy para la relación
        if (dto.getIdAntecedentePatologicoPersonal() != null) {
            AntecedentePatologicoPersonal app = new AntecedentePatologicoPersonal();
            app.setIdAntecedentePatologicoPersonal(dto.getIdAntecedentePatologicoPersonal());
            entity.setAntecedentePatologicoPersonal(app);
        }

        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setUuidOffline(dto.getUuidOffline() != null ? dto.getUuidOffline() : UUID.randomUUID().toString());
        entity.setSyncStatus(dto.getSyncStatus() != null ? dto.getSyncStatus() : "PENDING");
        entity.setOrigin(dto.getOrigin() != null ? dto.getOrigin() : "WEB");

        return entity;
    }

    public List<HospitalizacionPreviaDTO> toDTOList(List<HospitalizacionPrevia> list) {
        if (list == null || list.isEmpty()) return Collections.emptyList();
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
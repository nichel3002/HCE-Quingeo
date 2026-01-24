package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.EstudioLaboratorioDTO;
import ec.gob.salud.hce.backend.entity.Consulta;
import ec.gob.salud.hce.backend.entity.EstudioLaboratorio;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstudioLaboratorioMapper {

    public EstudioLaboratorioDTO toDTO(EstudioLaboratorio entity) {
        if (entity == null) return null;

        EstudioLaboratorioDTO dto = new EstudioLaboratorioDTO();
        dto.setIdEstudioLaboratorio(entity.getIdEstudioLaboratorio());
        dto.setSolicitados(entity.getSolicitados());
        dto.setResultadosRelevantes(entity.getResultadosRelevantes());
        dto.setFecha(entity.getFecha());
        
        // Mapeo seguro de la relación
        if (entity.getConsulta() != null) {
            dto.setIdConsulta(entity.getConsulta().getIdConsulta());
        }

        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }

    public EstudioLaboratorio toEntity(EstudioLaboratorioDTO dto) {
        if (dto == null) return null;

        EstudioLaboratorio entity = new EstudioLaboratorio();
        entity.setIdEstudioLaboratorio(dto.getIdEstudioLaboratorio());
        entity.setSolicitados(dto.getSolicitados());
        entity.setResultadosRelevantes(dto.getResultadosRelevantes());
        entity.setFecha(dto.getFecha());

        // Proxy para la relación con Consulta
        if (dto.getIdConsulta() != null) {
            Consulta c = new Consulta();
            c.setIdConsulta(dto.getIdConsulta());
            entity.setConsulta(c);
        }

        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setUuidOffline(dto.getUuidOffline());
        entity.setSyncStatus(dto.getSyncStatus());
        entity.setOrigin(dto.getOrigin());
        // lastModified se gestiona en PrePersist/PreUpdate

        return entity;
    }

    public List<EstudioLaboratorioDTO> toDTOList(List<EstudioLaboratorio> list) {
        if (list == null || list.isEmpty()) return Collections.emptyList();
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
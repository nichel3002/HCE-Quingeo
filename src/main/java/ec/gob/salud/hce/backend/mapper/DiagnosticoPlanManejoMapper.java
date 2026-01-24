package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.DiagnosticoPlanManejoDTO;
import ec.gob.salud.hce.backend.entity.DiagnosticoPlanManejo;

import java.util.List;

public interface DiagnosticoPlanManejoMapper {
    DiagnosticoPlanManejoDTO toDTO(DiagnosticoPlanManejo entity);
    DiagnosticoPlanManejo toEntity(DiagnosticoPlanManejoDTO dto);
    List<DiagnosticoPlanManejoDTO> toDTOList(List<DiagnosticoPlanManejo> list);
}
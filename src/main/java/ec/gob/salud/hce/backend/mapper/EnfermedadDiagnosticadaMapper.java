package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.EnfermedadDiagnosticadaDTO;
import ec.gob.salud.hce.backend.entity.EnfermedadDiagnosticada;

import java.util.List;

public interface EnfermedadDiagnosticadaMapper {
    EnfermedadDiagnosticadaDTO toDTO(EnfermedadDiagnosticada entity);
    EnfermedadDiagnosticada toEntity(EnfermedadDiagnosticadaDTO dto);
    List<EnfermedadDiagnosticadaDTO> toDTOList(List<EnfermedadDiagnosticada> list);
}
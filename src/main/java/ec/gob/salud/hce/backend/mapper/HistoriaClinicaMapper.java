package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class HistoriaClinicaMapper {

    public HistoriaClinica toEntity(HistoriaClinicaRequestDTO dto, Paciente paciente) {
        if (dto == null) return null;

        HistoriaClinica entity = new HistoriaClinica();
        entity.setPaciente(paciente);
        
        // Campo nuevo detectado en tu MySQL
        entity.setIdDiagnosticoPlanManejo(dto.getIdDiagnosticoPlanManejo());
        
        entity.setUsuario(dto.getUsuario());
        entity.setOrigin(dto.getOrigin() != null ? dto.getOrigin() : "WEB");
        entity.setSyncStatus(dto.getSyncStatus() != null ? dto.getSyncStatus() : "PENDING");
        
        // UUID automático si no viene en el DTO
        entity.setUuidOffline(dto.getUuidOffline() != null ? 
                             dto.getUuidOffline() : java.util.UUID.randomUUID().toString());

        return entity;
    }

    public HistoriaClinicaResponseDTO toResponse(HistoriaClinica entity) {
        if (entity == null) return null;

        HistoriaClinicaResponseDTO dto = new HistoriaClinicaResponseDTO();
        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());
        
        // Mapeo seguro del ID del Paciente
        if (entity.getPaciente() != null) {
            dto.setIdPaciente(entity.getPaciente().getIdPaciente().longValue());
        }

        dto.setIdDiagnosticoPlanManejo(entity.getIdDiagnosticoPlanManejo());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuario(entity.getUsuario());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }
}
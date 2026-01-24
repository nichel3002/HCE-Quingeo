package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.DiagnosticoPlanManejo;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.entity.Paciente;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HistoriaClinicaMapper {

    public HistoriaClinica toEntity(HistoriaClinicaRequestDTO dto, Paciente paciente) {
        if (dto == null) return null;

        HistoriaClinica entity = new HistoriaClinica();
        
        entity.setPaciente(paciente);
        
        if (dto.getIdDiagnosticoPlanManejo() != null) {
            DiagnosticoPlanManejo dpm = new DiagnosticoPlanManejo();
            dpm.setIdDiagnosticoPlanManejo(dto.getIdDiagnosticoPlanManejo());
            entity.setDiagnosticoPlanManejo(dpm);
        }
        
        entity.setUsuario(dto.getUsuario());
        entity.setOrigin(dto.getOrigin() != null ? dto.getOrigin() : "WEB");
        entity.setSyncStatus(dto.getSyncStatus() != null ? dto.getSyncStatus() : "PENDING");
        
        if (dto.getUuidOffline() != null) {
            entity.setUuidOffline(dto.getUuidOffline());
        } else {
            entity.setUuidOffline(UUID.randomUUID().toString());
        }

        return entity;
    }

    public HistoriaClinicaResponseDTO toResponse(HistoriaClinica entity) {
        if (entity == null) return null;

        HistoriaClinicaResponseDTO dto = new HistoriaClinicaResponseDTO();
        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());
        
        // CORRECCIÓN AQUÍ: Convertir Integer a Long
        if (entity.getPaciente() != null && entity.getPaciente().getIdPaciente() != null) {
            dto.setIdPaciente(entity.getPaciente().getIdPaciente().longValue()); 
        }

        if (entity.getDiagnosticoPlanManejo() != null) {
            dto.setIdDiagnosticoPlanManejo(entity.getDiagnosticoPlanManejo().getIdDiagnosticoPlanManejo());
        }

        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuario(entity.getUsuario());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }
}
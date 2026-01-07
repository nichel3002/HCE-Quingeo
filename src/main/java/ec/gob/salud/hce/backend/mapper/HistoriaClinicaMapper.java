package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class HistoriaClinicaMapper {

    public HistoriaClinica toEntity(HistoriaClinicaRequestDTO dto, Paciente paciente) {

        HistoriaClinica entity = new HistoriaClinica();

        entity.setPaciente(paciente);
        entity.setUsuario(dto.getUsuario());
        entity.setUuidOffline(dto.getUuidOffline());
        entity.setSyncStatus(dto.getSyncStatus());
        entity.setOrigin(dto.getOrigin());

        return entity;
    }

    public HistoriaClinicaResponseDTO toResponse(HistoriaClinica entity) {

        HistoriaClinicaResponseDTO dto = new HistoriaClinicaResponseDTO();

        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());
        dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuario(entity.getUsuario());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());

        return dto;
    }
}

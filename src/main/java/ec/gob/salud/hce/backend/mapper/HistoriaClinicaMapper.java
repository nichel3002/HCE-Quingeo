package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.entity.Paciente;

public class HistoriaClinicaMapper {

    private HistoriaClinicaMapper() {
        // Evita instancias
    }

    public static HistoriaClinica toEntity(HistoriaClinicaRequestDTO dto) {
        if (dto == null) return null;

        HistoriaClinica hc = new HistoriaClinica();

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(dto.getIdPaciente());
        hc.setPaciente(paciente);

        hc.setUsuario(dto.getUsuario());
        hc.setUuidOffline(dto.getUuidOffline());
        hc.setSyncStatus(dto.getSyncStatus());
        hc.setOrigin(dto.getOrigin());

        return hc;
    }

    public static HistoriaClinicaResponseDTO toResponse(HistoriaClinica entity) {
        if (entity == null) return null;

        return new HistoriaClinicaResponseDTO(
                entity.getIdHistoriaClinica(),
                entity.getPaciente().getIdPaciente(),
                entity.getFechaCreacion(),
                entity.getUsuario(),
                entity.getUuidOffline(),
                entity.getSyncStatus(),
                entity.getLastModified(),
                entity.getOrigin()
        );
    }
}

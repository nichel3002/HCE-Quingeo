package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;

public class HistoriaClinicaMapper {

    private HistoriaClinicaMapper() {}

    public static HistoriaClinicaResponseDTO toResponse(HistoriaClinica entity) {
        return HistoriaClinicaResponseDTO.builder()
                .idHistoriaClinica(entity.getIdHistoriaClinica())
                .idPaciente(entity.getPaciente().getIdPaciente())
                .fechaCreacion(entity.getFechaCreacion())
                .usuario(entity.getUsuario())
                .uuidOffline(entity.getUuidOffline())
                .syncStatus(entity.getSyncStatus())
                .lastModified(entity.getLastModified())
                .origin(entity.getOrigin())
                .build();
    }
}

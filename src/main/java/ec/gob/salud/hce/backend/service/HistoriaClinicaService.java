package ec.gob.salud.hce.backend.service;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;

public interface HistoriaClinicaService {

    HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto);

    HistoriaClinicaResponseDTO obtenerPorPaciente(Long idPaciente);
}

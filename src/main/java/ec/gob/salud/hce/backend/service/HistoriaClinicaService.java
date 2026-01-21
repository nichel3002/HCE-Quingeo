package ec.gob.salud.hce.backend.service;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import java.util.List;

public interface HistoriaClinicaService {
    HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto);
    List<HistoriaClinicaResponseDTO> listarTodas();
    HistoriaClinicaResponseDTO obtenerPorId(Long id);
    List<HistoriaClinicaResponseDTO> obtenerPorPaciente(Long idPaciente);
}
package ec.gob.salud.hce.backend.service;

import org.springframework.stereotype.Service;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;

@Service
public interface HistoriaClinicaService {

    HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto);

    HistoriaClinicaResponseDTO obtenerPorId(Long idHistoriaClinica);

    HistoriaClinicaResponseDTO obtenerPorPaciente(Long idPaciente);
}

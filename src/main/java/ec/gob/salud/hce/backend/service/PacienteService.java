package ec.gob.salud.hce.backend.service;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;

public interface PacienteService {

    PacienteResponseDTO crearPaciente(PacienteRequestDTO dto);
}

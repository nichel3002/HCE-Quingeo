package ec.gob.salud.hce.backend.service;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface PacienteService {

    PacienteResponseDTO crearPaciente(PacienteRequestDTO request);

    PacienteResponseDTO obtenerPorId(Long id);

    List<PacienteResponseDTO> listarTodos();
}

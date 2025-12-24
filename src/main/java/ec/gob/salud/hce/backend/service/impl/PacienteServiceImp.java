package ec.gob.salud.hce.backend.service.impl;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.Paciente;
import ec.gob.salud.hce.backend.mapper.PacienteMapper;
import ec.gob.salud.hce.backend.repository.PacienteRepository;
import ec.gob.salud.hce.backend.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteServiceImp implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public PacienteResponseDTO crearPaciente(PacienteRequestDTO request) {
        Paciente paciente = PacienteMapper.toEntity(request);
        Paciente guardado = pacienteRepository.save(paciente);
        return PacienteMapper.toResponse(guardado);
    }

    @Override
    public PacienteResponseDTO obtenerPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return PacienteMapper.toResponse(paciente);
    }

    @Override
    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toResponse)
                .collect(Collectors.toList());
    }
}

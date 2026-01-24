package ec.gob.salud.hce.backend.service.impl;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.Paciente;
import ec.gob.salud.hce.backend.mapper.PacienteMapper;
import ec.gob.salud.hce.backend.repository.PacienteRepository;
import ec.gob.salud.hce.backend.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteServiceImp implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    @Transactional
    public PacienteResponseDTO crearPaciente(PacienteRequestDTO request) {
        // Usamos la instancia inyectada del mapper
        Paciente paciente = pacienteMapper.toEntity(request);
        Paciente guardado = pacienteRepository.save(paciente);
        return pacienteMapper.toResponse(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteResponseDTO obtenerPorId(Integer id) {
        // El repositorio ahora espera Integer, igual que el parámetro. Coincidencia perfecta.
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return pacienteMapper.toResponse(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toResponse) // Referencia a método de instancia
                .collect(Collectors.toList());
    }
}
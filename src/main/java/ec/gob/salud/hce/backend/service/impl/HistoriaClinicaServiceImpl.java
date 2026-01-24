package ec.gob.salud.hce.backend.service.impl;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.entity.Paciente;
import ec.gob.salud.hce.backend.mapper.HistoriaClinicaMapper;
import ec.gob.salud.hce.backend.repository.HistoriaClinicaRepository;
import ec.gob.salud.hce.backend.repository.PacienteRepository;
import ec.gob.salud.hce.backend.service.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository repository;
    private final PacienteRepository pacienteRepository;
    private final HistoriaClinicaMapper mapper;

    @Override
    @Transactional
    public HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto) {
        // CORRECCIÓN 1: Casteo explícito de Long (DTO) a Integer (Entity)
        // Usamos .intValue() para satisfacer al repositorio de Paciente
        Integer idPaciente = (dto.getIdPaciente() != null) ? dto.getIdPaciente().intValue() : null;

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        HistoriaClinica entity = mapper.toEntity(dto, paciente);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoriaClinicaResponseDTO> listarTodas() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public HistoriaClinicaResponseDTO obtenerPorId(Long id) {
        HistoriaClinica entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia no encontrada"));
        return mapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoriaClinicaResponseDTO> obtenerPorPaciente(Long idPaciente) {
        // CORRECCIÓN 2: Casteo explícito aquí también
        // Si el repositorio de Historia busca por "paciente.idPaciente" (Integer), debemos pasarle Integer
        return repository.findByPacienteIdPaciente(idPaciente != null ? idPaciente.intValue() : null).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
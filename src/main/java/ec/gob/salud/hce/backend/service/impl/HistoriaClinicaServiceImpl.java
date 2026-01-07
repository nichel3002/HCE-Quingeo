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

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;
    private final PacienteRepository pacienteRepository;
    private final HistoriaClinicaMapper historiaClinicaMapper;

    @Override
    public HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto) {

        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        HistoriaClinica entity = historiaClinicaMapper.toEntity(dto, paciente);

        return historiaClinicaMapper.toResponse(
                historiaClinicaRepository.save(entity)
        );
    }

    @Override
    public HistoriaClinicaResponseDTO obtenerPorId(Long idHistoriaClinica) {

        HistoriaClinica historia = historiaClinicaRepository.findById(idHistoriaClinica)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));

        return historiaClinicaMapper.toResponse(historia);
    }

    @Override
    public HistoriaClinicaResponseDTO obtenerPorPaciente(Long idPaciente) {

        HistoriaClinica historia = historiaClinicaRepository
                .findByPacienteIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente sin historia clínica"));

        return historiaClinicaMapper.toResponse(historia);
    }
}

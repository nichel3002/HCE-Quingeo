package ec.gob.salud.hce.backend.service.impl;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import ec.gob.salud.hce.backend.mapper.HistoriaClinicaMapper;
import ec.gob.salud.hce.backend.repository.HistoriaClinicaRepository;
import ec.gob.salud.hce.backend.service.HistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository HistoriaClinicaRepository;
    private final HistoriaClinicaMapper HistoriaClinicaMapper;

    @Override
    public HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto) {
        HistoriaClinica entity = HistoriaClinicaMapper.toEntity(dto);
        return HistoriaClinicaMapper.toResponse(
                HistoriaClinicaRepository.save(entity)
        );
    }

    @Override
    public HistoriaClinicaResponseDTO obtenerPorId(Long idHistoriaClinica) {
        HistoriaClinica historia = HistoriaClinicaRepository.findById(idHistoriaClinica)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));

        return HistoriaClinicaMapper.toResponse(historia);
    }

    @Override
    public HistoriaClinicaResponseDTO obtenerPorPaciente(Long idPaciente) {
        HistoriaClinica historia = HistoriaClinicaRepository.findByPacienteIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente sin historia clínica"));

        return HistoriaClinicaMapper.toResponse(historia);
    }
}

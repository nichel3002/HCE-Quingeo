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

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaRepo;
    private final PacienteRepository pacienteRepo;

    @Override
    public HistoriaClinicaResponseDTO crearHistoriaClinica(HistoriaClinicaRequestDTO dto) {

        Paciente paciente = pacienteRepo.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        historiaRepo.findByPacienteIdPaciente(paciente.getIdPaciente())
                .ifPresent(h -> {
                    throw new RuntimeException("El paciente ya tiene historia clínica");
                });

        HistoriaClinica historia = HistoriaClinica.builder()
                .paciente(paciente)
                .fechaCreacion(LocalDateTime.now())
                .usuario(dto.getUsuario())
                .uuidOffline(dto.getUuidOffline())
                .syncStatus(dto.getSyncStatus())
                .origin(dto.getOrigin())
                .lastModified(LocalDateTime.now())
                .build();

        return HistoriaClinicaMapper.toResponse(historiaRepo.save(historia));
    }

    @Override
    public HistoriaClinicaResponseDTO obtenerPorPaciente(Long idPaciente) {
        return historiaRepo.findByPacienteIdPaciente(idPaciente)
                .map(HistoriaClinicaMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada"));
    }
}

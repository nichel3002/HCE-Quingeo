package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoriaClinicaRepository
        extends JpaRepository<HistoriaClinica, Long> {

    Optional<HistoriaClinica> findByPacienteIdPaciente(Long idPaciente);
}

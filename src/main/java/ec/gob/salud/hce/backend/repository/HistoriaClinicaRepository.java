package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    // Busca todas las historias que pertenezcan a un paciente específico
    List<HistoriaClinica> findByPacienteIdPaciente(Integer idPaciente);
}
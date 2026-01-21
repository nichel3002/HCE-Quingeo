package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.AlergiaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlergiaPacienteRepository extends JpaRepository<AlergiaPaciente, Integer> {
    // Método útil para buscar todas las alergias de un paciente específico
    List<AlergiaPaciente> findByIdPaciente(Integer idPaciente);
}
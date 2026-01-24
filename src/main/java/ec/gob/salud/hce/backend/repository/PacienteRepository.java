package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
    // Método auxiliar para buscar por UUID (utilizado en sincronización)
    Optional<Paciente> findByUuidOffline(String uuidOffline);
}   
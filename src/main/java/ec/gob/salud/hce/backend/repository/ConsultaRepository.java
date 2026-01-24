package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    // Para ver el historial de consultas de un paciente
    List<Consulta> findByIdHistoriaClinica(Integer idHistoriaClinica);
}
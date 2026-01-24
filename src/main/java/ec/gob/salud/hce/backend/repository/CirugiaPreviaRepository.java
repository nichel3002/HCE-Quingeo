package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.CirugiaPrevia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CirugiaPreviaRepository extends JpaRepository<CirugiaPrevia, Integer> {
    // Buscar todas las cirugías relacionadas a un antecedente patológico específico
    List<CirugiaPrevia> findByIdAntecedentePatologicoPersonal(Integer idAntecedente);
}
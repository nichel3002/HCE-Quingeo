package ec.gob.salud.hce.backend.repository;

import ec.gob.salud.hce.backend.entity.DesarrolloPsicomotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DesarrolloPsicomotorRepository extends JpaRepository<DesarrolloPsicomotor, Integer> {
    List<DesarrolloPsicomotor> findByIdHistoriaClinica(Integer idHistoriaClinica);
}
package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.ExamenFisicoDTO;
import ec.gob.salud.hce.backend.entity.ExamenFisico;
import ec.gob.salud.hce.backend.mapper.ExamenFisicoMapper;
import ec.gob.salud.hce.backend.repository.ExamenFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/examen-fisico")
public class ExamenFisicoController {

    @Autowired
    private ExamenFisicoRepository examenFisicoRepository;

    @PostMapping
    public ResponseEntity<ExamenFisicoDTO> create(@RequestBody ExamenFisicoDTO dto) {
        // Aquí convertirías el DTO a Entidad
        ExamenFisico entity = new ExamenFisico();
        entity.setIdHistoriaClinica(dto.getIdHistoriaClinica());
        entity.setIdExamenFisicoSegmentario(dto.getIdExamenFisicoSegmentario());
        // La unión se hace asignando los IDs o el objeto completo
        
        ExamenFisico guardado = examenFisicoRepository.save(entity);
        return ResponseEntity.ok(ExamenFisicoMapper.toDto(guardado));
    }
}
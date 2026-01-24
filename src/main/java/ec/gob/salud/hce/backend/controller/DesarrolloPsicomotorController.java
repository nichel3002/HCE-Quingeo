package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.DesarrolloPsicomotorDTO;
import ec.gob.salud.hce.backend.entity.DesarrolloPsicomotor;
import ec.gob.salud.hce.backend.mapper.DesarrolloPsicomotorMapper;
import ec.gob.salud.hce.backend.repository.DesarrolloPsicomotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desarrollo-psicomotor")
public class DesarrolloPsicomotorController {

    @Autowired
    private DesarrolloPsicomotorRepository repository;

    @GetMapping
    public List<DesarrolloPsicomotorDTO> getAll() {
        return DesarrolloPsicomotorMapper.toDtoList(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<DesarrolloPsicomotorDTO> create(@RequestBody DesarrolloPsicomotorDTO dto) {
        DesarrolloPsicomotor entity = DesarrolloPsicomotorMapper.toEntity(dto);
        DesarrolloPsicomotor guardado = repository.save(entity);
        return ResponseEntity.ok(DesarrolloPsicomotorMapper.toDto(guardado));
    }

    @GetMapping("/historia/{idHistoria}")
    public List<DesarrolloPsicomotorDTO> getByHistoria(@PathVariable Integer idHistoria) {
        return DesarrolloPsicomotorMapper.toDtoList(repository.findByIdHistoriaClinica(idHistoria));
    }
}
package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.ConsultaDTO;
import ec.gob.salud.hce.backend.entity.Consulta;
import ec.gob.salud.hce.backend.mapper.ConsultaMapper;
import ec.gob.salud.hce.backend.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @GetMapping
    public List<ConsultaDTO> getAll() {
        return ConsultaMapper.toDtoList(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> create(@RequestBody ConsultaDTO dto) {
        Consulta entity = ConsultaMapper.toEntity(dto);
        Consulta guardado = repository.save(entity);
        return ResponseEntity.ok(ConsultaMapper.toDto(guardado));
    }

    @GetMapping("/historia/{idHistoria}")
    public List<ConsultaDTO> getByHistoria(@PathVariable Integer idHistoria) {
        return ConsultaMapper.toDtoList(repository.findByIdHistoriaClinica(idHistoria));
    }
}
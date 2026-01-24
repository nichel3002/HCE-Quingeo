package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.HospitalizacionPreviaDTO;
import ec.gob.salud.hce.backend.mapper.HospitalizacionPreviaMapper;
import ec.gob.salud.hce.backend.repository.HospitalizacionPreviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitalizaciones-previas")
public class HospitalizacionPreviaController {

    @Autowired
    private HospitalizacionPreviaRepository repository;

    @Autowired
    private HospitalizacionPreviaMapper mapper;

    @GetMapping
    public List<HospitalizacionPreviaDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @PostMapping
    public HospitalizacionPreviaDTO create(@RequestBody HospitalizacionPreviaDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
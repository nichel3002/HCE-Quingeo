package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.GrupoEtnicoDTO;
import ec.gob.salud.hce.backend.mapper.GrupoEtnicoMapper;
import ec.gob.salud.hce.backend.repository.GrupoEtnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grupos-etnicos")
public class GrupoEtnicoController {

    @Autowired
    private GrupoEtnicoRepository repository;

    @Autowired
    private GrupoEtnicoMapper mapper;

    @GetMapping
    public List<GrupoEtnicoDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @PostMapping
    public GrupoEtnicoDTO create(@RequestBody GrupoEtnicoDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
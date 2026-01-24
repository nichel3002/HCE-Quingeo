package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.AntecedenteInmunizacionDTO;
import ec.gob.salud.hce.backend.entity.AntecedenteInmunizacion;
import ec.gob.salud.hce.backend.mapper.AntecedenteInmunizacionMapper;
import ec.gob.salud.hce.backend.repository.AntecedenteInmunizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedentes-inmunizacion")
public class AntecedenteInmunizacionController {

    @Autowired
    private AntecedenteInmunizacionRepository repository;

    @GetMapping
    public List<AntecedenteInmunizacionDTO> getAll() {
        return AntecedenteInmunizacionMapper.toDtoList(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<AntecedenteInmunizacionDTO> create(@RequestBody AntecedenteInmunizacionDTO dto) {
        AntecedenteInmunizacion entity = new AntecedenteInmunizacion();

        // Mapeo manual detallado
        entity.setEstadoVacunacion(dto.getEstadoVacunacion());
        entity.setFechaVacunacion(dto.getFechaVacunacion());
        entity.setDescripcion(dto.getDescripcion());
        entity.setIdHistoriaClinica(dto.getIdHistoriaClinica());
        entity.setIdAntecedentePerinatal(dto.getIdAntecedentePerinatal());
        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setOrigin(dto.getOrigin());

        if (dto.getUuidOffline() != null) {
            entity.setUuidOffline(dto.getUuidOffline());
        }

        AntecedenteInmunizacion guardado = repository.save(entity);
        return ResponseEntity.ok(AntecedenteInmunizacionMapper.toDto(guardado));
    }
}
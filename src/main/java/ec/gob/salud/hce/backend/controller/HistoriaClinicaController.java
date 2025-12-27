package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.HistoriaClinicaRequestDTO;
import ec.gob.salud.hce.backend.dto.HistoriaClinicaResponseDTO;
import ec.gob.salud.hce.backend.service.HistoriaClinicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historias-clinicas")
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    /**
     * Crear historia clínica para un paciente
     */
    @PostMapping
    public ResponseEntity<HistoriaClinicaResponseDTO> crearHistoriaClinica(
            @Valid @RequestBody HistoriaClinicaRequestDTO dto) {

        return new ResponseEntity<>(
                historiaClinicaService.crearHistoriaClinica(dto),
                HttpStatus.CREATED
        );
    }

    /**
     * Obtener historia clínica por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinicaResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                historiaClinicaService.obtenerPorId(id)
        );
    }

    /**
     * Obtener historia clínica por paciente
     */
    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<HistoriaClinicaResponseDTO> obtenerPorPaciente(
            @PathVariable Long idPaciente) {

        return ResponseEntity.ok(
                historiaClinicaService.obtenerPorPaciente(idPaciente)
        );
    }
}

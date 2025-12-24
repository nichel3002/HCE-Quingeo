package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    // Crear paciente
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> crear(
            @Valid @RequestBody PacienteRequestDTO request) {

        PacienteResponseDTO response = pacienteService.crearPaciente(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Obtener paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.obtenerPorId(id));
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }
}

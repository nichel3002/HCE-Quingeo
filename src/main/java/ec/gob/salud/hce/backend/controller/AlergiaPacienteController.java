package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.entity.AlergiaPaciente;
import ec.gob.salud.hce.backend.repository.AlergiaPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alergias-pacientes")
public class AlergiaPacienteController {

    @Autowired
    private AlergiaPacienteRepository repository;

    @GetMapping
    public List<AlergiaPaciente> listarTodo() {
        return repository.findAll();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<AlergiaPaciente> listarPorPaciente(@PathVariable Integer idPaciente) {
        // CORRECCIÓN: Se cambió findByIdPaciente por findByPaciente_IdPaciente
        return repository.findByPaciente_IdPaciente(idPaciente);
    }

    @PostMapping
    public AlergiaPaciente guardar(@RequestBody AlergiaPaciente alergiaPaciente) {
        return repository.save(alergiaPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return repository.findById(id)
                .map(a -> {
                    repository.delete(a);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
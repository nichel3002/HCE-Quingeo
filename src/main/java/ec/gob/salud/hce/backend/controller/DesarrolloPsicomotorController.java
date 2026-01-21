package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.entity.DesarrolloPsicomotor;
import ec.gob.salud.hce.backend.repository.DesarrolloPsicomotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desarrollos-psicomotores")
@CrossOrigin(origins = "*") // Permite peticiones desde el frontend
public class DesarrolloPsicomotorController {

    @Autowired
    private DesarrolloPsicomotorRepository repository;

    // 1. Obtener todos los registros
    @GetMapping
    public List<DesarrolloPsicomotor> listarTodos() {
        return repository.findAll();
    }

    // 2. Obtener hitos del desarrollo de un paciente específico
    @GetMapping("/paciente/{idPaciente}")
    public List<DesarrolloPsicomotor> listarPorPaciente(@PathVariable Integer idPaciente) {
        return repository.findByPacienteIdPaciente(idPaciente);
    }

    // 3. Obtener un registro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DesarrolloPsicomotor> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Crear un nuevo registro
    @PostMapping
    public ResponseEntity<DesarrolloPsicomotor> crear(@RequestBody DesarrolloPsicomotor desarrollo) {
        // Al guardar, el @PrePersist de la entidad llenará automáticamente 
        // uuid_offline, last_modified, sync_status y origin si vienen nulos.
        DesarrolloPsicomotor nuevo = repository.save(desarrollo);
        return ResponseEntity.ok(nuevo);
    }

    // 5. Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<DesarrolloPsicomotor> actualizar(@PathVariable Integer id, @RequestBody DesarrolloPsicomotor detalles) {
        return repository.findById(id)
                .map(desarrollo -> {
                    desarrollo.setSostenCefalo(detalles.getSostenCefalo());
                    desarrollo.setSedestacion(detalles.getSedestacion());
                    desarrollo.setDeambulacion(detalles.getDeambulacion());
                    desarrollo.setLenguaje(detalles.getLenguaje());
                    desarrollo.setObservacion(detalles.getObservacion());
                    desarrollo.setSyncStatus("UPDATED"); // Cambiamos estado para sincronización
                    return ResponseEntity.ok(repository.save(desarrollo));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
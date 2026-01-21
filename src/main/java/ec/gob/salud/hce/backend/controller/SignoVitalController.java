package ec.gob.salud.hce.backend.controller;

import ec.gob.salud.hce.backend.dto.SignoVitalDTO;
import ec.gob.salud.hce.backend.entity.SignoVital;
import ec.gob.salud.hce.backend.mapper.SignoVitalMapper;
import ec.gob.salud.hce.backend.repository.SignoVitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signos-vitales")
public class SignoVitalController {

    @Autowired
    private SignoVitalRepository signoVitalRepository;

    @PostMapping
    public ResponseEntity<SignoVitalDTO> create(@RequestBody SignoVitalDTO dto) {
        SignoVital entity = SignoVitalMapper.toEntity(dto);
        
        // Lógica de cálculo de IMC: peso (kg) / talla^2 (m)
        calcularYSetearIMC(entity);
        
        SignoVital guardado = signoVitalRepository.save(entity);
        return ResponseEntity.ok(SignoVitalMapper.toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignoVitalDTO> update(@PathVariable Integer id, @RequestBody SignoVitalDTO dto) {
        return signoVitalRepository.findById(id).map(entity -> {
            // Actualizar campos desde DTO
            SignoVital actualizado = SignoVitalMapper.toEntity(dto);
            actualizado.setIdSignoVital(id); // Aseguramos el ID del path
            
            calcularYSetearIMC(actualizado);
            
            SignoVital finalGuardado = signoVitalRepository.save(actualizado);
            return ResponseEntity.ok(SignoVitalMapper.toDto(finalGuardado));
        }).orElse(ResponseEntity.notFound().build());
    }

    private void calcularYSetearIMC(SignoVital entity) {
        if (entity.getPeso() != null && entity.getTallaLongitud() != null && entity.getTallaLongitud() > 0) {
            // Asumiendo que talla viene en metros (ej: 1.70)
            double imc = entity.getPeso() / Math.pow(entity.getTallaLongitud(), 2);
            // Redondear a 2 decimales
            entity.setImc(Math.round(imc * 100.0) / 100.0);
        }
    }
}
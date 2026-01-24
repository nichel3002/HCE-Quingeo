package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.PacienteRequestDTO;
import ec.gob.salud.hce.backend.dto.PacienteResponseDTO;
import ec.gob.salud.hce.backend.entity.DiagnosticoPlanManejo;
import ec.gob.salud.hce.backend.entity.GrupoEtnico;
import ec.gob.salud.hce.backend.entity.Paciente;
import ec.gob.salud.hce.backend.entity.Parroquia;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;

@Component
public class PacienteMapper {

    // Método para convertir de DTO (Request) a Entidad (Base de Datos)
    public Paciente toEntity(PacienteRequestDTO dto) {
        if (dto == null) return null;

        Paciente entity = new Paciente();

        // 1. Mapeo de campos simples
        entity.setIdPaciente(dto.getIdPaciente());
        entity.setPrimerNombre(dto.getPrimerNombre());
        entity.setSegundoNombre(dto.getSegundoNombre());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setSexo(dto.getSexo());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setTipoSangre(dto.getTipoSangre());

        // Campos de ubicación redundantes
        entity.setIdPrqParroquia(dto.getIdPrqParroquia());
        entity.setIdPrqCanton(dto.getIdPrqCanton());
        entity.setIdPrqProvincia(dto.getIdPrqProvincia());
        entity.setIdPrqCntProvincia(dto.getIdPrqCntProvincia());

        // Auditoría y Sync
        // entity.setUsuario(dto.getUsuario()); // ELIMINADO: La entidad Paciente no tiene campo usuario
        entity.setUuidOffline(dto.getUuidOffline());
        entity.setSyncStatus(dto.getSyncStatus());
        entity.setOrigin(dto.getOrigin());

        // CORRECCIÓN DE FECHA: Convertir LocalDateTime del DTO a LocalDate de la Entidad
        if (dto.getFechaCreacion() != null) {
            entity.setFechaCreacion(dto.getFechaCreacion().toLocalDate());
        } else {
            entity.setFechaCreacion(LocalDate.now());
        }
        
        entity.setLastModified(LocalDateTime.now());

        // ------------------------------------------------------------
        // 2. Mapeo de RELACIONES (JOINS)
        // ------------------------------------------------------------

        if (dto.getIdGrupoEtnico() != null) {
            GrupoEtnico ge = new GrupoEtnico();
            ge.setIdGrupoEtnico(dto.getIdGrupoEtnico());
            entity.setGrupoEtnico(ge);
        }

        if (dto.getIdDiagnosticoPlanManejo() != null) {
            DiagnosticoPlanManejo dpm = new DiagnosticoPlanManejo();
            dpm.setIdDiagnosticoPlanManejo(dto.getIdDiagnosticoPlanManejo());
            entity.setDiagnosticoPlanManejo(dpm);
        }

        if (dto.getIdParroquia() != null) {
            Parroquia p = new Parroquia();
            p.setId(dto.getIdParroquia().longValue()); 
            entity.setParroquia(p);
        }

        return entity;
    }

    // Método para convertir de Entidad a DTO (Response)
    public PacienteResponseDTO toResponse(Paciente entity) {
        if (entity == null) return null;

        PacienteResponseDTO dto = new PacienteResponseDTO();

        // 1. Campos simples
        dto.setIdPaciente(entity.getIdPaciente());
        dto.setPrimerNombre(entity.getPrimerNombre());
        dto.setSegundoNombre(entity.getSegundoNombre());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setSexo(entity.getSexo());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setTipoSangre(entity.getTipoSangre());
        
        String nombreCompleto = (entity.getPrimerNombre() + " " + entity.getApellidoPaterno()).trim();
        dto.setNombreCompleto(nombreCompleto);

        if (entity.getFechaNacimiento() != null) {
            dto.setEdad(Period.between(entity.getFechaNacimiento(), LocalDate.now()).getYears());
        }

        // Ubicación
        dto.setIdPrqParroquia(entity.getIdPrqParroquia());
        dto.setIdPrqCanton(entity.getIdPrqCanton());
        dto.setIdPrqCntProvincia(entity.getIdPrqCntProvincia());

        // Auditoría
        dto.setLastModified(entity.getLastModified());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setUuidOffline(entity.getUuidOffline());
        
        // Conversión inversa de LocalDate a LocalDateTime para el DTO (inicio del día)
        if (entity.getFechaCreacion() != null) {
            dto.setFechaCreacion(entity.getFechaCreacion().atStartOfDay());
        }

        // ------------------------------------------------------------
        // 2. Relaciones Planas
        // ------------------------------------------------------------

        if (entity.getGrupoEtnico() != null) {
            dto.setIdGrupoEtnico(entity.getGrupoEtnico().getIdGrupoEtnico());
        }

        if (entity.getParroquia() != null && entity.getParroquia().getId() != null) {
            dto.setIdParroquia(entity.getParroquia().getId().intValue());
        }

        // ------------------------------------------------------------
        // 3. Mapeo de Listas (CORRECCIÓN IMPORTANTE: toDto en minúscula)
        // ------------------------------------------------------------
        
        if (entity.getDesarrollosPsicomotores() != null) {
            dto.setDesarrollosPsicomotores(entity.getDesarrollosPsicomotores().stream()
                .map(DesarrolloPsicomotorMapper::toDto) // <--- CORREGIDO: toDto (no toDTO)
                .toList());
        } else {
            dto.setDesarrollosPsicomotores(Collections.emptyList());
        }

        if (entity.getAntecedentesFamiliares() != null) {
            dto.setAntecedentesFamiliares(entity.getAntecedentesFamiliares().stream()
                .map(AntecedenteFamiliarMapper::toDto) // <--- CORREGIDO: toDto (no toDTO)
                .toList());
        } else {
            dto.setAntecedentesFamiliares(Collections.emptyList());
        }

        return dto;
    }
}
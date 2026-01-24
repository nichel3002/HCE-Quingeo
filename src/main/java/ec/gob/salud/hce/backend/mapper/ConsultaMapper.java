package ec.gob.salud.hce.backend.mapper;

import ec.gob.salud.hce.backend.dto.ConsultaDTO;
import ec.gob.salud.hce.backend.entity.Consulta;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaMapper {

    // Constructor privado para evitar instancias
    private ConsultaMapper() {}

    public static ConsultaDTO toDto(Consulta entity) {
        if (entity == null) return null;
        
        ConsultaDTO dto = new ConsultaDTO();
        dto.setIdConsulta(entity.getIdConsulta());
        dto.setMotivoConsulta(entity.getMotivoConsulta());
        dto.setEnfermedadActual(entity.getEnfermedadActual());
        
        // Ahora funcionará porque ambos son LocalDateTime
        dto.setFechaAtencion(entity.getFechaAtencion()); 
        
        dto.setFechaProximaConsulta(entity.getFechaProximaConsulta());
        
        // Ahora funcionará porque agregamos el campo a la Entidad
        dto.setIdHistoriaClinica(entity.getIdHistoriaClinica());
        
        dto.setUsuario(entity.getUsuario());
        dto.setIdPersonal(entity.getIdPersonal());
        dto.setUuidOffline(entity.getUuidOffline());
        dto.setSyncStatus(entity.getSyncStatus());
        dto.setLastModified(entity.getLastModified());
        dto.setOrigin(entity.getOrigin());
        
        return dto;
    }

    public static Consulta toEntity(ConsultaDTO dto) {
        if (dto == null) return null;
        
        Consulta entity = new Consulta();
        // Nota: No seteamos idConsulta porque es autogenerado al crear
        // pero si es una actualización, deberías manejarlo en el servicio.
        
        entity.setMotivoConsulta(dto.getMotivoConsulta());
        entity.setEnfermedadActual(dto.getEnfermedadActual());
        entity.setFechaAtencion(dto.getFechaAtencion());
        entity.setFechaProximaConsulta(dto.getFechaProximaConsulta());
        entity.setIdHistoriaClinica(dto.getIdHistoriaClinica());
        entity.setUsuario(dto.getUsuario());
        entity.setIdPersonal(dto.getIdPersonal());
        entity.setOrigin(dto.getOrigin());
        
        // Campos de auditoría como uuidOffline o syncStatus 
        // a veces se setean aquí o en el servicio según tu lógica.
        entity.setUuidOffline(dto.getUuidOffline());
        entity.setSyncStatus(dto.getSyncStatus());

        return entity;
    }

    public static List<ConsultaDTO> toDtoList(List<Consulta> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                       .map(ConsultaMapper::toDto)
                       .collect(Collectors.toList());
    }
}
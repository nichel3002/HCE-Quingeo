package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PacienteRequestDTO {
    // El ID puede ser nulo al crear, obligatorio al actualizar
    private Integer idPaciente;
    
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String tipoSangre;
    private LocalDate fechaNacimiento;
    private String sexo;
    
    // IDs para vincular las relaciones (Foreign Keys)
    private Integer idGrupoEtnico;
    private Integer idPersonal;
    
    // --- CAMPO FALTANTE CRÍTICO ---
    private Integer idDiagnosticoPlanManejo; // El mapper lo pedía explícitamente

    // Ubicación completa
    private Integer idParroquia;
    // A veces los generadores de código crean duplicados para claves compuestas (idPrqParroquia vs idParroquia)
    // Agregamos ambos para asegurar compatibilidad con el Mapper
    private Integer idPrqParroquia; 
    private Integer idPrqCanton;
    private Integer idPrqProvincia;      // Faltaba en tu versión anterior
    private Integer idPrqCntProvincia;

    // Auditoría y Sync
    private String usuario;
    private String uuidOffline;
    private String syncStatus;
    private String origin;
    private LocalDateTime fechaCreacion;
}
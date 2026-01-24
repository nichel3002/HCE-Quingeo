package ec.gob.salud.hce.backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List; // Import necesario

@Data
public class PacienteResponseDTO {
    private Integer idPaciente;
    
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String nombreCompleto; // Campo calculado útil para frontend
    
    private String tipoSangre;
    private LocalDate fechaNacimiento;
    private String sexo;
    private Integer edad; // Agregado para el Mapper
    
    // Datos de Auditoría
    private LocalDateTime fechaCreacion;
    private LocalDateTime lastModified;
    private String syncStatus;
    private String uuidOffline;
    
    // Relaciones (IDs planos)
    private Integer idGrupoEtnico;
    private Integer idPersonal;
    
    // Ubicación
    private Integer idParroquia;
    private Integer idPrqCanton;
    private Integer idPrqCntProvincia;
    // Agrego este campo extra si tu base de datos usa la clave compuesta completa
    private Integer idPrqParroquia; 

    // --- LISTAS DE RELACIONES (Necesarias para que el Mapper toResponse funcione) ---
    private List<DesarrolloPsicomotorDTO> desarrollosPsicomotores;
    private List<AntecedenteFamiliarDTO> antecedentesFamiliares;
}
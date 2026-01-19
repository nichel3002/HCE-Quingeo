package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "id_psicomotor", nullable = false)
    private Integer idPsicomotor;

    @Column(name = "id_antecedente_familiar", nullable = false)
    private Integer idAntecedenteFamiliar;

    @Column(name = "id_examen_fisico", nullable = false)
    private Integer idExamenFisico;

    @Column(name = "id_diagnostico_plan_manejo", nullable = false)
    private Integer idDiagnosticoPlanManejo;

    @Column(name = "tipo_sangre", length = 10) // Verifica el nombre de la columna en tu DB
    private String tipoSangre;

    @Column(name = "id_grupo_etnico", nullable = false)
    private Integer idGrupoEtnico;

    @Column(name = "id_parroquia", nullable = false)
    private Integer idParroquia;

    @Column(name = "id_prq_canton", nullable = false)
    private Integer idPrqCanton;

    @Column(name = "id_prq_parroquia", nullable = false)
    private Integer idPrqParroquia;

    @Column(name = "id_prq_provincia", nullable = false)
    private Integer idPrqProvincia;

    @Column(name = "id_prq_cnt_provincia", nullable = false)
    private Integer idPrqCntProvincia;

    @Column(name = "primer_nombre", length = 60, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 60, nullable = false)
    private String segundoNombre;

    @Column(name = "apellido_paterno", length = 60, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 60, nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "sexo", length = 20, nullable = false)
    private String sexo;

    @Column(name = "uuid_offline", length = 36, nullable = false)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20, nullable = false)
    private String syncStatus;

    @Column(name = "last_modified", nullable = false)
    private LocalDateTime lastModified;

    @Column(name = "origin", length = 20, nullable = false)
    private String origin;
    @PrePersist
    protected void onCreate() {
        // 1. Fecha de creación automática
        this.fechaCreacion = LocalDate.now();
        
        // 2. Fecha de última modificación inicial
        this.lastModified = LocalDateTime.now();
        
        // 3. Generar UUID automáticamente si no viene (evita el error de null)
        if (this.uuidOffline == null) {
            this.uuidOffline = java.util.UUID.randomUUID().toString();
        }
        
        // 4. Estado inicial por defecto
        if (this.syncStatus == null) {
            this.syncStatus = "PENDING";
        }

        // 5. Origen por defecto si no se envía
        if (this.origin == null) {
            this.origin = "WEB";
        }
    }
}


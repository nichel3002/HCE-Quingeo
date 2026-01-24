package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    // ==========================================
    //       RELACIONES (JOINS) - @ManyToOne
    // ==========================================

    // Join con Grupo Étnico
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_etnico", nullable = false)
    private GrupoEtnico grupoEtnico;

    // Join con Parroquia (Ubicación)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parroquia", nullable = false)
    private Parroquia parroquia;

    // Join con Diagnóstico (Si aplica según tu lógica de negocio)
    // Nota: Si un paciente tiene un plan de manejo activo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_diagnostico_plan_manejo")
    private DiagnosticoPlanManejo diagnosticoPlanManejo;


    // ==========================================
    //       RELACIONES INVERSAS - @OneToMany
    // ==========================================
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DesarrolloPsicomotor> desarrollosPsicomotores;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AntecedenteFamiliar> antecedentesFamiliares;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ExamenFisico> examenesFisicos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AlergiaPaciente> alergias;

    // Nueva relación necesaria para historias clínicas
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<HistoriaClinica> historiasClinicas;


    // ==========================================
    //       CAMPOS NORMALES
    // ==========================================

    @Column(name = "tipo_sangre", length = 10)
    private String tipoSangre;

    // --- Columnas de Ubicación Redundantes ---
    // Las mantenemos como "insertable=false, updatable=false" si son parte de la FK compuesta
    // o simplemente como columnas informativas si la BD las exige.
    
    @Column(name = "id_prq_canton")
    private Integer idPrqCanton;

    @Column(name = "id_prq_parroquia")
    private Integer idPrqParroquia;

    @Column(name = "id_prq_provincia")
    private Integer idPrqProvincia;

    @Column(name = "id_prq_cnt_provincia")
    private Integer idPrqCntProvincia;

    // ----------------------------------------

    @Column(name = "primer_nombre", length = 60, nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 60)
    private String segundoNombre;

    @Column(name = "apellido_paterno", length = 60, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 60)
    private String apellidoMaterno;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "sexo", length = 20, nullable = false)
    private String sexo;

    // --- AUDITORÍA Y SYNC ---
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
        this.fechaCreacion = LocalDate.now();
        this.lastModified = LocalDateTime.now();
        if (this.uuidOffline == null) this.uuidOffline = java.util.UUID.randomUUID().toString();
        if (this.syncStatus == null) this.syncStatus = "PENDING";
        if (this.origin == null) this.origin = "WEB";
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.lastModified = LocalDateTime.now();
    }
}
package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia_clinica")
    private Long idHistoriaClinica;

    // ==========================================
    //       RELACIONES (JOINS)
    // ==========================================

    // Relación N:1 con Paciente (Muchas historias pertenecen a un paciente)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Relación con DiagnosticoPlanManejo
    // He cambiado 'Integer idDiagnostico...' por la Entidad real.
    // fetch = FetchType.LAZY es recomendado para rendimiento.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_diagnostico_plan_manejo") 
    private DiagnosticoPlanManejo diagnosticoPlanManejo;

    // ==========================================
    //       CAMPOS DE AUDITORÍA
    // ==========================================
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "uuid_offline")
    private String uuidOffline;

    @Column(name = "sync_status")
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "origin")
    private String origin;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
        if (this.uuidOffline == null) this.uuidOffline = java.util.UUID.randomUUID().toString();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModified = LocalDateTime.now();
    }
}
package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "estudios_laboratorios")
public class EstudioLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudio_laboratorio")
    private Integer idEstudioLaboratorio;

    @Column(name = "solicitados", length = 500) // Ajusta longitud según necesites
    private String solicitados;

    @Column(name = "resultados_relevantes", columnDefinition = "TEXT")
    private String resultadosRelevantes;

    @Column(name = "fecha")
    private LocalDate fecha; // Recomendado usar LocalDate en lugar de Date

    // --- JOIN (RELACIÓN) ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;
    // -----------------------

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "id_personal")
    private Integer idPersonal;

    // --- AUDITORÍA ---
    @Column(name = "uuid_offline")
    private String uuidOffline;
    
    @Column(name = "sync_status")
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "origin")
    private String origin;

    @PrePersist @PreUpdate
    public void audit() {
        this.lastModified = LocalDateTime.now();
        if (this.uuidOffline == null) this.uuidOffline = java.util.UUID.randomUUID().toString();
        if (this.syncStatus == null) this.syncStatus = "PENDING";
        if (this.origin == null) this.origin = "WEB";
    }
}
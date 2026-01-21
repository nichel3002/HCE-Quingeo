package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "desarrollos_psicomotores")
@Getter
@Setter
public class DesarrolloPsicomotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrollo_psicomotor")
    private Integer idDesarrolloPsicomotor;

    @Column(name = "sosten_cefalo", length = 150)
    private String sostenCefalo;

    @Column(length = 150)
    private String sedestacion;

    @Column(length = 150)
    private String deambulacion;

    @Column(length = 150)
    private String lenguaje;

    @Column(length = 100)
    private String observacion;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    private Paciente paciente;

    @Column(name = "id_historia_clinica")
    private Integer idHistoriaClinica; // Puedes convertirlo a objeto si tienes la entidad HistoriaClinica

    // Auditoría y Sincronización
    @Column(name = "uuid_offline", length = 36)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20)
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(length = 20)
    private String origin;

    @PrePersist
    protected void onCreate() {
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
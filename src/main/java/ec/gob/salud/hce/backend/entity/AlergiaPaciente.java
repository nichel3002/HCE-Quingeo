package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "alergias_pacientes")
@Getter
@Setter
public class AlergiaPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia_paciente")
    private Integer idAlergiaPaciente;

    @Column(name = "reaccion", length = 20)
    private String reaccion;

    @Column(name = "observaciones", length = 100)
    private String observaciones;

    // --- RELACIONES ---

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_alergia", referencedColumnName = "id_alergia", nullable = false)
    private Alergia alergia;

    // Si aún no tienes la entidad Antecedente creada, puedes dejarlo como Integer:
    @Column(name = "id_antecedente_patologico_personal")
    private Integer idAntecedentePatologicoPersonal;

    // --- AUDITORÍA Y SINCRONIZACIÓN ---

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "uuid_offline", length = 36)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20)
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "origin", length = 20)
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
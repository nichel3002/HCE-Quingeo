package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "signos_vitales")
@Getter
@Setter
public class SignoVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_signo_vital")
    private Integer idSignoVital;

    private Double peso;
    private Double tallaLongitud;
    private Double perimetroCefalico;
    private Double temperatura;
    private Integer frecuenciaCardiaca;
    private Integer frecuenciaRespiratoria;
    private Integer presionArterialSistolica;
    private Integer presionArterialDiastolica;
    private Integer saturacionOxigeno;
    
    @Column(name = "IMC")
    private Double imc;

    @Column(length = 50)
    private String puntuacion;

    @Column(length = 50)
    private String observacion;

    // --- UNIÓN CON EXAMEN FÍSICO ---
    @Column(name = "id_examen_fisico")
    private Integer idExamenFisico;

    // Auditoría
    @Column(name = "uuid_offline", length = 36)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20)
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(length = 20)
    private String origin;

    @PrePersist
    @PreUpdate
    protected void updateAudit() {
        this.lastModified = LocalDateTime.now();
        if (this.uuidOffline == null) this.uuidOffline = java.util.UUID.randomUUID().toString();
        if (this.syncStatus == null) this.syncStatus = "PENDING";
    }
}
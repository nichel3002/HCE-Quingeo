package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historia_clinica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia_clinica")
    private Long idHistoriaClinica;

    // 1 Paciente -> 1 Historia Clínica
    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false, unique = true)
    private Paciente paciente;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 100)
    private String usuario;

    // Sincronización
    @Column(name = "uuid_offline", length = 100)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20)
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(length = 50)
    private String origin;
}

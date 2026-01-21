package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "examenes_fisicos")
@Getter
@Setter
public class ExamenFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen_fisico")
    private Integer idExamenFisico;

    @Column(name = "id_historia_clinica")
    private Integer idHistoriaClinica;

    // ESTO ES LO QUE FALTA PARA QUE EL MAPPER FUNCIONE:
    // Un Examen Físico TIENE un Signo Vital (Relación 1 a 1 o Muchos a 1)
    @OneToOne
    @JoinColumn(name = "id_signo_vital", referencedColumnName = "id_signo_vital")
    private SignoVital signoVital;
    
    @OneToOne
    @JoinColumn(name = "id_examen_fisico_segmentario", referencedColumnName = "id_examen_fisico_segmentario")
    private ExamenFisicoSegmentario examenFisicoSegmentario;

    @Column(name = "id_examen_fisico_segmentario")
    private Integer idExamenFisicoSegmentario;

    // Auditoría
    @Column(name = "uuid_offline")
    private String uuidOffline;
    @Column(name = "sync_status")
    private String syncStatus;
    @Column(name = "last_modified")
    private LocalDateTime lastModified;
    @Column(name = "origin")
    private String origin;
}
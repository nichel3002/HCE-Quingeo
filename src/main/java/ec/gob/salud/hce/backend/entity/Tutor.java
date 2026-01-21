package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tutores")
@Data
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutor")
    private Integer idTutor;

    @Column(name = "nombre_completo_tutor")
    private String nombreCompletoTutor;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "domicilio_actual")
    private String domicilioActual;

    @Column(name = "nivel_educativo")
    private String nivelEducativo;

    @Column(name = "id_parroquia")
    private Integer idParroquia;

    @Column(name = "id_prq_canton")
    private Integer idPrqCanton;

    @Column(name = "id_prq_cnt_provincia")
    private Integer idPrqCntProvincia;

    @Column(name = "uuid_offline")
    private String uuidOffline;

    private String origin;

    @Column(name = "sync_status")
    private String syncStatus;

    @Column(name = "last_modified", insertable = false, updatable = false)
    private LocalDateTime lastModified;
}
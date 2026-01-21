package ec.gob.salud.hce.backend.entity;
import jakarta.persistence.*;
import lombok.Data;import java.time.LocalDateTime;

@Entity
@Table(name = "alergias")
@Data
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia")
    private Long idAlergia;

    @Column(name = "tipo_alergia", length = 150, nullable = false)
    private String tipoAlergia;

    @Column(length = 50)
    private String estado;

    @Column(length = 50)
    private String observaciones;

    @Column(name = "uuid_offline", length = 36)
    private String uuidOffline;

    @Column(name = "sync_status", length = 20)
    private String syncStatus;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(length = 20)
    private String origin;
}

package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pieles_faneras")
public class PielFanera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piel_fanera")
    private Integer idPielFanera;

    @Column(name = "id_examen_fisico_segmentario")
    private Integer idExamenFisicoSegmentario;

    @Column(name = "icterisia")
    private Byte icterisia; // TINYINT

    @Column(name = "psianosis")
    private Byte psianosis;

    @Column(name = "rash")
    private Byte rash;

    @Column(name = "otros")
    private String otros;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "id_personal")
    private Integer idPersonal;

    @Column(name = "uuid_offline")
    private String uuidOffline;
    
    @Column(name = "sync_status")
    private String syncStatus;
}
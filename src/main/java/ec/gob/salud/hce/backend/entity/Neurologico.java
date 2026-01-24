package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "neurologicos")
public class Neurologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_neurologico")
    private Integer idNeurologico;

    @Column(name = "id_examen_fisico_segmentario")
    private Integer idExamenFisicoSegmentario;

    @Column(name = "reflejo_osteotendinoso")
    private String reflejoOsteotendinoso;

    @Column(name = "estado_mental")
    private String estadoMental;

    @Column(name = "tono_muscular")
    private String tonoMuscular;

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
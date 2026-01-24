package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "hitos_desarrollo")
public class HitoDesarrollo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hito_desarrollo")
    private Integer idHitoDesarrollo;

    @Column(name = "sosten_cefalio")
    private String sostenCefalio;

    @Column(name = "sedestacion")
    private String sedestacion;

    @Column(name = "deambulacion")
    private String deambulacion;

    @Column(name = "lenguaje")
    private String lenguaje;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "id_desarrollo_psicomotor")
    private Integer idDesarrolloPsicomotor;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "id_personal")
    private Integer idPersonal;

    @Column(name = "uuid_offline")
    private String uuidOffline;
    
    @Column(name = "sync_status")
    private String syncStatus;
}
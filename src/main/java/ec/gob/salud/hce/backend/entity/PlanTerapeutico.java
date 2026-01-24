package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "planes_terapeuticos")
public class PlanTerapeutico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan_terapeutico")
    private Integer idPlanTerapeutico;

    @Column(name = "manejo_farmacologico")
    private String manejoFarmacologico;

    @Column(name = "manejo_no_farmacologico")
    private String manejoNoFarmacologico;

    @Column(name = "pronostico")
    private String pronostico;

    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "id_personal")
    private Integer idPersonal;

    @Column(name = "uuid_offline")
    private String uuidOffline;
    
    @Column(name = "sync_status")
    private String syncStatus;
}
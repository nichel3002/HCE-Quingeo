package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanTerapeuticoDTO {
    private Integer idPlanTerapeutico;
    private String manejoFarmacologico;
    private String manejoNoFarmacologico;
    private String pronostico;
    private Integer idConsulta;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
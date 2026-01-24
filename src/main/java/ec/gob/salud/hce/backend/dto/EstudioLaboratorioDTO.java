package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class EstudioLaboratorioDTO {
    private Integer idEstudioLaboratorio;
    private String solicitados;
    private String resultadosRelevantes;
    private Date fecha;
    private Integer idConsulta;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
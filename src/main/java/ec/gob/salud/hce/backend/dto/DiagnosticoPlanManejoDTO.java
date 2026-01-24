package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class DiagnosticoPlanManejoDTO {
    private Integer idDiagnosticoPlanManejo;
    private String observacion;
    private Date fecha;
    private Integer idHistoriaClinica;
    private String uuidOffline;
    private String syncStatus;
    private String origin;
}
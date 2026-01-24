package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeurologicoDTO {
    private Integer idNeurologico;
    private Integer idExamenFisicoSegmentario;
    private String reflejoOsteotendinoso;
    private String estadoMental;
    private String tonoMuscular;
    private String otros;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
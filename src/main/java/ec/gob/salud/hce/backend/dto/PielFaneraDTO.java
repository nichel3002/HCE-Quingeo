package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PielFaneraDTO {
    private Integer idPielFanera;
    private Integer idExamenFisicoSegmentario;
    private Byte icterisia;
    private Byte psianosis;
    private Byte rash;
    private String otros;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
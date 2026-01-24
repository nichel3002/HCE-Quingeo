package ec.gob.salud.hce.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HitoDesarrolloDTO {
    private Integer idHitoDesarrollo;
    private String sostenCefalio;
    private String sedestacion;
    private String deambulacion;
    private String lenguaje;
    private String observacion;
    private Integer idDesarrolloPsicomotor;
    private String usuario;
    private Integer idPersonal;
    private String uuidOffline;
    private String syncStatus;
}
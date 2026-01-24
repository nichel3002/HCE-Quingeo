package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*; // Asegúrate de tener este import (o javax.persistence)
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consulta") 
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;

    @Column(name = "motivo_consulta")
    private String motivoConsulta;

    @Column(name = "enfermedad_actual")
    private String enfermedadActual;

    @Column(name = "fecha_atencion")
    private LocalDateTime fechaAtencion;

    @Column(name = "fecha_proxima_consulta")
    private LocalDate fechaProximaConsulta;

    // --- AQUÍ ESTABA EL ERROR: FALTABA ESTE CAMPO ---
    @Column(name = "id_historia_clinica")
    private Integer idHistoriaClinica; 
    // Al agregar esto, Lombok genera automáticamente getIdHistoriaClinica() y setIdHistoriaClinica()
    // -------------------------------------------------

    @Column(name = "id_personal")
    private Integer idPersonal;

    // Campos de Auditoría
    private String usuario;
    
    @Column(name = "uuid_offline")
    private String uuidOffline;
    
    @Column(name = "sync_status")
    private String syncStatus;
    
    @Column(name = "last_modified")
    private LocalDateTime lastModified;
    
    private String origin;
}   
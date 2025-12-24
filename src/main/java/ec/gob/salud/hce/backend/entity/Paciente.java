package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    // =========================
    // DATOS PERSONALES
    // =========================
    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "tipo_sangre", length = 3)
    private String tipoSangre;

    // =========================
    // DEMOGRAFÍA
    // =========================
    @Column(name = "id_grupo_etnico")
    private Long idGrupoEtnico;

    @Column(name = "id_prq_parroquia")
    private Long idPrqParroquia;

    @Column(name = "id_prq_canton")
    private Long idPrqCanton;

    @Column(name = "id_prq_provincia")
    private Long idPrqProvincia;

    // =========================
    // AUDITORÍA
    // =========================
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    // =========================
    // SINCRONIZACIÓN
    // =========================
    @Column(name = "uuid_online", unique = true)
    private String uuidOnline;

    @Column(name = "sync_status")
    private String syncStatus;

    @Column(name = "origin")
    private String origin;

    // =========================
    // CICLO DE VIDA
    // =========================
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModified = LocalDateTime.now();
    }
}

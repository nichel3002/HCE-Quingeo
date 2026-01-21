package ec.gob.salud.hce.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pacientes_tutores")
@Data
public class PacienteTutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_tutor")
    private Integer idPacienteTutor;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "id_tutor")
    private Integer idTutor;

    private String parentesco;
}
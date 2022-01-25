package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "TBL_CITAS", schema = "business")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "ct_hra")
    private LocalTime hora;

    @Column(name = "ct_fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mdco_id", nullable = false)
    private MedicoEntity medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pcte_id", nullable = false)
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ct_tp_id")
    private CitaTipoEntity citaTipo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public CitaTipoEntity getCitaTipo() {
        return citaTipo;
    }

    public void setCitaTipo(CitaTipoEntity citaTipo) {
        this.citaTipo = citaTipo;
    }

    @Override
    public String toString() {
        return "CitaEntity{" +
                "id=" + id +
                ", hora=" + hora +
                ", fecha=" + fecha +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", citaTipo=" + citaTipo +
                '}';
    }
}

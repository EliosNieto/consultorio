package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TBL_HISTORIAS_CLINICA", schema = "business")
public class HistoriaClinicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hstria_clnca_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "hstria_clnca_obsrvcnes")
    private String observaciones;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mdco_id", nullable = false)
    private MedicoEntity medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pcnte_id", nullable = false)
    private PacienteEntity paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
}

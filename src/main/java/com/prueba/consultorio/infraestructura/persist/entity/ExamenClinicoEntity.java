package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TBL_EXAMENES_CLINICO", schema = "business")
public class ExamenClinicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exmn_clnco_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "exmn_clnco_estdo")
    private String estado;

    @Column(name = "exmn_clnco_rsltdo")
    private String resultado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pcnte_id", nullable = false)
    private PacienteEntity paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mdco_id")
    private MedicoEntity medico;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }
}

package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_pacientes", schema = "business")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pcnte_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "pcnte_tpo_dcmnto", nullable = false, length = 2)
    private String tipoDocumento;

    @Column(name = "pcnte_nmro", nullable = false, length = 20)
    private Integer numero;

    @Column(name = "pcnte_nmbres", nullable = false, length = 150)
    private String nombres;

    @OneToMany(mappedBy = "paciente")
    private List<CitaEntity> citas;

    @OneToMany(mappedBy = "paciente")
    private List<HistoriaClinicaEntity> historiaClinicas;

    @OneToMany(mappedBy = "paciente")
    private List<ControlEntity> controls;

    @OneToMany(mappedBy = "paciente")
    private List<ExamenClinicoEntity> examenClinicos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numero=" + numero +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}

package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_medicos", schema = "business")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mdco_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "pcnte_tpo_dcmnto", nullable = false, length = 2)
    private String tipoDocumento;

    @Column(name = "pcnte_nmro", nullable = false, length = 20)
    private Integer numero;

    @Column(name = "pcnte_nmbres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "pcnte_trjta_nmro", nullable = false, length = 20)
    private String tarjetaNumero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "espcldad_id", nullable = false)
    private EspecialidadEntity especialidadEntity;

    @OneToMany(mappedBy = "medico")
    private List<CitaEntity> citas;

    @OneToMany(mappedBy = "medico")
    private List<HistoriaClinicaEntity> historiaClinicas;

    @OneToMany(mappedBy = "medico")
    private List<ControlEntity> controls;

    @OneToMany(mappedBy = "medico")
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

    public String getTarjetaNumero() {
        return tarjetaNumero;
    }

    public void setTarjetaNumero(String tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }

    public EspecialidadEntity getEspecialidadEntity() {
        return especialidadEntity;
    }

    public void setEspecialidadEntity(EspecialidadEntity especialidadEntity) {
        this.especialidadEntity = especialidadEntity;
    }

    public List<HistoriaClinicaEntity> getHistoriaClinicas() {
        return historiaClinicas;
    }

    public void setHistoriaClinicas(List<HistoriaClinicaEntity> historiaClinicas) {
        this.historiaClinicas = historiaClinicas;
    }

    public List<ControlEntity> getControls() {
        return controls;
    }

    public void setControls(List<ControlEntity> controls) {
        this.controls = controls;
    }

    public List<ExamenClinicoEntity> getExamenClinicos() {
        return examenClinicos;
    }

    public void setExamenClinicos(List<ExamenClinicoEntity> examenClinicos) {
        this.examenClinicos = examenClinicos;
    }

    public List<CitaEntity> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaEntity> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "MedicoEntity{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numero=" + numero +
                ", nombres='" + nombres + '\'' +
                ", tarjetaNumero='" + tarjetaNumero + '\'' +
                ", especialidadEntity=" + especialidadEntity +
                '}';
    }
}

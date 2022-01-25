package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL_ESPECIALIDADES", schema = "business")
public class EspecialidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "espcldad_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "espcldad_nmbres", nullable = false, length = 200)
    private String nombres;

    @OneToMany(mappedBy = "especialidadEntity")
    private List<MedicoEntity> medico;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public List<MedicoEntity> getMedico() {
        return medico;
    }

    public void setMedico(List<MedicoEntity> medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}

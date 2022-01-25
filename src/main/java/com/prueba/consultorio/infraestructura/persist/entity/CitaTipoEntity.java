package com.prueba.consultorio.infraestructura.persist.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL_CITA_TIPO", schema = "business")
public class CitaTipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_tp_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @Column(name = "ct_tp_nmbre", nullable = false, length = 200)
    private String nombre;

    @OneToMany(mappedBy = "citaTipo")
    private List<CitaEntity> citas;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CitaEntity> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaEntity> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "CitaTipoEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

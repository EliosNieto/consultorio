package com.prueba.consultorio.infraestructura.persist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TBL_ENFERMERAS", schema = "business")
public class EnfermeraEntity {

    @Id
    @Column(name = "enfrmra_id", nullable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "pcnte_tpo_dcmnto", nullable = false, length = 2)
    private String tipoDocumento;

    @Column(name = "pcnte_nmro", nullable = false, length = 20)
    private Integer numero;

    @Column(name = "pcnte_nmbres", nullable = false, length = 150)
    private String nombres;

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
}

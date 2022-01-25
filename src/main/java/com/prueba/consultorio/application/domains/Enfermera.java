package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class Enfermera {
    private NonEmptyUUID idFermera;
    private NonEmptyString tipoDocumento;
    private NonEmptyNumber numero;
    private NonEmptyString nombres;

    public Enfermera(NonEmptyString tipoDocumento, NonEmptyNumber numero, NonEmptyString nombres) {
        this.tipoDocumento = tipoDocumento;
        this.numero = numero;
        this.nombres = nombres;
    }

    public Enfermera(NonEmptyUUID idFermera, NonEmptyString tipoDocumento, NonEmptyNumber numero, NonEmptyString nombres) {
        this.idFermera = idFermera;
        this.tipoDocumento = tipoDocumento;
        this.numero = numero;
        this.nombres = nombres;
    }

    public NonEmptyUUID getIdFermera() {
        return idFermera;
    }

    public void setIdFermera(NonEmptyUUID idFermera) {
        this.idFermera = idFermera;
    }

    public NonEmptyString getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(NonEmptyString tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public NonEmptyNumber getNumero() {
        return numero;
    }

    public void setNumero(NonEmptyNumber numero) {
        this.numero = numero;
    }

    public NonEmptyString getNombres() {
        return nombres;
    }

    public void setNombres(NonEmptyString nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Enfermera{" +
                "idFermera=" + idFermera +
                ", tipoDocumento=" + tipoDocumento +
                ", numero=" + numero +
                ", nombres=" + nombres +
                '}';
    }
}

package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class Paciente {

    private NonEmptyUUID idPaciente;
    private NonEmptyString tipoDocumento;
    private NonEmptyNumber numeroDocumento;
    private NonEmptyString nombres;

    public Paciente(NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
    }

    public Paciente(NonEmptyUUID idPaciente, NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres) {
        this.idPaciente = idPaciente;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
    }

    public NonEmptyUUID getIdPaciente() {
        return idPaciente;
    }

    public NonEmptyString getTipoDocumento() {
        return tipoDocumento;
    }

    public NonEmptyNumber getNumeroDocumento() {
        return numeroDocumento;
    }

    public NonEmptyString getNombres() {
        return nombres;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", tipoDocumento=" + tipoDocumento +
                ", numeroDocumento=" + numeroDocumento +
                ", nombres=" + nombres +
                '}';
    }
}

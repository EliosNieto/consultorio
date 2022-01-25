package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class Medico {

    private NonEmptyUUID idMedico;
    private NonEmptyString tipoDocumento;
    private NonEmptyNumber numeroDocumento;
    private NonEmptyString nombres;
    private NonEmptyString tarjetaProfesional;
    private MedicoEspecialidad medicoEspecialidad;

    public Medico(NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres, NonEmptyString tarjetaProfesional, MedicoEspecialidad medicoEspecialidad) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.tarjetaProfesional = tarjetaProfesional;
        this.medicoEspecialidad = medicoEspecialidad;
    }

    public Medico(NonEmptyUUID idMedico, NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres, NonEmptyString tarjetaProfesional, MedicoEspecialidad medicoEspecialidad) {
        this.idMedico = idMedico;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.tarjetaProfesional = tarjetaProfesional;
        this.medicoEspecialidad = medicoEspecialidad;
    }

    public NonEmptyUUID getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(NonEmptyUUID idMedico) {
        this.idMedico = idMedico;
    }

    public NonEmptyString getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(NonEmptyString tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public NonEmptyNumber getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(NonEmptyNumber numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public NonEmptyString getNombres() {
        return nombres;
    }

    public void setNombres(NonEmptyString nombres) {
        this.nombres = nombres;
    }

    public NonEmptyString getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(NonEmptyString tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public MedicoEspecialidad getMedicoEspecialidad() {
        return medicoEspecialidad;
    }

    public void setMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        this.medicoEspecialidad = medicoEspecialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico=" + idMedico +
                ", tipoDocumento=" + tipoDocumento +
                ", numeroDocumento=" + numeroDocumento +
                ", nombres=" + nombres +
                ", tarjetaProfesional=" + tarjetaProfesional +
                ", medicoEspecialidad=" + medicoEspecialidad +
                '}';
    }
}

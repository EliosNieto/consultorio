package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class HistoriaClinica {

    private NonEmptyUUID idHistoria;
    private NonEmptyString observacion;
    private Medico medico;
    private Paciente paciente;

    public HistoriaClinica(NonEmptyString observacion, Medico medico, Paciente paciente) {
        this.observacion = observacion;
        this.medico = medico;
        this.paciente = paciente;
    }

    public HistoriaClinica(NonEmptyUUID idHistoria, NonEmptyString observacion, Medico medico, Paciente paciente) {
        this.idHistoria = idHistoria;
        this.observacion = observacion;
        this.medico = medico;
        this.paciente = paciente;
    }

    public NonEmptyUUID getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(NonEmptyUUID idHistoria) {
        this.idHistoria = idHistoria;
    }

    public NonEmptyString getObservacion() {
        return observacion;
    }

    public void setObservacion(NonEmptyString observacion) {
        this.observacion = observacion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

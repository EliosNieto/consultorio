package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class ExamenClinico {
    private NonEmptyUUID idExamen;
    private Medico medico;
    private Paciente paciente;
    private NonEmptyString estado;
    private NonEmptyString resultado;

    public ExamenClinico(Medico medico, Paciente paciente, NonEmptyString estado, NonEmptyString resultado) {
        this.medico = medico;
        this.paciente = paciente;
        this.estado = estado;
        this.resultado = resultado;
    }

    public ExamenClinico(NonEmptyUUID idExamen, Medico medico, Paciente paciente, NonEmptyString estado, NonEmptyString resultado) {
        this.idExamen = idExamen;
        this.medico = medico;
        this.paciente = paciente;
        this.estado = estado;
        this.resultado = resultado;
    }

    public NonEmptyUUID getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(NonEmptyUUID idExamen) {
        this.idExamen = idExamen;
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

    public NonEmptyString getEstado() {
        return estado;
    }

    public void setEstado(NonEmptyString estado) {
        this.estado = estado;
    }

    public NonEmptyString getResultado() {
        return resultado;
    }

    public void setResultado(NonEmptyString resultado) {
        this.resultado = resultado;
    }
}

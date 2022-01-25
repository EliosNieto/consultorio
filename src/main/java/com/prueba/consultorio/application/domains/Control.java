package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class Control {
    private NonEmptyUUID idControl;
    private Paciente paciente;
    private Medico medico;
    private NonEmptyLocalDate fecha;
    private NonEmptyLocalTime hora;
    private NonEmptyString observacion;

    public Control(Paciente paciente, Medico medico, NonEmptyLocalDate fecha, NonEmptyLocalTime hora, NonEmptyString observacion) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
    }

    public Control(NonEmptyUUID idControl, Paciente paciente, Medico medico, NonEmptyLocalDate fecha, NonEmptyLocalTime hora, NonEmptyString observacion) {
        this.idControl = idControl;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
    }

    public NonEmptyUUID getIdControl() {
        return idControl;
    }

    public void setIdControl(NonEmptyUUID idControl) {
        this.idControl = idControl;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public NonEmptyLocalDate getFecha() {
        return fecha;
    }

    public void setFecha(NonEmptyLocalDate fecha) {
        this.fecha = fecha;
    }

    public NonEmptyLocalTime getHora() {
        return hora;
    }

    public void setHora(NonEmptyLocalTime hora) {
        this.hora = hora;
    }

    public NonEmptyString getObservacion() {
        return observacion;
    }

    public void setObservacion(NonEmptyString observacion) {
        this.observacion = observacion;
    }
}

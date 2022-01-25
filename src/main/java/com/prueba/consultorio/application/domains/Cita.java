package com.prueba.consultorio.application.domains;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.commons.NonEmptyUUID;

public class Cita {
    private NonEmptyUUID idCita;
    private NonEmptyLocalTime hora;
    private NonEmptyLocalDate date;
    private Paciente paciente;
    private Medico medico;
    private CitaTipo citaTipo;

    public Cita(NonEmptyLocalTime hora, NonEmptyLocalDate date, Paciente paciente, Medico medico, CitaTipo citaTipo) {
        this.hora = hora;
        this.date = date;
        this.paciente = paciente;
        this.medico = medico;
        this.citaTipo = citaTipo;
    }

    public Cita(NonEmptyUUID idCita, NonEmptyLocalTime hora, NonEmptyLocalDate date, Paciente paciente, Medico medico, CitaTipo citaTipo) {
        this.idCita = idCita;
        this.hora = hora;
        this.date = date;
        this.paciente = paciente;
        this.medico = medico;
        this.citaTipo = citaTipo;
    }

    public NonEmptyUUID getIdCita() {
        return idCita;
    }

    public void setIdCita(NonEmptyUUID idCita) {
        this.idCita = idCita;
    }

    public NonEmptyLocalTime getHora() {
        return hora;
    }

    public void setHora(NonEmptyLocalTime hora) {
        this.hora = hora;
    }

    public NonEmptyLocalDate getDate() {
        return date;
    }

    public void setDate(NonEmptyLocalDate date) {
        this.date = date;
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

    public CitaTipo getCitaTipo() {
        return citaTipo;
    }

    public void setCitaTipo(CitaTipo citaTipo) {
        this.citaTipo = citaTipo;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", hora=" + hora +
                ", date=" + date +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", citaTipo=" + citaTipo +
                '}';
    }
}

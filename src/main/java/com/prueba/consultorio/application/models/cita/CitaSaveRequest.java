package com.prueba.consultorio.application.models.cita;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class CitaSaveRequest implements ApplicationRequest {

    private String hora;
    private String fecha;
    private String medicoId;
    private String pacienteId;
    private String citaTipoId;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(String medicoId) {
        this.medicoId = medicoId;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getCitaTipoId() {
        return citaTipoId;
    }

    public void setCitaTipoId(String citaTipoId) {
        this.citaTipoId = citaTipoId;
    }
}

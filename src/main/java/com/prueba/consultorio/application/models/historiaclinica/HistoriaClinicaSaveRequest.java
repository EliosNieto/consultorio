package com.prueba.consultorio.application.models.historiaclinica;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class HistoriaClinicaSaveRequest implements ApplicationRequest {

    private String medicoId;
    private String pacienteId;
    private String observacion;

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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}

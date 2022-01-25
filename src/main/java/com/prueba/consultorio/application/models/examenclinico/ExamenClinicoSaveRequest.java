package com.prueba.consultorio.application.models.examenclinico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class ExamenClinicoSaveRequest implements ApplicationRequest {

    private String medicoId;
    private String pacienteId;
    private String estado;
    private String resultado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}

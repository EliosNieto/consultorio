package com.prueba.consultorio.application.models.paciente;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class PacienteSaveRequest implements ApplicationRequest {

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}

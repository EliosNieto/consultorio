package com.prueba.consultorio.application.models.enfermera;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

public class EnfermeraSaveRequest implements ApplicationRequest {
    private String tipoDocumento;
    private String numero;
    private String nombres;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}

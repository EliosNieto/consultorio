package com.prueba.consultorio.application.models.medico;

import com.prueba.consultorio.application.commons.operation.ApplicationRequest;

import java.util.UUID;

public class MedicoSaveRequest implements ApplicationRequest {

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String tarjetaProfesional;
    private MedicoEspecialidad medicoEspecialidad;

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

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public MedicoEspecialidad getMedicoEspecialidad() {
        return medicoEspecialidad;
    }

    public void setMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        this.medicoEspecialidad = medicoEspecialidad;
    }

    public class MedicoEspecialidad {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

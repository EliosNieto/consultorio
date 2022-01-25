package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.paciente.PacienteListRequest;
import com.prueba.consultorio.application.models.paciente.PacienteListResponse;
import com.prueba.consultorio.application.ports.in.PacienteListUseCase;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;

public class PacienteListService implements PacienteListUseCase {

    private final PacienteRepositiry pacienteRepositiry;

    public PacienteListService(PacienteRepositiry pacienteRepositiry) {
        this.pacienteRepositiry = pacienteRepositiry;
    }

    @Override
    public PacienteListResponse execute(PacienteListRequest request) {
        return new PacienteListResponse(pacienteRepositiry.list());
    }
}

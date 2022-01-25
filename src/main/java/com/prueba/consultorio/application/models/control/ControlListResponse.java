package com.prueba.consultorio.application.models.control;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Control;

import java.util.List;

public class ControlListResponse implements ApplicationResponse {

    private final List<Control> controls;

    public ControlListResponse(List<Control> controls) {
        this.controls = controls;
    }

    public List<Control> getControls() {
        return controls;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}

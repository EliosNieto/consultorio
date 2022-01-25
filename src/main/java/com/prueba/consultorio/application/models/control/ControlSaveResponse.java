package com.prueba.consultorio.application.models.control;

import com.prueba.consultorio.application.commons.errors.HttpStatusCode;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.domains.Control;

public class ControlSaveResponse implements ApplicationResponse {

    private final Control control;

    public ControlSaveResponse(Control control) {
        this.control = control;
    }

    public Control getControl() {
        return control;
    }

    @Override
    public HttpStatusCode statusCode() {
        return HttpStatusCode.Ok;
    }
}

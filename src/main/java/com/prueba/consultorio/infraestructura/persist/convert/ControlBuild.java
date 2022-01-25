package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;

public class ControlBuild extends Control {

    public ControlBuild(NonEmptyUUID idControl, Paciente paciente, Medico medico, NonEmptyLocalDate fecha, NonEmptyLocalTime hora, NonEmptyString observacion) {
        super(idControl, paciente, medico, fecha, hora, observacion);
    }
}

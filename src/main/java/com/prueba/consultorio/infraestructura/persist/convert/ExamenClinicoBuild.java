package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;

public class ExamenClinicoBuild extends ExamenClinico {

    public ExamenClinicoBuild(NonEmptyUUID idExamen, Medico medico, Paciente paciente, NonEmptyString estado, NonEmptyString resultado) {
        super(idExamen, medico, paciente, estado, resultado);
    }
}

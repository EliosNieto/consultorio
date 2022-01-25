package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

public class EspecialidadBuild extends MedicoEspecialidad {

    public EspecialidadBuild(NonEmptyUUID id, NonEmptyString nombres) {
        super(id, nombres);
    }
}

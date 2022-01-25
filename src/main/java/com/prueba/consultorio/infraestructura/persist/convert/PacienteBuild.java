package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Paciente;

public class PacienteBuild extends Paciente {

    public PacienteBuild(NonEmptyUUID idPaciente, NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres) {
        super(idPaciente, tipoDocumento, numeroDocumento, nombres);
    }
}

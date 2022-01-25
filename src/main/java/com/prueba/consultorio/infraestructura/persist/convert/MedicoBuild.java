package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.MedicoEspecialidad;

public class MedicoBuild extends Medico {

    public MedicoBuild(NonEmptyUUID idMedico, NonEmptyString tipoDocumento, NonEmptyNumber numeroDocumento, NonEmptyString nombres, NonEmptyString tarjetaProfesional, MedicoEspecialidad medicoEspecialidad) {
        super(idMedico, tipoDocumento, numeroDocumento, nombres, tarjetaProfesional, medicoEspecialidad);
    }
}

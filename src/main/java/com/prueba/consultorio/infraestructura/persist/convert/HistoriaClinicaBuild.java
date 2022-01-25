package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;

public class HistoriaClinicaBuild extends HistoriaClinica {

    public HistoriaClinicaBuild(NonEmptyUUID idHistoria, NonEmptyString observacion, Medico medico, Paciente paciente) {
        super(idHistoria, observacion, medico, paciente);
    }
}

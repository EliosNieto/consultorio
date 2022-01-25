package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.application.domains.Paciente;

public class CitaBuild extends Cita {

    public CitaBuild(NonEmptyUUID idCita, NonEmptyLocalTime hora, NonEmptyLocalDate date, Paciente paciente, Medico medico, CitaTipo citaTipo) {
        super(idCita, hora, date, paciente, medico, citaTipo);
    }
}

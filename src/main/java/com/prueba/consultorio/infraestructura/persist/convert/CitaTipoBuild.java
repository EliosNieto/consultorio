package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.CitaTipo;

public class CitaTipoBuild extends CitaTipo {

    public CitaTipoBuild(NonEmptyUUID idCitaTipo, NonEmptyString nombre) {
        super(idCitaTipo, nombre);
    }
}

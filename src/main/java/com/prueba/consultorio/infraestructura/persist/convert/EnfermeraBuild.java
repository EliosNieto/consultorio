package com.prueba.consultorio.infraestructura.persist.convert;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Enfermera;

public class EnfermeraBuild extends Enfermera {

    public EnfermeraBuild(NonEmptyUUID idFermera, NonEmptyString tipoDocumento, NonEmptyNumber numero, NonEmptyString nombres) {
        super(idFermera, tipoDocumento, numero, nombres);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

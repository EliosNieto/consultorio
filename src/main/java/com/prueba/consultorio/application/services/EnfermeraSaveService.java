package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyNumber;
import com.prueba.consultorio.application.commons.NonEmptyString;
import com.prueba.consultorio.application.commons.Validate;
import com.prueba.consultorio.application.domains.Enfermera;
import com.prueba.consultorio.application.errors.ExternalServerError;
import com.prueba.consultorio.application.models.enfermera.EnfermeraSaveRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraSaveResponse;
import com.prueba.consultorio.application.ports.in.EnfermeraSaveUseCase;
import com.prueba.consultorio.application.ports.out.EnfermeraRepository;

import java.util.Optional;

public class EnfermeraSaveService implements EnfermeraSaveUseCase {

    private final EnfermeraRepository enfermeraRepository;

    public EnfermeraSaveService(EnfermeraRepository enfermeraRepository) {
        this.enfermeraRepository = enfermeraRepository;
    }

    @Override
    public EnfermeraSaveResponse execute(EnfermeraSaveRequest request) {
        Enfermera enfermera = validRequest(request);
        Optional<Enfermera> optionalEnfermera = enfermeraRepository.save(enfermera);
        if(!optionalEnfermera.isPresent()){
            throw new ExternalServerError("Error trying to save", new InterruptedException());
        }
        return new EnfermeraSaveResponse(optionalEnfermera.get());
    }

    private Enfermera validRequest(EnfermeraSaveRequest request){
        NonEmptyString tipoDocumento = Validate.nonEmptyString("tipoDocumento", request.getTipoDocumento());
        NonEmptyNumber numero = Validate.nonEmptyNumber("numero", request.getNumero());
        NonEmptyString nombres = Validate.nonEmptyString("nombres", request.getNombres());

        return new Enfermera(tipoDocumento, numero, nombres);
    }
}

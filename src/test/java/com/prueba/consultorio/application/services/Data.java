package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.*;
import com.prueba.consultorio.application.domains.*;
import com.prueba.consultorio.application.models.cita.CitaSaveRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Data {
    public static List<Cita> CITAS = Arrays.asList(
            new Cita(new NonEmptyUUID(UUID.randomUUID().toString()),
                    new NonEmptyLocalTime(LocalTime.now().toString()),
                    new NonEmptyLocalDate(LocalDate.now().toString()),
                    new Paciente(new NonEmptyString("CC"), new NonEmptyNumber("1"), new NonEmptyString("Pedro")),
                    new Medico(new NonEmptyString("CC"), new NonEmptyNumber("30000000"), new NonEmptyString("Pablo"), new NonEmptyString("1234fr"), new MedicoEspecialidad(new NonEmptyString("General"))),
                    new CitaTipo(new NonEmptyString("Control"))),
            new Cita(new NonEmptyUUID(UUID.randomUUID().toString()),
                    new NonEmptyLocalTime(LocalTime.now().toString()),
                    new NonEmptyLocalDate(LocalDate.now().toString()),
                    new Paciente(new NonEmptyString("CC"), new NonEmptyNumber("2"), new NonEmptyString("Francisco")),
                    new Medico(new NonEmptyString("CC"), new NonEmptyNumber("30000000"), new NonEmptyString("Pablo"), new NonEmptyString("1234fr"), new MedicoEspecialidad(new NonEmptyString("General"))),
                    new CitaTipo(new NonEmptyString("Control"))),
            new Cita(new NonEmptyUUID(UUID.randomUUID().toString()),
                    new NonEmptyLocalTime(LocalTime.now().toString()),
                    new NonEmptyLocalDate(LocalDate.now().toString()),
                    new Paciente(new NonEmptyString("CC"), new NonEmptyNumber("3"), new NonEmptyString("Pablo")),
                    new Medico(new NonEmptyString("CC"), new NonEmptyNumber("30000000"), new NonEmptyString("Pablo"), new NonEmptyString("1234fr"), new MedicoEspecialidad(new NonEmptyString("General"))),
                    new CitaTipo(new NonEmptyString("Control")))
    );

    public static Optional<Medico> OPTIONAL_MEDICO = Optional.of(new Medico(new NonEmptyString("CC"), new NonEmptyNumber("30000000"), new NonEmptyString("Pablo"), new NonEmptyString("1234fr"), new MedicoEspecialidad(new NonEmptyString("General"))));
    public static Optional<Paciente> OPTIONAL_PACIENTE = Optional.of(new Paciente(new NonEmptyString("CC"), new NonEmptyNumber("1"), new NonEmptyString("Pedro")));
    public static Optional<CitaTipo> OPTIONAL_CITA_TIPO = Optional.of(new CitaTipo(new NonEmptyString("Control")));

    public static CitaSaveRequest SAVE_REQUEST_EMPTY = new CitaSaveRequest();

    public static CitaSaveRequest saveRequestFechaNotFormat(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-0h1");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestHoraNotNull(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestHoraNotFormat(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:300");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestMedicoIdNull(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestMedicoIdNotFound(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef0");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestMedicoIdNotFormat(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestPacienteIdNull(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestPacienteIdNotFound(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("78c6729c-b9bd-49b8-84cc-524b6e9caee5");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestPacienteIdNotFormat(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("fd");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestCitaTipoIdNull(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("78c6729c-b9bd-49b8-84cc-524b6e9caeef");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestCitaTipoIdNotFound(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("78c6729c-b9bd-49b8-84cc-524b6e9caeef");
        saveRequest.setCitaTipoId("d763e7e4-de39-4bd4-8f99-20ee8d41d239");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestCitaTipoIdNotFormat(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("78c6729c-b9bd-49b8-84cc-524b6e9caeef");
        saveRequest.setCitaTipoId("fd");
        return saveRequest;
    }

    public static CitaSaveRequest saveRequestCita(){
        CitaSaveRequest saveRequest = new CitaSaveRequest();
        saveRequest.setFecha("2022-01-01");
        saveRequest.setHora("10:15:30");
        saveRequest.setMedicoId("fd6f68fe-79c2-47e2-adb5-46e97c47aef9");
        saveRequest.setPacienteId("78c6729c-b9bd-49b8-84cc-524b6e9caeef");
        saveRequest.setCitaTipoId("d763e7e4-de39-4bd4-8f99-20ee8d41d23e");
        return saveRequest;
    }

}

package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.commons.NonEmptyUUID;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.application.errors.CitaTipoIdNotFound;
import com.prueba.consultorio.application.errors.InputDataError;
import com.prueba.consultorio.application.errors.MedicoIdNotFound;
import com.prueba.consultorio.application.errors.PacienteIdNotFound;
import com.prueba.consultorio.application.models.cita.CitaSaveResponse;
import com.prueba.consultorio.application.ports.out.CitaRepository;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CitaSaveServiceTest {

    @Mock
    private CitaRepository citaRepository;
    @Mock
    private MedicoRepository medicoRepository;
    @Mock
    private PacienteRepositiry pacienteRepositiry;
    @Mock
    private CitaTipoRepository citaTipoRepository;
    @InjectMocks
    private CitaSaveService citaSaveService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void citaSaveServiceValidFechaNullTest() {
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
           citaSaveService.execute(Data.SAVE_REQUEST_EMPTY);
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("fecha"));
        assertEquals(inputDataError.getMessage(), "parameter can not be null");
    }

    @Test
    void citaSaveServiceValidFechaNotFormatTestTest() {
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestFechaNotFormat());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("fecha"));
        assertEquals(inputDataError.getMessage(), "value of parameter not allowed");
    }

    @Test
    void citaSaveServiceValidHoraNullTestTest() {
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestHoraNotNull());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("hora"));
        assertEquals(inputDataError.getMessage(), "parameter can not be null");
    }

    @Test
    void citaSaveServiceValidHoraNotFormatTestTest() {
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestHoraNotFormat());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("hora"));
        assertEquals(inputDataError.getMessage(), "value of parameter not allowed");
    }

    @Test
    void citaSaveServiceValidMedicoIdNullTest(){
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestMedicoIdNull());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("medicoId"));
        assertEquals(inputDataError.getMessage(), "parameter can not be null");
    }

    @Test
    void citaSaveServiceValidMedicoIdNotFormatTest(){
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestMedicoIdNotFormat());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("medicoId"));
        assertEquals(inputDataError.getMessage(), "value of parameter not allowed");
    }

    @Test
    void citaSaveServiceValidMedicoIdNotFoundTest(){
        MedicoIdNotFound inputDataError =  assertThrows(MedicoIdNotFound.class, ()->{
            citaSaveService.execute(Data.saveRequestMedicoIdNotFound());
        });

        assertTrue(inputDataError.errorCode().contains("MEDICO_NOT_FOUND_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("medicoId"));
        assertEquals(inputDataError.getMessage(), "Medico not found");
    }

    @Test
    void citaSaveServiceValidPacienteIdNullTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestPacienteIdNull());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("pacienteId"));
        assertEquals(inputDataError.getMessage(), "parameter can not be null");
    }

    @Test
    void citaSaveServiceValidPacienteIdNotFormatTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestPacienteIdNotFormat());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("pacienteId"));
        assertEquals(inputDataError.getMessage(), "value of parameter not allowed");
    }

    @Test
    void citaSaveServiceValidPacienteIdNotFoundTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        PacienteIdNotFound pacienteIdNotFound = assertThrows(PacienteIdNotFound.class, ()->{
            citaSaveService.execute(Data.saveRequestPacienteIdNotFound());
        });

        assertTrue(pacienteIdNotFound.errorCode().contains("PACIENTE_NOT_FOUND_ERROR"));
        assertTrue(pacienteIdNotFound.metadata().keySet().contains("pacienteId"));
        assertEquals(pacienteIdNotFound.getMessage(), "Paciente not found");
    }

    @Test
    void citaSaveServiceValidCitaTipoIdNullTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        when(pacienteRepositiry.findId(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_PACIENTE);
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestCitaTipoIdNull());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("citaTipoId"));
        assertEquals(inputDataError.getMessage(), "parameter can not be null");
    }

    @Test
    void citaSaveServiceValidCitaTipoNotFormatTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        when(pacienteRepositiry.findId(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_PACIENTE);
        InputDataError inputDataError =  assertThrows(InputDataError.class, ()->{
            citaSaveService.execute(Data.saveRequestCitaTipoIdNotFormat());
        });

        assertTrue(inputDataError.errorCode().contains("INPUT_DATA_ERROR"));
        assertTrue(inputDataError.metadata().keySet().contains("citaTipoId"));
        assertEquals(inputDataError.getMessage(), "value of parameter not allowed");
    }

    @Test
    void citaSaveServiceValidCitaTipoIdNotFoundTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        when(pacienteRepositiry.findId(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_PACIENTE);
        CitaTipoIdNotFound citaTipoIdNotFound = assertThrows(CitaTipoIdNotFound.class, ()->{
            citaSaveService.execute(Data.saveRequestCitaTipoIdNotFound());
        });

        assertTrue(citaTipoIdNotFound.errorCode().contains("CITA_TIPO_NOT_FOUND_ERROR"));
        assertTrue(citaTipoIdNotFound.metadata().keySet().contains("citaTipoId"));
        assertEquals(citaTipoIdNotFound.getMessage(), "Cita tipo not found");
    }

    @Test
    void citaSaveServiceTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        when(pacienteRepositiry.findId(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_PACIENTE);
        when(citaTipoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_CITA_TIPO);
        when(citaRepository.save(any(Cita.class))).then(invocationOnMock -> {
            Cita cita = invocationOnMock.getArgument(0);
            cita.setIdCita(new NonEmptyUUID(UUID.randomUUID().toString()));
            return Optional.of(cita);
        });

        CitaSaveResponse citaSaveResponse = citaSaveService.execute(Data.saveRequestCita());
        assertNotNull(citaSaveResponse.getCita().getIdCita());
    }

    @Test
    void citaSaveServiceRuntimeExceptionTest(){
        when(medicoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_MEDICO);
        when(pacienteRepositiry.findId(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_PACIENTE);
        when(citaTipoRepository.findById(any(NonEmptyUUID.class))).thenReturn(Data.OPTIONAL_CITA_TIPO);
        when(citaRepository.save(any(Cita.class))).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            citaSaveService.execute(Data.saveRequestCita());
        });

        assertEquals(runtimeException.getMessage(), "Error trying to save");
    }


}
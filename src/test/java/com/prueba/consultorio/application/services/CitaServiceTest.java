package com.prueba.consultorio.application.services;

import com.prueba.consultorio.application.models.cita.CitaListRequest;
import com.prueba.consultorio.application.models.cita.CitaListResponse;
import com.prueba.consultorio.application.ports.out.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CitaListServiceTest {

    @Mock
    CitaRepository citaRepository;

    @InjectMocks
    CitaListService citaListService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void citaListTest(){
        when(citaRepository.list()).thenReturn(Data.CITAS);
        CitaListResponse citaListResponse = citaListService.execute(null);

        assertNotNull(citaListResponse);
        assertEquals(3, citaListResponse.getCitas().size());
        assertTrue(citaListResponse.getCitas().get(1).getPaciente().getNombres().getValue().contains("Francisco"));
    }

}
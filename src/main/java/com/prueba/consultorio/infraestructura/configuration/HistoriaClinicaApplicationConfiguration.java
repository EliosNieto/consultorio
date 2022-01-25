package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.HistoriaClinicaDeleteUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaListUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaSaveUseCase;
import com.prueba.consultorio.application.services.HistoriaClinicaDeleteService;
import com.prueba.consultorio.application.services.HistoriaClinicaFindByIdService;
import com.prueba.consultorio.application.services.HistoriaClinicaListService;
import com.prueba.consultorio.application.services.HistoriaClinicaSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.HistoriaClinicaRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.MedicoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.PacienteRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoriaClinicaApplicationConfiguration {

    @Bean
    public HistoriaClinicaListUseCase historiaClinicaListUseCase(HistoriaClinicaRepositoryImpl historiaClinicaRepository){
        return new HistoriaClinicaListService(historiaClinicaRepository);
    }

    @Bean
    public HistoriaClinicaSaveUseCase historiaClinicaSaveUseCase(HistoriaClinicaRepositoryImpl historiaClinicaRepository, MedicoRepositoryImpl medicoRepository, PacienteRepositoryImpl pacienteRepository){
        return new HistoriaClinicaSaveService(historiaClinicaRepository, pacienteRepository, medicoRepository);
    }

    @Bean
    public HistoriaClinicaDeleteUseCase historiaClinicaDeleteUseCase(HistoriaClinicaRepositoryImpl historiaClinicaRepository){
        return new HistoriaClinicaDeleteService(historiaClinicaRepository);
    }

    @Bean
    public HistoriaClinicaFindByIdUseCase historiaClinicaFindByIdUseCase(HistoriaClinicaRepositoryImpl historiaClinicaRepository){
        return new HistoriaClinicaFindByIdService(historiaClinicaRepository);
    }
}

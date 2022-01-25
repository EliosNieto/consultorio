package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.MedicoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.MedicoFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.MedicoListUseCase;
import com.prueba.consultorio.application.ports.in.MedicoSaveUseCase;
import com.prueba.consultorio.application.services.MedicoDeleteService;
import com.prueba.consultorio.application.services.MedicoFindByIdService;
import com.prueba.consultorio.application.services.MedicoListService;
import com.prueba.consultorio.application.services.MedicoSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.EspecialidadRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.MedicoRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicoApplicationConfiguration {

    @Bean
    public MedicoListUseCase medicoListUseCase(MedicoRepositoryImpl medicoRepository){
        return new MedicoListService(medicoRepository);
    }

    @Bean
    public MedicoSaveUseCase medicoSaveUseCase(MedicoRepositoryImpl medicoRepository, EspecialidadRepositoryImpl especialidadRepository){
        return new MedicoSaveService(medicoRepository, especialidadRepository);
    }

    @Bean
    public MedicoDeleteUseCase medicoDeleteUseCase(MedicoRepositoryImpl medicoRepository){
        return new MedicoDeleteService(medicoRepository);
    }

    @Bean
    public MedicoFindByIdUseCase medicoFindByIdUseCase(MedicoRepositoryImpl medicoRepository){
        return new MedicoFindByIdService(medicoRepository);
    }
}

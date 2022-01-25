package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.EspecialidadDeleteUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadListUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadSaveUseCase;
import com.prueba.consultorio.application.services.EspecialidadDeleteService;
import com.prueba.consultorio.application.services.EspecialidadFindByIdService;
import com.prueba.consultorio.application.services.EspecialidadListService;
import com.prueba.consultorio.application.services.EspecialidadSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.EspecialidadRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EspecialidadAppliationConfiguration {

    @Bean
    public EspecialidadListUseCase especialidadListUseCase(EspecialidadRepositoryImpl especialidadRepository){
        return new EspecialidadListService(especialidadRepository);
    }

    @Bean
    public EspecialidadSaveUseCase especialidadSaveUseCase(EspecialidadRepositoryImpl especialidadRepository){
        return new EspecialidadSaveService(especialidadRepository);
    }

    @Bean
    public EspecialidadDeleteUseCase especialidadDeleteUseCase(EspecialidadRepositoryImpl especialidadRepository){
        return new EspecialidadDeleteService(especialidadRepository);
    }

    @Bean
    public EspecialidadFindByIdUseCase especialidadFindByIdUseCase(EspecialidadRepositoryImpl especialidadRepository){
        return new EspecialidadFindByIdService(especialidadRepository);
    }
}

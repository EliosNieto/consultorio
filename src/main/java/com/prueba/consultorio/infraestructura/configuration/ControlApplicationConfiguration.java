package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.ControlDeleteUseCase;
import com.prueba.consultorio.application.ports.in.ControlFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.ControlListUseCase;
import com.prueba.consultorio.application.ports.in.ControlSaveUseCase;
import com.prueba.consultorio.application.services.ControlDeleteService;
import com.prueba.consultorio.application.services.ControlFindByIdService;
import com.prueba.consultorio.application.services.ControlListService;
import com.prueba.consultorio.application.services.ControlSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.ControlRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.MedicoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.PacienteRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControlApplicationConfiguration {

    @Bean
    public ControlListUseCase controlListUseCase(ControlRepositoryImpl controlRepository){
        return new ControlListService(controlRepository);
    }

    @Bean
    public ControlSaveUseCase controlSaveUseCase(ControlRepositoryImpl controlRepository, MedicoRepositoryImpl medicoRepository, PacienteRepositoryImpl pacienteRepository){
        return new ControlSaveService(controlRepository, pacienteRepository, medicoRepository);
    }

    @Bean
    public ControlFindByIdUseCase controlFindByIdUseCase(ControlRepositoryImpl controlRepository){
        return new ControlFindByIdService(controlRepository);
    }

    @Bean
    public ControlDeleteUseCase controlDeleteUseCase(ControlRepositoryImpl controlRepository){
        return new ControlDeleteService(controlRepository);
    }
}

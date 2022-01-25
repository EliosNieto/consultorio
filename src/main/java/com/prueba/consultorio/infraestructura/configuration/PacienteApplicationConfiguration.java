package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.PacienteDeleteUseCase;
import com.prueba.consultorio.application.ports.in.PacienteFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.PacienteListUseCase;
import com.prueba.consultorio.application.ports.in.PacienteSaveUseCase;
import com.prueba.consultorio.application.services.PacienteDeleteService;
import com.prueba.consultorio.application.services.PacienteFindByIdService;
import com.prueba.consultorio.application.services.PacienteListService;
import com.prueba.consultorio.application.services.PacienteSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.PacienteRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteApplicationConfiguration {

    @Bean
    public PacienteSaveUseCase pacienteSaveUseCase(PacienteRepositoryImpl pacienteRepository ){
        return new PacienteSaveService(pacienteRepository);
    }

    @Bean
    public PacienteListUseCase pacienteListUseCase(PacienteRepositoryImpl pacienteRepository){
        return new PacienteListService(pacienteRepository);
    }

    @Bean
    public PacienteDeleteUseCase pacienteDeleteUseCase(PacienteRepositoryImpl pacienteRepository){
        return new PacienteDeleteService(pacienteRepository);
    }

    @Bean
    public PacienteFindByIdUseCase pacienteFindByIdUseCase(PacienteRepositoryImpl pacienteRepository){
        return new PacienteFindByIdService(pacienteRepository);
    }
}

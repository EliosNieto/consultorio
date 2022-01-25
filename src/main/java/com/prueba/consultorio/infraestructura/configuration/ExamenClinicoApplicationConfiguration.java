package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.ExamenClinicoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.ExamenClinicoListUseCase;
import com.prueba.consultorio.application.ports.in.ExamenClinicoSaveUseCase;
import com.prueba.consultorio.application.services.ExamenClinicoDeleteService;
import com.prueba.consultorio.application.services.ExamenClinicoFindByIdService;
import com.prueba.consultorio.application.services.ExamenClinicoListService;
import com.prueba.consultorio.application.services.ExamenClinicoSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.ExamenClinicoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.MedicoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.PacienteRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamenClinicoApplicationConfiguration {

    @Bean
    public ExamenClinicoListUseCase examenClinicoListUseCase(ExamenClinicoRepositoryImpl examenClinicoRepository){
        return new ExamenClinicoListService(examenClinicoRepository);
    }

    @Bean
    public ExamenClinicoSaveUseCase examenClinicoSaveUseCase(ExamenClinicoRepositoryImpl examenClinicoRepository, MedicoRepositoryImpl medicoRepository, PacienteRepositoryImpl pacienteRepository){
        return new ExamenClinicoSaveService(medicoRepository, pacienteRepository, examenClinicoRepository);
    }

    @Bean
    public ExamenClinicoFindByIdService examenClinicoFindByIdService(ExamenClinicoRepositoryImpl examenClinicoRepository){
        return new ExamenClinicoFindByIdService(examenClinicoRepository);
    }

    @Bean
    public ExamenClinicoDeleteUseCase examenClinicoDeleteUseCase(ExamenClinicoRepositoryImpl examenClinicoRepository){
        return new ExamenClinicoDeleteService(examenClinicoRepository);
    }
}

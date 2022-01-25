package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.CitaTipoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoListUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoSaveUseCase;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;
import com.prueba.consultorio.application.services.CitaTipoDeleteService;
import com.prueba.consultorio.application.services.CitaTipoFindByIdService;
import com.prueba.consultorio.application.services.CitaTipoListService;
import com.prueba.consultorio.application.services.CitaTipoSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.CitaTipoRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitaTipoApplicationConfiguration {

    @Bean
    public CitaTipoListUseCase citaTipoListUseCase(CitaTipoRepositoryImpl citaTipoRepository){
        return new CitaTipoListService(citaTipoRepository);
    }

    @Bean
    public CitaTipoSaveUseCase citaTipoSaveUseCase(CitaTipoRepository citaTipoRepository){
        return new CitaTipoSaveService(citaTipoRepository);
    }

    @Bean
    public CitaTipoDeleteUseCase citaTipoDeleteUseCase(CitaTipoRepository citaTipoRepository){
        return new CitaTipoDeleteService(citaTipoRepository);
    }

    @Bean
    public CitaTipoFindByIdUseCase citaTipoFindByIdUseCase(CitaTipoRepository citaTipoRepository){
        return new CitaTipoFindByIdService(citaTipoRepository);
    }
}

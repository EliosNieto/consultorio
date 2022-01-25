package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.EnfermeraDeleteUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraListUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraSaveUseCase;
import com.prueba.consultorio.application.services.EnfermeraFindByIdService;
import com.prueba.consultorio.application.services.EnfermeraDeleteService;
import com.prueba.consultorio.application.services.EnfermeraListService;
import com.prueba.consultorio.application.services.EnfermeraSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.EnfermeraRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnfermeriaApplicationConfiguration {

    @Bean
    public EnfermeraListUseCase enfermeraListUseCase(EnfermeraRepositoryImpl enfermeraRepository){
        return new EnfermeraListService(enfermeraRepository);
    }

    @Bean
    public EnfermeraSaveUseCase enfermeraSaveUseCase(EnfermeraRepositoryImpl enfermeraRepository){
        return new EnfermeraSaveService(enfermeraRepository);
    }

    @Bean
    public EnfermeraDeleteUseCase enfermeraDeleteUseCase(EnfermeraRepositoryImpl enfermeraRepository){
        return new EnfermeraDeleteService(enfermeraRepository);
    }

    @Bean
    public EnfermeraFindByIdUseCase enfermeraFindByIdUseCase(EnfermeraRepositoryImpl enfermeraRepository){
        return new EnfermeraFindByIdService(enfermeraRepository);
    }
}

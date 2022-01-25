package com.prueba.consultorio.infraestructura.configuration;

import com.prueba.consultorio.application.ports.in.CitaDeleteUseCase;
import com.prueba.consultorio.application.ports.in.CitaFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.CitaListUseCase;
import com.prueba.consultorio.application.ports.in.CitaSaveUseCase;
import com.prueba.consultorio.application.ports.out.CitaRepository;
import com.prueba.consultorio.application.ports.out.CitaTipoRepository;
import com.prueba.consultorio.application.ports.out.MedicoRepository;
import com.prueba.consultorio.application.ports.out.PacienteRepositiry;
import com.prueba.consultorio.application.services.CitaDeleteService;
import com.prueba.consultorio.application.services.CitaFindByIdService;
import com.prueba.consultorio.application.services.CitaListService;
import com.prueba.consultorio.application.services.CitaSaveService;
import com.prueba.consultorio.infraestructura.adapter.out.CitaRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.CitaTipoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.MedicoRepositoryImpl;
import com.prueba.consultorio.infraestructura.adapter.out.PacienteRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitaApplicationConfiguration {

    @Bean
    public CitaListUseCase citaListUseCase(CitaRepository citaRepository){
        return new CitaListService(citaRepository);
    }

    @Bean
    public CitaSaveUseCase citaSaveUseCase(CitaRepositoryImpl citaRepository, MedicoRepositoryImpl medicoRepository, PacienteRepositoryImpl pacienteRepositiry, CitaTipoRepositoryImpl citaTipoRepository){
        return new CitaSaveService(citaRepository, medicoRepository,pacienteRepositiry,citaTipoRepository);
    }

    @Bean
    public CitaDeleteUseCase citaDeleteUseCase(CitaRepositoryImpl citaRepository){
        return new CitaDeleteService(citaRepository);
    }

    @Bean
    public CitaFindByIdUseCase citaFindByIdUseCase(CitaRepositoryImpl citaRepository){
        return new CitaFindByIdService(citaRepository);
    }

}

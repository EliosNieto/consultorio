package com.prueba.consultorio.infraestructura.adapter.out;

import com.prueba.consultorio.application.domains.Cita;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CitaRepositoryImplTest {

    @Autowired
    private CitaRepositoryImpl citaRepository;

    @Test
    void listTest(){
        List<Cita> list = citaRepository.list();
    }
}
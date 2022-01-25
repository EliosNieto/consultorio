package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.enfermera.EnfermeraDeleteRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraFindByIdRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraListRequest;
import com.prueba.consultorio.application.models.enfermera.EnfermeraSaveRequest;
import com.prueba.consultorio.application.ports.in.EnfermeraDeleteUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraListUseCase;
import com.prueba.consultorio.application.ports.in.EnfermeraSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/enfermera")
public class EnfermeraController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final EnfermeraListUseCase enfermeraListUseCase;
    private final EnfermeraSaveUseCase enfermeraSaveUseCase;
    private final EnfermeraDeleteUseCase enfermeraDeleteUseCase;
    private final EnfermeraFindByIdUseCase enfermeraFindByIdUseCase;

    public EnfermeraController(UseCaseHttpExecutor useCaseHttpExecutor, EnfermeraListUseCase enfermeraListUseCase, EnfermeraSaveUseCase enfermeraSaveUseCase, EnfermeraDeleteUseCase enfermeraDeleteUseCase, EnfermeraFindByIdUseCase enfermeraFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.enfermeraListUseCase = enfermeraListUseCase;
        this.enfermeraSaveUseCase = enfermeraSaveUseCase;
        this.enfermeraDeleteUseCase = enfermeraDeleteUseCase;
        this.enfermeraFindByIdUseCase = enfermeraFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity enfermeraListHandler(){
        return useCaseHttpExecutor.executeUseCase(enfermeraListUseCase, new EnfermeraListRequest());
    }

    @PostMapping
    public ResponseEntity enfermeraSaveHandler(@RequestBody EnfermeraSaveRequest enfermeraSaveRequest){
        return useCaseHttpExecutor.executeUseCase(enfermeraSaveUseCase, enfermeraSaveRequest);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity enfermeraDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(enfermeraDeleteUseCase, new EnfermeraDeleteRequest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity enefermeraFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(enfermeraFindByIdUseCase, new EnfermeraFindByIdRequest(id));
    }

}

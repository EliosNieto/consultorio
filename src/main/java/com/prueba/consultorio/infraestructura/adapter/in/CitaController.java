package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.cita.CitaDeleteRequest;
import com.prueba.consultorio.application.models.cita.CitaFindByIdRequest;
import com.prueba.consultorio.application.models.cita.CitaListRequest;
import com.prueba.consultorio.application.models.cita.CitaSaveRequest;
import com.prueba.consultorio.application.ports.in.CitaDeleteUseCase;
import com.prueba.consultorio.application.ports.in.CitaFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.CitaListUseCase;
import com.prueba.consultorio.application.ports.in.CitaSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cita")
public class CitaController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CitaListUseCase citaListUseCase;
    private final CitaSaveUseCase citaSaveUseCase;
    private final CitaDeleteUseCase citaDeleteUseCase;
    private final CitaFindByIdUseCase citaFindByIdUseCase;

    public CitaController(UseCaseHttpExecutor useCaseHttpExecutor, CitaListUseCase citaListUseCase, CitaSaveUseCase citaSaveUseCase, CitaDeleteUseCase citaDeleteUseCase, CitaFindByIdUseCase citaFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.citaListUseCase = citaListUseCase;
        this.citaSaveUseCase = citaSaveUseCase;
        this.citaDeleteUseCase = citaDeleteUseCase;
        this.citaFindByIdUseCase = citaFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity citaListHandler(){
        return useCaseHttpExecutor.executeUseCase(citaListUseCase, new CitaListRequest());
    }

    @PostMapping
    public ResponseEntity citaSaveHandler(@RequestBody CitaSaveRequest request){
        return useCaseHttpExecutor.executeUseCase(citaSaveUseCase, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity citaFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(citaFindByIdUseCase, new CitaFindByIdRequest(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity citaDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(citaDeleteUseCase, new CitaDeleteRequest(id));
    }
}

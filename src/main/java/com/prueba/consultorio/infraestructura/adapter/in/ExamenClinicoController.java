package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.examenclinico.*;
import com.prueba.consultorio.application.ports.in.ExamenClinicoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.ExamenClinicoFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.ExamenClinicoListUseCase;
import com.prueba.consultorio.application.ports.in.ExamenClinicoSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/examenclinico")
public class ExamenClinicoController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final ExamenClinicoListUseCase examenClinicoListUseCase;
    private final ExamenClinicoSaveUseCase examenClinicoSaveUseCase;
    private final ExamenClinicoDeleteUseCase examenClinicoDeleteUseCase;
    private final ExamenClinicoFindByIdUseCase examenClinicoFindByIdUseCase;

    public ExamenClinicoController(UseCaseHttpExecutor useCaseHttpExecutor, ExamenClinicoListUseCase examenClinicoListUseCase, ExamenClinicoSaveUseCase examenClinicoSaveUseCase, ExamenClinicoDeleteUseCase examenClinicoDeleteUseCase, ExamenClinicoFindByIdUseCase examenClinicoFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.examenClinicoListUseCase = examenClinicoListUseCase;
        this.examenClinicoSaveUseCase = examenClinicoSaveUseCase;
        this.examenClinicoDeleteUseCase = examenClinicoDeleteUseCase;
        this.examenClinicoFindByIdUseCase = examenClinicoFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity examenClinicoListHandler(){
        return useCaseHttpExecutor.executeUseCase(examenClinicoListUseCase, new ExamenClinicoListRequest());
    }

    @PostMapping
    public ResponseEntity examenClinicoSaveHandler(@RequestBody ExamenClinicoSaveRequest examenClinicoSaveRequest){
        return useCaseHttpExecutor.executeUseCase(examenClinicoSaveUseCase, examenClinicoSaveRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity examenClinicoFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(examenClinicoFindByIdUseCase, new ExamenClinicoFindByIdRequest(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity examenClinicoDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(examenClinicoDeleteUseCase, new ExamenClinicoDeleteRequest(id));
    }
}

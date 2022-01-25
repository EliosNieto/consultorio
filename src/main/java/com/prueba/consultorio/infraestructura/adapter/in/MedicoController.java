package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.medico.MedicoDeleteRequest;
import com.prueba.consultorio.application.models.medico.MedicoFindByIdRequest;
import com.prueba.consultorio.application.models.medico.MedicoListRequest;
import com.prueba.consultorio.application.models.medico.MedicoSaveRequest;
import com.prueba.consultorio.application.ports.in.MedicoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.MedicoFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.MedicoListUseCase;
import com.prueba.consultorio.application.ports.in.MedicoSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medico")
public class MedicoController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final MedicoListUseCase medicoListUseCase;
    private final MedicoSaveUseCase saveUseCase;
    private final MedicoDeleteUseCase medicoDeleteUseCase;
    private final MedicoFindByIdUseCase medicoFindByIdUseCase;

    public MedicoController(UseCaseHttpExecutor useCaseHttpExecutor, MedicoListUseCase medicoListUseCase, MedicoSaveUseCase saveUseCase, MedicoDeleteUseCase medicoDeleteUseCase, MedicoFindByIdUseCase medicoFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.medicoListUseCase = medicoListUseCase;
        this.saveUseCase = saveUseCase;
        this.medicoDeleteUseCase = medicoDeleteUseCase;
        this.medicoFindByIdUseCase = medicoFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity medicoListHandler(){
        return useCaseHttpExecutor.executeUseCase(medicoListUseCase, new MedicoListRequest());
    }

    @PostMapping
    public ResponseEntity medicoSaveHandler(@RequestBody MedicoSaveRequest request){
        return useCaseHttpExecutor.executeUseCase(saveUseCase, request);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity medicoDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(medicoDeleteUseCase, new MedicoDeleteRequest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity medicoFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(medicoFindByIdUseCase, new MedicoFindByIdRequest(id));
    }
}

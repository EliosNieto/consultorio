package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.citatipo.*;
import com.prueba.consultorio.application.ports.in.CitaTipoDeleteUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoListUseCase;
import com.prueba.consultorio.application.ports.in.CitaTipoSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/citatipo")
public class CitaTipoController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CitaTipoListUseCase citaTipoListUseCase;
    private final CitaTipoSaveUseCase citaTipoSaveUseCase;
    private final CitaTipoDeleteUseCase citaTipoDeleteUseCase;
    private final CitaTipoFindByIdUseCase citaTipoFindByIdUseCase;

    public CitaTipoController(UseCaseHttpExecutor useCaseHttpExecutor, CitaTipoListUseCase citaTipoListUseCase, CitaTipoSaveUseCase citaTipoSaveUseCase, CitaTipoDeleteUseCase citaTipoDeleteUseCase, CitaTipoFindByIdUseCase citaTipoFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.citaTipoListUseCase = citaTipoListUseCase;
        this.citaTipoSaveUseCase = citaTipoSaveUseCase;
        this.citaTipoDeleteUseCase = citaTipoDeleteUseCase;
        this.citaTipoFindByIdUseCase = citaTipoFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity citaTipoListHandler(){
        return useCaseHttpExecutor.executeUseCase(citaTipoListUseCase, new CitaTipoListRequest());
    }

    @PostMapping
    public ResponseEntity citaTipoSaveHandler(@RequestBody CitaTipoSaveRequest request){
        return useCaseHttpExecutor.executeUseCase(citaTipoSaveUseCase, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity citaTipoFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(citaTipoFindByIdUseCase, new CitaTipoFindByIdRequest(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity citaTipoDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(citaTipoDeleteUseCase, new CitaTipoDeleteRequest(id));
    }
}

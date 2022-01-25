package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.especialidad.EspecialidadDeleteRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadFindByIdRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadListRequest;
import com.prueba.consultorio.application.models.especialidad.EspecialidadSaveRequest;
import com.prueba.consultorio.application.ports.in.EspecialidadDeleteUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadListUseCase;
import com.prueba.consultorio.application.ports.in.EspecialidadSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/especialidad")
public class EspecialidadController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final EspecialidadListUseCase listUseCase;
    private final EspecialidadSaveUseCase saveUseCase;
    private final EspecialidadDeleteUseCase especialidadDeleteUseCase;
    private final EspecialidadFindByIdUseCase especialidadFindByIdUseCase;

    public EspecialidadController(UseCaseHttpExecutor useCaseHttpExecutor, EspecialidadListUseCase listUseCase, EspecialidadSaveUseCase saveUseCase, EspecialidadDeleteUseCase especialidadDeleteUseCase, EspecialidadFindByIdUseCase especialidadFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.listUseCase = listUseCase;
        this.saveUseCase = saveUseCase;
        this.especialidadDeleteUseCase = especialidadDeleteUseCase;
        this.especialidadFindByIdUseCase = especialidadFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity especialidadListHandler(){
        return useCaseHttpExecutor.executeUseCase(listUseCase, new EspecialidadListRequest());
    }

    @PostMapping
    public ResponseEntity especialidadSavehandler(@RequestBody EspecialidadSaveRequest request){
        return useCaseHttpExecutor.executeUseCase(saveUseCase, request);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity especialidadDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(especialidadDeleteUseCase, new EspecialidadDeleteRequest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity especialidadFindById(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(especialidadFindByIdUseCase, new EspecialidadFindByIdRequest(id));
    }
}

package com.prueba.consultorio.infraestructura.adapter.in;


import com.prueba.consultorio.application.models.control.ControlDeleteRequest;
import com.prueba.consultorio.application.models.control.ControlFindByIdRequest;
import com.prueba.consultorio.application.models.control.ControlListRequest;
import com.prueba.consultorio.application.models.control.ControlSaveRequest;
import com.prueba.consultorio.application.ports.in.ControlDeleteUseCase;
import com.prueba.consultorio.application.ports.in.ControlFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.ControlListUseCase;
import com.prueba.consultorio.application.ports.in.ControlSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/control")
public class ControlController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final ControlListUseCase controlListUseCase;
    private final ControlSaveUseCase controlSaveUseCase;
    private final ControlDeleteUseCase controlDeleteUseCase;
    private final ControlFindByIdUseCase controlFindByIdUseCase;

    public ControlController(UseCaseHttpExecutor useCaseHttpExecutor, ControlListUseCase controlListUseCase, ControlSaveUseCase controlSaveUseCase, ControlDeleteUseCase controlDeleteUseCase, ControlFindByIdUseCase controlFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.controlListUseCase = controlListUseCase;
        this.controlSaveUseCase = controlSaveUseCase;
        this.controlDeleteUseCase = controlDeleteUseCase;
        this.controlFindByIdUseCase = controlFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity controlListHandler(){
        return useCaseHttpExecutor.executeUseCase(controlListUseCase, new ControlListRequest());
    }

    @PostMapping
    public ResponseEntity controlSaveHandler(@RequestBody ControlSaveRequest controlSaveRequest){
        return useCaseHttpExecutor.executeUseCase(controlSaveUseCase, controlSaveRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity controlFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(controlFindByIdUseCase, new ControlFindByIdRequest(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity controlDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(controlDeleteUseCase, new ControlDeleteRequest(id));
    }
}

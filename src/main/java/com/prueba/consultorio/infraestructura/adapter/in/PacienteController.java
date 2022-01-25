package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.paciente.PacienteDeleteRequest;
import com.prueba.consultorio.application.models.paciente.PacienteFindByIdRequest;
import com.prueba.consultorio.application.models.paciente.PacienteListRequest;
import com.prueba.consultorio.application.models.paciente.PacienteSaveRequest;
import com.prueba.consultorio.application.ports.in.PacienteDeleteUseCase;
import com.prueba.consultorio.application.ports.in.PacienteFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.PacienteListUseCase;
import com.prueba.consultorio.application.ports.in.PacienteSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final PacienteListUseCase pacienteListUseCase;
    private final PacienteSaveUseCase pacienteSaveUseCase;
    private final PacienteDeleteUseCase pacienteDeleteUseCase;
    private final PacienteFindByIdUseCase pacienteFindByIdUseCase;

    public PacienteController(UseCaseHttpExecutor useCaseHttpExecutor, PacienteListUseCase pacienteListUseCase, PacienteSaveUseCase pacienteSaveUseCase, PacienteDeleteUseCase pacienteDeleteUseCase, PacienteFindByIdUseCase pacienteFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.pacienteListUseCase = pacienteListUseCase;
        this.pacienteSaveUseCase = pacienteSaveUseCase;
        this.pacienteDeleteUseCase = pacienteDeleteUseCase;
        this.pacienteFindByIdUseCase = pacienteFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity pacienteListHandler(){
        return useCaseHttpExecutor.executeUseCase(pacienteListUseCase, new PacienteListRequest());
    }

    @PostMapping
    public ResponseEntity pacienteSaveHandler(@RequestBody PacienteSaveRequest request){
        return useCaseHttpExecutor.executeUseCase(pacienteSaveUseCase, request);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity responseEntity(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(pacienteDeleteUseCase, new PacienteDeleteRequest(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity pacienteFindById(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(pacienteFindByIdUseCase, new PacienteFindByIdRequest(id));
    }
}

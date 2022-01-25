package com.prueba.consultorio.infraestructura.adapter.in;

import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaDeleteRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaFindByIdRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaListRequest;
import com.prueba.consultorio.application.models.historiaclinica.HistoriaClinicaSaveRequest;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaDeleteUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaFindByIdUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaListUseCase;
import com.prueba.consultorio.application.ports.in.HistoriaClinicaSaveUseCase;
import com.prueba.consultorio.infraestructura.common.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/historiaclinica")
public class HistoriaClinicaController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final HistoriaClinicaListUseCase historiaClinicaListUseCase;
    private final HistoriaClinicaSaveUseCase historiaClinicaSaveUseCase;
    private final HistoriaClinicaDeleteUseCase historiaClinicaDeleteUseCase;
    private final HistoriaClinicaFindByIdUseCase historiaClinicaFindByIdUseCase;

    public HistoriaClinicaController(UseCaseHttpExecutor useCaseHttpExecutor, HistoriaClinicaListUseCase historiaClinicaListUseCase, HistoriaClinicaSaveUseCase historiaClinicaSaveUseCase, HistoriaClinicaDeleteUseCase historiaClinicaDeleteUseCase, HistoriaClinicaFindByIdUseCase historiaClinicaFindByIdUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.historiaClinicaListUseCase = historiaClinicaListUseCase;
        this.historiaClinicaSaveUseCase = historiaClinicaSaveUseCase;
        this.historiaClinicaDeleteUseCase = historiaClinicaDeleteUseCase;
        this.historiaClinicaFindByIdUseCase = historiaClinicaFindByIdUseCase;
    }

    @GetMapping
    public ResponseEntity historiaClinicaListHandler(){
        return useCaseHttpExecutor.executeUseCase(historiaClinicaListUseCase, new HistoriaClinicaListRequest());
    }

    @PostMapping
    public ResponseEntity historiaClinicaSaveHanlder(@RequestBody HistoriaClinicaSaveRequest historiaClinicaSaveRequest){
        return useCaseHttpExecutor.executeUseCase(historiaClinicaSaveUseCase, historiaClinicaSaveRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity historiaClinicaFindByIdHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(historiaClinicaFindByIdUseCase, new HistoriaClinicaFindByIdRequest(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity historiaClinicaDeleteHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(historiaClinicaDeleteUseCase, new HistoriaClinicaDeleteRequest(id));
    }
}

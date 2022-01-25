package com.prueba.consultorio.infraestructura.common;

import com.prueba.consultorio.application.commons.errors.ApplicationError;
import com.prueba.consultorio.application.commons.operation.ApplicationRequest;
import com.prueba.consultorio.application.commons.operation.ApplicationResponse;
import com.prueba.consultorio.application.commons.operation.ApplicationUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UseCaseHttpExecutor {

    private final Logger logger = LoggerFactory.getLogger(UseCaseHttpExecutor.class);

    public <IN extends ApplicationRequest, OUT extends ApplicationResponse>ResponseEntity executeUseCase(
        ApplicationUseCase<IN,OUT> useCase, IN applicationRequest
    ){
        try{
            OUT response = useCase.execute(applicationRequest);
            return ResponseEntity.status(response.statusCode().getCode()).body(response);
        }catch (ApplicationError applicationError){
            int httpStatusCode = applicationError.httpStatusCode().getCode();
            Map<String, Object> body = Map.of(
                    "Message", applicationError.getMessage(),
                    "errorCode", applicationError.errorCode(),
                    "metadata", applicationError.metadata()
            );
            return ResponseEntity.status(httpStatusCode).body(body);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

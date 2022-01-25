package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.ExamenClinico;
import com.prueba.consultorio.infraestructura.persist.convert.ExamenClinicoBuild;
import com.prueba.consultorio.infraestructura.persist.entity.ExamenClinicoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class, PacienteIdMapper.class, MedicoIdMapper.class})
public interface ExamenClinicoMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "medico", target = "medico"),
            @Mapping(source = "paciente", target = "paciente"),
            @Mapping(source = "estado.value", target = "estado"),
            @Mapping(source = "resultado.value", target = "resultado"),
    })
    public ExamenClinicoEntity toExamenClinicoEntity(ExamenClinico examenClinico);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idExamen")
    })
    public ExamenClinicoBuild toExamenClinicoBuild(ExamenClinicoEntity examenClinicoEntity);
    public List<ExamenClinicoBuild> toExamenClinicoBuild(Iterable<ExamenClinicoEntity> examenClinicoEntitys);

}

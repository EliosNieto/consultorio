package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.Control;
import com.prueba.consultorio.infraestructura.persist.convert.ControlBuild;
import com.prueba.consultorio.infraestructura.persist.entity.ControlEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyLocalDateMap;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyLocalTimeMap;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class, NonEmptyLocalDateMap.class, NonEmptyLocalTimeMap.class,
                                            PacienteIdMapper.class, MedicoIdMapper.class})
public interface ControlMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "fecha.value", target = "fecha"),
            @Mapping(source = "hora.value", target = "hora"),
            @Mapping(source = "observacion.value", target = "observacion"),
            @Mapping(source = "paciente", target = "paciente"),
            @Mapping(source = "medico", target = "medico"),
    })
    public ControlEntity toControlEntity(Control control);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idControl")
    })
    public ControlBuild toControlBuild(ControlEntity controlEntity);
    public List<ControlBuild> toControlBuilds(Iterable<ControlEntity> controlEntity);
}

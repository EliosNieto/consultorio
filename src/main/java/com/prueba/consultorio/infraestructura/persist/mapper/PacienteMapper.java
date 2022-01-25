package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.Paciente;
import com.prueba.consultorio.infraestructura.persist.convert.PacienteBuild;
import com.prueba.consultorio.infraestructura.persist.entity.PacienteEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class})
public interface PacienteMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "tipoDocumento.value", target = "tipoDocumento"),
            @Mapping(source = "numeroDocumento.value", target = "numero"),
            @Mapping(source = "nombres.value", target = "nombres"),
    })
    public PacienteEntity toPacienteEntity(Paciente paciente);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idPaciente"),
    })
    public PacienteBuild toPacienteBuild(PacienteEntity pacienteEntity);
    public List<PacienteBuild> toPacienteBuilds(Iterable<PacienteEntity> pacienteEntities);
}

package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.Medico;
import com.prueba.consultorio.infraestructura.persist.convert.MedicoBuild;
import com.prueba.consultorio.infraestructura.persist.entity.MedicoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyStringMap;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class, NonEmptyStringMap.class, EspecialidadIdMapper.class})
public interface MedicoIdMapper {
    @Mappings({
            @Mapping(source = "idMedico.value", target = "id"),
            @Mapping(source = "tipoDocumento.value", target = "tipoDocumento"),
            @Mapping(source = "numeroDocumento.value", target = "numero"),
            @Mapping(source = "nombres.value", target = "nombres"),
            @Mapping(source = "tarjetaProfesional.value", target = "tarjetaNumero"),
            @Mapping(source = "medicoEspecialidad", target = "especialidadEntity"),

    })
    public MedicoEntity toMedicoIdEntity(Medico medico);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idMedico")
    })
    public MedicoBuild toMedicoBuild(MedicoEntity medico);
    public List<MedicoBuild> toMedicoBuilds(Iterable<MedicoEntity> medicos);

}

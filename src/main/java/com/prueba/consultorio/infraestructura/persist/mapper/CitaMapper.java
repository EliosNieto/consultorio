package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.commons.NonEmptyLocalDate;
import com.prueba.consultorio.application.commons.NonEmptyLocalTime;
import com.prueba.consultorio.application.domains.Cita;
import com.prueba.consultorio.infraestructura.persist.convert.CitaBuild;
import com.prueba.consultorio.infraestructura.persist.entity.CitaEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class, PacienteIdMapper.class, MedicoIdMapper.class, CitaTipoIdMapper.class,
        NonEmptyLocalDate.class, NonEmptyLocalTime.class})
public interface CitaMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "hora.value", target = "hora"),
            @Mapping(source = "date.value", target = "fecha"),
            @Mapping(source = "paciente", target = "paciente"),
            @Mapping(source = "medico", target = "medico"),
            @Mapping(source = "citaTipo", target = "citaTipo"),

    })
    public CitaEntity toCitaEntity(Cita cita);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idCita")
    })
    public CitaBuild toCitaBuild(CitaEntity citaEntity);
    public List<CitaBuild> toCitaBuilds(Iterable<CitaEntity> citaEntity);
}

package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.HistoriaClinica;
import com.prueba.consultorio.infraestructura.persist.convert.HistoriaClinicaBuild;
import com.prueba.consultorio.infraestructura.persist.entity.HistoriaClinicaEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class, MedicoIdMapper.class, PacienteIdMapper.class})
public interface HistoriaClinicaMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "observacion.value", target = "observaciones"),
            @Mapping(source = "medico", target = "medico"),
            @Mapping(source = "paciente", target = "paciente"),
    })
    public HistoriaClinicaEntity toHistoriaClinica(HistoriaClinica historiaClinica);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idHistoria")
    })
    public HistoriaClinicaBuild toHistoriaClinicaBuild(HistoriaClinicaEntity historiaClinicaEntity);
    public List<HistoriaClinicaBuild> toHistoriaClinicaBuilds(Iterable<HistoriaClinicaEntity> historiaClinicaEntitys);
}

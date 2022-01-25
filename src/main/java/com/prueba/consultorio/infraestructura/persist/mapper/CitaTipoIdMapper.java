package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.CitaTipo;
import com.prueba.consultorio.infraestructura.persist.convert.CitaTipoBuild;
import com.prueba.consultorio.infraestructura.persist.entity.CitaTipoEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class})
public interface CitaTipoIdMapper {

    @Mappings({
            @Mapping(source = "idCitaTipo", target = "id"),
            @Mapping(source = "nombre.value", target = "nombre")
    })
    public CitaTipoEntity toCitaTipoIdEntity(CitaTipo citaTipo);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idCitaTipo")
    })
    public CitaTipoBuild toCitaTipoBuild(CitaTipoEntity citaTipo);
    public List<CitaTipoBuild> toCitaTipoBuilds(Iterable<CitaTipoEntity> citaTipo);
}

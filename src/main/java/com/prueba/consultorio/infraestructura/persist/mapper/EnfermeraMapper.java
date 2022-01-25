package com.prueba.consultorio.infraestructura.persist.mapper;

import com.prueba.consultorio.application.domains.Enfermera;
import com.prueba.consultorio.infraestructura.persist.convert.EnfermeraBuild;
import com.prueba.consultorio.infraestructura.persist.entity.EnfermeraEntity;
import com.prueba.consultorio.infraestructura.persist.mapper.common.NonEmptyUUIDMap;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NonEmptyUUIDMap.class})
public interface EnfermeraMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "tipoDocumento.value", target = "tipoDocumento"),
            @Mapping(source = "numero.value", target = "numero"),
            @Mapping(source = "nombres.value", target = "nombres"),
    })
    public EnfermeraEntity toEnfermera(Enfermera enfermera);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "id", target = "idFermera")
    })
    public EnfermeraBuild toEnfermera(EnfermeraEntity enfermera);
    public List<EnfermeraBuild> toEnfermeras(Iterable<EnfermeraEntity> enfermeraEntities);

}

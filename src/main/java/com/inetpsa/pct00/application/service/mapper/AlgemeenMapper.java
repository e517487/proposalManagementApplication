package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.AlgemeenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Algemeen and its DTO AlgemeenDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AlgemeenMapper extends EntityMapper<AlgemeenDTO, Algemeen> {


    @Mapping(target = "aanvraagbericht", ignore = true)
    Algemeen toEntity(AlgemeenDTO algemeenDTO);

    default Algemeen fromId(Long id) {
        if (id == null) {
            return null;
        }
        Algemeen algemeen = new Algemeen();
        algemeen.setId(id);
        return algemeen;
    }
}

package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record46RelatieHuishoudelijkDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record46RelatieHuishoudelijk and its DTO Record46RelatieHuishoudelijkDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record46RelatieHuishoudelijkMapper extends EntityMapper<Record46RelatieHuishoudelijkDTO, Record46RelatieHuishoudelijk> {



    default Record46RelatieHuishoudelijk fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk = new Record46RelatieHuishoudelijk();
        record46RelatieHuishoudelijk.setId(id);
        return record46RelatieHuishoudelijk;
    }
}

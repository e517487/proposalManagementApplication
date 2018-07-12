package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record62UitlegDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record62Uitleg and its DTO Record62UitlegDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record62UitlegMapper extends EntityMapper<Record62UitlegDTO, Record62Uitleg> {



    default Record62Uitleg fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record62Uitleg record62Uitleg = new Record62Uitleg();
        record62Uitleg.setId(id);
        return record62Uitleg;
    }
}

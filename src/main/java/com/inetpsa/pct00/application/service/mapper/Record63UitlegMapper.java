package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record63UitlegDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record63Uitleg and its DTO Record63UitlegDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record63UitlegMapper extends EntityMapper<Record63UitlegDTO, Record63Uitleg> {



    default Record63Uitleg fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record63Uitleg record63Uitleg = new Record63Uitleg();
        record63Uitleg.setId(id);
        return record63Uitleg;
    }
}

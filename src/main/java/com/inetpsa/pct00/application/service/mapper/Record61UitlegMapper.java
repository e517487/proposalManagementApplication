package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record61UitlegDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record61Uitleg and its DTO Record61UitlegDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record61UitlegMapper extends EntityMapper<Record61UitlegDTO, Record61Uitleg> {



    default Record61Uitleg fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record61Uitleg record61Uitleg = new Record61Uitleg();
        record61Uitleg.setId(id);
        return record61Uitleg;
    }
}

package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record99EindDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record99Eind and its DTO Record99EindDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record99EindMapper extends EntityMapper<Record99EindDTO, Record99Eind> {



    default Record99Eind fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record99Eind record99Eind = new Record99Eind();
        record99Eind.setId(id);
        return record99Eind;
    }
}

package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record35ObjectDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record35Object and its DTO Record35ObjectDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record35ObjectMapper extends EntityMapper<Record35ObjectDTO, Record35Object> {



    default Record35Object fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record35Object record35Object = new Record35Object();
        record35Object.setId(id);
        return record35Object;
    }
}

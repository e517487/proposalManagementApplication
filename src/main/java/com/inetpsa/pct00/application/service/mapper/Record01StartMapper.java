package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record01StartDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record01Start and its DTO Record01StartDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record01StartMapper extends EntityMapper<Record01StartDTO, Record01Start> {



    default Record01Start fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record01Start record01Start = new Record01Start();
        record01Start.setId(id);
        return record01Start;
    }
}

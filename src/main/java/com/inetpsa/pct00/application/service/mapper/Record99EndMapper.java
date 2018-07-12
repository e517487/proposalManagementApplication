package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record99EndDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record99End and its DTO Record99EndDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record99EndMapper extends EntityMapper<Record99EndDTO, Record99End> {



    default Record99End fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record99End record99End = new Record99End();
        record99End.setId(id);
        return record99End;
    }
}

package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record45RelatieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record45Relatie and its DTO Record45RelatieDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record45RelatieMapper extends EntityMapper<Record45RelatieDTO, Record45Relatie> {



    default Record45Relatie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record45Relatie record45Relatie = new Record45Relatie();
        record45Relatie.setId(id);
        return record45Relatie;
    }
}

package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record10AanvraagGegevensAlgemeenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record10AanvraagGegevensAlgemeen and its DTO Record10AanvraagGegevensAlgemeenDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record10AanvraagGegevensAlgemeenMapper extends EntityMapper<Record10AanvraagGegevensAlgemeenDTO, Record10AanvraagGegevensAlgemeen> {



    default Record10AanvraagGegevensAlgemeen fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen = new Record10AanvraagGegevensAlgemeen();
        record10AanvraagGegevensAlgemeen.setId(id);
        return record10AanvraagGegevensAlgemeen;
    }
}

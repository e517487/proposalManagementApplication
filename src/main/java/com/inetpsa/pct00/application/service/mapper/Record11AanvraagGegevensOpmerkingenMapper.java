package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record11AanvraagGegevensOpmerkingenDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record11AanvraagGegevensOpmerkingen and its DTO Record11AanvraagGegevensOpmerkingenDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record11AanvraagGegevensOpmerkingenMapper extends EntityMapper<Record11AanvraagGegevensOpmerkingenDTO, Record11AanvraagGegevensOpmerkingen> {



    default Record11AanvraagGegevensOpmerkingen fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen = new Record11AanvraagGegevensOpmerkingen();
        record11AanvraagGegevensOpmerkingen.setId(id);
        return record11AanvraagGegevensOpmerkingen;
    }
}

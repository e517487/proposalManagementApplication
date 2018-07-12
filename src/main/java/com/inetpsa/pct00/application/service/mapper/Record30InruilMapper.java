package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record30InruilDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record30Inruil and its DTO Record30InruilDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record30InruilMapper extends EntityMapper<Record30InruilDTO, Record30Inruil> {



    default Record30Inruil fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record30Inruil record30Inruil = new Record30Inruil();
        record30Inruil.setId(id);
        return record30Inruil;
    }
}

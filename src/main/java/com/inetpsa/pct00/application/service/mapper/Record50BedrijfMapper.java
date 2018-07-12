package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record50BedrijfDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record50Bedrijf and its DTO Record50BedrijfDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record50BedrijfMapper extends EntityMapper<Record50BedrijfDTO, Record50Bedrijf> {



    default Record50Bedrijf fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record50Bedrijf record50Bedrijf = new Record50Bedrijf();
        record50Bedrijf.setId(id);
        return record50Bedrijf;
    }
}

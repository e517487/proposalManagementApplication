package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record25HerfinancieeringDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record25Herfinancieering and its DTO Record25HerfinancieeringDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record25HerfinancieeringMapper extends EntityMapper<Record25HerfinancieeringDTO, Record25Herfinancieering> {



    default Record25Herfinancieering fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record25Herfinancieering record25Herfinancieering = new Record25Herfinancieering();
        record25Herfinancieering.setId(id);
        return record25Herfinancieering;
    }
}

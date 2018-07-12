package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record55ScoringDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record55Scoring and its DTO Record55ScoringDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record55ScoringMapper extends EntityMapper<Record55ScoringDTO, Record55Scoring> {



    default Record55Scoring fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record55Scoring record55Scoring = new Record55Scoring();
        record55Scoring.setId(id);
        return record55Scoring;
    }
}

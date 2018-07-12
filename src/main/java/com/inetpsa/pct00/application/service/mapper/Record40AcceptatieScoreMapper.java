package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record40AcceptatieScoreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record40AcceptatieScore and its DTO Record40AcceptatieScoreDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record40AcceptatieScoreMapper extends EntityMapper<Record40AcceptatieScoreDTO, Record40AcceptatieScore> {



    default Record40AcceptatieScore fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record40AcceptatieScore record40AcceptatieScore = new Record40AcceptatieScore();
        record40AcceptatieScore.setId(id);
        return record40AcceptatieScore;
    }
}

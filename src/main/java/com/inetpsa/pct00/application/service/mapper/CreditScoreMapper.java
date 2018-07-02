package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.CreditScoreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CreditScore and its DTO CreditScoreDTO.
 */
@Mapper(componentModel = "spring", uses = {RequestMapper.class})
public interface CreditScoreMapper extends EntityMapper<CreditScoreDTO, CreditScore> {

    @Mapping(source = "request.id", target = "requestId")
    CreditScoreDTO toDto(CreditScore creditScore);

    @Mapping(source = "requestId", target = "request")
    CreditScore toEntity(CreditScoreDTO creditScoreDTO);

    default CreditScore fromId(Long id) {
        if (id == null) {
            return null;
        }
        CreditScore creditScore = new CreditScore();
        creditScore.setId(id);
        return creditScore;
    }
}

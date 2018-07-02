package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.FinancieleSituatieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity FinancieleSituatie and its DTO FinancieleSituatieDTO.
 */
@Mapper(componentModel = "spring", uses = {FdnAanvragerMapper.class})
public interface FinancieleSituatieMapper extends EntityMapper<FinancieleSituatieDTO, FinancieleSituatie> {

    @Mapping(source = "fdnAanvrager.id", target = "fdnAanvragerId")
    FinancieleSituatieDTO toDto(FinancieleSituatie financieleSituatie);

    @Mapping(source = "fdnAanvragerId", target = "fdnAanvrager")
    FinancieleSituatie toEntity(FinancieleSituatieDTO financieleSituatieDTO);

    default FinancieleSituatie fromId(Long id) {
        if (id == null) {
            return null;
        }
        FinancieleSituatie financieleSituatie = new FinancieleSituatie();
        financieleSituatie.setId(id);
        return financieleSituatie;
    }
}

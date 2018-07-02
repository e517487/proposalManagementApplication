package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.LegitimatiebewijsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Legitimatiebewijs and its DTO LegitimatiebewijsDTO.
 */
@Mapper(componentModel = "spring", uses = {FdnAanvragerMapper.class})
public interface LegitimatiebewijsMapper extends EntityMapper<LegitimatiebewijsDTO, Legitimatiebewijs> {

    @Mapping(source = "fdnAanvrager.id", target = "fdnAanvragerId")
    LegitimatiebewijsDTO toDto(Legitimatiebewijs legitimatiebewijs);

    @Mapping(source = "fdnAanvragerId", target = "fdnAanvrager")
    Legitimatiebewijs toEntity(LegitimatiebewijsDTO legitimatiebewijsDTO);

    default Legitimatiebewijs fromId(Long id) {
        if (id == null) {
            return null;
        }
        Legitimatiebewijs legitimatiebewijs = new Legitimatiebewijs();
        legitimatiebewijs.setId(id);
        return legitimatiebewijs;
    }
}

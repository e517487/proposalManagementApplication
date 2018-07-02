package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.TekstRegelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TekstRegel and its DTO TekstRegelDTO.
 */
@Mapper(componentModel = "spring", uses = {VrijeTekstMapper.class})
public interface TekstRegelMapper extends EntityMapper<TekstRegelDTO, TekstRegel> {

    @Mapping(source = "vrijeTekst.id", target = "vrijeTekstId")
    TekstRegelDTO toDto(TekstRegel tekstRegel);

    @Mapping(source = "vrijeTekstId", target = "vrijeTekst")
    TekstRegel toEntity(TekstRegelDTO tekstRegelDTO);

    default TekstRegel fromId(Long id) {
        if (id == null) {
            return null;
        }
        TekstRegel tekstRegel = new TekstRegel();
        tekstRegel.setId(id);
        return tekstRegel;
    }
}

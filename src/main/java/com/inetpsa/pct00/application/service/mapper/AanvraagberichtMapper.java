package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.AanvraagberichtDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Aanvraagbericht and its DTO AanvraagberichtDTO.
 */
@Mapper(componentModel = "spring", uses = {RekenmoduleAanvraagMapper.class, HeaderMapper.class, AlgemeenMapper.class})
public interface AanvraagberichtMapper extends EntityMapper<AanvraagberichtDTO, Aanvraagbericht> {

    @Mapping(source = "rekenmoduleAanvraag.id", target = "rekenmoduleAanvraagId")
    @Mapping(source = "header.id", target = "headerId")
    @Mapping(source = "algemeen.id", target = "algemeenId")
    AanvraagberichtDTO toDto(Aanvraagbericht aanvraagbericht);

    @Mapping(source = "rekenmoduleAanvraagId", target = "rekenmoduleAanvraag")
    @Mapping(source = "headerId", target = "header")
    @Mapping(source = "algemeenId", target = "algemeen")
    @Mapping(target = "fdnAanvragers", ignore = true)
    @Mapping(target = "kredietAanvraags", ignore = true)
    @Mapping(target = "vrijeTeksts", ignore = true)
    Aanvraagbericht toEntity(AanvraagberichtDTO aanvraagberichtDTO);

    default Aanvraagbericht fromId(Long id) {
        if (id == null) {
            return null;
        }
        Aanvraagbericht aanvraagbericht = new Aanvraagbericht();
        aanvraagbericht.setId(id);
        return aanvraagbericht;
    }
}

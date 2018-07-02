package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.VrijeTekstDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VrijeTekst and its DTO VrijeTekstDTO.
 */
@Mapper(componentModel = "spring", uses = {AanvraagberichtMapper.class})
public interface VrijeTekstMapper extends EntityMapper<VrijeTekstDTO, VrijeTekst> {

    @Mapping(source = "aanvraagbericht.id", target = "aanvraagberichtId")
    VrijeTekstDTO toDto(VrijeTekst vrijeTekst);

    @Mapping(target = "tekstRegels", ignore = true)
    @Mapping(source = "aanvraagberichtId", target = "aanvraagbericht")
    VrijeTekst toEntity(VrijeTekstDTO vrijeTekstDTO);

    default VrijeTekst fromId(Long id) {
        if (id == null) {
            return null;
        }
        VrijeTekst vrijeTekst = new VrijeTekst();
        vrijeTekst.setId(id);
        return vrijeTekst;
    }
}

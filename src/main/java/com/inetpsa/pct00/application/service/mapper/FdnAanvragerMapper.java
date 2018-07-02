package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.FdnAanvragerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity FdnAanvrager and its DTO FdnAanvragerDTO.
 */
@Mapper(componentModel = "spring", uses = {AanvraagberichtMapper.class})
public interface FdnAanvragerMapper extends EntityMapper<FdnAanvragerDTO, FdnAanvrager> {

    @Mapping(source = "aanvraagbericht.id", target = "aanvraagberichtId")
    FdnAanvragerDTO toDto(FdnAanvrager fdnAanvrager);

    @Mapping(target = "adres", ignore = true)
    @Mapping(target = "legitimatiebewijs", ignore = true)
    @Mapping(target = "werksituaties", ignore = true)
    @Mapping(target = "gezinssituaties", ignore = true)
    @Mapping(target = "financieleSituaties", ignore = true)
    @Mapping(source = "aanvraagberichtId", target = "aanvraagbericht")
    FdnAanvrager toEntity(FdnAanvragerDTO fdnAanvragerDTO);

    default FdnAanvrager fromId(Long id) {
        if (id == null) {
            return null;
        }
        FdnAanvrager fdnAanvrager = new FdnAanvrager();
        fdnAanvrager.setId(id);
        return fdnAanvrager;
    }
}

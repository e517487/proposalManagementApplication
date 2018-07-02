package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.KredietAanvraagDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity KredietAanvraag and its DTO KredietAanvraagDTO.
 */
@Mapper(componentModel = "spring", uses = {AanvraagberichtMapper.class})
public interface KredietAanvraagMapper extends EntityMapper<KredietAanvraagDTO, KredietAanvraag> {

    @Mapping(source = "aanvraagbericht.id", target = "aanvraagberichtId")
    KredietAanvraagDTO toDto(KredietAanvraag kredietAanvraag);

    @Mapping(source = "aanvraagberichtId", target = "aanvraagbericht")
    KredietAanvraag toEntity(KredietAanvraagDTO kredietAanvraagDTO);

    default KredietAanvraag fromId(Long id) {
        if (id == null) {
            return null;
        }
        KredietAanvraag kredietAanvraag = new KredietAanvraag();
        kredietAanvraag.setId(id);
        return kredietAanvraag;
    }
}

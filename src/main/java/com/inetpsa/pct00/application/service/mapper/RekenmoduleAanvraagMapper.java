package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.RekenmoduleAanvraagDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RekenmoduleAanvraag and its DTO RekenmoduleAanvraagDTO.
 */
@Mapper(componentModel = "spring", uses = {RequestMapper.class})
public interface RekenmoduleAanvraagMapper extends EntityMapper<RekenmoduleAanvraagDTO, RekenmoduleAanvraag> {

    @Mapping(source = "request.id", target = "requestId")
    RekenmoduleAanvraagDTO toDto(RekenmoduleAanvraag rekenmoduleAanvraag);

    @Mapping(source = "requestId", target = "request")
    @Mapping(target = "aanvraagbericht", ignore = true)
    RekenmoduleAanvraag toEntity(RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO);

    default RekenmoduleAanvraag fromId(Long id) {
        if (id == null) {
            return null;
        }
        RekenmoduleAanvraag rekenmoduleAanvraag = new RekenmoduleAanvraag();
        rekenmoduleAanvraag.setId(id);
        return rekenmoduleAanvraag;
    }
}

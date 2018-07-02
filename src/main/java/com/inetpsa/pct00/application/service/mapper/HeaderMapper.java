package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.HeaderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Header and its DTO HeaderDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HeaderMapper extends EntityMapper<HeaderDTO, Header> {


    @Mapping(target = "aanvraagbericht", ignore = true)
    Header toEntity(HeaderDTO headerDTO);

    default Header fromId(Long id) {
        if (id == null) {
            return null;
        }
        Header header = new Header();
        header.setId(id);
        return header;
    }
}

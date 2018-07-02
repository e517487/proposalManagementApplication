package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.GezinssituatieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Gezinssituatie and its DTO GezinssituatieDTO.
 */
@Mapper(componentModel = "spring", uses = {FdnAanvragerMapper.class})
public interface GezinssituatieMapper extends EntityMapper<GezinssituatieDTO, Gezinssituatie> {

    @Mapping(source = "fdnAanvrager.id", target = "fdnAanvragerId")
    GezinssituatieDTO toDto(Gezinssituatie gezinssituatie);

    @Mapping(source = "fdnAanvragerId", target = "fdnAanvrager")
    Gezinssituatie toEntity(GezinssituatieDTO gezinssituatieDTO);

    default Gezinssituatie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Gezinssituatie gezinssituatie = new Gezinssituatie();
        gezinssituatie.setId(id);
        return gezinssituatie;
    }
}

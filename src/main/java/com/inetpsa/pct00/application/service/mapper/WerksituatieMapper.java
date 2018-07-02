package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.WerksituatieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Werksituatie and its DTO WerksituatieDTO.
 */
@Mapper(componentModel = "spring", uses = {FdnAanvragerMapper.class})
public interface WerksituatieMapper extends EntityMapper<WerksituatieDTO, Werksituatie> {

    @Mapping(source = "fdnAanvrager.id", target = "fdnAanvragerId")
    WerksituatieDTO toDto(Werksituatie werksituatie);

    @Mapping(target = "nawWerkgeverUWVS", ignore = true)
    @Mapping(source = "fdnAanvragerId", target = "fdnAanvrager")
    Werksituatie toEntity(WerksituatieDTO werksituatieDTO);

    default Werksituatie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Werksituatie werksituatie = new Werksituatie();
        werksituatie.setId(id);
        return werksituatie;
    }
}

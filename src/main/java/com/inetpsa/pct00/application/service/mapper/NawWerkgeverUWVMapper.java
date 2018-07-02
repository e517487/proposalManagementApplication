package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.NawWerkgeverUWVDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity NawWerkgeverUWV and its DTO NawWerkgeverUWVDTO.
 */
@Mapper(componentModel = "spring", uses = {WerksituatieMapper.class})
public interface NawWerkgeverUWVMapper extends EntityMapper<NawWerkgeverUWVDTO, NawWerkgeverUWV> {

    @Mapping(source = "werksituatie.id", target = "werksituatieId")
    NawWerkgeverUWVDTO toDto(NawWerkgeverUWV nawWerkgeverUWV);

    @Mapping(source = "werksituatieId", target = "werksituatie")
    NawWerkgeverUWV toEntity(NawWerkgeverUWVDTO nawWerkgeverUWVDTO);

    default NawWerkgeverUWV fromId(Long id) {
        if (id == null) {
            return null;
        }
        NawWerkgeverUWV nawWerkgeverUWV = new NawWerkgeverUWV();
        nawWerkgeverUWV.setId(id);
        return nawWerkgeverUWV;
    }
}

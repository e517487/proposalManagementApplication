package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.AdresDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Adres and its DTO AdresDTO.
 */
@Mapper(componentModel = "spring", uses = {FdnAanvragerMapper.class})
public interface AdresMapper extends EntityMapper<AdresDTO, Adres> {

    @Mapping(source = "fdnAanvrager.id", target = "fdnAanvragerId")
    AdresDTO toDto(Adres adres);

    @Mapping(source = "fdnAanvragerId", target = "fdnAanvrager")
    Adres toEntity(AdresDTO adresDTO);

    default Adres fromId(Long id) {
        if (id == null) {
            return null;
        }
        Adres adres = new Adres();
        adres.setId(id);
        return adres;
    }
}

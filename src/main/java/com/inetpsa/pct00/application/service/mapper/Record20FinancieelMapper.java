package com.inetpsa.pct00.application.service.mapper;

import com.inetpsa.pct00.application.domain.*;
import com.inetpsa.pct00.application.service.dto.Record20FinancieelDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Record20Financieel and its DTO Record20FinancieelDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface Record20FinancieelMapper extends EntityMapper<Record20FinancieelDTO, Record20Financieel> {



    default Record20Financieel fromId(Long id) {
        if (id == null) {
            return null;
        }
        Record20Financieel record20Financieel = new Record20Financieel();
        record20Financieel.setId(id);
        return record20Financieel;
    }
}

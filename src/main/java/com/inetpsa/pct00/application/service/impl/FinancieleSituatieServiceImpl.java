package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.FinancieleSituatieService;
import com.inetpsa.pct00.application.domain.FinancieleSituatie;
import com.inetpsa.pct00.application.repository.FinancieleSituatieRepository;
import com.inetpsa.pct00.application.service.dto.FinancieleSituatieDTO;
import com.inetpsa.pct00.application.service.mapper.FinancieleSituatieMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing FinancieleSituatie.
 */
@Service
@Transactional
public class FinancieleSituatieServiceImpl implements FinancieleSituatieService {

    private final Logger log = LoggerFactory.getLogger(FinancieleSituatieServiceImpl.class);

    private final FinancieleSituatieRepository financieleSituatieRepository;

    private final FinancieleSituatieMapper financieleSituatieMapper;

    public FinancieleSituatieServiceImpl(FinancieleSituatieRepository financieleSituatieRepository, FinancieleSituatieMapper financieleSituatieMapper) {
        this.financieleSituatieRepository = financieleSituatieRepository;
        this.financieleSituatieMapper = financieleSituatieMapper;
    }

    /**
     * Save a financieleSituatie.
     *
     * @param financieleSituatieDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FinancieleSituatieDTO save(FinancieleSituatieDTO financieleSituatieDTO) {
        log.debug("Request to save FinancieleSituatie : {}", financieleSituatieDTO);
        FinancieleSituatie financieleSituatie = financieleSituatieMapper.toEntity(financieleSituatieDTO);
        financieleSituatie = financieleSituatieRepository.save(financieleSituatie);
        return financieleSituatieMapper.toDto(financieleSituatie);
    }

    /**
     * Get all the financieleSituaties.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FinancieleSituatieDTO> findAll() {
        log.debug("Request to get all FinancieleSituaties");
        return financieleSituatieRepository.findAll().stream()
            .map(financieleSituatieMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one financieleSituatie by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FinancieleSituatieDTO> findOne(Long id) {
        log.debug("Request to get FinancieleSituatie : {}", id);
        return financieleSituatieRepository.findById(id)
            .map(financieleSituatieMapper::toDto);
    }

    /**
     * Delete the financieleSituatie by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FinancieleSituatie : {}", id);
        financieleSituatieRepository.deleteById(id);
    }
}

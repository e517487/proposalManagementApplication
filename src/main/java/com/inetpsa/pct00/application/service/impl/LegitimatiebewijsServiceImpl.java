package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.LegitimatiebewijsService;
import com.inetpsa.pct00.application.domain.Legitimatiebewijs;
import com.inetpsa.pct00.application.repository.LegitimatiebewijsRepository;
import com.inetpsa.pct00.application.service.dto.LegitimatiebewijsDTO;
import com.inetpsa.pct00.application.service.mapper.LegitimatiebewijsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Legitimatiebewijs.
 */
@Service
@Transactional
public class LegitimatiebewijsServiceImpl implements LegitimatiebewijsService {

    private final Logger log = LoggerFactory.getLogger(LegitimatiebewijsServiceImpl.class);

    private final LegitimatiebewijsRepository legitimatiebewijsRepository;

    private final LegitimatiebewijsMapper legitimatiebewijsMapper;

    public LegitimatiebewijsServiceImpl(LegitimatiebewijsRepository legitimatiebewijsRepository, LegitimatiebewijsMapper legitimatiebewijsMapper) {
        this.legitimatiebewijsRepository = legitimatiebewijsRepository;
        this.legitimatiebewijsMapper = legitimatiebewijsMapper;
    }

    /**
     * Save a legitimatiebewijs.
     *
     * @param legitimatiebewijsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public LegitimatiebewijsDTO save(LegitimatiebewijsDTO legitimatiebewijsDTO) {
        log.debug("Request to save Legitimatiebewijs : {}", legitimatiebewijsDTO);
        Legitimatiebewijs legitimatiebewijs = legitimatiebewijsMapper.toEntity(legitimatiebewijsDTO);
        legitimatiebewijs = legitimatiebewijsRepository.save(legitimatiebewijs);
        return legitimatiebewijsMapper.toDto(legitimatiebewijs);
    }

    /**
     * Get all the legitimatiebewijs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<LegitimatiebewijsDTO> findAll() {
        log.debug("Request to get all Legitimatiebewijs");
        return legitimatiebewijsRepository.findAll().stream()
            .map(legitimatiebewijsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one legitimatiebewijs by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LegitimatiebewijsDTO> findOne(Long id) {
        log.debug("Request to get Legitimatiebewijs : {}", id);
        return legitimatiebewijsRepository.findById(id)
            .map(legitimatiebewijsMapper::toDto);
    }

    /**
     * Delete the legitimatiebewijs by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Legitimatiebewijs : {}", id);
        legitimatiebewijsRepository.deleteById(id);
    }
}

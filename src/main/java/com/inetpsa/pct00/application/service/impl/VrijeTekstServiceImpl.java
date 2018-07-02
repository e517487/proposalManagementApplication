package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.VrijeTekstService;
import com.inetpsa.pct00.application.domain.VrijeTekst;
import com.inetpsa.pct00.application.repository.VrijeTekstRepository;
import com.inetpsa.pct00.application.service.dto.VrijeTekstDTO;
import com.inetpsa.pct00.application.service.mapper.VrijeTekstMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing VrijeTekst.
 */
@Service
@Transactional
public class VrijeTekstServiceImpl implements VrijeTekstService {

    private final Logger log = LoggerFactory.getLogger(VrijeTekstServiceImpl.class);

    private final VrijeTekstRepository vrijeTekstRepository;

    private final VrijeTekstMapper vrijeTekstMapper;

    public VrijeTekstServiceImpl(VrijeTekstRepository vrijeTekstRepository, VrijeTekstMapper vrijeTekstMapper) {
        this.vrijeTekstRepository = vrijeTekstRepository;
        this.vrijeTekstMapper = vrijeTekstMapper;
    }

    /**
     * Save a vrijeTekst.
     *
     * @param vrijeTekstDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public VrijeTekstDTO save(VrijeTekstDTO vrijeTekstDTO) {
        log.debug("Request to save VrijeTekst : {}", vrijeTekstDTO);
        VrijeTekst vrijeTekst = vrijeTekstMapper.toEntity(vrijeTekstDTO);
        vrijeTekst = vrijeTekstRepository.save(vrijeTekst);
        return vrijeTekstMapper.toDto(vrijeTekst);
    }

    /**
     * Get all the vrijeTeksts.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<VrijeTekstDTO> findAll() {
        log.debug("Request to get all VrijeTeksts");
        return vrijeTekstRepository.findAll().stream()
            .map(vrijeTekstMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one vrijeTekst by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VrijeTekstDTO> findOne(Long id) {
        log.debug("Request to get VrijeTekst : {}", id);
        return vrijeTekstRepository.findById(id)
            .map(vrijeTekstMapper::toDto);
    }

    /**
     * Delete the vrijeTekst by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete VrijeTekst : {}", id);
        vrijeTekstRepository.deleteById(id);
    }
}

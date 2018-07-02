package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.AlgemeenService;
import com.inetpsa.pct00.application.domain.Algemeen;
import com.inetpsa.pct00.application.repository.AlgemeenRepository;
import com.inetpsa.pct00.application.service.dto.AlgemeenDTO;
import com.inetpsa.pct00.application.service.mapper.AlgemeenMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing Algemeen.
 */
@Service
@Transactional
public class AlgemeenServiceImpl implements AlgemeenService {

    private final Logger log = LoggerFactory.getLogger(AlgemeenServiceImpl.class);

    private final AlgemeenRepository algemeenRepository;

    private final AlgemeenMapper algemeenMapper;

    public AlgemeenServiceImpl(AlgemeenRepository algemeenRepository, AlgemeenMapper algemeenMapper) {
        this.algemeenRepository = algemeenRepository;
        this.algemeenMapper = algemeenMapper;
    }

    /**
     * Save a algemeen.
     *
     * @param algemeenDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AlgemeenDTO save(AlgemeenDTO algemeenDTO) {
        log.debug("Request to save Algemeen : {}", algemeenDTO);
        Algemeen algemeen = algemeenMapper.toEntity(algemeenDTO);
        algemeen = algemeenRepository.save(algemeen);
        return algemeenMapper.toDto(algemeen);
    }

    /**
     * Get all the algemeens.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AlgemeenDTO> findAll() {
        log.debug("Request to get all Algemeens");
        return algemeenRepository.findAll().stream()
            .map(algemeenMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the algemeens where Aanvraagbericht is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<AlgemeenDTO> findAllWhereAanvraagberichtIsNull() {
        log.debug("Request to get all algemeens where Aanvraagbericht is null");
        return StreamSupport
            .stream(algemeenRepository.findAll().spliterator(), false)
            .filter(algemeen -> algemeen.getAanvraagbericht() == null)
            .map(algemeenMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one algemeen by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AlgemeenDTO> findOne(Long id) {
        log.debug("Request to get Algemeen : {}", id);
        return algemeenRepository.findById(id)
            .map(algemeenMapper::toDto);
    }

    /**
     * Delete the algemeen by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Algemeen : {}", id);
        algemeenRepository.deleteById(id);
    }
}

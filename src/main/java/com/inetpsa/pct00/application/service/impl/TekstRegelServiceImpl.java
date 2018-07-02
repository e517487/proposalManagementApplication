package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.TekstRegelService;
import com.inetpsa.pct00.application.domain.TekstRegel;
import com.inetpsa.pct00.application.repository.TekstRegelRepository;
import com.inetpsa.pct00.application.service.dto.TekstRegelDTO;
import com.inetpsa.pct00.application.service.mapper.TekstRegelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing TekstRegel.
 */
@Service
@Transactional
public class TekstRegelServiceImpl implements TekstRegelService {

    private final Logger log = LoggerFactory.getLogger(TekstRegelServiceImpl.class);

    private final TekstRegelRepository tekstRegelRepository;

    private final TekstRegelMapper tekstRegelMapper;

    public TekstRegelServiceImpl(TekstRegelRepository tekstRegelRepository, TekstRegelMapper tekstRegelMapper) {
        this.tekstRegelRepository = tekstRegelRepository;
        this.tekstRegelMapper = tekstRegelMapper;
    }

    /**
     * Save a tekstRegel.
     *
     * @param tekstRegelDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TekstRegelDTO save(TekstRegelDTO tekstRegelDTO) {
        log.debug("Request to save TekstRegel : {}", tekstRegelDTO);
        TekstRegel tekstRegel = tekstRegelMapper.toEntity(tekstRegelDTO);
        tekstRegel = tekstRegelRepository.save(tekstRegel);
        return tekstRegelMapper.toDto(tekstRegel);
    }

    /**
     * Get all the tekstRegels.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TekstRegelDTO> findAll() {
        log.debug("Request to get all TekstRegels");
        return tekstRegelRepository.findAll().stream()
            .map(tekstRegelMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one tekstRegel by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TekstRegelDTO> findOne(Long id) {
        log.debug("Request to get TekstRegel : {}", id);
        return tekstRegelRepository.findById(id)
            .map(tekstRegelMapper::toDto);
    }

    /**
     * Delete the tekstRegel by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TekstRegel : {}", id);
        tekstRegelRepository.deleteById(id);
    }
}

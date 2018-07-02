package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.AanvraagberichtService;
import com.inetpsa.pct00.application.domain.Aanvraagbericht;
import com.inetpsa.pct00.application.repository.AanvraagberichtRepository;
import com.inetpsa.pct00.application.service.dto.AanvraagberichtDTO;
import com.inetpsa.pct00.application.service.mapper.AanvraagberichtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Aanvraagbericht.
 */
@Service
@Transactional
public class AanvraagberichtServiceImpl implements AanvraagberichtService {

    private final Logger log = LoggerFactory.getLogger(AanvraagberichtServiceImpl.class);

    private final AanvraagberichtRepository aanvraagberichtRepository;

    private final AanvraagberichtMapper aanvraagberichtMapper;

    public AanvraagberichtServiceImpl(AanvraagberichtRepository aanvraagberichtRepository, AanvraagberichtMapper aanvraagberichtMapper) {
        this.aanvraagberichtRepository = aanvraagberichtRepository;
        this.aanvraagberichtMapper = aanvraagberichtMapper;
    }

    /**
     * Save a aanvraagbericht.
     *
     * @param aanvraagberichtDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AanvraagberichtDTO save(AanvraagberichtDTO aanvraagberichtDTO) {
        log.debug("Request to save Aanvraagbericht : {}", aanvraagberichtDTO);
        Aanvraagbericht aanvraagbericht = aanvraagberichtMapper.toEntity(aanvraagberichtDTO);
        aanvraagbericht = aanvraagberichtRepository.save(aanvraagbericht);
        return aanvraagberichtMapper.toDto(aanvraagbericht);
    }

    /**
     * Get all the aanvraagberichts.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AanvraagberichtDTO> findAll() {
        log.debug("Request to get all Aanvraagberichts");
        return aanvraagberichtRepository.findAll().stream()
            .map(aanvraagberichtMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one aanvraagbericht by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AanvraagberichtDTO> findOne(Long id) {
        log.debug("Request to get Aanvraagbericht : {}", id);
        return aanvraagberichtRepository.findById(id)
            .map(aanvraagberichtMapper::toDto);
    }

    /**
     * Delete the aanvraagbericht by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Aanvraagbericht : {}", id);
        aanvraagberichtRepository.deleteById(id);
    }
}

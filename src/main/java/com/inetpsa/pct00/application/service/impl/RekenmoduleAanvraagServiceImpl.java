package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.RekenmoduleAanvraagService;
import com.inetpsa.pct00.application.domain.RekenmoduleAanvraag;
import com.inetpsa.pct00.application.repository.RekenmoduleAanvraagRepository;
import com.inetpsa.pct00.application.service.dto.RekenmoduleAanvraagDTO;
import com.inetpsa.pct00.application.service.mapper.RekenmoduleAanvraagMapper;
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
 * Service Implementation for managing RekenmoduleAanvraag.
 */
@Service
@Transactional
public class RekenmoduleAanvraagServiceImpl implements RekenmoduleAanvraagService {

    private final Logger log = LoggerFactory.getLogger(RekenmoduleAanvraagServiceImpl.class);

    private final RekenmoduleAanvraagRepository rekenmoduleAanvraagRepository;

    private final RekenmoduleAanvraagMapper rekenmoduleAanvraagMapper;

    public RekenmoduleAanvraagServiceImpl(RekenmoduleAanvraagRepository rekenmoduleAanvraagRepository, RekenmoduleAanvraagMapper rekenmoduleAanvraagMapper) {
        this.rekenmoduleAanvraagRepository = rekenmoduleAanvraagRepository;
        this.rekenmoduleAanvraagMapper = rekenmoduleAanvraagMapper;
    }

    /**
     * Save a rekenmoduleAanvraag.
     *
     * @param rekenmoduleAanvraagDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RekenmoduleAanvraagDTO save(RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO) {
        log.debug("Request to save RekenmoduleAanvraag : {}", rekenmoduleAanvraagDTO);
        RekenmoduleAanvraag rekenmoduleAanvraag = rekenmoduleAanvraagMapper.toEntity(rekenmoduleAanvraagDTO);
        rekenmoduleAanvraag = rekenmoduleAanvraagRepository.save(rekenmoduleAanvraag);
        return rekenmoduleAanvraagMapper.toDto(rekenmoduleAanvraag);
    }

    /**
     * Get all the rekenmoduleAanvraags.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RekenmoduleAanvraagDTO> findAll() {
        log.debug("Request to get all RekenmoduleAanvraags");
        return rekenmoduleAanvraagRepository.findAll().stream()
            .map(rekenmoduleAanvraagMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the rekenmoduleAanvraags where Aanvraagbericht is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<RekenmoduleAanvraagDTO> findAllWhereAanvraagberichtIsNull() {
        log.debug("Request to get all rekenmoduleAanvraags where Aanvraagbericht is null");
        return StreamSupport
            .stream(rekenmoduleAanvraagRepository.findAll().spliterator(), false)
            .filter(rekenmoduleAanvraag -> rekenmoduleAanvraag.getAanvraagbericht() == null)
            .map(rekenmoduleAanvraagMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one rekenmoduleAanvraag by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RekenmoduleAanvraagDTO> findOne(Long id) {
        log.debug("Request to get RekenmoduleAanvraag : {}", id);
        return rekenmoduleAanvraagRepository.findById(id)
            .map(rekenmoduleAanvraagMapper::toDto);
    }

    /**
     * Delete the rekenmoduleAanvraag by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RekenmoduleAanvraag : {}", id);
        rekenmoduleAanvraagRepository.deleteById(id);
    }
}

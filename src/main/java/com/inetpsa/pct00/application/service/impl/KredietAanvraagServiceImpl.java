package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.KredietAanvraagService;
import com.inetpsa.pct00.application.domain.KredietAanvraag;
import com.inetpsa.pct00.application.repository.KredietAanvraagRepository;
import com.inetpsa.pct00.application.service.dto.KredietAanvraagDTO;
import com.inetpsa.pct00.application.service.mapper.KredietAanvraagMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing KredietAanvraag.
 */
@Service
@Transactional
public class KredietAanvraagServiceImpl implements KredietAanvraagService {

    private final Logger log = LoggerFactory.getLogger(KredietAanvraagServiceImpl.class);

    private final KredietAanvraagRepository kredietAanvraagRepository;

    private final KredietAanvraagMapper kredietAanvraagMapper;

    public KredietAanvraagServiceImpl(KredietAanvraagRepository kredietAanvraagRepository, KredietAanvraagMapper kredietAanvraagMapper) {
        this.kredietAanvraagRepository = kredietAanvraagRepository;
        this.kredietAanvraagMapper = kredietAanvraagMapper;
    }

    /**
     * Save a kredietAanvraag.
     *
     * @param kredietAanvraagDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public KredietAanvraagDTO save(KredietAanvraagDTO kredietAanvraagDTO) {
        log.debug("Request to save KredietAanvraag : {}", kredietAanvraagDTO);
        KredietAanvraag kredietAanvraag = kredietAanvraagMapper.toEntity(kredietAanvraagDTO);
        kredietAanvraag = kredietAanvraagRepository.save(kredietAanvraag);
        return kredietAanvraagMapper.toDto(kredietAanvraag);
    }

    /**
     * Get all the kredietAanvraags.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<KredietAanvraagDTO> findAll() {
        log.debug("Request to get all KredietAanvraags");
        return kredietAanvraagRepository.findAll().stream()
            .map(kredietAanvraagMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one kredietAanvraag by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<KredietAanvraagDTO> findOne(Long id) {
        log.debug("Request to get KredietAanvraag : {}", id);
        return kredietAanvraagRepository.findById(id)
            .map(kredietAanvraagMapper::toDto);
    }

    /**
     * Delete the kredietAanvraag by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete KredietAanvraag : {}", id);
        kredietAanvraagRepository.deleteById(id);
    }
}

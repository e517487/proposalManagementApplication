package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.WerksituatieService;
import com.inetpsa.pct00.application.domain.Werksituatie;
import com.inetpsa.pct00.application.repository.WerksituatieRepository;
import com.inetpsa.pct00.application.service.dto.WerksituatieDTO;
import com.inetpsa.pct00.application.service.mapper.WerksituatieMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Werksituatie.
 */
@Service
@Transactional
public class WerksituatieServiceImpl implements WerksituatieService {

    private final Logger log = LoggerFactory.getLogger(WerksituatieServiceImpl.class);

    private final WerksituatieRepository werksituatieRepository;

    private final WerksituatieMapper werksituatieMapper;

    public WerksituatieServiceImpl(WerksituatieRepository werksituatieRepository, WerksituatieMapper werksituatieMapper) {
        this.werksituatieRepository = werksituatieRepository;
        this.werksituatieMapper = werksituatieMapper;
    }

    /**
     * Save a werksituatie.
     *
     * @param werksituatieDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WerksituatieDTO save(WerksituatieDTO werksituatieDTO) {
        log.debug("Request to save Werksituatie : {}", werksituatieDTO);
        Werksituatie werksituatie = werksituatieMapper.toEntity(werksituatieDTO);
        werksituatie = werksituatieRepository.save(werksituatie);
        return werksituatieMapper.toDto(werksituatie);
    }

    /**
     * Get all the werksituaties.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<WerksituatieDTO> findAll() {
        log.debug("Request to get all Werksituaties");
        return werksituatieRepository.findAll().stream()
            .map(werksituatieMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one werksituatie by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WerksituatieDTO> findOne(Long id) {
        log.debug("Request to get Werksituatie : {}", id);
        return werksituatieRepository.findById(id)
            .map(werksituatieMapper::toDto);
    }

    /**
     * Delete the werksituatie by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Werksituatie : {}", id);
        werksituatieRepository.deleteById(id);
    }
}

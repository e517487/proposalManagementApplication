package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.GezinssituatieService;
import com.inetpsa.pct00.application.domain.Gezinssituatie;
import com.inetpsa.pct00.application.repository.GezinssituatieRepository;
import com.inetpsa.pct00.application.service.dto.GezinssituatieDTO;
import com.inetpsa.pct00.application.service.mapper.GezinssituatieMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Gezinssituatie.
 */
@Service
@Transactional
public class GezinssituatieServiceImpl implements GezinssituatieService {

    private final Logger log = LoggerFactory.getLogger(GezinssituatieServiceImpl.class);

    private final GezinssituatieRepository gezinssituatieRepository;

    private final GezinssituatieMapper gezinssituatieMapper;

    public GezinssituatieServiceImpl(GezinssituatieRepository gezinssituatieRepository, GezinssituatieMapper gezinssituatieMapper) {
        this.gezinssituatieRepository = gezinssituatieRepository;
        this.gezinssituatieMapper = gezinssituatieMapper;
    }

    /**
     * Save a gezinssituatie.
     *
     * @param gezinssituatieDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public GezinssituatieDTO save(GezinssituatieDTO gezinssituatieDTO) {
        log.debug("Request to save Gezinssituatie : {}", gezinssituatieDTO);
        Gezinssituatie gezinssituatie = gezinssituatieMapper.toEntity(gezinssituatieDTO);
        gezinssituatie = gezinssituatieRepository.save(gezinssituatie);
        return gezinssituatieMapper.toDto(gezinssituatie);
    }

    /**
     * Get all the gezinssituaties.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<GezinssituatieDTO> findAll() {
        log.debug("Request to get all Gezinssituaties");
        return gezinssituatieRepository.findAll().stream()
            .map(gezinssituatieMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one gezinssituatie by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GezinssituatieDTO> findOne(Long id) {
        log.debug("Request to get Gezinssituatie : {}", id);
        return gezinssituatieRepository.findById(id)
            .map(gezinssituatieMapper::toDto);
    }

    /**
     * Delete the gezinssituatie by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Gezinssituatie : {}", id);
        gezinssituatieRepository.deleteById(id);
    }
}

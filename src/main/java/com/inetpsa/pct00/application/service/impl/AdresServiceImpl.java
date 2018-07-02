package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.AdresService;
import com.inetpsa.pct00.application.domain.Adres;
import com.inetpsa.pct00.application.repository.AdresRepository;
import com.inetpsa.pct00.application.service.dto.AdresDTO;
import com.inetpsa.pct00.application.service.mapper.AdresMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Adres.
 */
@Service
@Transactional
public class AdresServiceImpl implements AdresService {

    private final Logger log = LoggerFactory.getLogger(AdresServiceImpl.class);

    private final AdresRepository adresRepository;

    private final AdresMapper adresMapper;

    public AdresServiceImpl(AdresRepository adresRepository, AdresMapper adresMapper) {
        this.adresRepository = adresRepository;
        this.adresMapper = adresMapper;
    }

    /**
     * Save a adres.
     *
     * @param adresDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AdresDTO save(AdresDTO adresDTO) {
        log.debug("Request to save Adres : {}", adresDTO);
        Adres adres = adresMapper.toEntity(adresDTO);
        adres = adresRepository.save(adres);
        return adresMapper.toDto(adres);
    }

    /**
     * Get all the adres.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AdresDTO> findAll() {
        log.debug("Request to get all Adres");
        return adresRepository.findAll().stream()
            .map(adresMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one adres by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AdresDTO> findOne(Long id) {
        log.debug("Request to get Adres : {}", id);
        return adresRepository.findById(id)
            .map(adresMapper::toDto);
    }

    /**
     * Delete the adres by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Adres : {}", id);
        adresRepository.deleteById(id);
    }
}

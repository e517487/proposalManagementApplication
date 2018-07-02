package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.FdnAanvragerService;
import com.inetpsa.pct00.application.domain.FdnAanvrager;
import com.inetpsa.pct00.application.repository.FdnAanvragerRepository;
import com.inetpsa.pct00.application.service.dto.FdnAanvragerDTO;
import com.inetpsa.pct00.application.service.mapper.FdnAanvragerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing FdnAanvrager.
 */
@Service
@Transactional
public class FdnAanvragerServiceImpl implements FdnAanvragerService {

    private final Logger log = LoggerFactory.getLogger(FdnAanvragerServiceImpl.class);

    private final FdnAanvragerRepository fdnAanvragerRepository;

    private final FdnAanvragerMapper fdnAanvragerMapper;

    public FdnAanvragerServiceImpl(FdnAanvragerRepository fdnAanvragerRepository, FdnAanvragerMapper fdnAanvragerMapper) {
        this.fdnAanvragerRepository = fdnAanvragerRepository;
        this.fdnAanvragerMapper = fdnAanvragerMapper;
    }

    /**
     * Save a fdnAanvrager.
     *
     * @param fdnAanvragerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FdnAanvragerDTO save(FdnAanvragerDTO fdnAanvragerDTO) {
        log.debug("Request to save FdnAanvrager : {}", fdnAanvragerDTO);
        FdnAanvrager fdnAanvrager = fdnAanvragerMapper.toEntity(fdnAanvragerDTO);
        fdnAanvrager = fdnAanvragerRepository.save(fdnAanvrager);
        return fdnAanvragerMapper.toDto(fdnAanvrager);
    }

    /**
     * Get all the fdnAanvragers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FdnAanvragerDTO> findAll() {
        log.debug("Request to get all FdnAanvragers");
        return fdnAanvragerRepository.findAll().stream()
            .map(fdnAanvragerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one fdnAanvrager by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FdnAanvragerDTO> findOne(Long id) {
        log.debug("Request to get FdnAanvrager : {}", id);
        return fdnAanvragerRepository.findById(id)
            .map(fdnAanvragerMapper::toDto);
    }

    /**
     * Delete the fdnAanvrager by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FdnAanvrager : {}", id);
        fdnAanvragerRepository.deleteById(id);
    }
}

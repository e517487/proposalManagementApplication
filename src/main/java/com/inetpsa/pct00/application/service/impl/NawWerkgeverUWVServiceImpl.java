package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.NawWerkgeverUWVService;
import com.inetpsa.pct00.application.domain.NawWerkgeverUWV;
import com.inetpsa.pct00.application.repository.NawWerkgeverUWVRepository;
import com.inetpsa.pct00.application.service.dto.NawWerkgeverUWVDTO;
import com.inetpsa.pct00.application.service.mapper.NawWerkgeverUWVMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing NawWerkgeverUWV.
 */
@Service
@Transactional
public class NawWerkgeverUWVServiceImpl implements NawWerkgeverUWVService {

    private final Logger log = LoggerFactory.getLogger(NawWerkgeverUWVServiceImpl.class);

    private final NawWerkgeverUWVRepository nawWerkgeverUWVRepository;

    private final NawWerkgeverUWVMapper nawWerkgeverUWVMapper;

    public NawWerkgeverUWVServiceImpl(NawWerkgeverUWVRepository nawWerkgeverUWVRepository, NawWerkgeverUWVMapper nawWerkgeverUWVMapper) {
        this.nawWerkgeverUWVRepository = nawWerkgeverUWVRepository;
        this.nawWerkgeverUWVMapper = nawWerkgeverUWVMapper;
    }

    /**
     * Save a nawWerkgeverUWV.
     *
     * @param nawWerkgeverUWVDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public NawWerkgeverUWVDTO save(NawWerkgeverUWVDTO nawWerkgeverUWVDTO) {
        log.debug("Request to save NawWerkgeverUWV : {}", nawWerkgeverUWVDTO);
        NawWerkgeverUWV nawWerkgeverUWV = nawWerkgeverUWVMapper.toEntity(nawWerkgeverUWVDTO);
        nawWerkgeverUWV = nawWerkgeverUWVRepository.save(nawWerkgeverUWV);
        return nawWerkgeverUWVMapper.toDto(nawWerkgeverUWV);
    }

    /**
     * Get all the nawWerkgeverUWVS.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<NawWerkgeverUWVDTO> findAll() {
        log.debug("Request to get all NawWerkgeverUWVS");
        return nawWerkgeverUWVRepository.findAll().stream()
            .map(nawWerkgeverUWVMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one nawWerkgeverUWV by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<NawWerkgeverUWVDTO> findOne(Long id) {
        log.debug("Request to get NawWerkgeverUWV : {}", id);
        return nawWerkgeverUWVRepository.findById(id)
            .map(nawWerkgeverUWVMapper::toDto);
    }

    /**
     * Delete the nawWerkgeverUWV by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete NawWerkgeverUWV : {}", id);
        nawWerkgeverUWVRepository.deleteById(id);
    }
}

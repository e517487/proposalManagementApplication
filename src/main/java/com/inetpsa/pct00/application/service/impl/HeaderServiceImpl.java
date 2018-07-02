package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.HeaderService;
import com.inetpsa.pct00.application.domain.Header;
import com.inetpsa.pct00.application.repository.HeaderRepository;
import com.inetpsa.pct00.application.service.dto.HeaderDTO;
import com.inetpsa.pct00.application.service.mapper.HeaderMapper;
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
 * Service Implementation for managing Header.
 */
@Service
@Transactional
public class HeaderServiceImpl implements HeaderService {

    private final Logger log = LoggerFactory.getLogger(HeaderServiceImpl.class);

    private final HeaderRepository headerRepository;

    private final HeaderMapper headerMapper;

    public HeaderServiceImpl(HeaderRepository headerRepository, HeaderMapper headerMapper) {
        this.headerRepository = headerRepository;
        this.headerMapper = headerMapper;
    }

    /**
     * Save a header.
     *
     * @param headerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public HeaderDTO save(HeaderDTO headerDTO) {
        log.debug("Request to save Header : {}", headerDTO);
        Header header = headerMapper.toEntity(headerDTO);
        header = headerRepository.save(header);
        return headerMapper.toDto(header);
    }

    /**
     * Get all the headers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<HeaderDTO> findAll() {
        log.debug("Request to get all Headers");
        return headerRepository.findAll().stream()
            .map(headerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the headers where Aanvraagbericht is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<HeaderDTO> findAllWhereAanvraagberichtIsNull() {
        log.debug("Request to get all headers where Aanvraagbericht is null");
        return StreamSupport
            .stream(headerRepository.findAll().spliterator(), false)
            .filter(header -> header.getAanvraagbericht() == null)
            .map(headerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one header by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<HeaderDTO> findOne(Long id) {
        log.debug("Request to get Header : {}", id);
        return headerRepository.findById(id)
            .map(headerMapper::toDto);
    }

    /**
     * Delete the header by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Header : {}", id);
        headerRepository.deleteById(id);
    }
}

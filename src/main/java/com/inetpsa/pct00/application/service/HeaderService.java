package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.HeaderDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Header.
 */
public interface HeaderService {

    /**
     * Save a header.
     *
     * @param headerDTO the entity to save
     * @return the persisted entity
     */
    HeaderDTO save(HeaderDTO headerDTO);

    /**
     * Get all the headers.
     *
     * @return the list of entities
     */
    List<HeaderDTO> findAll();
    /**
     * Get all the HeaderDTO where Aanvraagbericht is null.
     *
     * @return the list of entities
     */
    List<HeaderDTO> findAllWhereAanvraagberichtIsNull();


    /**
     * Get the "id" header.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<HeaderDTO> findOne(Long id);

    /**
     * Delete the "id" header.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

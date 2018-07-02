package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.FdnAanvragerDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing FdnAanvrager.
 */
public interface FdnAanvragerService {

    /**
     * Save a fdnAanvrager.
     *
     * @param fdnAanvragerDTO the entity to save
     * @return the persisted entity
     */
    FdnAanvragerDTO save(FdnAanvragerDTO fdnAanvragerDTO);

    /**
     * Get all the fdnAanvragers.
     *
     * @return the list of entities
     */
    List<FdnAanvragerDTO> findAll();


    /**
     * Get the "id" fdnAanvrager.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FdnAanvragerDTO> findOne(Long id);

    /**
     * Delete the "id" fdnAanvrager.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.LegitimatiebewijsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Legitimatiebewijs.
 */
public interface LegitimatiebewijsService {

    /**
     * Save a legitimatiebewijs.
     *
     * @param legitimatiebewijsDTO the entity to save
     * @return the persisted entity
     */
    LegitimatiebewijsDTO save(LegitimatiebewijsDTO legitimatiebewijsDTO);

    /**
     * Get all the legitimatiebewijs.
     *
     * @return the list of entities
     */
    List<LegitimatiebewijsDTO> findAll();


    /**
     * Get the "id" legitimatiebewijs.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<LegitimatiebewijsDTO> findOne(Long id);

    /**
     * Delete the "id" legitimatiebewijs.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

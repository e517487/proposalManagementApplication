package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.TekstRegelDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing TekstRegel.
 */
public interface TekstRegelService {

    /**
     * Save a tekstRegel.
     *
     * @param tekstRegelDTO the entity to save
     * @return the persisted entity
     */
    TekstRegelDTO save(TekstRegelDTO tekstRegelDTO);

    /**
     * Get all the tekstRegels.
     *
     * @return the list of entities
     */
    List<TekstRegelDTO> findAll();


    /**
     * Get the "id" tekstRegel.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TekstRegelDTO> findOne(Long id);

    /**
     * Delete the "id" tekstRegel.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

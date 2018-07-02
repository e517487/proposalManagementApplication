package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.VrijeTekstDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing VrijeTekst.
 */
public interface VrijeTekstService {

    /**
     * Save a vrijeTekst.
     *
     * @param vrijeTekstDTO the entity to save
     * @return the persisted entity
     */
    VrijeTekstDTO save(VrijeTekstDTO vrijeTekstDTO);

    /**
     * Get all the vrijeTeksts.
     *
     * @return the list of entities
     */
    List<VrijeTekstDTO> findAll();


    /**
     * Get the "id" vrijeTekst.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<VrijeTekstDTO> findOne(Long id);

    /**
     * Delete the "id" vrijeTekst.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

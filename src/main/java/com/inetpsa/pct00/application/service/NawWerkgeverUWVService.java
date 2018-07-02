package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.NawWerkgeverUWVDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing NawWerkgeverUWV.
 */
public interface NawWerkgeverUWVService {

    /**
     * Save a nawWerkgeverUWV.
     *
     * @param nawWerkgeverUWVDTO the entity to save
     * @return the persisted entity
     */
    NawWerkgeverUWVDTO save(NawWerkgeverUWVDTO nawWerkgeverUWVDTO);

    /**
     * Get all the nawWerkgeverUWVS.
     *
     * @return the list of entities
     */
    List<NawWerkgeverUWVDTO> findAll();


    /**
     * Get the "id" nawWerkgeverUWV.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<NawWerkgeverUWVDTO> findOne(Long id);

    /**
     * Delete the "id" nawWerkgeverUWV.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

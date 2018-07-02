package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.WerksituatieDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Werksituatie.
 */
public interface WerksituatieService {

    /**
     * Save a werksituatie.
     *
     * @param werksituatieDTO the entity to save
     * @return the persisted entity
     */
    WerksituatieDTO save(WerksituatieDTO werksituatieDTO);

    /**
     * Get all the werksituaties.
     *
     * @return the list of entities
     */
    List<WerksituatieDTO> findAll();


    /**
     * Get the "id" werksituatie.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WerksituatieDTO> findOne(Long id);

    /**
     * Delete the "id" werksituatie.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

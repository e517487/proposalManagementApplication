package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.GezinssituatieDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Gezinssituatie.
 */
public interface GezinssituatieService {

    /**
     * Save a gezinssituatie.
     *
     * @param gezinssituatieDTO the entity to save
     * @return the persisted entity
     */
    GezinssituatieDTO save(GezinssituatieDTO gezinssituatieDTO);

    /**
     * Get all the gezinssituaties.
     *
     * @return the list of entities
     */
    List<GezinssituatieDTO> findAll();


    /**
     * Get the "id" gezinssituatie.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<GezinssituatieDTO> findOne(Long id);

    /**
     * Delete the "id" gezinssituatie.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

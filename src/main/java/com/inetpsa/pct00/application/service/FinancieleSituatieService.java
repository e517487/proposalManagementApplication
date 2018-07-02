package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.FinancieleSituatieDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing FinancieleSituatie.
 */
public interface FinancieleSituatieService {

    /**
     * Save a financieleSituatie.
     *
     * @param financieleSituatieDTO the entity to save
     * @return the persisted entity
     */
    FinancieleSituatieDTO save(FinancieleSituatieDTO financieleSituatieDTO);

    /**
     * Get all the financieleSituaties.
     *
     * @return the list of entities
     */
    List<FinancieleSituatieDTO> findAll();


    /**
     * Get the "id" financieleSituatie.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FinancieleSituatieDTO> findOne(Long id);

    /**
     * Delete the "id" financieleSituatie.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.AanvraagberichtDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Aanvraagbericht.
 */
public interface AanvraagberichtService {

    /**
     * Save a aanvraagbericht.
     *
     * @param aanvraagberichtDTO the entity to save
     * @return the persisted entity
     */
    AanvraagberichtDTO save(AanvraagberichtDTO aanvraagberichtDTO);

    /**
     * Get all the aanvraagberichts.
     *
     * @return the list of entities
     */
    List<AanvraagberichtDTO> findAll();


    /**
     * Get the "id" aanvraagbericht.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AanvraagberichtDTO> findOne(Long id);

    /**
     * Delete the "id" aanvraagbericht.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

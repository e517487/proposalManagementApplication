package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.AlgemeenDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Algemeen.
 */
public interface AlgemeenService {

    /**
     * Save a algemeen.
     *
     * @param algemeenDTO the entity to save
     * @return the persisted entity
     */
    AlgemeenDTO save(AlgemeenDTO algemeenDTO);

    /**
     * Get all the algemeens.
     *
     * @return the list of entities
     */
    List<AlgemeenDTO> findAll();
    /**
     * Get all the AlgemeenDTO where Aanvraagbericht is null.
     *
     * @return the list of entities
     */
    List<AlgemeenDTO> findAllWhereAanvraagberichtIsNull();


    /**
     * Get the "id" algemeen.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AlgemeenDTO> findOne(Long id);

    /**
     * Delete the "id" algemeen.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.RekenmoduleAanvraagDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing RekenmoduleAanvraag.
 */
public interface RekenmoduleAanvraagService {

    /**
     * Save a rekenmoduleAanvraag.
     *
     * @param rekenmoduleAanvraagDTO the entity to save
     * @return the persisted entity
     */
    RekenmoduleAanvraagDTO save(RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO);

    /**
     * Get all the rekenmoduleAanvraags.
     *
     * @return the list of entities
     */
    List<RekenmoduleAanvraagDTO> findAll();
    /**
     * Get all the RekenmoduleAanvraagDTO where Aanvraagbericht is null.
     *
     * @return the list of entities
     */
    List<RekenmoduleAanvraagDTO> findAllWhereAanvraagberichtIsNull();


    /**
     * Get the "id" rekenmoduleAanvraag.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<RekenmoduleAanvraagDTO> findOne(Long id);

    /**
     * Delete the "id" rekenmoduleAanvraag.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

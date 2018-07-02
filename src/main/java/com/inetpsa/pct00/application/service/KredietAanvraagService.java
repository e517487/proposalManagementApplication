package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.KredietAanvraagDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing KredietAanvraag.
 */
public interface KredietAanvraagService {

    /**
     * Save a kredietAanvraag.
     *
     * @param kredietAanvraagDTO the entity to save
     * @return the persisted entity
     */
    KredietAanvraagDTO save(KredietAanvraagDTO kredietAanvraagDTO);

    /**
     * Get all the kredietAanvraags.
     *
     * @return the list of entities
     */
    List<KredietAanvraagDTO> findAll();


    /**
     * Get the "id" kredietAanvraag.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<KredietAanvraagDTO> findOne(Long id);

    /**
     * Delete the "id" kredietAanvraag.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

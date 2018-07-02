package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.RequestDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Request.
 */
public interface RequestService {

    /**
     * Save a request.
     *
     * @param requestDTO the entity to save
     * @return the persisted entity
     */
    RequestDTO save(RequestDTO requestDTO);

    /**
     * Get all the requests.
     *
     * @return the list of entities
     */
    List<RequestDTO> findAll();
    /**
     * Get all the RequestDTO where RekenmoduleAanvraag is null.
     *
     * @return the list of entities
     */
    List<RequestDTO> findAllWhereRekenmoduleAanvraagIsNull();
    /**
     * Get all the RequestDTO where CreditScore is null.
     *
     * @return the list of entities
     */
    List<RequestDTO> findAllWhereCreditScoreIsNull();


    /**
     * Get the "id" request.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<RequestDTO> findOne(Long id);

    /**
     * Delete the "id" request.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

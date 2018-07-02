package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.service.dto.CreditScoreDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing CreditScore.
 */
public interface CreditScoreService {

    /**
     * Save a creditScore.
     *
     * @param creditScoreDTO the entity to save
     * @return the persisted entity
     */
    CreditScoreDTO save(CreditScoreDTO creditScoreDTO);

    /**
     * Get all the creditScores.
     *
     * @return the list of entities
     */
    List<CreditScoreDTO> findAll();


    /**
     * Get the "id" creditScore.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CreditScoreDTO> findOne(Long id);

    /**
     * Delete the "id" creditScore.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}

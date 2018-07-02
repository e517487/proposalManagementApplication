package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.CreditScoreService;
import com.inetpsa.pct00.application.domain.CreditScore;
import com.inetpsa.pct00.application.repository.CreditScoreRepository;
import com.inetpsa.pct00.application.service.dto.CreditScoreDTO;
import com.inetpsa.pct00.application.service.mapper.CreditScoreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing CreditScore.
 */
@Service
@Transactional
public class CreditScoreServiceImpl implements CreditScoreService {

    private final Logger log = LoggerFactory.getLogger(CreditScoreServiceImpl.class);

    private final CreditScoreRepository creditScoreRepository;

    private final CreditScoreMapper creditScoreMapper;

    public CreditScoreServiceImpl(CreditScoreRepository creditScoreRepository, CreditScoreMapper creditScoreMapper) {
        this.creditScoreRepository = creditScoreRepository;
        this.creditScoreMapper = creditScoreMapper;
    }

    /**
     * Save a creditScore.
     *
     * @param creditScoreDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CreditScoreDTO save(CreditScoreDTO creditScoreDTO) {
        log.debug("Request to save CreditScore : {}", creditScoreDTO);
        CreditScore creditScore = creditScoreMapper.toEntity(creditScoreDTO);
        creditScore = creditScoreRepository.save(creditScore);
        return creditScoreMapper.toDto(creditScore);
    }

    /**
     * Get all the creditScores.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<CreditScoreDTO> findAll() {
        log.debug("Request to get all CreditScores");
        return creditScoreRepository.findAll().stream()
            .map(creditScoreMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one creditScore by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CreditScoreDTO> findOne(Long id) {
        log.debug("Request to get CreditScore : {}", id);
        return creditScoreRepository.findById(id)
            .map(creditScoreMapper::toDto);
    }

    /**
     * Delete the creditScore by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CreditScore : {}", id);
        creditScoreRepository.deleteById(id);
    }
}

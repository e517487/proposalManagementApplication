package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.RequestService;
import com.inetpsa.pct00.application.domain.Request;
import com.inetpsa.pct00.application.repository.RequestRepository;
import com.inetpsa.pct00.application.service.dto.RequestDTO;
import com.inetpsa.pct00.application.service.mapper.RequestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing Request.
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private final Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);

    private final RequestRepository requestRepository;

    private final RequestMapper requestMapper;

    public RequestServiceImpl(RequestRepository requestRepository, RequestMapper requestMapper) {
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
    }

    /**
     * Save a request.
     *
     * @param requestDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RequestDTO save(RequestDTO requestDTO) {
        log.debug("Request to save Request : {}", requestDTO);
        Request request = requestMapper.toEntity(requestDTO);
        request = requestRepository.save(request);
        return requestMapper.toDto(request);
    }

    /**
     * Get all the requests.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RequestDTO> findAll() {
        log.debug("Request to get all Requests");
        return requestRepository.findAll().stream()
            .map(requestMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the requests where RekenmoduleAanvraag is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<RequestDTO> findAllWhereRekenmoduleAanvraagIsNull() {
        log.debug("Request to get all requests where RekenmoduleAanvraag is null");
        return StreamSupport
            .stream(requestRepository.findAll().spliterator(), false)
            .filter(request -> request.getRekenmoduleAanvraag() == null)
            .map(requestMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     *  get all the requests where CreditScore is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<RequestDTO> findAllWhereCreditScoreIsNull() {
        log.debug("Request to get all requests where CreditScore is null");
        return StreamSupport
            .stream(requestRepository.findAll().spliterator(), false)
            .filter(request -> request.getCreditScore() == null)
            .map(requestMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one request by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RequestDTO> findOne(Long id) {
        log.debug("Request to get Request : {}", id);
        return requestRepository.findById(id)
            .map(requestMapper::toDto);
    }

    /**
     * Delete the request by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Request : {}", id);
        requestRepository.deleteById(id);
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record55Scoring;
import com.inetpsa.pct00.application.repository.Record55ScoringRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record55ScoringDTO;
import com.inetpsa.pct00.application.service.mapper.Record55ScoringMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Record55Scoring.
 */
@RestController
@RequestMapping("/api")
public class Record55ScoringResource {

    private final Logger log = LoggerFactory.getLogger(Record55ScoringResource.class);

    private static final String ENTITY_NAME = "record55Scoring";

    private final Record55ScoringRepository record55ScoringRepository;

    private final Record55ScoringMapper record55ScoringMapper;

    public Record55ScoringResource(Record55ScoringRepository record55ScoringRepository, Record55ScoringMapper record55ScoringMapper) {
        this.record55ScoringRepository = record55ScoringRepository;
        this.record55ScoringMapper = record55ScoringMapper;
    }

    /**
     * POST  /record-55-scorings : Create a new record55Scoring.
     *
     * @param record55ScoringDTO the record55ScoringDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record55ScoringDTO, or with status 400 (Bad Request) if the record55Scoring has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-55-scorings")
    @Timed
    public ResponseEntity<Record55ScoringDTO> createRecord55Scoring(@RequestBody Record55ScoringDTO record55ScoringDTO) throws URISyntaxException {
        log.debug("REST request to save Record55Scoring : {}", record55ScoringDTO);
        if (record55ScoringDTO.getId() != null) {
            throw new BadRequestAlertException("A new record55Scoring cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record55Scoring record55Scoring = record55ScoringMapper.toEntity(record55ScoringDTO);
        record55Scoring = record55ScoringRepository.save(record55Scoring);
        Record55ScoringDTO result = record55ScoringMapper.toDto(record55Scoring);
        return ResponseEntity.created(new URI("/api/record-55-scorings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-55-scorings : Updates an existing record55Scoring.
     *
     * @param record55ScoringDTO the record55ScoringDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record55ScoringDTO,
     * or with status 400 (Bad Request) if the record55ScoringDTO is not valid,
     * or with status 500 (Internal Server Error) if the record55ScoringDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-55-scorings")
    @Timed
    public ResponseEntity<Record55ScoringDTO> updateRecord55Scoring(@RequestBody Record55ScoringDTO record55ScoringDTO) throws URISyntaxException {
        log.debug("REST request to update Record55Scoring : {}", record55ScoringDTO);
        if (record55ScoringDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record55Scoring record55Scoring = record55ScoringMapper.toEntity(record55ScoringDTO);
        record55Scoring = record55ScoringRepository.save(record55Scoring);
        Record55ScoringDTO result = record55ScoringMapper.toDto(record55Scoring);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record55ScoringDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-55-scorings : get all the record55Scorings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record55Scorings in body
     */
    @GetMapping("/record-55-scorings")
    @Timed
    public List<Record55ScoringDTO> getAllRecord55Scorings() {
        log.debug("REST request to get all Record55Scorings");
        List<Record55Scoring> record55Scorings = record55ScoringRepository.findAll();
        return record55ScoringMapper.toDto(record55Scorings);
    }

    /**
     * GET  /record-55-scorings/:id : get the "id" record55Scoring.
     *
     * @param id the id of the record55ScoringDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record55ScoringDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-55-scorings/{id}")
    @Timed
    public ResponseEntity<Record55ScoringDTO> getRecord55Scoring(@PathVariable Long id) {
        log.debug("REST request to get Record55Scoring : {}", id);
        Optional<Record55ScoringDTO> record55ScoringDTO = record55ScoringRepository.findById(id)
            .map(record55ScoringMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record55ScoringDTO);
    }

    /**
     * DELETE  /record-55-scorings/:id : delete the "id" record55Scoring.
     *
     * @param id the id of the record55ScoringDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-55-scorings/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord55Scoring(@PathVariable Long id) {
        log.debug("REST request to delete Record55Scoring : {}", id);

        record55ScoringRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

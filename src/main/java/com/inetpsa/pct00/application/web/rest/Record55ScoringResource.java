package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record55Scoring;
import com.inetpsa.pct00.application.repository.Record55ScoringRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
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

    public Record55ScoringResource(Record55ScoringRepository record55ScoringRepository) {
        this.record55ScoringRepository = record55ScoringRepository;
    }

    /**
     * POST  /record-55-scorings : Create a new record55Scoring.
     *
     * @param record55Scoring the record55Scoring to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record55Scoring, or with status 400 (Bad Request) if the record55Scoring has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-55-scorings")
    @Timed
    public ResponseEntity<Record55Scoring> createRecord55Scoring(@RequestBody Record55Scoring record55Scoring) throws URISyntaxException {
        log.debug("REST request to save Record55Scoring : {}", record55Scoring);
        if (record55Scoring.getId() != null) {
            throw new BadRequestAlertException("A new record55Scoring cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record55Scoring result = record55ScoringRepository.save(record55Scoring);
        return ResponseEntity.created(new URI("/api/record-55-scorings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-55-scorings : Updates an existing record55Scoring.
     *
     * @param record55Scoring the record55Scoring to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record55Scoring,
     * or with status 400 (Bad Request) if the record55Scoring is not valid,
     * or with status 500 (Internal Server Error) if the record55Scoring couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-55-scorings")
    @Timed
    public ResponseEntity<Record55Scoring> updateRecord55Scoring(@RequestBody Record55Scoring record55Scoring) throws URISyntaxException {
        log.debug("REST request to update Record55Scoring : {}", record55Scoring);
        if (record55Scoring.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record55Scoring result = record55ScoringRepository.save(record55Scoring);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record55Scoring.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-55-scorings : get all the record55Scorings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record55Scorings in body
     */
    @GetMapping("/record-55-scorings")
    @Timed
    public List<Record55Scoring> getAllRecord55Scorings() {
        log.debug("REST request to get all Record55Scorings");
        return record55ScoringRepository.findAll();
    }

    /**
     * GET  /record-55-scorings/:id : get the "id" record55Scoring.
     *
     * @param id the id of the record55Scoring to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record55Scoring, or with status 404 (Not Found)
     */
    @GetMapping("/record-55-scorings/{id}")
    @Timed
    public ResponseEntity<Record55Scoring> getRecord55Scoring(@PathVariable Long id) {
        log.debug("REST request to get Record55Scoring : {}", id);
        Optional<Record55Scoring> record55Scoring = record55ScoringRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record55Scoring);
    }

    /**
     * DELETE  /record-55-scorings/:id : delete the "id" record55Scoring.
     *
     * @param id the id of the record55Scoring to delete
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

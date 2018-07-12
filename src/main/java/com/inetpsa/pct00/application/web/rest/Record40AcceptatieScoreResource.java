package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record40AcceptatieScore;
import com.inetpsa.pct00.application.repository.Record40AcceptatieScoreRepository;
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
 * REST controller for managing Record40AcceptatieScore.
 */
@RestController
@RequestMapping("/api")
public class Record40AcceptatieScoreResource {

    private final Logger log = LoggerFactory.getLogger(Record40AcceptatieScoreResource.class);

    private static final String ENTITY_NAME = "record40AcceptatieScore";

    private final Record40AcceptatieScoreRepository record40AcceptatieScoreRepository;

    public Record40AcceptatieScoreResource(Record40AcceptatieScoreRepository record40AcceptatieScoreRepository) {
        this.record40AcceptatieScoreRepository = record40AcceptatieScoreRepository;
    }

    /**
     * POST  /record-40-acceptatie-scores : Create a new record40AcceptatieScore.
     *
     * @param record40AcceptatieScore the record40AcceptatieScore to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record40AcceptatieScore, or with status 400 (Bad Request) if the record40AcceptatieScore has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-40-acceptatie-scores")
    @Timed
    public ResponseEntity<Record40AcceptatieScore> createRecord40AcceptatieScore(@RequestBody Record40AcceptatieScore record40AcceptatieScore) throws URISyntaxException {
        log.debug("REST request to save Record40AcceptatieScore : {}", record40AcceptatieScore);
        if (record40AcceptatieScore.getId() != null) {
            throw new BadRequestAlertException("A new record40AcceptatieScore cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record40AcceptatieScore result = record40AcceptatieScoreRepository.save(record40AcceptatieScore);
        return ResponseEntity.created(new URI("/api/record-40-acceptatie-scores/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-40-acceptatie-scores : Updates an existing record40AcceptatieScore.
     *
     * @param record40AcceptatieScore the record40AcceptatieScore to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record40AcceptatieScore,
     * or with status 400 (Bad Request) if the record40AcceptatieScore is not valid,
     * or with status 500 (Internal Server Error) if the record40AcceptatieScore couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-40-acceptatie-scores")
    @Timed
    public ResponseEntity<Record40AcceptatieScore> updateRecord40AcceptatieScore(@RequestBody Record40AcceptatieScore record40AcceptatieScore) throws URISyntaxException {
        log.debug("REST request to update Record40AcceptatieScore : {}", record40AcceptatieScore);
        if (record40AcceptatieScore.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record40AcceptatieScore result = record40AcceptatieScoreRepository.save(record40AcceptatieScore);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record40AcceptatieScore.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-40-acceptatie-scores : get all the record40AcceptatieScores.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record40AcceptatieScores in body
     */
    @GetMapping("/record-40-acceptatie-scores")
    @Timed
    public List<Record40AcceptatieScore> getAllRecord40AcceptatieScores() {
        log.debug("REST request to get all Record40AcceptatieScores");
        return record40AcceptatieScoreRepository.findAll();
    }

    /**
     * GET  /record-40-acceptatie-scores/:id : get the "id" record40AcceptatieScore.
     *
     * @param id the id of the record40AcceptatieScore to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record40AcceptatieScore, or with status 404 (Not Found)
     */
    @GetMapping("/record-40-acceptatie-scores/{id}")
    @Timed
    public ResponseEntity<Record40AcceptatieScore> getRecord40AcceptatieScore(@PathVariable Long id) {
        log.debug("REST request to get Record40AcceptatieScore : {}", id);
        Optional<Record40AcceptatieScore> record40AcceptatieScore = record40AcceptatieScoreRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record40AcceptatieScore);
    }

    /**
     * DELETE  /record-40-acceptatie-scores/:id : delete the "id" record40AcceptatieScore.
     *
     * @param id the id of the record40AcceptatieScore to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-40-acceptatie-scores/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord40AcceptatieScore(@PathVariable Long id) {
        log.debug("REST request to delete Record40AcceptatieScore : {}", id);

        record40AcceptatieScoreRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

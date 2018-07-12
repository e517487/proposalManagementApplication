package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record01Start;
import com.inetpsa.pct00.application.repository.Record01StartRepository;
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
 * REST controller for managing Record01Start.
 */
@RestController
@RequestMapping("/api")
public class Record01StartResource {

    private final Logger log = LoggerFactory.getLogger(Record01StartResource.class);

    private static final String ENTITY_NAME = "record01Start";

    private final Record01StartRepository record01StartRepository;

    public Record01StartResource(Record01StartRepository record01StartRepository) {
        this.record01StartRepository = record01StartRepository;
    }

    /**
     * POST  /record-01-starts : Create a new record01Start.
     *
     * @param record01Start the record01Start to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record01Start, or with status 400 (Bad Request) if the record01Start has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-01-starts")
    @Timed
    public ResponseEntity<Record01Start> createRecord01Start(@RequestBody Record01Start record01Start) throws URISyntaxException {
        log.debug("REST request to save Record01Start : {}", record01Start);
        if (record01Start.getId() != null) {
            throw new BadRequestAlertException("A new record01Start cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record01Start result = record01StartRepository.save(record01Start);
        return ResponseEntity.created(new URI("/api/record-01-starts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-01-starts : Updates an existing record01Start.
     *
     * @param record01Start the record01Start to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record01Start,
     * or with status 400 (Bad Request) if the record01Start is not valid,
     * or with status 500 (Internal Server Error) if the record01Start couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-01-starts")
    @Timed
    public ResponseEntity<Record01Start> updateRecord01Start(@RequestBody Record01Start record01Start) throws URISyntaxException {
        log.debug("REST request to update Record01Start : {}", record01Start);
        if (record01Start.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record01Start result = record01StartRepository.save(record01Start);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record01Start.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-01-starts : get all the record01Starts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record01Starts in body
     */
    @GetMapping("/record-01-starts")
    @Timed
    public List<Record01Start> getAllRecord01Starts() {
        log.debug("REST request to get all Record01Starts");
        return record01StartRepository.findAll();
    }

    /**
     * GET  /record-01-starts/:id : get the "id" record01Start.
     *
     * @param id the id of the record01Start to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record01Start, or with status 404 (Not Found)
     */
    @GetMapping("/record-01-starts/{id}")
    @Timed
    public ResponseEntity<Record01Start> getRecord01Start(@PathVariable Long id) {
        log.debug("REST request to get Record01Start : {}", id);
        Optional<Record01Start> record01Start = record01StartRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record01Start);
    }

    /**
     * DELETE  /record-01-starts/:id : delete the "id" record01Start.
     *
     * @param id the id of the record01Start to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-01-starts/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord01Start(@PathVariable Long id) {
        log.debug("REST request to delete Record01Start : {}", id);

        record01StartRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

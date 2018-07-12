package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record63Uitleg;
import com.inetpsa.pct00.application.repository.Record63UitlegRepository;
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
 * REST controller for managing Record63Uitleg.
 */
@RestController
@RequestMapping("/api")
public class Record63UitlegResource {

    private final Logger log = LoggerFactory.getLogger(Record63UitlegResource.class);

    private static final String ENTITY_NAME = "record63Uitleg";

    private final Record63UitlegRepository record63UitlegRepository;

    public Record63UitlegResource(Record63UitlegRepository record63UitlegRepository) {
        this.record63UitlegRepository = record63UitlegRepository;
    }

    /**
     * POST  /record-63-uitlegs : Create a new record63Uitleg.
     *
     * @param record63Uitleg the record63Uitleg to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record63Uitleg, or with status 400 (Bad Request) if the record63Uitleg has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-63-uitlegs")
    @Timed
    public ResponseEntity<Record63Uitleg> createRecord63Uitleg(@RequestBody Record63Uitleg record63Uitleg) throws URISyntaxException {
        log.debug("REST request to save Record63Uitleg : {}", record63Uitleg);
        if (record63Uitleg.getId() != null) {
            throw new BadRequestAlertException("A new record63Uitleg cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record63Uitleg result = record63UitlegRepository.save(record63Uitleg);
        return ResponseEntity.created(new URI("/api/record-63-uitlegs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-63-uitlegs : Updates an existing record63Uitleg.
     *
     * @param record63Uitleg the record63Uitleg to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record63Uitleg,
     * or with status 400 (Bad Request) if the record63Uitleg is not valid,
     * or with status 500 (Internal Server Error) if the record63Uitleg couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-63-uitlegs")
    @Timed
    public ResponseEntity<Record63Uitleg> updateRecord63Uitleg(@RequestBody Record63Uitleg record63Uitleg) throws URISyntaxException {
        log.debug("REST request to update Record63Uitleg : {}", record63Uitleg);
        if (record63Uitleg.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record63Uitleg result = record63UitlegRepository.save(record63Uitleg);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record63Uitleg.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-63-uitlegs : get all the record63Uitlegs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record63Uitlegs in body
     */
    @GetMapping("/record-63-uitlegs")
    @Timed
    public List<Record63Uitleg> getAllRecord63Uitlegs() {
        log.debug("REST request to get all Record63Uitlegs");
        return record63UitlegRepository.findAll();
    }

    /**
     * GET  /record-63-uitlegs/:id : get the "id" record63Uitleg.
     *
     * @param id the id of the record63Uitleg to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record63Uitleg, or with status 404 (Not Found)
     */
    @GetMapping("/record-63-uitlegs/{id}")
    @Timed
    public ResponseEntity<Record63Uitleg> getRecord63Uitleg(@PathVariable Long id) {
        log.debug("REST request to get Record63Uitleg : {}", id);
        Optional<Record63Uitleg> record63Uitleg = record63UitlegRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record63Uitleg);
    }

    /**
     * DELETE  /record-63-uitlegs/:id : delete the "id" record63Uitleg.
     *
     * @param id the id of the record63Uitleg to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-63-uitlegs/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord63Uitleg(@PathVariable Long id) {
        log.debug("REST request to delete Record63Uitleg : {}", id);

        record63UitlegRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

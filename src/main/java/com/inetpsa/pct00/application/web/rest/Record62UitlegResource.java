package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record62Uitleg;
import com.inetpsa.pct00.application.repository.Record62UitlegRepository;
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
 * REST controller for managing Record62Uitleg.
 */
@RestController
@RequestMapping("/api")
public class Record62UitlegResource {

    private final Logger log = LoggerFactory.getLogger(Record62UitlegResource.class);

    private static final String ENTITY_NAME = "record62Uitleg";

    private final Record62UitlegRepository record62UitlegRepository;

    public Record62UitlegResource(Record62UitlegRepository record62UitlegRepository) {
        this.record62UitlegRepository = record62UitlegRepository;
    }

    /**
     * POST  /record-62-uitlegs : Create a new record62Uitleg.
     *
     * @param record62Uitleg the record62Uitleg to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record62Uitleg, or with status 400 (Bad Request) if the record62Uitleg has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-62-uitlegs")
    @Timed
    public ResponseEntity<Record62Uitleg> createRecord62Uitleg(@RequestBody Record62Uitleg record62Uitleg) throws URISyntaxException {
        log.debug("REST request to save Record62Uitleg : {}", record62Uitleg);
        if (record62Uitleg.getId() != null) {
            throw new BadRequestAlertException("A new record62Uitleg cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record62Uitleg result = record62UitlegRepository.save(record62Uitleg);
        return ResponseEntity.created(new URI("/api/record-62-uitlegs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-62-uitlegs : Updates an existing record62Uitleg.
     *
     * @param record62Uitleg the record62Uitleg to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record62Uitleg,
     * or with status 400 (Bad Request) if the record62Uitleg is not valid,
     * or with status 500 (Internal Server Error) if the record62Uitleg couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-62-uitlegs")
    @Timed
    public ResponseEntity<Record62Uitleg> updateRecord62Uitleg(@RequestBody Record62Uitleg record62Uitleg) throws URISyntaxException {
        log.debug("REST request to update Record62Uitleg : {}", record62Uitleg);
        if (record62Uitleg.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record62Uitleg result = record62UitlegRepository.save(record62Uitleg);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record62Uitleg.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-62-uitlegs : get all the record62Uitlegs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record62Uitlegs in body
     */
    @GetMapping("/record-62-uitlegs")
    @Timed
    public List<Record62Uitleg> getAllRecord62Uitlegs() {
        log.debug("REST request to get all Record62Uitlegs");
        return record62UitlegRepository.findAll();
    }

    /**
     * GET  /record-62-uitlegs/:id : get the "id" record62Uitleg.
     *
     * @param id the id of the record62Uitleg to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record62Uitleg, or with status 404 (Not Found)
     */
    @GetMapping("/record-62-uitlegs/{id}")
    @Timed
    public ResponseEntity<Record62Uitleg> getRecord62Uitleg(@PathVariable Long id) {
        log.debug("REST request to get Record62Uitleg : {}", id);
        Optional<Record62Uitleg> record62Uitleg = record62UitlegRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record62Uitleg);
    }

    /**
     * DELETE  /record-62-uitlegs/:id : delete the "id" record62Uitleg.
     *
     * @param id the id of the record62Uitleg to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-62-uitlegs/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord62Uitleg(@PathVariable Long id) {
        log.debug("REST request to delete Record62Uitleg : {}", id);

        record62UitlegRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

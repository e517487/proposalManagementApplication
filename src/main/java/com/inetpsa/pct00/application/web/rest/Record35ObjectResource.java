package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record35Object;
import com.inetpsa.pct00.application.repository.Record35ObjectRepository;
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
 * REST controller for managing Record35Object.
 */
@RestController
@RequestMapping("/api")
public class Record35ObjectResource {

    private final Logger log = LoggerFactory.getLogger(Record35ObjectResource.class);

    private static final String ENTITY_NAME = "record35Object";

    private final Record35ObjectRepository record35ObjectRepository;

    public Record35ObjectResource(Record35ObjectRepository record35ObjectRepository) {
        this.record35ObjectRepository = record35ObjectRepository;
    }

    /**
     * POST  /record-35-objects : Create a new record35Object.
     *
     * @param record35Object the record35Object to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record35Object, or with status 400 (Bad Request) if the record35Object has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-35-objects")
    @Timed
    public ResponseEntity<Record35Object> createRecord35Object(@RequestBody Record35Object record35Object) throws URISyntaxException {
        log.debug("REST request to save Record35Object : {}", record35Object);
        if (record35Object.getId() != null) {
            throw new BadRequestAlertException("A new record35Object cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record35Object result = record35ObjectRepository.save(record35Object);
        return ResponseEntity.created(new URI("/api/record-35-objects/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-35-objects : Updates an existing record35Object.
     *
     * @param record35Object the record35Object to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record35Object,
     * or with status 400 (Bad Request) if the record35Object is not valid,
     * or with status 500 (Internal Server Error) if the record35Object couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-35-objects")
    @Timed
    public ResponseEntity<Record35Object> updateRecord35Object(@RequestBody Record35Object record35Object) throws URISyntaxException {
        log.debug("REST request to update Record35Object : {}", record35Object);
        if (record35Object.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record35Object result = record35ObjectRepository.save(record35Object);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record35Object.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-35-objects : get all the record35Objects.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record35Objects in body
     */
    @GetMapping("/record-35-objects")
    @Timed
    public List<Record35Object> getAllRecord35Objects() {
        log.debug("REST request to get all Record35Objects");
        return record35ObjectRepository.findAll();
    }

    /**
     * GET  /record-35-objects/:id : get the "id" record35Object.
     *
     * @param id the id of the record35Object to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record35Object, or with status 404 (Not Found)
     */
    @GetMapping("/record-35-objects/{id}")
    @Timed
    public ResponseEntity<Record35Object> getRecord35Object(@PathVariable Long id) {
        log.debug("REST request to get Record35Object : {}", id);
        Optional<Record35Object> record35Object = record35ObjectRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record35Object);
    }

    /**
     * DELETE  /record-35-objects/:id : delete the "id" record35Object.
     *
     * @param id the id of the record35Object to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-35-objects/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord35Object(@PathVariable Long id) {
        log.debug("REST request to delete Record35Object : {}", id);

        record35ObjectRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

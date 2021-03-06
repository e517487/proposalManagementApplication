package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record99Eind;
import com.inetpsa.pct00.application.repository.Record99EindRepository;
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
 * REST controller for managing Record99Eind.
 */
@RestController
@RequestMapping("/api")
public class Record99EindResource {

    private final Logger log = LoggerFactory.getLogger(Record99EindResource.class);

    private static final String ENTITY_NAME = "record99Eind";

    private final Record99EindRepository record99EindRepository;

    public Record99EindResource(Record99EindRepository record99EindRepository) {
        this.record99EindRepository = record99EindRepository;
    }

    /**
     * POST  /record-99-einds : Create a new record99Eind.
     *
     * @param record99Eind the record99Eind to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record99Eind, or with status 400 (Bad Request) if the record99Eind has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-99-einds")
    @Timed
    public ResponseEntity<Record99Eind> createRecord99Eind(@RequestBody Record99Eind record99Eind) throws URISyntaxException {
        log.debug("REST request to save Record99Eind : {}", record99Eind);
        if (record99Eind.getId() != null) {
            throw new BadRequestAlertException("A new record99Eind cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record99Eind result = record99EindRepository.save(record99Eind);
        return ResponseEntity.created(new URI("/api/record-99-einds/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-99-einds : Updates an existing record99Eind.
     *
     * @param record99Eind the record99Eind to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record99Eind,
     * or with status 400 (Bad Request) if the record99Eind is not valid,
     * or with status 500 (Internal Server Error) if the record99Eind couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-99-einds")
    @Timed
    public ResponseEntity<Record99Eind> updateRecord99Eind(@RequestBody Record99Eind record99Eind) throws URISyntaxException {
        log.debug("REST request to update Record99Eind : {}", record99Eind);
        if (record99Eind.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record99Eind result = record99EindRepository.save(record99Eind);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record99Eind.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-99-einds : get all the record99Einds.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record99Einds in body
     */
    @GetMapping("/record-99-einds")
    @Timed
    public List<Record99Eind> getAllRecord99Einds() {
        log.debug("REST request to get all Record99Einds");
        return record99EindRepository.findAll();
    }

    /**
     * GET  /record-99-einds/:id : get the "id" record99Eind.
     *
     * @param id the id of the record99Eind to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record99Eind, or with status 404 (Not Found)
     */
    @GetMapping("/record-99-einds/{id}")
    @Timed
    public ResponseEntity<Record99Eind> getRecord99Eind(@PathVariable Long id) {
        log.debug("REST request to get Record99Eind : {}", id);
        Optional<Record99Eind> record99Eind = record99EindRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record99Eind);
    }

    /**
     * DELETE  /record-99-einds/:id : delete the "id" record99Eind.
     *
     * @param id the id of the record99Eind to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-99-einds/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord99Eind(@PathVariable Long id) {
        log.debug("REST request to delete Record99Eind : {}", id);

        record99EindRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

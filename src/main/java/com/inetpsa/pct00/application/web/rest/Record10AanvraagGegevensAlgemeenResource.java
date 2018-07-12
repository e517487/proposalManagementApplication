package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record10AanvraagGegevensAlgemeen;
import com.inetpsa.pct00.application.repository.Record10AanvraagGegevensAlgemeenRepository;
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
 * REST controller for managing Record10AanvraagGegevensAlgemeen.
 */
@RestController
@RequestMapping("/api")
public class Record10AanvraagGegevensAlgemeenResource {

    private final Logger log = LoggerFactory.getLogger(Record10AanvraagGegevensAlgemeenResource.class);

    private static final String ENTITY_NAME = "record10AanvraagGegevensAlgemeen";

    private final Record10AanvraagGegevensAlgemeenRepository record10AanvraagGegevensAlgemeenRepository;

    public Record10AanvraagGegevensAlgemeenResource(Record10AanvraagGegevensAlgemeenRepository record10AanvraagGegevensAlgemeenRepository) {
        this.record10AanvraagGegevensAlgemeenRepository = record10AanvraagGegevensAlgemeenRepository;
    }

    /**
     * POST  /record-10-aanvraag-gegevens-algemeens : Create a new record10AanvraagGegevensAlgemeen.
     *
     * @param record10AanvraagGegevensAlgemeen the record10AanvraagGegevensAlgemeen to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record10AanvraagGegevensAlgemeen, or with status 400 (Bad Request) if the record10AanvraagGegevensAlgemeen has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-10-aanvraag-gegevens-algemeens")
    @Timed
    public ResponseEntity<Record10AanvraagGegevensAlgemeen> createRecord10AanvraagGegevensAlgemeen(@RequestBody Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen) throws URISyntaxException {
        log.debug("REST request to save Record10AanvraagGegevensAlgemeen : {}", record10AanvraagGegevensAlgemeen);
        if (record10AanvraagGegevensAlgemeen.getId() != null) {
            throw new BadRequestAlertException("A new record10AanvraagGegevensAlgemeen cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record10AanvraagGegevensAlgemeen result = record10AanvraagGegevensAlgemeenRepository.save(record10AanvraagGegevensAlgemeen);
        return ResponseEntity.created(new URI("/api/record-10-aanvraag-gegevens-algemeens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-10-aanvraag-gegevens-algemeens : Updates an existing record10AanvraagGegevensAlgemeen.
     *
     * @param record10AanvraagGegevensAlgemeen the record10AanvraagGegevensAlgemeen to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record10AanvraagGegevensAlgemeen,
     * or with status 400 (Bad Request) if the record10AanvraagGegevensAlgemeen is not valid,
     * or with status 500 (Internal Server Error) if the record10AanvraagGegevensAlgemeen couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-10-aanvraag-gegevens-algemeens")
    @Timed
    public ResponseEntity<Record10AanvraagGegevensAlgemeen> updateRecord10AanvraagGegevensAlgemeen(@RequestBody Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen) throws URISyntaxException {
        log.debug("REST request to update Record10AanvraagGegevensAlgemeen : {}", record10AanvraagGegevensAlgemeen);
        if (record10AanvraagGegevensAlgemeen.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record10AanvraagGegevensAlgemeen result = record10AanvraagGegevensAlgemeenRepository.save(record10AanvraagGegevensAlgemeen);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record10AanvraagGegevensAlgemeen.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-10-aanvraag-gegevens-algemeens : get all the record10AanvraagGegevensAlgemeens.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record10AanvraagGegevensAlgemeens in body
     */
    @GetMapping("/record-10-aanvraag-gegevens-algemeens")
    @Timed
    public List<Record10AanvraagGegevensAlgemeen> getAllRecord10AanvraagGegevensAlgemeens() {
        log.debug("REST request to get all Record10AanvraagGegevensAlgemeens");
        return record10AanvraagGegevensAlgemeenRepository.findAll();
    }

    /**
     * GET  /record-10-aanvraag-gegevens-algemeens/:id : get the "id" record10AanvraagGegevensAlgemeen.
     *
     * @param id the id of the record10AanvraagGegevensAlgemeen to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record10AanvraagGegevensAlgemeen, or with status 404 (Not Found)
     */
    @GetMapping("/record-10-aanvraag-gegevens-algemeens/{id}")
    @Timed
    public ResponseEntity<Record10AanvraagGegevensAlgemeen> getRecord10AanvraagGegevensAlgemeen(@PathVariable Long id) {
        log.debug("REST request to get Record10AanvraagGegevensAlgemeen : {}", id);
        Optional<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeenRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record10AanvraagGegevensAlgemeen);
    }

    /**
     * DELETE  /record-10-aanvraag-gegevens-algemeens/:id : delete the "id" record10AanvraagGegevensAlgemeen.
     *
     * @param id the id of the record10AanvraagGegevensAlgemeen to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-10-aanvraag-gegevens-algemeens/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord10AanvraagGegevensAlgemeen(@PathVariable Long id) {
        log.debug("REST request to delete Record10AanvraagGegevensAlgemeen : {}", id);

        record10AanvraagGegevensAlgemeenRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

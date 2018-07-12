package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record11AanvraagGegevensOpmerkingen;
import com.inetpsa.pct00.application.repository.Record11AanvraagGegevensOpmerkingenRepository;
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
 * REST controller for managing Record11AanvraagGegevensOpmerkingen.
 */
@RestController
@RequestMapping("/api")
public class Record11AanvraagGegevensOpmerkingenResource {

    private final Logger log = LoggerFactory.getLogger(Record11AanvraagGegevensOpmerkingenResource.class);

    private static final String ENTITY_NAME = "record11AanvraagGegevensOpmerkingen";

    private final Record11AanvraagGegevensOpmerkingenRepository record11AanvraagGegevensOpmerkingenRepository;

    public Record11AanvraagGegevensOpmerkingenResource(Record11AanvraagGegevensOpmerkingenRepository record11AanvraagGegevensOpmerkingenRepository) {
        this.record11AanvraagGegevensOpmerkingenRepository = record11AanvraagGegevensOpmerkingenRepository;
    }

    /**
     * POST  /record-11-aanvraag-gegevens-opmerkingens : Create a new record11AanvraagGegevensOpmerkingen.
     *
     * @param record11AanvraagGegevensOpmerkingen the record11AanvraagGegevensOpmerkingen to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record11AanvraagGegevensOpmerkingen, or with status 400 (Bad Request) if the record11AanvraagGegevensOpmerkingen has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingen> createRecord11AanvraagGegevensOpmerkingen(@RequestBody Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen) throws URISyntaxException {
        log.debug("REST request to save Record11AanvraagGegevensOpmerkingen : {}", record11AanvraagGegevensOpmerkingen);
        if (record11AanvraagGegevensOpmerkingen.getId() != null) {
            throw new BadRequestAlertException("A new record11AanvraagGegevensOpmerkingen cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record11AanvraagGegevensOpmerkingen result = record11AanvraagGegevensOpmerkingenRepository.save(record11AanvraagGegevensOpmerkingen);
        return ResponseEntity.created(new URI("/api/record-11-aanvraag-gegevens-opmerkingens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-11-aanvraag-gegevens-opmerkingens : Updates an existing record11AanvraagGegevensOpmerkingen.
     *
     * @param record11AanvraagGegevensOpmerkingen the record11AanvraagGegevensOpmerkingen to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record11AanvraagGegevensOpmerkingen,
     * or with status 400 (Bad Request) if the record11AanvraagGegevensOpmerkingen is not valid,
     * or with status 500 (Internal Server Error) if the record11AanvraagGegevensOpmerkingen couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingen> updateRecord11AanvraagGegevensOpmerkingen(@RequestBody Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen) throws URISyntaxException {
        log.debug("REST request to update Record11AanvraagGegevensOpmerkingen : {}", record11AanvraagGegevensOpmerkingen);
        if (record11AanvraagGegevensOpmerkingen.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record11AanvraagGegevensOpmerkingen result = record11AanvraagGegevensOpmerkingenRepository.save(record11AanvraagGegevensOpmerkingen);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record11AanvraagGegevensOpmerkingen.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-11-aanvraag-gegevens-opmerkingens : get all the record11AanvraagGegevensOpmerkingens.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record11AanvraagGegevensOpmerkingens in body
     */
    @GetMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public List<Record11AanvraagGegevensOpmerkingen> getAllRecord11AanvraagGegevensOpmerkingens() {
        log.debug("REST request to get all Record11AanvraagGegevensOpmerkingens");
        return record11AanvraagGegevensOpmerkingenRepository.findAll();
    }

    /**
     * GET  /record-11-aanvraag-gegevens-opmerkingens/:id : get the "id" record11AanvraagGegevensOpmerkingen.
     *
     * @param id the id of the record11AanvraagGegevensOpmerkingen to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record11AanvraagGegevensOpmerkingen, or with status 404 (Not Found)
     */
    @GetMapping("/record-11-aanvraag-gegevens-opmerkingens/{id}")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingen> getRecord11AanvraagGegevensOpmerkingen(@PathVariable Long id) {
        log.debug("REST request to get Record11AanvraagGegevensOpmerkingen : {}", id);
        Optional<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record11AanvraagGegevensOpmerkingen);
    }

    /**
     * DELETE  /record-11-aanvraag-gegevens-opmerkingens/:id : delete the "id" record11AanvraagGegevensOpmerkingen.
     *
     * @param id the id of the record11AanvraagGegevensOpmerkingen to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-11-aanvraag-gegevens-opmerkingens/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord11AanvraagGegevensOpmerkingen(@PathVariable Long id) {
        log.debug("REST request to delete Record11AanvraagGegevensOpmerkingen : {}", id);

        record11AanvraagGegevensOpmerkingenRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record25Herfinancieering;
import com.inetpsa.pct00.application.repository.Record25HerfinancieeringRepository;
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
 * REST controller for managing Record25Herfinancieering.
 */
@RestController
@RequestMapping("/api")
public class Record25HerfinancieeringResource {

    private final Logger log = LoggerFactory.getLogger(Record25HerfinancieeringResource.class);

    private static final String ENTITY_NAME = "record25Herfinancieering";

    private final Record25HerfinancieeringRepository record25HerfinancieeringRepository;

    public Record25HerfinancieeringResource(Record25HerfinancieeringRepository record25HerfinancieeringRepository) {
        this.record25HerfinancieeringRepository = record25HerfinancieeringRepository;
    }

    /**
     * POST  /record-25-herfinancieerings : Create a new record25Herfinancieering.
     *
     * @param record25Herfinancieering the record25Herfinancieering to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record25Herfinancieering, or with status 400 (Bad Request) if the record25Herfinancieering has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-25-herfinancieerings")
    @Timed
    public ResponseEntity<Record25Herfinancieering> createRecord25Herfinancieering(@RequestBody Record25Herfinancieering record25Herfinancieering) throws URISyntaxException {
        log.debug("REST request to save Record25Herfinancieering : {}", record25Herfinancieering);
        if (record25Herfinancieering.getId() != null) {
            throw new BadRequestAlertException("A new record25Herfinancieering cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record25Herfinancieering result = record25HerfinancieeringRepository.save(record25Herfinancieering);
        return ResponseEntity.created(new URI("/api/record-25-herfinancieerings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-25-herfinancieerings : Updates an existing record25Herfinancieering.
     *
     * @param record25Herfinancieering the record25Herfinancieering to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record25Herfinancieering,
     * or with status 400 (Bad Request) if the record25Herfinancieering is not valid,
     * or with status 500 (Internal Server Error) if the record25Herfinancieering couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-25-herfinancieerings")
    @Timed
    public ResponseEntity<Record25Herfinancieering> updateRecord25Herfinancieering(@RequestBody Record25Herfinancieering record25Herfinancieering) throws URISyntaxException {
        log.debug("REST request to update Record25Herfinancieering : {}", record25Herfinancieering);
        if (record25Herfinancieering.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record25Herfinancieering result = record25HerfinancieeringRepository.save(record25Herfinancieering);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record25Herfinancieering.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-25-herfinancieerings : get all the record25Herfinancieerings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record25Herfinancieerings in body
     */
    @GetMapping("/record-25-herfinancieerings")
    @Timed
    public List<Record25Herfinancieering> getAllRecord25Herfinancieerings() {
        log.debug("REST request to get all Record25Herfinancieerings");
        return record25HerfinancieeringRepository.findAll();
    }

    /**
     * GET  /record-25-herfinancieerings/:id : get the "id" record25Herfinancieering.
     *
     * @param id the id of the record25Herfinancieering to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record25Herfinancieering, or with status 404 (Not Found)
     */
    @GetMapping("/record-25-herfinancieerings/{id}")
    @Timed
    public ResponseEntity<Record25Herfinancieering> getRecord25Herfinancieering(@PathVariable Long id) {
        log.debug("REST request to get Record25Herfinancieering : {}", id);
        Optional<Record25Herfinancieering> record25Herfinancieering = record25HerfinancieeringRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record25Herfinancieering);
    }

    /**
     * DELETE  /record-25-herfinancieerings/:id : delete the "id" record25Herfinancieering.
     *
     * @param id the id of the record25Herfinancieering to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-25-herfinancieerings/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord25Herfinancieering(@PathVariable Long id) {
        log.debug("REST request to delete Record25Herfinancieering : {}", id);

        record25HerfinancieeringRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

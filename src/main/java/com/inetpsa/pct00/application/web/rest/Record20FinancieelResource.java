package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record20Financieel;
import com.inetpsa.pct00.application.repository.Record20FinancieelRepository;
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
 * REST controller for managing Record20Financieel.
 */
@RestController
@RequestMapping("/api")
public class Record20FinancieelResource {

    private final Logger log = LoggerFactory.getLogger(Record20FinancieelResource.class);

    private static final String ENTITY_NAME = "record20Financieel";

    private final Record20FinancieelRepository record20FinancieelRepository;

    public Record20FinancieelResource(Record20FinancieelRepository record20FinancieelRepository) {
        this.record20FinancieelRepository = record20FinancieelRepository;
    }

    /**
     * POST  /record-20-financieels : Create a new record20Financieel.
     *
     * @param record20Financieel the record20Financieel to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record20Financieel, or with status 400 (Bad Request) if the record20Financieel has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-20-financieels")
    @Timed
    public ResponseEntity<Record20Financieel> createRecord20Financieel(@RequestBody Record20Financieel record20Financieel) throws URISyntaxException {
        log.debug("REST request to save Record20Financieel : {}", record20Financieel);
        if (record20Financieel.getId() != null) {
            throw new BadRequestAlertException("A new record20Financieel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Record20Financieel result = record20FinancieelRepository.save(record20Financieel);
        return ResponseEntity.created(new URI("/api/record-20-financieels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-20-financieels : Updates an existing record20Financieel.
     *
     * @param record20Financieel the record20Financieel to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record20Financieel,
     * or with status 400 (Bad Request) if the record20Financieel is not valid,
     * or with status 500 (Internal Server Error) if the record20Financieel couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-20-financieels")
    @Timed
    public ResponseEntity<Record20Financieel> updateRecord20Financieel(@RequestBody Record20Financieel record20Financieel) throws URISyntaxException {
        log.debug("REST request to update Record20Financieel : {}", record20Financieel);
        if (record20Financieel.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Record20Financieel result = record20FinancieelRepository.save(record20Financieel);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record20Financieel.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-20-financieels : get all the record20Financieels.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record20Financieels in body
     */
    @GetMapping("/record-20-financieels")
    @Timed
    public List<Record20Financieel> getAllRecord20Financieels() {
        log.debug("REST request to get all Record20Financieels");
        return record20FinancieelRepository.findAll();
    }

    /**
     * GET  /record-20-financieels/:id : get the "id" record20Financieel.
     *
     * @param id the id of the record20Financieel to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record20Financieel, or with status 404 (Not Found)
     */
    @GetMapping("/record-20-financieels/{id}")
    @Timed
    public ResponseEntity<Record20Financieel> getRecord20Financieel(@PathVariable Long id) {
        log.debug("REST request to get Record20Financieel : {}", id);
        Optional<Record20Financieel> record20Financieel = record20FinancieelRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(record20Financieel);
    }

    /**
     * DELETE  /record-20-financieels/:id : delete the "id" record20Financieel.
     *
     * @param id the id of the record20Financieel to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-20-financieels/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord20Financieel(@PathVariable Long id) {
        log.debug("REST request to delete Record20Financieel : {}", id);

        record20FinancieelRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

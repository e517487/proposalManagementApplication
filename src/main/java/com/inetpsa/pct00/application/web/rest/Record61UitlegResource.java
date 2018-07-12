package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record61Uitleg;
import com.inetpsa.pct00.application.repository.Record61UitlegRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record61UitlegDTO;
import com.inetpsa.pct00.application.service.mapper.Record61UitlegMapper;
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
 * REST controller for managing Record61Uitleg.
 */
@RestController
@RequestMapping("/api")
public class Record61UitlegResource {

    private final Logger log = LoggerFactory.getLogger(Record61UitlegResource.class);

    private static final String ENTITY_NAME = "record61Uitleg";

    private final Record61UitlegRepository record61UitlegRepository;

    private final Record61UitlegMapper record61UitlegMapper;

    public Record61UitlegResource(Record61UitlegRepository record61UitlegRepository, Record61UitlegMapper record61UitlegMapper) {
        this.record61UitlegRepository = record61UitlegRepository;
        this.record61UitlegMapper = record61UitlegMapper;
    }

    /**
     * POST  /record-61-uitlegs : Create a new record61Uitleg.
     *
     * @param record61UitlegDTO the record61UitlegDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record61UitlegDTO, or with status 400 (Bad Request) if the record61Uitleg has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-61-uitlegs")
    @Timed
    public ResponseEntity<Record61UitlegDTO> createRecord61Uitleg(@RequestBody Record61UitlegDTO record61UitlegDTO) throws URISyntaxException {
        log.debug("REST request to save Record61Uitleg : {}", record61UitlegDTO);
        if (record61UitlegDTO.getId() != null) {
            throw new BadRequestAlertException("A new record61Uitleg cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record61Uitleg record61Uitleg = record61UitlegMapper.toEntity(record61UitlegDTO);
        record61Uitleg = record61UitlegRepository.save(record61Uitleg);
        Record61UitlegDTO result = record61UitlegMapper.toDto(record61Uitleg);
        return ResponseEntity.created(new URI("/api/record-61-uitlegs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-61-uitlegs : Updates an existing record61Uitleg.
     *
     * @param record61UitlegDTO the record61UitlegDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record61UitlegDTO,
     * or with status 400 (Bad Request) if the record61UitlegDTO is not valid,
     * or with status 500 (Internal Server Error) if the record61UitlegDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-61-uitlegs")
    @Timed
    public ResponseEntity<Record61UitlegDTO> updateRecord61Uitleg(@RequestBody Record61UitlegDTO record61UitlegDTO) throws URISyntaxException {
        log.debug("REST request to update Record61Uitleg : {}", record61UitlegDTO);
        if (record61UitlegDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record61Uitleg record61Uitleg = record61UitlegMapper.toEntity(record61UitlegDTO);
        record61Uitleg = record61UitlegRepository.save(record61Uitleg);
        Record61UitlegDTO result = record61UitlegMapper.toDto(record61Uitleg);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record61UitlegDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-61-uitlegs : get all the record61Uitlegs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record61Uitlegs in body
     */
    @GetMapping("/record-61-uitlegs")
    @Timed
    public List<Record61UitlegDTO> getAllRecord61Uitlegs() {
        log.debug("REST request to get all Record61Uitlegs");
        List<Record61Uitleg> record61Uitlegs = record61UitlegRepository.findAll();
        return record61UitlegMapper.toDto(record61Uitlegs);
    }

    /**
     * GET  /record-61-uitlegs/:id : get the "id" record61Uitleg.
     *
     * @param id the id of the record61UitlegDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record61UitlegDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-61-uitlegs/{id}")
    @Timed
    public ResponseEntity<Record61UitlegDTO> getRecord61Uitleg(@PathVariable Long id) {
        log.debug("REST request to get Record61Uitleg : {}", id);
        Optional<Record61UitlegDTO> record61UitlegDTO = record61UitlegRepository.findById(id)
            .map(record61UitlegMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record61UitlegDTO);
    }

    /**
     * DELETE  /record-61-uitlegs/:id : delete the "id" record61Uitleg.
     *
     * @param id the id of the record61UitlegDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-61-uitlegs/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord61Uitleg(@PathVariable Long id) {
        log.debug("REST request to delete Record61Uitleg : {}", id);

        record61UitlegRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

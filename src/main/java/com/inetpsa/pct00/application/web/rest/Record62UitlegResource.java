package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record62Uitleg;
import com.inetpsa.pct00.application.repository.Record62UitlegRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record62UitlegDTO;
import com.inetpsa.pct00.application.service.mapper.Record62UitlegMapper;
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

    private final Record62UitlegMapper record62UitlegMapper;

    public Record62UitlegResource(Record62UitlegRepository record62UitlegRepository, Record62UitlegMapper record62UitlegMapper) {
        this.record62UitlegRepository = record62UitlegRepository;
        this.record62UitlegMapper = record62UitlegMapper;
    }

    /**
     * POST  /record-62-uitlegs : Create a new record62Uitleg.
     *
     * @param record62UitlegDTO the record62UitlegDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record62UitlegDTO, or with status 400 (Bad Request) if the record62Uitleg has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-62-uitlegs")
    @Timed
    public ResponseEntity<Record62UitlegDTO> createRecord62Uitleg(@RequestBody Record62UitlegDTO record62UitlegDTO) throws URISyntaxException {
        log.debug("REST request to save Record62Uitleg : {}", record62UitlegDTO);
        if (record62UitlegDTO.getId() != null) {
            throw new BadRequestAlertException("A new record62Uitleg cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record62Uitleg record62Uitleg = record62UitlegMapper.toEntity(record62UitlegDTO);
        record62Uitleg = record62UitlegRepository.save(record62Uitleg);
        Record62UitlegDTO result = record62UitlegMapper.toDto(record62Uitleg);
        return ResponseEntity.created(new URI("/api/record-62-uitlegs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-62-uitlegs : Updates an existing record62Uitleg.
     *
     * @param record62UitlegDTO the record62UitlegDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record62UitlegDTO,
     * or with status 400 (Bad Request) if the record62UitlegDTO is not valid,
     * or with status 500 (Internal Server Error) if the record62UitlegDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-62-uitlegs")
    @Timed
    public ResponseEntity<Record62UitlegDTO> updateRecord62Uitleg(@RequestBody Record62UitlegDTO record62UitlegDTO) throws URISyntaxException {
        log.debug("REST request to update Record62Uitleg : {}", record62UitlegDTO);
        if (record62UitlegDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record62Uitleg record62Uitleg = record62UitlegMapper.toEntity(record62UitlegDTO);
        record62Uitleg = record62UitlegRepository.save(record62Uitleg);
        Record62UitlegDTO result = record62UitlegMapper.toDto(record62Uitleg);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record62UitlegDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-62-uitlegs : get all the record62Uitlegs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record62Uitlegs in body
     */
    @GetMapping("/record-62-uitlegs")
    @Timed
    public List<Record62UitlegDTO> getAllRecord62Uitlegs() {
        log.debug("REST request to get all Record62Uitlegs");
        List<Record62Uitleg> record62Uitlegs = record62UitlegRepository.findAll();
        return record62UitlegMapper.toDto(record62Uitlegs);
    }

    /**
     * GET  /record-62-uitlegs/:id : get the "id" record62Uitleg.
     *
     * @param id the id of the record62UitlegDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record62UitlegDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-62-uitlegs/{id}")
    @Timed
    public ResponseEntity<Record62UitlegDTO> getRecord62Uitleg(@PathVariable Long id) {
        log.debug("REST request to get Record62Uitleg : {}", id);
        Optional<Record62UitlegDTO> record62UitlegDTO = record62UitlegRepository.findById(id)
            .map(record62UitlegMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record62UitlegDTO);
    }

    /**
     * DELETE  /record-62-uitlegs/:id : delete the "id" record62Uitleg.
     *
     * @param id the id of the record62UitlegDTO to delete
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

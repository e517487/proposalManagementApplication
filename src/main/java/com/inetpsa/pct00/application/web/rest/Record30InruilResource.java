package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record30Inruil;
import com.inetpsa.pct00.application.repository.Record30InruilRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record30InruilDTO;
import com.inetpsa.pct00.application.service.mapper.Record30InruilMapper;
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
 * REST controller for managing Record30Inruil.
 */
@RestController
@RequestMapping("/api")
public class Record30InruilResource {

    private final Logger log = LoggerFactory.getLogger(Record30InruilResource.class);

    private static final String ENTITY_NAME = "record30Inruil";

    private final Record30InruilRepository record30InruilRepository;

    private final Record30InruilMapper record30InruilMapper;

    public Record30InruilResource(Record30InruilRepository record30InruilRepository, Record30InruilMapper record30InruilMapper) {
        this.record30InruilRepository = record30InruilRepository;
        this.record30InruilMapper = record30InruilMapper;
    }

    /**
     * POST  /record-30-inruils : Create a new record30Inruil.
     *
     * @param record30InruilDTO the record30InruilDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record30InruilDTO, or with status 400 (Bad Request) if the record30Inruil has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-30-inruils")
    @Timed
    public ResponseEntity<Record30InruilDTO> createRecord30Inruil(@RequestBody Record30InruilDTO record30InruilDTO) throws URISyntaxException {
        log.debug("REST request to save Record30Inruil : {}", record30InruilDTO);
        if (record30InruilDTO.getId() != null) {
            throw new BadRequestAlertException("A new record30Inruil cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record30Inruil record30Inruil = record30InruilMapper.toEntity(record30InruilDTO);
        record30Inruil = record30InruilRepository.save(record30Inruil);
        Record30InruilDTO result = record30InruilMapper.toDto(record30Inruil);
        return ResponseEntity.created(new URI("/api/record-30-inruils/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-30-inruils : Updates an existing record30Inruil.
     *
     * @param record30InruilDTO the record30InruilDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record30InruilDTO,
     * or with status 400 (Bad Request) if the record30InruilDTO is not valid,
     * or with status 500 (Internal Server Error) if the record30InruilDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-30-inruils")
    @Timed
    public ResponseEntity<Record30InruilDTO> updateRecord30Inruil(@RequestBody Record30InruilDTO record30InruilDTO) throws URISyntaxException {
        log.debug("REST request to update Record30Inruil : {}", record30InruilDTO);
        if (record30InruilDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record30Inruil record30Inruil = record30InruilMapper.toEntity(record30InruilDTO);
        record30Inruil = record30InruilRepository.save(record30Inruil);
        Record30InruilDTO result = record30InruilMapper.toDto(record30Inruil);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record30InruilDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-30-inruils : get all the record30Inruils.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record30Inruils in body
     */
    @GetMapping("/record-30-inruils")
    @Timed
    public List<Record30InruilDTO> getAllRecord30Inruils() {
        log.debug("REST request to get all Record30Inruils");
        List<Record30Inruil> record30Inruils = record30InruilRepository.findAll();
        return record30InruilMapper.toDto(record30Inruils);
    }

    /**
     * GET  /record-30-inruils/:id : get the "id" record30Inruil.
     *
     * @param id the id of the record30InruilDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record30InruilDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-30-inruils/{id}")
    @Timed
    public ResponseEntity<Record30InruilDTO> getRecord30Inruil(@PathVariable Long id) {
        log.debug("REST request to get Record30Inruil : {}", id);
        Optional<Record30InruilDTO> record30InruilDTO = record30InruilRepository.findById(id)
            .map(record30InruilMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record30InruilDTO);
    }

    /**
     * DELETE  /record-30-inruils/:id : delete the "id" record30Inruil.
     *
     * @param id the id of the record30InruilDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-30-inruils/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord30Inruil(@PathVariable Long id) {
        log.debug("REST request to delete Record30Inruil : {}", id);

        record30InruilRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

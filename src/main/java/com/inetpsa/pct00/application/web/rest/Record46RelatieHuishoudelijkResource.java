package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record46RelatieHuishoudelijk;
import com.inetpsa.pct00.application.repository.Record46RelatieHuishoudelijkRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record46RelatieHuishoudelijkDTO;
import com.inetpsa.pct00.application.service.mapper.Record46RelatieHuishoudelijkMapper;
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
 * REST controller for managing Record46RelatieHuishoudelijk.
 */
@RestController
@RequestMapping("/api")
public class Record46RelatieHuishoudelijkResource {

    private final Logger log = LoggerFactory.getLogger(Record46RelatieHuishoudelijkResource.class);

    private static final String ENTITY_NAME = "record46RelatieHuishoudelijk";

    private final Record46RelatieHuishoudelijkRepository record46RelatieHuishoudelijkRepository;

    private final Record46RelatieHuishoudelijkMapper record46RelatieHuishoudelijkMapper;

    public Record46RelatieHuishoudelijkResource(Record46RelatieHuishoudelijkRepository record46RelatieHuishoudelijkRepository, Record46RelatieHuishoudelijkMapper record46RelatieHuishoudelijkMapper) {
        this.record46RelatieHuishoudelijkRepository = record46RelatieHuishoudelijkRepository;
        this.record46RelatieHuishoudelijkMapper = record46RelatieHuishoudelijkMapper;
    }

    /**
     * POST  /record-46-relatie-huishoudelijks : Create a new record46RelatieHuishoudelijk.
     *
     * @param record46RelatieHuishoudelijkDTO the record46RelatieHuishoudelijkDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record46RelatieHuishoudelijkDTO, or with status 400 (Bad Request) if the record46RelatieHuishoudelijk has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-46-relatie-huishoudelijks")
    @Timed
    public ResponseEntity<Record46RelatieHuishoudelijkDTO> createRecord46RelatieHuishoudelijk(@RequestBody Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO) throws URISyntaxException {
        log.debug("REST request to save Record46RelatieHuishoudelijk : {}", record46RelatieHuishoudelijkDTO);
        if (record46RelatieHuishoudelijkDTO.getId() != null) {
            throw new BadRequestAlertException("A new record46RelatieHuishoudelijk cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk = record46RelatieHuishoudelijkMapper.toEntity(record46RelatieHuishoudelijkDTO);
        record46RelatieHuishoudelijk = record46RelatieHuishoudelijkRepository.save(record46RelatieHuishoudelijk);
        Record46RelatieHuishoudelijkDTO result = record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijk);
        return ResponseEntity.created(new URI("/api/record-46-relatie-huishoudelijks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-46-relatie-huishoudelijks : Updates an existing record46RelatieHuishoudelijk.
     *
     * @param record46RelatieHuishoudelijkDTO the record46RelatieHuishoudelijkDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record46RelatieHuishoudelijkDTO,
     * or with status 400 (Bad Request) if the record46RelatieHuishoudelijkDTO is not valid,
     * or with status 500 (Internal Server Error) if the record46RelatieHuishoudelijkDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-46-relatie-huishoudelijks")
    @Timed
    public ResponseEntity<Record46RelatieHuishoudelijkDTO> updateRecord46RelatieHuishoudelijk(@RequestBody Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO) throws URISyntaxException {
        log.debug("REST request to update Record46RelatieHuishoudelijk : {}", record46RelatieHuishoudelijkDTO);
        if (record46RelatieHuishoudelijkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk = record46RelatieHuishoudelijkMapper.toEntity(record46RelatieHuishoudelijkDTO);
        record46RelatieHuishoudelijk = record46RelatieHuishoudelijkRepository.save(record46RelatieHuishoudelijk);
        Record46RelatieHuishoudelijkDTO result = record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijk);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record46RelatieHuishoudelijkDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-46-relatie-huishoudelijks : get all the record46RelatieHuishoudelijks.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record46RelatieHuishoudelijks in body
     */
    @GetMapping("/record-46-relatie-huishoudelijks")
    @Timed
    public List<Record46RelatieHuishoudelijkDTO> getAllRecord46RelatieHuishoudelijks() {
        log.debug("REST request to get all Record46RelatieHuishoudelijks");
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijks = record46RelatieHuishoudelijkRepository.findAll();
        return record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijks);
    }

    /**
     * GET  /record-46-relatie-huishoudelijks/:id : get the "id" record46RelatieHuishoudelijk.
     *
     * @param id the id of the record46RelatieHuishoudelijkDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record46RelatieHuishoudelijkDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-46-relatie-huishoudelijks/{id}")
    @Timed
    public ResponseEntity<Record46RelatieHuishoudelijkDTO> getRecord46RelatieHuishoudelijk(@PathVariable Long id) {
        log.debug("REST request to get Record46RelatieHuishoudelijk : {}", id);
        Optional<Record46RelatieHuishoudelijkDTO> record46RelatieHuishoudelijkDTO = record46RelatieHuishoudelijkRepository.findById(id)
            .map(record46RelatieHuishoudelijkMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record46RelatieHuishoudelijkDTO);
    }

    /**
     * DELETE  /record-46-relatie-huishoudelijks/:id : delete the "id" record46RelatieHuishoudelijk.
     *
     * @param id the id of the record46RelatieHuishoudelijkDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-46-relatie-huishoudelijks/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord46RelatieHuishoudelijk(@PathVariable Long id) {
        log.debug("REST request to delete Record46RelatieHuishoudelijk : {}", id);

        record46RelatieHuishoudelijkRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

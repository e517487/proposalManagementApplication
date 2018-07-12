package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record99End;
import com.inetpsa.pct00.application.repository.Record99EndRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record99EndDTO;
import com.inetpsa.pct00.application.service.mapper.Record99EndMapper;
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
 * REST controller for managing Record99End.
 */
@RestController
@RequestMapping("/api")
public class Record99EndResource {

    private final Logger log = LoggerFactory.getLogger(Record99EndResource.class);

    private static final String ENTITY_NAME = "record99End";

    private final Record99EndRepository record99EndRepository;

    private final Record99EndMapper record99EndMapper;

    public Record99EndResource(Record99EndRepository record99EndRepository, Record99EndMapper record99EndMapper) {
        this.record99EndRepository = record99EndRepository;
        this.record99EndMapper = record99EndMapper;
    }

    /**
     * POST  /record-99-ends : Create a new record99End.
     *
     * @param record99EndDTO the record99EndDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record99EndDTO, or with status 400 (Bad Request) if the record99End has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-99-ends")
    @Timed
    public ResponseEntity<Record99EndDTO> createRecord99End(@RequestBody Record99EndDTO record99EndDTO) throws URISyntaxException {
        log.debug("REST request to save Record99End : {}", record99EndDTO);
        if (record99EndDTO.getId() != null) {
            throw new BadRequestAlertException("A new record99End cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record99End record99End = record99EndMapper.toEntity(record99EndDTO);
        record99End = record99EndRepository.save(record99End);
        Record99EndDTO result = record99EndMapper.toDto(record99End);
        return ResponseEntity.created(new URI("/api/record-99-ends/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-99-ends : Updates an existing record99End.
     *
     * @param record99EndDTO the record99EndDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record99EndDTO,
     * or with status 400 (Bad Request) if the record99EndDTO is not valid,
     * or with status 500 (Internal Server Error) if the record99EndDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-99-ends")
    @Timed
    public ResponseEntity<Record99EndDTO> updateRecord99End(@RequestBody Record99EndDTO record99EndDTO) throws URISyntaxException {
        log.debug("REST request to update Record99End : {}", record99EndDTO);
        if (record99EndDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record99End record99End = record99EndMapper.toEntity(record99EndDTO);
        record99End = record99EndRepository.save(record99End);
        Record99EndDTO result = record99EndMapper.toDto(record99End);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record99EndDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-99-ends : get all the record99Ends.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record99Ends in body
     */
    @GetMapping("/record-99-ends")
    @Timed
    public List<Record99EndDTO> getAllRecord99Ends() {
        log.debug("REST request to get all Record99Ends");
        List<Record99End> record99Ends = record99EndRepository.findAll();
        return record99EndMapper.toDto(record99Ends);
    }

    /**
     * GET  /record-99-ends/:id : get the "id" record99End.
     *
     * @param id the id of the record99EndDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record99EndDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-99-ends/{id}")
    @Timed
    public ResponseEntity<Record99EndDTO> getRecord99End(@PathVariable Long id) {
        log.debug("REST request to get Record99End : {}", id);
        Optional<Record99EndDTO> record99EndDTO = record99EndRepository.findById(id)
            .map(record99EndMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record99EndDTO);
    }

    /**
     * DELETE  /record-99-ends/:id : delete the "id" record99End.
     *
     * @param id the id of the record99EndDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-99-ends/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord99End(@PathVariable Long id) {
        log.debug("REST request to delete Record99End : {}", id);

        record99EndRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

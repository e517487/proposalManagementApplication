package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record50Bedrijf;
import com.inetpsa.pct00.application.repository.Record50BedrijfRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record50BedrijfDTO;
import com.inetpsa.pct00.application.service.mapper.Record50BedrijfMapper;
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
 * REST controller for managing Record50Bedrijf.
 */
@RestController
@RequestMapping("/api")
public class Record50BedrijfResource {

    private final Logger log = LoggerFactory.getLogger(Record50BedrijfResource.class);

    private static final String ENTITY_NAME = "record50Bedrijf";

    private final Record50BedrijfRepository record50BedrijfRepository;

    private final Record50BedrijfMapper record50BedrijfMapper;

    public Record50BedrijfResource(Record50BedrijfRepository record50BedrijfRepository, Record50BedrijfMapper record50BedrijfMapper) {
        this.record50BedrijfRepository = record50BedrijfRepository;
        this.record50BedrijfMapper = record50BedrijfMapper;
    }

    /**
     * POST  /record-50-bedrijfs : Create a new record50Bedrijf.
     *
     * @param record50BedrijfDTO the record50BedrijfDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record50BedrijfDTO, or with status 400 (Bad Request) if the record50Bedrijf has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-50-bedrijfs")
    @Timed
    public ResponseEntity<Record50BedrijfDTO> createRecord50Bedrijf(@RequestBody Record50BedrijfDTO record50BedrijfDTO) throws URISyntaxException {
        log.debug("REST request to save Record50Bedrijf : {}", record50BedrijfDTO);
        if (record50BedrijfDTO.getId() != null) {
            throw new BadRequestAlertException("A new record50Bedrijf cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record50Bedrijf record50Bedrijf = record50BedrijfMapper.toEntity(record50BedrijfDTO);
        record50Bedrijf = record50BedrijfRepository.save(record50Bedrijf);
        Record50BedrijfDTO result = record50BedrijfMapper.toDto(record50Bedrijf);
        return ResponseEntity.created(new URI("/api/record-50-bedrijfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-50-bedrijfs : Updates an existing record50Bedrijf.
     *
     * @param record50BedrijfDTO the record50BedrijfDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record50BedrijfDTO,
     * or with status 400 (Bad Request) if the record50BedrijfDTO is not valid,
     * or with status 500 (Internal Server Error) if the record50BedrijfDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-50-bedrijfs")
    @Timed
    public ResponseEntity<Record50BedrijfDTO> updateRecord50Bedrijf(@RequestBody Record50BedrijfDTO record50BedrijfDTO) throws URISyntaxException {
        log.debug("REST request to update Record50Bedrijf : {}", record50BedrijfDTO);
        if (record50BedrijfDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record50Bedrijf record50Bedrijf = record50BedrijfMapper.toEntity(record50BedrijfDTO);
        record50Bedrijf = record50BedrijfRepository.save(record50Bedrijf);
        Record50BedrijfDTO result = record50BedrijfMapper.toDto(record50Bedrijf);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record50BedrijfDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-50-bedrijfs : get all the record50Bedrijfs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record50Bedrijfs in body
     */
    @GetMapping("/record-50-bedrijfs")
    @Timed
    public List<Record50BedrijfDTO> getAllRecord50Bedrijfs() {
        log.debug("REST request to get all Record50Bedrijfs");
        List<Record50Bedrijf> record50Bedrijfs = record50BedrijfRepository.findAll();
        return record50BedrijfMapper.toDto(record50Bedrijfs);
    }

    /**
     * GET  /record-50-bedrijfs/:id : get the "id" record50Bedrijf.
     *
     * @param id the id of the record50BedrijfDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record50BedrijfDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-50-bedrijfs/{id}")
    @Timed
    public ResponseEntity<Record50BedrijfDTO> getRecord50Bedrijf(@PathVariable Long id) {
        log.debug("REST request to get Record50Bedrijf : {}", id);
        Optional<Record50BedrijfDTO> record50BedrijfDTO = record50BedrijfRepository.findById(id)
            .map(record50BedrijfMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record50BedrijfDTO);
    }

    /**
     * DELETE  /record-50-bedrijfs/:id : delete the "id" record50Bedrijf.
     *
     * @param id the id of the record50BedrijfDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-50-bedrijfs/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord50Bedrijf(@PathVariable Long id) {
        log.debug("REST request to delete Record50Bedrijf : {}", id);

        record50BedrijfRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record25Herfinancieering;
import com.inetpsa.pct00.application.repository.Record25HerfinancieeringRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record25HerfinancieeringDTO;
import com.inetpsa.pct00.application.service.mapper.Record25HerfinancieeringMapper;
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

    private final Record25HerfinancieeringMapper record25HerfinancieeringMapper;

    public Record25HerfinancieeringResource(Record25HerfinancieeringRepository record25HerfinancieeringRepository, Record25HerfinancieeringMapper record25HerfinancieeringMapper) {
        this.record25HerfinancieeringRepository = record25HerfinancieeringRepository;
        this.record25HerfinancieeringMapper = record25HerfinancieeringMapper;
    }

    /**
     * POST  /record-25-herfinancieerings : Create a new record25Herfinancieering.
     *
     * @param record25HerfinancieeringDTO the record25HerfinancieeringDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record25HerfinancieeringDTO, or with status 400 (Bad Request) if the record25Herfinancieering has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-25-herfinancieerings")
    @Timed
    public ResponseEntity<Record25HerfinancieeringDTO> createRecord25Herfinancieering(@RequestBody Record25HerfinancieeringDTO record25HerfinancieeringDTO) throws URISyntaxException {
        log.debug("REST request to save Record25Herfinancieering : {}", record25HerfinancieeringDTO);
        if (record25HerfinancieeringDTO.getId() != null) {
            throw new BadRequestAlertException("A new record25Herfinancieering cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record25Herfinancieering record25Herfinancieering = record25HerfinancieeringMapper.toEntity(record25HerfinancieeringDTO);
        record25Herfinancieering = record25HerfinancieeringRepository.save(record25Herfinancieering);
        Record25HerfinancieeringDTO result = record25HerfinancieeringMapper.toDto(record25Herfinancieering);
        return ResponseEntity.created(new URI("/api/record-25-herfinancieerings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-25-herfinancieerings : Updates an existing record25Herfinancieering.
     *
     * @param record25HerfinancieeringDTO the record25HerfinancieeringDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record25HerfinancieeringDTO,
     * or with status 400 (Bad Request) if the record25HerfinancieeringDTO is not valid,
     * or with status 500 (Internal Server Error) if the record25HerfinancieeringDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-25-herfinancieerings")
    @Timed
    public ResponseEntity<Record25HerfinancieeringDTO> updateRecord25Herfinancieering(@RequestBody Record25HerfinancieeringDTO record25HerfinancieeringDTO) throws URISyntaxException {
        log.debug("REST request to update Record25Herfinancieering : {}", record25HerfinancieeringDTO);
        if (record25HerfinancieeringDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record25Herfinancieering record25Herfinancieering = record25HerfinancieeringMapper.toEntity(record25HerfinancieeringDTO);
        record25Herfinancieering = record25HerfinancieeringRepository.save(record25Herfinancieering);
        Record25HerfinancieeringDTO result = record25HerfinancieeringMapper.toDto(record25Herfinancieering);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record25HerfinancieeringDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-25-herfinancieerings : get all the record25Herfinancieerings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record25Herfinancieerings in body
     */
    @GetMapping("/record-25-herfinancieerings")
    @Timed
    public List<Record25HerfinancieeringDTO> getAllRecord25Herfinancieerings() {
        log.debug("REST request to get all Record25Herfinancieerings");
        List<Record25Herfinancieering> record25Herfinancieerings = record25HerfinancieeringRepository.findAll();
        return record25HerfinancieeringMapper.toDto(record25Herfinancieerings);
    }

    /**
     * GET  /record-25-herfinancieerings/:id : get the "id" record25Herfinancieering.
     *
     * @param id the id of the record25HerfinancieeringDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record25HerfinancieeringDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-25-herfinancieerings/{id}")
    @Timed
    public ResponseEntity<Record25HerfinancieeringDTO> getRecord25Herfinancieering(@PathVariable Long id) {
        log.debug("REST request to get Record25Herfinancieering : {}", id);
        Optional<Record25HerfinancieeringDTO> record25HerfinancieeringDTO = record25HerfinancieeringRepository.findById(id)
            .map(record25HerfinancieeringMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record25HerfinancieeringDTO);
    }

    /**
     * DELETE  /record-25-herfinancieerings/:id : delete the "id" record25Herfinancieering.
     *
     * @param id the id of the record25HerfinancieeringDTO to delete
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

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record11AanvraagGegevensOpmerkingen;
import com.inetpsa.pct00.application.repository.Record11AanvraagGegevensOpmerkingenRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record11AanvraagGegevensOpmerkingenDTO;
import com.inetpsa.pct00.application.service.mapper.Record11AanvraagGegevensOpmerkingenMapper;
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

    private final Record11AanvraagGegevensOpmerkingenMapper record11AanvraagGegevensOpmerkingenMapper;

    public Record11AanvraagGegevensOpmerkingenResource(Record11AanvraagGegevensOpmerkingenRepository record11AanvraagGegevensOpmerkingenRepository, Record11AanvraagGegevensOpmerkingenMapper record11AanvraagGegevensOpmerkingenMapper) {
        this.record11AanvraagGegevensOpmerkingenRepository = record11AanvraagGegevensOpmerkingenRepository;
        this.record11AanvraagGegevensOpmerkingenMapper = record11AanvraagGegevensOpmerkingenMapper;
    }

    /**
     * POST  /record-11-aanvraag-gegevens-opmerkingens : Create a new record11AanvraagGegevensOpmerkingen.
     *
     * @param record11AanvraagGegevensOpmerkingenDTO the record11AanvraagGegevensOpmerkingenDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record11AanvraagGegevensOpmerkingenDTO, or with status 400 (Bad Request) if the record11AanvraagGegevensOpmerkingen has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingenDTO> createRecord11AanvraagGegevensOpmerkingen(@RequestBody Record11AanvraagGegevensOpmerkingenDTO record11AanvraagGegevensOpmerkingenDTO) throws URISyntaxException {
        log.debug("REST request to save Record11AanvraagGegevensOpmerkingen : {}", record11AanvraagGegevensOpmerkingenDTO);
        if (record11AanvraagGegevensOpmerkingenDTO.getId() != null) {
            throw new BadRequestAlertException("A new record11AanvraagGegevensOpmerkingen cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenMapper.toEntity(record11AanvraagGegevensOpmerkingenDTO);
        record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenRepository.save(record11AanvraagGegevensOpmerkingen);
        Record11AanvraagGegevensOpmerkingenDTO result = record11AanvraagGegevensOpmerkingenMapper.toDto(record11AanvraagGegevensOpmerkingen);
        return ResponseEntity.created(new URI("/api/record-11-aanvraag-gegevens-opmerkingens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-11-aanvraag-gegevens-opmerkingens : Updates an existing record11AanvraagGegevensOpmerkingen.
     *
     * @param record11AanvraagGegevensOpmerkingenDTO the record11AanvraagGegevensOpmerkingenDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record11AanvraagGegevensOpmerkingenDTO,
     * or with status 400 (Bad Request) if the record11AanvraagGegevensOpmerkingenDTO is not valid,
     * or with status 500 (Internal Server Error) if the record11AanvraagGegevensOpmerkingenDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingenDTO> updateRecord11AanvraagGegevensOpmerkingen(@RequestBody Record11AanvraagGegevensOpmerkingenDTO record11AanvraagGegevensOpmerkingenDTO) throws URISyntaxException {
        log.debug("REST request to update Record11AanvraagGegevensOpmerkingen : {}", record11AanvraagGegevensOpmerkingenDTO);
        if (record11AanvraagGegevensOpmerkingenDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenMapper.toEntity(record11AanvraagGegevensOpmerkingenDTO);
        record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenRepository.save(record11AanvraagGegevensOpmerkingen);
        Record11AanvraagGegevensOpmerkingenDTO result = record11AanvraagGegevensOpmerkingenMapper.toDto(record11AanvraagGegevensOpmerkingen);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record11AanvraagGegevensOpmerkingenDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-11-aanvraag-gegevens-opmerkingens : get all the record11AanvraagGegevensOpmerkingens.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record11AanvraagGegevensOpmerkingens in body
     */
    @GetMapping("/record-11-aanvraag-gegevens-opmerkingens")
    @Timed
    public List<Record11AanvraagGegevensOpmerkingenDTO> getAllRecord11AanvraagGegevensOpmerkingens() {
        log.debug("REST request to get all Record11AanvraagGegevensOpmerkingens");
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingens = record11AanvraagGegevensOpmerkingenRepository.findAll();
        return record11AanvraagGegevensOpmerkingenMapper.toDto(record11AanvraagGegevensOpmerkingens);
    }

    /**
     * GET  /record-11-aanvraag-gegevens-opmerkingens/:id : get the "id" record11AanvraagGegevensOpmerkingen.
     *
     * @param id the id of the record11AanvraagGegevensOpmerkingenDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record11AanvraagGegevensOpmerkingenDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-11-aanvraag-gegevens-opmerkingens/{id}")
    @Timed
    public ResponseEntity<Record11AanvraagGegevensOpmerkingenDTO> getRecord11AanvraagGegevensOpmerkingen(@PathVariable Long id) {
        log.debug("REST request to get Record11AanvraagGegevensOpmerkingen : {}", id);
        Optional<Record11AanvraagGegevensOpmerkingenDTO> record11AanvraagGegevensOpmerkingenDTO = record11AanvraagGegevensOpmerkingenRepository.findById(id)
            .map(record11AanvraagGegevensOpmerkingenMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record11AanvraagGegevensOpmerkingenDTO);
    }

    /**
     * DELETE  /record-11-aanvraag-gegevens-opmerkingens/:id : delete the "id" record11AanvraagGegevensOpmerkingen.
     *
     * @param id the id of the record11AanvraagGegevensOpmerkingenDTO to delete
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

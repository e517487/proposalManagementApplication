package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record45Relatie;
import com.inetpsa.pct00.application.repository.Record45RelatieRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record45RelatieDTO;
import com.inetpsa.pct00.application.service.mapper.Record45RelatieMapper;
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
 * REST controller for managing Record45Relatie.
 */
@RestController
@RequestMapping("/api")
public class Record45RelatieResource {

    private final Logger log = LoggerFactory.getLogger(Record45RelatieResource.class);

    private static final String ENTITY_NAME = "record45Relatie";

    private final Record45RelatieRepository record45RelatieRepository;

    private final Record45RelatieMapper record45RelatieMapper;

    public Record45RelatieResource(Record45RelatieRepository record45RelatieRepository, Record45RelatieMapper record45RelatieMapper) {
        this.record45RelatieRepository = record45RelatieRepository;
        this.record45RelatieMapper = record45RelatieMapper;
    }

    /**
     * POST  /record-45-relaties : Create a new record45Relatie.
     *
     * @param record45RelatieDTO the record45RelatieDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record45RelatieDTO, or with status 400 (Bad Request) if the record45Relatie has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-45-relaties")
    @Timed
    public ResponseEntity<Record45RelatieDTO> createRecord45Relatie(@RequestBody Record45RelatieDTO record45RelatieDTO) throws URISyntaxException {
        log.debug("REST request to save Record45Relatie : {}", record45RelatieDTO);
        if (record45RelatieDTO.getId() != null) {
            throw new BadRequestAlertException("A new record45Relatie cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record45Relatie record45Relatie = record45RelatieMapper.toEntity(record45RelatieDTO);
        record45Relatie = record45RelatieRepository.save(record45Relatie);
        Record45RelatieDTO result = record45RelatieMapper.toDto(record45Relatie);
        return ResponseEntity.created(new URI("/api/record-45-relaties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-45-relaties : Updates an existing record45Relatie.
     *
     * @param record45RelatieDTO the record45RelatieDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record45RelatieDTO,
     * or with status 400 (Bad Request) if the record45RelatieDTO is not valid,
     * or with status 500 (Internal Server Error) if the record45RelatieDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-45-relaties")
    @Timed
    public ResponseEntity<Record45RelatieDTO> updateRecord45Relatie(@RequestBody Record45RelatieDTO record45RelatieDTO) throws URISyntaxException {
        log.debug("REST request to update Record45Relatie : {}", record45RelatieDTO);
        if (record45RelatieDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record45Relatie record45Relatie = record45RelatieMapper.toEntity(record45RelatieDTO);
        record45Relatie = record45RelatieRepository.save(record45Relatie);
        Record45RelatieDTO result = record45RelatieMapper.toDto(record45Relatie);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record45RelatieDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-45-relaties : get all the record45Relaties.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record45Relaties in body
     */
    @GetMapping("/record-45-relaties")
    @Timed
    public List<Record45RelatieDTO> getAllRecord45Relaties() {
        log.debug("REST request to get all Record45Relaties");
        List<Record45Relatie> record45Relaties = record45RelatieRepository.findAll();
        return record45RelatieMapper.toDto(record45Relaties);
    }

    /**
     * GET  /record-45-relaties/:id : get the "id" record45Relatie.
     *
     * @param id the id of the record45RelatieDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record45RelatieDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-45-relaties/{id}")
    @Timed
    public ResponseEntity<Record45RelatieDTO> getRecord45Relatie(@PathVariable Long id) {
        log.debug("REST request to get Record45Relatie : {}", id);
        Optional<Record45RelatieDTO> record45RelatieDTO = record45RelatieRepository.findById(id)
            .map(record45RelatieMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record45RelatieDTO);
    }

    /**
     * DELETE  /record-45-relaties/:id : delete the "id" record45Relatie.
     *
     * @param id the id of the record45RelatieDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-45-relaties/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord45Relatie(@PathVariable Long id) {
        log.debug("REST request to delete Record45Relatie : {}", id);

        record45RelatieRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

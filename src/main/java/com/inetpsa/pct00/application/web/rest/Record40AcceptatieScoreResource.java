package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.domain.Record40AcceptatieScore;
import com.inetpsa.pct00.application.repository.Record40AcceptatieScoreRepository;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.Record40AcceptatieScoreDTO;
import com.inetpsa.pct00.application.service.mapper.Record40AcceptatieScoreMapper;
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
 * REST controller for managing Record40AcceptatieScore.
 */
@RestController
@RequestMapping("/api")
public class Record40AcceptatieScoreResource {

    private final Logger log = LoggerFactory.getLogger(Record40AcceptatieScoreResource.class);

    private static final String ENTITY_NAME = "record40AcceptatieScore";

    private final Record40AcceptatieScoreRepository record40AcceptatieScoreRepository;

    private final Record40AcceptatieScoreMapper record40AcceptatieScoreMapper;

    public Record40AcceptatieScoreResource(Record40AcceptatieScoreRepository record40AcceptatieScoreRepository, Record40AcceptatieScoreMapper record40AcceptatieScoreMapper) {
        this.record40AcceptatieScoreRepository = record40AcceptatieScoreRepository;
        this.record40AcceptatieScoreMapper = record40AcceptatieScoreMapper;
    }

    /**
     * POST  /record-40-acceptatie-scores : Create a new record40AcceptatieScore.
     *
     * @param record40AcceptatieScoreDTO the record40AcceptatieScoreDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record40AcceptatieScoreDTO, or with status 400 (Bad Request) if the record40AcceptatieScore has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/record-40-acceptatie-scores")
    @Timed
    public ResponseEntity<Record40AcceptatieScoreDTO> createRecord40AcceptatieScore(@RequestBody Record40AcceptatieScoreDTO record40AcceptatieScoreDTO) throws URISyntaxException {
        log.debug("REST request to save Record40AcceptatieScore : {}", record40AcceptatieScoreDTO);
        if (record40AcceptatieScoreDTO.getId() != null) {
            throw new BadRequestAlertException("A new record40AcceptatieScore cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Record40AcceptatieScore record40AcceptatieScore = record40AcceptatieScoreMapper.toEntity(record40AcceptatieScoreDTO);
        record40AcceptatieScore = record40AcceptatieScoreRepository.save(record40AcceptatieScore);
        Record40AcceptatieScoreDTO result = record40AcceptatieScoreMapper.toDto(record40AcceptatieScore);
        return ResponseEntity.created(new URI("/api/record-40-acceptatie-scores/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /record-40-acceptatie-scores : Updates an existing record40AcceptatieScore.
     *
     * @param record40AcceptatieScoreDTO the record40AcceptatieScoreDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record40AcceptatieScoreDTO,
     * or with status 400 (Bad Request) if the record40AcceptatieScoreDTO is not valid,
     * or with status 500 (Internal Server Error) if the record40AcceptatieScoreDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/record-40-acceptatie-scores")
    @Timed
    public ResponseEntity<Record40AcceptatieScoreDTO> updateRecord40AcceptatieScore(@RequestBody Record40AcceptatieScoreDTO record40AcceptatieScoreDTO) throws URISyntaxException {
        log.debug("REST request to update Record40AcceptatieScore : {}", record40AcceptatieScoreDTO);
        if (record40AcceptatieScoreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Record40AcceptatieScore record40AcceptatieScore = record40AcceptatieScoreMapper.toEntity(record40AcceptatieScoreDTO);
        record40AcceptatieScore = record40AcceptatieScoreRepository.save(record40AcceptatieScore);
        Record40AcceptatieScoreDTO result = record40AcceptatieScoreMapper.toDto(record40AcceptatieScore);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record40AcceptatieScoreDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /record-40-acceptatie-scores : get all the record40AcceptatieScores.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of record40AcceptatieScores in body
     */
    @GetMapping("/record-40-acceptatie-scores")
    @Timed
    public List<Record40AcceptatieScoreDTO> getAllRecord40AcceptatieScores() {
        log.debug("REST request to get all Record40AcceptatieScores");
        List<Record40AcceptatieScore> record40AcceptatieScores = record40AcceptatieScoreRepository.findAll();
        return record40AcceptatieScoreMapper.toDto(record40AcceptatieScores);
    }

    /**
     * GET  /record-40-acceptatie-scores/:id : get the "id" record40AcceptatieScore.
     *
     * @param id the id of the record40AcceptatieScoreDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record40AcceptatieScoreDTO, or with status 404 (Not Found)
     */
    @GetMapping("/record-40-acceptatie-scores/{id}")
    @Timed
    public ResponseEntity<Record40AcceptatieScoreDTO> getRecord40AcceptatieScore(@PathVariable Long id) {
        log.debug("REST request to get Record40AcceptatieScore : {}", id);
        Optional<Record40AcceptatieScoreDTO> record40AcceptatieScoreDTO = record40AcceptatieScoreRepository.findById(id)
            .map(record40AcceptatieScoreMapper::toDto);
        return ResponseUtil.wrapOrNotFound(record40AcceptatieScoreDTO);
    }

    /**
     * DELETE  /record-40-acceptatie-scores/:id : delete the "id" record40AcceptatieScore.
     *
     * @param id the id of the record40AcceptatieScoreDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/record-40-acceptatie-scores/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord40AcceptatieScore(@PathVariable Long id) {
        log.debug("REST request to delete Record40AcceptatieScore : {}", id);

        record40AcceptatieScoreRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

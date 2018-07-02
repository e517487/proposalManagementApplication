package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.LegitimatiebewijsService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.LegitimatiebewijsDTO;
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
 * REST controller for managing Legitimatiebewijs.
 */
@RestController
@RequestMapping("/api")
public class LegitimatiebewijsResource {

    private final Logger log = LoggerFactory.getLogger(LegitimatiebewijsResource.class);

    private static final String ENTITY_NAME = "legitimatiebewijs";

    private final LegitimatiebewijsService legitimatiebewijsService;

    public LegitimatiebewijsResource(LegitimatiebewijsService legitimatiebewijsService) {
        this.legitimatiebewijsService = legitimatiebewijsService;
    }

    /**
     * POST  /legitimatiebewijs : Create a new legitimatiebewijs.
     *
     * @param legitimatiebewijsDTO the legitimatiebewijsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new legitimatiebewijsDTO, or with status 400 (Bad Request) if the legitimatiebewijs has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/legitimatiebewijs")
    @Timed
    public ResponseEntity<LegitimatiebewijsDTO> createLegitimatiebewijs(@RequestBody LegitimatiebewijsDTO legitimatiebewijsDTO) throws URISyntaxException {
        log.debug("REST request to save Legitimatiebewijs : {}", legitimatiebewijsDTO);
        if (legitimatiebewijsDTO.getId() != null) {
            throw new BadRequestAlertException("A new legitimatiebewijs cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LegitimatiebewijsDTO result = legitimatiebewijsService.save(legitimatiebewijsDTO);
        return ResponseEntity.created(new URI("/api/legitimatiebewijs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /legitimatiebewijs : Updates an existing legitimatiebewijs.
     *
     * @param legitimatiebewijsDTO the legitimatiebewijsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated legitimatiebewijsDTO,
     * or with status 400 (Bad Request) if the legitimatiebewijsDTO is not valid,
     * or with status 500 (Internal Server Error) if the legitimatiebewijsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/legitimatiebewijs")
    @Timed
    public ResponseEntity<LegitimatiebewijsDTO> updateLegitimatiebewijs(@RequestBody LegitimatiebewijsDTO legitimatiebewijsDTO) throws URISyntaxException {
        log.debug("REST request to update Legitimatiebewijs : {}", legitimatiebewijsDTO);
        if (legitimatiebewijsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        LegitimatiebewijsDTO result = legitimatiebewijsService.save(legitimatiebewijsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, legitimatiebewijsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /legitimatiebewijs : get all the legitimatiebewijs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of legitimatiebewijs in body
     */
    @GetMapping("/legitimatiebewijs")
    @Timed
    public List<LegitimatiebewijsDTO> getAllLegitimatiebewijs() {
        log.debug("REST request to get all Legitimatiebewijs");
        return legitimatiebewijsService.findAll();
    }

    /**
     * GET  /legitimatiebewijs/:id : get the "id" legitimatiebewijs.
     *
     * @param id the id of the legitimatiebewijsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the legitimatiebewijsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/legitimatiebewijs/{id}")
    @Timed
    public ResponseEntity<LegitimatiebewijsDTO> getLegitimatiebewijs(@PathVariable Long id) {
        log.debug("REST request to get Legitimatiebewijs : {}", id);
        Optional<LegitimatiebewijsDTO> legitimatiebewijsDTO = legitimatiebewijsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(legitimatiebewijsDTO);
    }

    /**
     * DELETE  /legitimatiebewijs/:id : delete the "id" legitimatiebewijs.
     *
     * @param id the id of the legitimatiebewijsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/legitimatiebewijs/{id}")
    @Timed
    public ResponseEntity<Void> deleteLegitimatiebewijs(@PathVariable Long id) {
        log.debug("REST request to delete Legitimatiebewijs : {}", id);
        legitimatiebewijsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

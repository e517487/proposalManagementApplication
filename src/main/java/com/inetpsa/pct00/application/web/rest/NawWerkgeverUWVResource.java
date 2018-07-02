package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.NawWerkgeverUWVService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.NawWerkgeverUWVDTO;
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
 * REST controller for managing NawWerkgeverUWV.
 */
@RestController
@RequestMapping("/api")
public class NawWerkgeverUWVResource {

    private final Logger log = LoggerFactory.getLogger(NawWerkgeverUWVResource.class);

    private static final String ENTITY_NAME = "nawWerkgeverUWV";

    private final NawWerkgeverUWVService nawWerkgeverUWVService;

    public NawWerkgeverUWVResource(NawWerkgeverUWVService nawWerkgeverUWVService) {
        this.nawWerkgeverUWVService = nawWerkgeverUWVService;
    }

    /**
     * POST  /naw-werkgever-uwvs : Create a new nawWerkgeverUWV.
     *
     * @param nawWerkgeverUWVDTO the nawWerkgeverUWVDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new nawWerkgeverUWVDTO, or with status 400 (Bad Request) if the nawWerkgeverUWV has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/naw-werkgever-uwvs")
    @Timed
    public ResponseEntity<NawWerkgeverUWVDTO> createNawWerkgeverUWV(@RequestBody NawWerkgeverUWVDTO nawWerkgeverUWVDTO) throws URISyntaxException {
        log.debug("REST request to save NawWerkgeverUWV : {}", nawWerkgeverUWVDTO);
        if (nawWerkgeverUWVDTO.getId() != null) {
            throw new BadRequestAlertException("A new nawWerkgeverUWV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NawWerkgeverUWVDTO result = nawWerkgeverUWVService.save(nawWerkgeverUWVDTO);
        return ResponseEntity.created(new URI("/api/naw-werkgever-uwvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /naw-werkgever-uwvs : Updates an existing nawWerkgeverUWV.
     *
     * @param nawWerkgeverUWVDTO the nawWerkgeverUWVDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated nawWerkgeverUWVDTO,
     * or with status 400 (Bad Request) if the nawWerkgeverUWVDTO is not valid,
     * or with status 500 (Internal Server Error) if the nawWerkgeverUWVDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/naw-werkgever-uwvs")
    @Timed
    public ResponseEntity<NawWerkgeverUWVDTO> updateNawWerkgeverUWV(@RequestBody NawWerkgeverUWVDTO nawWerkgeverUWVDTO) throws URISyntaxException {
        log.debug("REST request to update NawWerkgeverUWV : {}", nawWerkgeverUWVDTO);
        if (nawWerkgeverUWVDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NawWerkgeverUWVDTO result = nawWerkgeverUWVService.save(nawWerkgeverUWVDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, nawWerkgeverUWVDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /naw-werkgever-uwvs : get all the nawWerkgeverUWVS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of nawWerkgeverUWVS in body
     */
    @GetMapping("/naw-werkgever-uwvs")
    @Timed
    public List<NawWerkgeverUWVDTO> getAllNawWerkgeverUWVS() {
        log.debug("REST request to get all NawWerkgeverUWVS");
        return nawWerkgeverUWVService.findAll();
    }

    /**
     * GET  /naw-werkgever-uwvs/:id : get the "id" nawWerkgeverUWV.
     *
     * @param id the id of the nawWerkgeverUWVDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the nawWerkgeverUWVDTO, or with status 404 (Not Found)
     */
    @GetMapping("/naw-werkgever-uwvs/{id}")
    @Timed
    public ResponseEntity<NawWerkgeverUWVDTO> getNawWerkgeverUWV(@PathVariable Long id) {
        log.debug("REST request to get NawWerkgeverUWV : {}", id);
        Optional<NawWerkgeverUWVDTO> nawWerkgeverUWVDTO = nawWerkgeverUWVService.findOne(id);
        return ResponseUtil.wrapOrNotFound(nawWerkgeverUWVDTO);
    }

    /**
     * DELETE  /naw-werkgever-uwvs/:id : delete the "id" nawWerkgeverUWV.
     *
     * @param id the id of the nawWerkgeverUWVDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/naw-werkgever-uwvs/{id}")
    @Timed
    public ResponseEntity<Void> deleteNawWerkgeverUWV(@PathVariable Long id) {
        log.debug("REST request to delete NawWerkgeverUWV : {}", id);
        nawWerkgeverUWVService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

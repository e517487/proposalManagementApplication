package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.VrijeTekstService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.VrijeTekstDTO;
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
 * REST controller for managing VrijeTekst.
 */
@RestController
@RequestMapping("/api")
public class VrijeTekstResource {

    private final Logger log = LoggerFactory.getLogger(VrijeTekstResource.class);

    private static final String ENTITY_NAME = "vrijeTekst";

    private final VrijeTekstService vrijeTekstService;

    public VrijeTekstResource(VrijeTekstService vrijeTekstService) {
        this.vrijeTekstService = vrijeTekstService;
    }

    /**
     * POST  /vrije-teksts : Create a new vrijeTekst.
     *
     * @param vrijeTekstDTO the vrijeTekstDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vrijeTekstDTO, or with status 400 (Bad Request) if the vrijeTekst has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vrije-teksts")
    @Timed
    public ResponseEntity<VrijeTekstDTO> createVrijeTekst(@RequestBody VrijeTekstDTO vrijeTekstDTO) throws URISyntaxException {
        log.debug("REST request to save VrijeTekst : {}", vrijeTekstDTO);
        if (vrijeTekstDTO.getId() != null) {
            throw new BadRequestAlertException("A new vrijeTekst cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VrijeTekstDTO result = vrijeTekstService.save(vrijeTekstDTO);
        return ResponseEntity.created(new URI("/api/vrije-teksts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vrije-teksts : Updates an existing vrijeTekst.
     *
     * @param vrijeTekstDTO the vrijeTekstDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vrijeTekstDTO,
     * or with status 400 (Bad Request) if the vrijeTekstDTO is not valid,
     * or with status 500 (Internal Server Error) if the vrijeTekstDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vrije-teksts")
    @Timed
    public ResponseEntity<VrijeTekstDTO> updateVrijeTekst(@RequestBody VrijeTekstDTO vrijeTekstDTO) throws URISyntaxException {
        log.debug("REST request to update VrijeTekst : {}", vrijeTekstDTO);
        if (vrijeTekstDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VrijeTekstDTO result = vrijeTekstService.save(vrijeTekstDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vrijeTekstDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vrije-teksts : get all the vrijeTeksts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of vrijeTeksts in body
     */
    @GetMapping("/vrije-teksts")
    @Timed
    public List<VrijeTekstDTO> getAllVrijeTeksts() {
        log.debug("REST request to get all VrijeTeksts");
        return vrijeTekstService.findAll();
    }

    /**
     * GET  /vrije-teksts/:id : get the "id" vrijeTekst.
     *
     * @param id the id of the vrijeTekstDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vrijeTekstDTO, or with status 404 (Not Found)
     */
    @GetMapping("/vrije-teksts/{id}")
    @Timed
    public ResponseEntity<VrijeTekstDTO> getVrijeTekst(@PathVariable Long id) {
        log.debug("REST request to get VrijeTekst : {}", id);
        Optional<VrijeTekstDTO> vrijeTekstDTO = vrijeTekstService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vrijeTekstDTO);
    }

    /**
     * DELETE  /vrije-teksts/:id : delete the "id" vrijeTekst.
     *
     * @param id the id of the vrijeTekstDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vrije-teksts/{id}")
    @Timed
    public ResponseEntity<Void> deleteVrijeTekst(@PathVariable Long id) {
        log.debug("REST request to delete VrijeTekst : {}", id);
        vrijeTekstService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.AanvraagberichtService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.AanvraagberichtDTO;
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
 * REST controller for managing Aanvraagbericht.
 */
@RestController
@RequestMapping("/api")
public class AanvraagberichtResource {

    private final Logger log = LoggerFactory.getLogger(AanvraagberichtResource.class);

    private static final String ENTITY_NAME = "aanvraagbericht";

    private final AanvraagberichtService aanvraagberichtService;

    public AanvraagberichtResource(AanvraagberichtService aanvraagberichtService) {
        this.aanvraagberichtService = aanvraagberichtService;
    }

    /**
     * POST  /aanvraagberichts : Create a new aanvraagbericht.
     *
     * @param aanvraagberichtDTO the aanvraagberichtDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new aanvraagberichtDTO, or with status 400 (Bad Request) if the aanvraagbericht has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/aanvraagberichts")
    @Timed
    public ResponseEntity<AanvraagberichtDTO> createAanvraagbericht(@RequestBody AanvraagberichtDTO aanvraagberichtDTO) throws URISyntaxException {
        log.debug("REST request to save Aanvraagbericht : {}", aanvraagberichtDTO);
        if (aanvraagberichtDTO.getId() != null) {
            throw new BadRequestAlertException("A new aanvraagbericht cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AanvraagberichtDTO result = aanvraagberichtService.save(aanvraagberichtDTO);
        return ResponseEntity.created(new URI("/api/aanvraagberichts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /aanvraagberichts : Updates an existing aanvraagbericht.
     *
     * @param aanvraagberichtDTO the aanvraagberichtDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated aanvraagberichtDTO,
     * or with status 400 (Bad Request) if the aanvraagberichtDTO is not valid,
     * or with status 500 (Internal Server Error) if the aanvraagberichtDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/aanvraagberichts")
    @Timed
    public ResponseEntity<AanvraagberichtDTO> updateAanvraagbericht(@RequestBody AanvraagberichtDTO aanvraagberichtDTO) throws URISyntaxException {
        log.debug("REST request to update Aanvraagbericht : {}", aanvraagberichtDTO);
        if (aanvraagberichtDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AanvraagberichtDTO result = aanvraagberichtService.save(aanvraagberichtDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, aanvraagberichtDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /aanvraagberichts : get all the aanvraagberichts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of aanvraagberichts in body
     */
    @GetMapping("/aanvraagberichts")
    @Timed
    public List<AanvraagberichtDTO> getAllAanvraagberichts() {
        log.debug("REST request to get all Aanvraagberichts");
        return aanvraagberichtService.findAll();
    }

    /**
     * GET  /aanvraagberichts/:id : get the "id" aanvraagbericht.
     *
     * @param id the id of the aanvraagberichtDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the aanvraagberichtDTO, or with status 404 (Not Found)
     */
    @GetMapping("/aanvraagberichts/{id}")
    @Timed
    public ResponseEntity<AanvraagberichtDTO> getAanvraagbericht(@PathVariable Long id) {
        log.debug("REST request to get Aanvraagbericht : {}", id);
        Optional<AanvraagberichtDTO> aanvraagberichtDTO = aanvraagberichtService.findOne(id);
        return ResponseUtil.wrapOrNotFound(aanvraagberichtDTO);
    }

    /**
     * DELETE  /aanvraagberichts/:id : delete the "id" aanvraagbericht.
     *
     * @param id the id of the aanvraagberichtDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/aanvraagberichts/{id}")
    @Timed
    public ResponseEntity<Void> deleteAanvraagbericht(@PathVariable Long id) {
        log.debug("REST request to delete Aanvraagbericht : {}", id);
        aanvraagberichtService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

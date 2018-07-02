package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.TekstRegelService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.TekstRegelDTO;
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
 * REST controller for managing TekstRegel.
 */
@RestController
@RequestMapping("/api")
public class TekstRegelResource {

    private final Logger log = LoggerFactory.getLogger(TekstRegelResource.class);

    private static final String ENTITY_NAME = "tekstRegel";

    private final TekstRegelService tekstRegelService;

    public TekstRegelResource(TekstRegelService tekstRegelService) {
        this.tekstRegelService = tekstRegelService;
    }

    /**
     * POST  /tekst-regels : Create a new tekstRegel.
     *
     * @param tekstRegelDTO the tekstRegelDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tekstRegelDTO, or with status 400 (Bad Request) if the tekstRegel has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tekst-regels")
    @Timed
    public ResponseEntity<TekstRegelDTO> createTekstRegel(@RequestBody TekstRegelDTO tekstRegelDTO) throws URISyntaxException {
        log.debug("REST request to save TekstRegel : {}", tekstRegelDTO);
        if (tekstRegelDTO.getId() != null) {
            throw new BadRequestAlertException("A new tekstRegel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TekstRegelDTO result = tekstRegelService.save(tekstRegelDTO);
        return ResponseEntity.created(new URI("/api/tekst-regels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tekst-regels : Updates an existing tekstRegel.
     *
     * @param tekstRegelDTO the tekstRegelDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tekstRegelDTO,
     * or with status 400 (Bad Request) if the tekstRegelDTO is not valid,
     * or with status 500 (Internal Server Error) if the tekstRegelDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tekst-regels")
    @Timed
    public ResponseEntity<TekstRegelDTO> updateTekstRegel(@RequestBody TekstRegelDTO tekstRegelDTO) throws URISyntaxException {
        log.debug("REST request to update TekstRegel : {}", tekstRegelDTO);
        if (tekstRegelDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TekstRegelDTO result = tekstRegelService.save(tekstRegelDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tekstRegelDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tekst-regels : get all the tekstRegels.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tekstRegels in body
     */
    @GetMapping("/tekst-regels")
    @Timed
    public List<TekstRegelDTO> getAllTekstRegels() {
        log.debug("REST request to get all TekstRegels");
        return tekstRegelService.findAll();
    }

    /**
     * GET  /tekst-regels/:id : get the "id" tekstRegel.
     *
     * @param id the id of the tekstRegelDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tekstRegelDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tekst-regels/{id}")
    @Timed
    public ResponseEntity<TekstRegelDTO> getTekstRegel(@PathVariable Long id) {
        log.debug("REST request to get TekstRegel : {}", id);
        Optional<TekstRegelDTO> tekstRegelDTO = tekstRegelService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tekstRegelDTO);
    }

    /**
     * DELETE  /tekst-regels/:id : delete the "id" tekstRegel.
     *
     * @param id the id of the tekstRegelDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tekst-regels/{id}")
    @Timed
    public ResponseEntity<Void> deleteTekstRegel(@PathVariable Long id) {
        log.debug("REST request to delete TekstRegel : {}", id);
        tekstRegelService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

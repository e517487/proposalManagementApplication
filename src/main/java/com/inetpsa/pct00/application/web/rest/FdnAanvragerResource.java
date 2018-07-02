package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.FdnAanvragerService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.FdnAanvragerDTO;
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
 * REST controller for managing FdnAanvrager.
 */
@RestController
@RequestMapping("/api")
public class FdnAanvragerResource {

    private final Logger log = LoggerFactory.getLogger(FdnAanvragerResource.class);

    private static final String ENTITY_NAME = "fdnAanvrager";

    private final FdnAanvragerService fdnAanvragerService;

    public FdnAanvragerResource(FdnAanvragerService fdnAanvragerService) {
        this.fdnAanvragerService = fdnAanvragerService;
    }

    /**
     * POST  /fdn-aanvragers : Create a new fdnAanvrager.
     *
     * @param fdnAanvragerDTO the fdnAanvragerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new fdnAanvragerDTO, or with status 400 (Bad Request) if the fdnAanvrager has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/fdn-aanvragers")
    @Timed
    public ResponseEntity<FdnAanvragerDTO> createFdnAanvrager(@RequestBody FdnAanvragerDTO fdnAanvragerDTO) throws URISyntaxException {
        log.debug("REST request to save FdnAanvrager : {}", fdnAanvragerDTO);
        if (fdnAanvragerDTO.getId() != null) {
            throw new BadRequestAlertException("A new fdnAanvrager cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FdnAanvragerDTO result = fdnAanvragerService.save(fdnAanvragerDTO);
        return ResponseEntity.created(new URI("/api/fdn-aanvragers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /fdn-aanvragers : Updates an existing fdnAanvrager.
     *
     * @param fdnAanvragerDTO the fdnAanvragerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated fdnAanvragerDTO,
     * or with status 400 (Bad Request) if the fdnAanvragerDTO is not valid,
     * or with status 500 (Internal Server Error) if the fdnAanvragerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/fdn-aanvragers")
    @Timed
    public ResponseEntity<FdnAanvragerDTO> updateFdnAanvrager(@RequestBody FdnAanvragerDTO fdnAanvragerDTO) throws URISyntaxException {
        log.debug("REST request to update FdnAanvrager : {}", fdnAanvragerDTO);
        if (fdnAanvragerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FdnAanvragerDTO result = fdnAanvragerService.save(fdnAanvragerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, fdnAanvragerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /fdn-aanvragers : get all the fdnAanvragers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of fdnAanvragers in body
     */
    @GetMapping("/fdn-aanvragers")
    @Timed
    public List<FdnAanvragerDTO> getAllFdnAanvragers() {
        log.debug("REST request to get all FdnAanvragers");
        return fdnAanvragerService.findAll();
    }

    /**
     * GET  /fdn-aanvragers/:id : get the "id" fdnAanvrager.
     *
     * @param id the id of the fdnAanvragerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the fdnAanvragerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/fdn-aanvragers/{id}")
    @Timed
    public ResponseEntity<FdnAanvragerDTO> getFdnAanvrager(@PathVariable Long id) {
        log.debug("REST request to get FdnAanvrager : {}", id);
        Optional<FdnAanvragerDTO> fdnAanvragerDTO = fdnAanvragerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fdnAanvragerDTO);
    }

    /**
     * DELETE  /fdn-aanvragers/:id : delete the "id" fdnAanvrager.
     *
     * @param id the id of the fdnAanvragerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/fdn-aanvragers/{id}")
    @Timed
    public ResponseEntity<Void> deleteFdnAanvrager(@PathVariable Long id) {
        log.debug("REST request to delete FdnAanvrager : {}", id);
        fdnAanvragerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.AlgemeenService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.AlgemeenDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing Algemeen.
 */
@RestController
@RequestMapping("/api")
public class AlgemeenResource {

    private final Logger log = LoggerFactory.getLogger(AlgemeenResource.class);

    private static final String ENTITY_NAME = "algemeen";

    private final AlgemeenService algemeenService;

    public AlgemeenResource(AlgemeenService algemeenService) {
        this.algemeenService = algemeenService;
    }

    /**
     * POST  /algemeens : Create a new algemeen.
     *
     * @param algemeenDTO the algemeenDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new algemeenDTO, or with status 400 (Bad Request) if the algemeen has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/algemeens")
    @Timed
    public ResponseEntity<AlgemeenDTO> createAlgemeen(@RequestBody AlgemeenDTO algemeenDTO) throws URISyntaxException {
        log.debug("REST request to save Algemeen : {}", algemeenDTO);
        if (algemeenDTO.getId() != null) {
            throw new BadRequestAlertException("A new algemeen cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AlgemeenDTO result = algemeenService.save(algemeenDTO);
        return ResponseEntity.created(new URI("/api/algemeens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /algemeens : Updates an existing algemeen.
     *
     * @param algemeenDTO the algemeenDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated algemeenDTO,
     * or with status 400 (Bad Request) if the algemeenDTO is not valid,
     * or with status 500 (Internal Server Error) if the algemeenDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/algemeens")
    @Timed
    public ResponseEntity<AlgemeenDTO> updateAlgemeen(@RequestBody AlgemeenDTO algemeenDTO) throws URISyntaxException {
        log.debug("REST request to update Algemeen : {}", algemeenDTO);
        if (algemeenDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AlgemeenDTO result = algemeenService.save(algemeenDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, algemeenDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /algemeens : get all the algemeens.
     *
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of algemeens in body
     */
    @GetMapping("/algemeens")
    @Timed
    public List<AlgemeenDTO> getAllAlgemeens(@RequestParam(required = false) String filter) {
        if ("aanvraagbericht-is-null".equals(filter)) {
            log.debug("REST request to get all Algemeens where aanvraagbericht is null");
            return algemeenService.findAllWhereAanvraagberichtIsNull();
        }
        log.debug("REST request to get all Algemeens");
        return algemeenService.findAll();
    }

    /**
     * GET  /algemeens/:id : get the "id" algemeen.
     *
     * @param id the id of the algemeenDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the algemeenDTO, or with status 404 (Not Found)
     */
    @GetMapping("/algemeens/{id}")
    @Timed
    public ResponseEntity<AlgemeenDTO> getAlgemeen(@PathVariable Long id) {
        log.debug("REST request to get Algemeen : {}", id);
        Optional<AlgemeenDTO> algemeenDTO = algemeenService.findOne(id);
        return ResponseUtil.wrapOrNotFound(algemeenDTO);
    }

    /**
     * DELETE  /algemeens/:id : delete the "id" algemeen.
     *
     * @param id the id of the algemeenDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/algemeens/{id}")
    @Timed
    public ResponseEntity<Void> deleteAlgemeen(@PathVariable Long id) {
        log.debug("REST request to delete Algemeen : {}", id);
        algemeenService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

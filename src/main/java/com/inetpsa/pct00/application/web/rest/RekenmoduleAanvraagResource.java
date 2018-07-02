package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.RekenmoduleAanvraagService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.RekenmoduleAanvraagDTO;
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
 * REST controller for managing RekenmoduleAanvraag.
 */
@RestController
@RequestMapping("/api")
public class RekenmoduleAanvraagResource {

    private final Logger log = LoggerFactory.getLogger(RekenmoduleAanvraagResource.class);

    private static final String ENTITY_NAME = "rekenmoduleAanvraag";

    private final RekenmoduleAanvraagService rekenmoduleAanvraagService;

    public RekenmoduleAanvraagResource(RekenmoduleAanvraagService rekenmoduleAanvraagService) {
        this.rekenmoduleAanvraagService = rekenmoduleAanvraagService;
    }

    /**
     * POST  /rekenmodule-aanvraags : Create a new rekenmoduleAanvraag.
     *
     * @param rekenmoduleAanvraagDTO the rekenmoduleAanvraagDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rekenmoduleAanvraagDTO, or with status 400 (Bad Request) if the rekenmoduleAanvraag has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rekenmodule-aanvraags")
    @Timed
    public ResponseEntity<RekenmoduleAanvraagDTO> createRekenmoduleAanvraag(@RequestBody RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO) throws URISyntaxException {
        log.debug("REST request to save RekenmoduleAanvraag : {}", rekenmoduleAanvraagDTO);
        if (rekenmoduleAanvraagDTO.getId() != null) {
            throw new BadRequestAlertException("A new rekenmoduleAanvraag cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RekenmoduleAanvraagDTO result = rekenmoduleAanvraagService.save(rekenmoduleAanvraagDTO);
        return ResponseEntity.created(new URI("/api/rekenmodule-aanvraags/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rekenmodule-aanvraags : Updates an existing rekenmoduleAanvraag.
     *
     * @param rekenmoduleAanvraagDTO the rekenmoduleAanvraagDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rekenmoduleAanvraagDTO,
     * or with status 400 (Bad Request) if the rekenmoduleAanvraagDTO is not valid,
     * or with status 500 (Internal Server Error) if the rekenmoduleAanvraagDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rekenmodule-aanvraags")
    @Timed
    public ResponseEntity<RekenmoduleAanvraagDTO> updateRekenmoduleAanvraag(@RequestBody RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO) throws URISyntaxException {
        log.debug("REST request to update RekenmoduleAanvraag : {}", rekenmoduleAanvraagDTO);
        if (rekenmoduleAanvraagDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RekenmoduleAanvraagDTO result = rekenmoduleAanvraagService.save(rekenmoduleAanvraagDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rekenmoduleAanvraagDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rekenmodule-aanvraags : get all the rekenmoduleAanvraags.
     *
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of rekenmoduleAanvraags in body
     */
    @GetMapping("/rekenmodule-aanvraags")
    @Timed
    public List<RekenmoduleAanvraagDTO> getAllRekenmoduleAanvraags(@RequestParam(required = false) String filter) {
        if ("aanvraagbericht-is-null".equals(filter)) {
            log.debug("REST request to get all RekenmoduleAanvraags where aanvraagbericht is null");
            return rekenmoduleAanvraagService.findAllWhereAanvraagberichtIsNull();
        }
        log.debug("REST request to get all RekenmoduleAanvraags");
        return rekenmoduleAanvraagService.findAll();
    }

    /**
     * GET  /rekenmodule-aanvraags/:id : get the "id" rekenmoduleAanvraag.
     *
     * @param id the id of the rekenmoduleAanvraagDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rekenmoduleAanvraagDTO, or with status 404 (Not Found)
     */
    @GetMapping("/rekenmodule-aanvraags/{id}")
    @Timed
    public ResponseEntity<RekenmoduleAanvraagDTO> getRekenmoduleAanvraag(@PathVariable Long id) {
        log.debug("REST request to get RekenmoduleAanvraag : {}", id);
        Optional<RekenmoduleAanvraagDTO> rekenmoduleAanvraagDTO = rekenmoduleAanvraagService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rekenmoduleAanvraagDTO);
    }

    /**
     * DELETE  /rekenmodule-aanvraags/:id : delete the "id" rekenmoduleAanvraag.
     *
     * @param id the id of the rekenmoduleAanvraagDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rekenmodule-aanvraags/{id}")
    @Timed
    public ResponseEntity<Void> deleteRekenmoduleAanvraag(@PathVariable Long id) {
        log.debug("REST request to delete RekenmoduleAanvraag : {}", id);
        rekenmoduleAanvraagService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

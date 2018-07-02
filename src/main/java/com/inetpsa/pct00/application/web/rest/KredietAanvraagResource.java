package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.KredietAanvraagService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.KredietAanvraagDTO;
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
 * REST controller for managing KredietAanvraag.
 */
@RestController
@RequestMapping("/api")
public class KredietAanvraagResource {

    private final Logger log = LoggerFactory.getLogger(KredietAanvraagResource.class);

    private static final String ENTITY_NAME = "kredietAanvraag";

    private final KredietAanvraagService kredietAanvraagService;

    public KredietAanvraagResource(KredietAanvraagService kredietAanvraagService) {
        this.kredietAanvraagService = kredietAanvraagService;
    }

    /**
     * POST  /krediet-aanvraags : Create a new kredietAanvraag.
     *
     * @param kredietAanvraagDTO the kredietAanvraagDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new kredietAanvraagDTO, or with status 400 (Bad Request) if the kredietAanvraag has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/krediet-aanvraags")
    @Timed
    public ResponseEntity<KredietAanvraagDTO> createKredietAanvraag(@RequestBody KredietAanvraagDTO kredietAanvraagDTO) throws URISyntaxException {
        log.debug("REST request to save KredietAanvraag : {}", kredietAanvraagDTO);
        if (kredietAanvraagDTO.getId() != null) {
            throw new BadRequestAlertException("A new kredietAanvraag cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KredietAanvraagDTO result = kredietAanvraagService.save(kredietAanvraagDTO);
        return ResponseEntity.created(new URI("/api/krediet-aanvraags/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /krediet-aanvraags : Updates an existing kredietAanvraag.
     *
     * @param kredietAanvraagDTO the kredietAanvraagDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated kredietAanvraagDTO,
     * or with status 400 (Bad Request) if the kredietAanvraagDTO is not valid,
     * or with status 500 (Internal Server Error) if the kredietAanvraagDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/krediet-aanvraags")
    @Timed
    public ResponseEntity<KredietAanvraagDTO> updateKredietAanvraag(@RequestBody KredietAanvraagDTO kredietAanvraagDTO) throws URISyntaxException {
        log.debug("REST request to update KredietAanvraag : {}", kredietAanvraagDTO);
        if (kredietAanvraagDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        KredietAanvraagDTO result = kredietAanvraagService.save(kredietAanvraagDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, kredietAanvraagDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /krediet-aanvraags : get all the kredietAanvraags.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of kredietAanvraags in body
     */
    @GetMapping("/krediet-aanvraags")
    @Timed
    public List<KredietAanvraagDTO> getAllKredietAanvraags() {
        log.debug("REST request to get all KredietAanvraags");
        return kredietAanvraagService.findAll();
    }

    /**
     * GET  /krediet-aanvraags/:id : get the "id" kredietAanvraag.
     *
     * @param id the id of the kredietAanvraagDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the kredietAanvraagDTO, or with status 404 (Not Found)
     */
    @GetMapping("/krediet-aanvraags/{id}")
    @Timed
    public ResponseEntity<KredietAanvraagDTO> getKredietAanvraag(@PathVariable Long id) {
        log.debug("REST request to get KredietAanvraag : {}", id);
        Optional<KredietAanvraagDTO> kredietAanvraagDTO = kredietAanvraagService.findOne(id);
        return ResponseUtil.wrapOrNotFound(kredietAanvraagDTO);
    }

    /**
     * DELETE  /krediet-aanvraags/:id : delete the "id" kredietAanvraag.
     *
     * @param id the id of the kredietAanvraagDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/krediet-aanvraags/{id}")
    @Timed
    public ResponseEntity<Void> deleteKredietAanvraag(@PathVariable Long id) {
        log.debug("REST request to delete KredietAanvraag : {}", id);
        kredietAanvraagService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.GezinssituatieService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.GezinssituatieDTO;
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
 * REST controller for managing Gezinssituatie.
 */
@RestController
@RequestMapping("/api")
public class GezinssituatieResource {

    private final Logger log = LoggerFactory.getLogger(GezinssituatieResource.class);

    private static final String ENTITY_NAME = "gezinssituatie";

    private final GezinssituatieService gezinssituatieService;

    public GezinssituatieResource(GezinssituatieService gezinssituatieService) {
        this.gezinssituatieService = gezinssituatieService;
    }

    /**
     * POST  /gezinssituaties : Create a new gezinssituatie.
     *
     * @param gezinssituatieDTO the gezinssituatieDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new gezinssituatieDTO, or with status 400 (Bad Request) if the gezinssituatie has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/gezinssituaties")
    @Timed
    public ResponseEntity<GezinssituatieDTO> createGezinssituatie(@RequestBody GezinssituatieDTO gezinssituatieDTO) throws URISyntaxException {
        log.debug("REST request to save Gezinssituatie : {}", gezinssituatieDTO);
        if (gezinssituatieDTO.getId() != null) {
            throw new BadRequestAlertException("A new gezinssituatie cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GezinssituatieDTO result = gezinssituatieService.save(gezinssituatieDTO);
        return ResponseEntity.created(new URI("/api/gezinssituaties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /gezinssituaties : Updates an existing gezinssituatie.
     *
     * @param gezinssituatieDTO the gezinssituatieDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated gezinssituatieDTO,
     * or with status 400 (Bad Request) if the gezinssituatieDTO is not valid,
     * or with status 500 (Internal Server Error) if the gezinssituatieDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/gezinssituaties")
    @Timed
    public ResponseEntity<GezinssituatieDTO> updateGezinssituatie(@RequestBody GezinssituatieDTO gezinssituatieDTO) throws URISyntaxException {
        log.debug("REST request to update Gezinssituatie : {}", gezinssituatieDTO);
        if (gezinssituatieDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GezinssituatieDTO result = gezinssituatieService.save(gezinssituatieDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, gezinssituatieDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /gezinssituaties : get all the gezinssituaties.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of gezinssituaties in body
     */
    @GetMapping("/gezinssituaties")
    @Timed
    public List<GezinssituatieDTO> getAllGezinssituaties() {
        log.debug("REST request to get all Gezinssituaties");
        return gezinssituatieService.findAll();
    }

    /**
     * GET  /gezinssituaties/:id : get the "id" gezinssituatie.
     *
     * @param id the id of the gezinssituatieDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the gezinssituatieDTO, or with status 404 (Not Found)
     */
    @GetMapping("/gezinssituaties/{id}")
    @Timed
    public ResponseEntity<GezinssituatieDTO> getGezinssituatie(@PathVariable Long id) {
        log.debug("REST request to get Gezinssituatie : {}", id);
        Optional<GezinssituatieDTO> gezinssituatieDTO = gezinssituatieService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gezinssituatieDTO);
    }

    /**
     * DELETE  /gezinssituaties/:id : delete the "id" gezinssituatie.
     *
     * @param id the id of the gezinssituatieDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/gezinssituaties/{id}")
    @Timed
    public ResponseEntity<Void> deleteGezinssituatie(@PathVariable Long id) {
        log.debug("REST request to delete Gezinssituatie : {}", id);
        gezinssituatieService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

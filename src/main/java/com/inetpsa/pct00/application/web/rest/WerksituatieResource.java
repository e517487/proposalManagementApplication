package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.WerksituatieService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.WerksituatieDTO;
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
 * REST controller for managing Werksituatie.
 */
@RestController
@RequestMapping("/api")
public class WerksituatieResource {

    private final Logger log = LoggerFactory.getLogger(WerksituatieResource.class);

    private static final String ENTITY_NAME = "werksituatie";

    private final WerksituatieService werksituatieService;

    public WerksituatieResource(WerksituatieService werksituatieService) {
        this.werksituatieService = werksituatieService;
    }

    /**
     * POST  /werksituaties : Create a new werksituatie.
     *
     * @param werksituatieDTO the werksituatieDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new werksituatieDTO, or with status 400 (Bad Request) if the werksituatie has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/werksituaties")
    @Timed
    public ResponseEntity<WerksituatieDTO> createWerksituatie(@RequestBody WerksituatieDTO werksituatieDTO) throws URISyntaxException {
        log.debug("REST request to save Werksituatie : {}", werksituatieDTO);
        if (werksituatieDTO.getId() != null) {
            throw new BadRequestAlertException("A new werksituatie cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WerksituatieDTO result = werksituatieService.save(werksituatieDTO);
        return ResponseEntity.created(new URI("/api/werksituaties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /werksituaties : Updates an existing werksituatie.
     *
     * @param werksituatieDTO the werksituatieDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated werksituatieDTO,
     * or with status 400 (Bad Request) if the werksituatieDTO is not valid,
     * or with status 500 (Internal Server Error) if the werksituatieDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/werksituaties")
    @Timed
    public ResponseEntity<WerksituatieDTO> updateWerksituatie(@RequestBody WerksituatieDTO werksituatieDTO) throws URISyntaxException {
        log.debug("REST request to update Werksituatie : {}", werksituatieDTO);
        if (werksituatieDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WerksituatieDTO result = werksituatieService.save(werksituatieDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, werksituatieDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /werksituaties : get all the werksituaties.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of werksituaties in body
     */
    @GetMapping("/werksituaties")
    @Timed
    public List<WerksituatieDTO> getAllWerksituaties() {
        log.debug("REST request to get all Werksituaties");
        return werksituatieService.findAll();
    }

    /**
     * GET  /werksituaties/:id : get the "id" werksituatie.
     *
     * @param id the id of the werksituatieDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the werksituatieDTO, or with status 404 (Not Found)
     */
    @GetMapping("/werksituaties/{id}")
    @Timed
    public ResponseEntity<WerksituatieDTO> getWerksituatie(@PathVariable Long id) {
        log.debug("REST request to get Werksituatie : {}", id);
        Optional<WerksituatieDTO> werksituatieDTO = werksituatieService.findOne(id);
        return ResponseUtil.wrapOrNotFound(werksituatieDTO);
    }

    /**
     * DELETE  /werksituaties/:id : delete the "id" werksituatie.
     *
     * @param id the id of the werksituatieDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/werksituaties/{id}")
    @Timed
    public ResponseEntity<Void> deleteWerksituatie(@PathVariable Long id) {
        log.debug("REST request to delete Werksituatie : {}", id);
        werksituatieService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

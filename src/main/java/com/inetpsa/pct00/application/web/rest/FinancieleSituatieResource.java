package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.FinancieleSituatieService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.FinancieleSituatieDTO;
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
 * REST controller for managing FinancieleSituatie.
 */
@RestController
@RequestMapping("/api")
public class FinancieleSituatieResource {

    private final Logger log = LoggerFactory.getLogger(FinancieleSituatieResource.class);

    private static final String ENTITY_NAME = "financieleSituatie";

    private final FinancieleSituatieService financieleSituatieService;

    public FinancieleSituatieResource(FinancieleSituatieService financieleSituatieService) {
        this.financieleSituatieService = financieleSituatieService;
    }

    /**
     * POST  /financiele-situaties : Create a new financieleSituatie.
     *
     * @param financieleSituatieDTO the financieleSituatieDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new financieleSituatieDTO, or with status 400 (Bad Request) if the financieleSituatie has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/financiele-situaties")
    @Timed
    public ResponseEntity<FinancieleSituatieDTO> createFinancieleSituatie(@RequestBody FinancieleSituatieDTO financieleSituatieDTO) throws URISyntaxException {
        log.debug("REST request to save FinancieleSituatie : {}", financieleSituatieDTO);
        if (financieleSituatieDTO.getId() != null) {
            throw new BadRequestAlertException("A new financieleSituatie cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FinancieleSituatieDTO result = financieleSituatieService.save(financieleSituatieDTO);
        return ResponseEntity.created(new URI("/api/financiele-situaties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /financiele-situaties : Updates an existing financieleSituatie.
     *
     * @param financieleSituatieDTO the financieleSituatieDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated financieleSituatieDTO,
     * or with status 400 (Bad Request) if the financieleSituatieDTO is not valid,
     * or with status 500 (Internal Server Error) if the financieleSituatieDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/financiele-situaties")
    @Timed
    public ResponseEntity<FinancieleSituatieDTO> updateFinancieleSituatie(@RequestBody FinancieleSituatieDTO financieleSituatieDTO) throws URISyntaxException {
        log.debug("REST request to update FinancieleSituatie : {}", financieleSituatieDTO);
        if (financieleSituatieDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FinancieleSituatieDTO result = financieleSituatieService.save(financieleSituatieDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, financieleSituatieDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /financiele-situaties : get all the financieleSituaties.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of financieleSituaties in body
     */
    @GetMapping("/financiele-situaties")
    @Timed
    public List<FinancieleSituatieDTO> getAllFinancieleSituaties() {
        log.debug("REST request to get all FinancieleSituaties");
        return financieleSituatieService.findAll();
    }

    /**
     * GET  /financiele-situaties/:id : get the "id" financieleSituatie.
     *
     * @param id the id of the financieleSituatieDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the financieleSituatieDTO, or with status 404 (Not Found)
     */
    @GetMapping("/financiele-situaties/{id}")
    @Timed
    public ResponseEntity<FinancieleSituatieDTO> getFinancieleSituatie(@PathVariable Long id) {
        log.debug("REST request to get FinancieleSituatie : {}", id);
        Optional<FinancieleSituatieDTO> financieleSituatieDTO = financieleSituatieService.findOne(id);
        return ResponseUtil.wrapOrNotFound(financieleSituatieDTO);
    }

    /**
     * DELETE  /financiele-situaties/:id : delete the "id" financieleSituatie.
     *
     * @param id the id of the financieleSituatieDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/financiele-situaties/{id}")
    @Timed
    public ResponseEntity<Void> deleteFinancieleSituatie(@PathVariable Long id) {
        log.debug("REST request to delete FinancieleSituatie : {}", id);
        financieleSituatieService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

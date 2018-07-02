package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.CreditScoreService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.CreditScoreDTO;
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
 * REST controller for managing CreditScore.
 */
@RestController
@RequestMapping("/api")
public class CreditScoreResource {

    private final Logger log = LoggerFactory.getLogger(CreditScoreResource.class);

    private static final String ENTITY_NAME = "creditScore";

    private final CreditScoreService creditScoreService;

    public CreditScoreResource(CreditScoreService creditScoreService) {
        this.creditScoreService = creditScoreService;
    }

    /**
     * POST  /credit-scores : Create a new creditScore.
     *
     * @param creditScoreDTO the creditScoreDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new creditScoreDTO, or with status 400 (Bad Request) if the creditScore has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/credit-scores")
    @Timed
    public ResponseEntity<CreditScoreDTO> createCreditScore(@RequestBody CreditScoreDTO creditScoreDTO) throws URISyntaxException {
        log.debug("REST request to save CreditScore : {}", creditScoreDTO);
        if (creditScoreDTO.getId() != null) {
            throw new BadRequestAlertException("A new creditScore cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CreditScoreDTO result = creditScoreService.save(creditScoreDTO);
        return ResponseEntity.created(new URI("/api/credit-scores/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /credit-scores : Updates an existing creditScore.
     *
     * @param creditScoreDTO the creditScoreDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated creditScoreDTO,
     * or with status 400 (Bad Request) if the creditScoreDTO is not valid,
     * or with status 500 (Internal Server Error) if the creditScoreDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/credit-scores")
    @Timed
    public ResponseEntity<CreditScoreDTO> updateCreditScore(@RequestBody CreditScoreDTO creditScoreDTO) throws URISyntaxException {
        log.debug("REST request to update CreditScore : {}", creditScoreDTO);
        if (creditScoreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CreditScoreDTO result = creditScoreService.save(creditScoreDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, creditScoreDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /credit-scores : get all the creditScores.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of creditScores in body
     */
    @GetMapping("/credit-scores")
    @Timed
    public List<CreditScoreDTO> getAllCreditScores() {
        log.debug("REST request to get all CreditScores");
        return creditScoreService.findAll();
    }

    /**
     * GET  /credit-scores/:id : get the "id" creditScore.
     *
     * @param id the id of the creditScoreDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the creditScoreDTO, or with status 404 (Not Found)
     */
    @GetMapping("/credit-scores/{id}")
    @Timed
    public ResponseEntity<CreditScoreDTO> getCreditScore(@PathVariable Long id) {
        log.debug("REST request to get CreditScore : {}", id);
        Optional<CreditScoreDTO> creditScoreDTO = creditScoreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(creditScoreDTO);
    }

    /**
     * DELETE  /credit-scores/:id : delete the "id" creditScore.
     *
     * @param id the id of the creditScoreDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/credit-scores/{id}")
    @Timed
    public ResponseEntity<Void> deleteCreditScore(@PathVariable Long id) {
        log.debug("REST request to delete CreditScore : {}", id);
        creditScoreService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

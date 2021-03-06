package com.inetpsa.pct00.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.inetpsa.pct00.application.service.AdresService;
import com.inetpsa.pct00.application.web.rest.errors.BadRequestAlertException;
import com.inetpsa.pct00.application.web.rest.util.HeaderUtil;
import com.inetpsa.pct00.application.service.dto.AdresDTO;
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
 * REST controller for managing Adres.
 */
@RestController
@RequestMapping("/api")
public class AdresResource {

    private final Logger log = LoggerFactory.getLogger(AdresResource.class);

    private static final String ENTITY_NAME = "adres";

    private final AdresService adresService;

    public AdresResource(AdresService adresService) {
        this.adresService = adresService;
    }

    /**
     * POST  /adres : Create a new adres.
     *
     * @param adresDTO the adresDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new adresDTO, or with status 400 (Bad Request) if the adres has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/adres")
    @Timed
    public ResponseEntity<AdresDTO> createAdres(@RequestBody AdresDTO adresDTO) throws URISyntaxException {
        log.debug("REST request to save Adres : {}", adresDTO);
        if (adresDTO.getId() != null) {
            throw new BadRequestAlertException("A new adres cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AdresDTO result = adresService.save(adresDTO);
        return ResponseEntity.created(new URI("/api/adres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /adres : Updates an existing adres.
     *
     * @param adresDTO the adresDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated adresDTO,
     * or with status 400 (Bad Request) if the adresDTO is not valid,
     * or with status 500 (Internal Server Error) if the adresDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/adres")
    @Timed
    public ResponseEntity<AdresDTO> updateAdres(@RequestBody AdresDTO adresDTO) throws URISyntaxException {
        log.debug("REST request to update Adres : {}", adresDTO);
        if (adresDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AdresDTO result = adresService.save(adresDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, adresDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /adres : get all the adres.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of adres in body
     */
    @GetMapping("/adres")
    @Timed
    public List<AdresDTO> getAllAdres() {
        log.debug("REST request to get all Adres");
        return adresService.findAll();
    }

    /**
     * GET  /adres/:id : get the "id" adres.
     *
     * @param id the id of the adresDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the adresDTO, or with status 404 (Not Found)
     */
    @GetMapping("/adres/{id}")
    @Timed
    public ResponseEntity<AdresDTO> getAdres(@PathVariable Long id) {
        log.debug("REST request to get Adres : {}", id);
        Optional<AdresDTO> adresDTO = adresService.findOne(id);
        return ResponseUtil.wrapOrNotFound(adresDTO);
    }

    /**
     * DELETE  /adres/:id : delete the "id" adres.
     *
     * @param id the id of the adresDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/adres/{id}")
    @Timed
    public ResponseEntity<Void> deleteAdres(@PathVariable Long id) {
        log.debug("REST request to delete Adres : {}", id);
        adresService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

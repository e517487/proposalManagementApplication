package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Adres;
import com.inetpsa.pct00.application.repository.AdresRepository;
import com.inetpsa.pct00.application.service.AdresService;
import com.inetpsa.pct00.application.service.dto.AdresDTO;
import com.inetpsa.pct00.application.service.mapper.AdresMapper;
import com.inetpsa.pct00.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AdresResource REST controller.
 *
 * @see AdresResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class AdresResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_SOORT_ADRES = "AAAAAAAAAA";
    private static final String UPDATED_SOORT_ADRES = "BBBBBBBBBB";

    private static final String DEFAULT_STRAAT_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_STRAAT_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_HUIS_NR = "AAAAAAAAAA";
    private static final String UPDATED_HUIS_NR = "BBBBBBBBBB";

    private static final String DEFAULT_PLAATS_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_PLAATS_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_POSTCODE = "AAAAAAAAAA";
    private static final String UPDATED_POSTCODE = "BBBBBBBBBB";

    private static final String DEFAULT_LAND = "AAAAAAAAAA";
    private static final String UPDATED_LAND = "BBBBBBBBBB";

    @Autowired
    private AdresRepository adresRepository;


    @Autowired
    private AdresMapper adresMapper;
    

    @Autowired
    private AdresService adresService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAdresMockMvc;

    private Adres adres;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AdresResource adresResource = new AdresResource(adresService);
        this.restAdresMockMvc = MockMvcBuilders.standaloneSetup(adresResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Adres createEntity(EntityManager em) {
        Adres adres = new Adres()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .soortAdres(DEFAULT_SOORT_ADRES)
            .straatNaam(DEFAULT_STRAAT_NAAM)
            .huisNr(DEFAULT_HUIS_NR)
            .plaatsNaam(DEFAULT_PLAATS_NAAM)
            .postcode(DEFAULT_POSTCODE)
            .land(DEFAULT_LAND);
        return adres;
    }

    @Before
    public void initTest() {
        adres = createEntity(em);
    }

    @Test
    @Transactional
    public void createAdres() throws Exception {
        int databaseSizeBeforeCreate = adresRepository.findAll().size();

        // Create the Adres
        AdresDTO adresDTO = adresMapper.toDto(adres);
        restAdresMockMvc.perform(post("/api/adres")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(adresDTO)))
            .andExpect(status().isCreated());

        // Validate the Adres in the database
        List<Adres> adresList = adresRepository.findAll();
        assertThat(adresList).hasSize(databaseSizeBeforeCreate + 1);
        Adres testAdres = adresList.get(adresList.size() - 1);
        assertThat(testAdres.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testAdres.getSoortAdres()).isEqualTo(DEFAULT_SOORT_ADRES);
        assertThat(testAdres.getStraatNaam()).isEqualTo(DEFAULT_STRAAT_NAAM);
        assertThat(testAdres.getHuisNr()).isEqualTo(DEFAULT_HUIS_NR);
        assertThat(testAdres.getPlaatsNaam()).isEqualTo(DEFAULT_PLAATS_NAAM);
        assertThat(testAdres.getPostcode()).isEqualTo(DEFAULT_POSTCODE);
        assertThat(testAdres.getLand()).isEqualTo(DEFAULT_LAND);
    }

    @Test
    @Transactional
    public void createAdresWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = adresRepository.findAll().size();

        // Create the Adres with an existing ID
        adres.setId(1L);
        AdresDTO adresDTO = adresMapper.toDto(adres);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAdresMockMvc.perform(post("/api/adres")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(adresDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Adres in the database
        List<Adres> adresList = adresRepository.findAll();
        assertThat(adresList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAdres() throws Exception {
        // Initialize the database
        adresRepository.saveAndFlush(adres);

        // Get all the adresList
        restAdresMockMvc.perform(get("/api/adres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(adres.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].soortAdres").value(hasItem(DEFAULT_SOORT_ADRES.toString())))
            .andExpect(jsonPath("$.[*].straatNaam").value(hasItem(DEFAULT_STRAAT_NAAM.toString())))
            .andExpect(jsonPath("$.[*].huisNr").value(hasItem(DEFAULT_HUIS_NR.toString())))
            .andExpect(jsonPath("$.[*].plaatsNaam").value(hasItem(DEFAULT_PLAATS_NAAM.toString())))
            .andExpect(jsonPath("$.[*].postcode").value(hasItem(DEFAULT_POSTCODE.toString())))
            .andExpect(jsonPath("$.[*].land").value(hasItem(DEFAULT_LAND.toString())));
    }
    

    @Test
    @Transactional
    public void getAdres() throws Exception {
        // Initialize the database
        adresRepository.saveAndFlush(adres);

        // Get the adres
        restAdresMockMvc.perform(get("/api/adres/{id}", adres.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(adres.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.soortAdres").value(DEFAULT_SOORT_ADRES.toString()))
            .andExpect(jsonPath("$.straatNaam").value(DEFAULT_STRAAT_NAAM.toString()))
            .andExpect(jsonPath("$.huisNr").value(DEFAULT_HUIS_NR.toString()))
            .andExpect(jsonPath("$.plaatsNaam").value(DEFAULT_PLAATS_NAAM.toString()))
            .andExpect(jsonPath("$.postcode").value(DEFAULT_POSTCODE.toString()))
            .andExpect(jsonPath("$.land").value(DEFAULT_LAND.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingAdres() throws Exception {
        // Get the adres
        restAdresMockMvc.perform(get("/api/adres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAdres() throws Exception {
        // Initialize the database
        adresRepository.saveAndFlush(adres);

        int databaseSizeBeforeUpdate = adresRepository.findAll().size();

        // Update the adres
        Adres updatedAdres = adresRepository.findById(adres.getId()).get();
        // Disconnect from session so that the updates on updatedAdres are not directly saved in db
        em.detach(updatedAdres);
        updatedAdres
            .volgnummer(UPDATED_VOLGNUMMER)
            .soortAdres(UPDATED_SOORT_ADRES)
            .straatNaam(UPDATED_STRAAT_NAAM)
            .huisNr(UPDATED_HUIS_NR)
            .plaatsNaam(UPDATED_PLAATS_NAAM)
            .postcode(UPDATED_POSTCODE)
            .land(UPDATED_LAND);
        AdresDTO adresDTO = adresMapper.toDto(updatedAdres);

        restAdresMockMvc.perform(put("/api/adres")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(adresDTO)))
            .andExpect(status().isOk());

        // Validate the Adres in the database
        List<Adres> adresList = adresRepository.findAll();
        assertThat(adresList).hasSize(databaseSizeBeforeUpdate);
        Adres testAdres = adresList.get(adresList.size() - 1);
        assertThat(testAdres.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testAdres.getSoortAdres()).isEqualTo(UPDATED_SOORT_ADRES);
        assertThat(testAdres.getStraatNaam()).isEqualTo(UPDATED_STRAAT_NAAM);
        assertThat(testAdres.getHuisNr()).isEqualTo(UPDATED_HUIS_NR);
        assertThat(testAdres.getPlaatsNaam()).isEqualTo(UPDATED_PLAATS_NAAM);
        assertThat(testAdres.getPostcode()).isEqualTo(UPDATED_POSTCODE);
        assertThat(testAdres.getLand()).isEqualTo(UPDATED_LAND);
    }

    @Test
    @Transactional
    public void updateNonExistingAdres() throws Exception {
        int databaseSizeBeforeUpdate = adresRepository.findAll().size();

        // Create the Adres
        AdresDTO adresDTO = adresMapper.toDto(adres);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAdresMockMvc.perform(put("/api/adres")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(adresDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Adres in the database
        List<Adres> adresList = adresRepository.findAll();
        assertThat(adresList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAdres() throws Exception {
        // Initialize the database
        adresRepository.saveAndFlush(adres);

        int databaseSizeBeforeDelete = adresRepository.findAll().size();

        // Get the adres
        restAdresMockMvc.perform(delete("/api/adres/{id}", adres.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Adres> adresList = adresRepository.findAll();
        assertThat(adresList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Adres.class);
        Adres adres1 = new Adres();
        adres1.setId(1L);
        Adres adres2 = new Adres();
        adres2.setId(adres1.getId());
        assertThat(adres1).isEqualTo(adres2);
        adres2.setId(2L);
        assertThat(adres1).isNotEqualTo(adres2);
        adres1.setId(null);
        assertThat(adres1).isNotEqualTo(adres2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AdresDTO.class);
        AdresDTO adresDTO1 = new AdresDTO();
        adresDTO1.setId(1L);
        AdresDTO adresDTO2 = new AdresDTO();
        assertThat(adresDTO1).isNotEqualTo(adresDTO2);
        adresDTO2.setId(adresDTO1.getId());
        assertThat(adresDTO1).isEqualTo(adresDTO2);
        adresDTO2.setId(2L);
        assertThat(adresDTO1).isNotEqualTo(adresDTO2);
        adresDTO1.setId(null);
        assertThat(adresDTO1).isNotEqualTo(adresDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(adresMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(adresMapper.fromId(null)).isNull();
    }
}

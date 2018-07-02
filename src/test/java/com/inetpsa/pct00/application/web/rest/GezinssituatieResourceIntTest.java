package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Gezinssituatie;
import com.inetpsa.pct00.application.repository.GezinssituatieRepository;
import com.inetpsa.pct00.application.service.GezinssituatieService;
import com.inetpsa.pct00.application.service.dto.GezinssituatieDTO;
import com.inetpsa.pct00.application.service.mapper.GezinssituatieMapper;
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
 * Test class for the GezinssituatieResource REST controller.
 *
 * @see GezinssituatieResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class GezinssituatieResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_BURGERLIJKE_STAAT = "AAAAAAAAAA";
    private static final String UPDATED_BURGERLIJKE_STAAT = "BBBBBBBBBB";

    private static final String DEFAULT_HUWELIJKSE_VW = "AAAAAAAAAA";
    private static final String UPDATED_HUWELIJKSE_VW = "BBBBBBBBBB";

    private static final String DEFAULT_HUWELIJK_ONTBONDEN = "AAAAAAAAAA";
    private static final String UPDATED_HUWELIJK_ONTBONDEN = "BBBBBBBBBB";

    private static final String DEFAULT_WEDUWE_WEDUWNAAR = "AAAAAAAAAA";
    private static final String UPDATED_WEDUWE_WEDUWNAAR = "BBBBBBBBBB";

    private static final Integer DEFAULT_KINDEREN_AANTAL = 1;
    private static final Integer UPDATED_KINDEREN_AANTAL = 2;

    @Autowired
    private GezinssituatieRepository gezinssituatieRepository;


    @Autowired
    private GezinssituatieMapper gezinssituatieMapper;
    

    @Autowired
    private GezinssituatieService gezinssituatieService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restGezinssituatieMockMvc;

    private Gezinssituatie gezinssituatie;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final GezinssituatieResource gezinssituatieResource = new GezinssituatieResource(gezinssituatieService);
        this.restGezinssituatieMockMvc = MockMvcBuilders.standaloneSetup(gezinssituatieResource)
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
    public static Gezinssituatie createEntity(EntityManager em) {
        Gezinssituatie gezinssituatie = new Gezinssituatie()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .burgerlijkeStaat(DEFAULT_BURGERLIJKE_STAAT)
            .huwelijkseVw(DEFAULT_HUWELIJKSE_VW)
            .huwelijkOntbonden(DEFAULT_HUWELIJK_ONTBONDEN)
            .weduweWeduwnaar(DEFAULT_WEDUWE_WEDUWNAAR)
            .kinderenAantal(DEFAULT_KINDEREN_AANTAL);
        return gezinssituatie;
    }

    @Before
    public void initTest() {
        gezinssituatie = createEntity(em);
    }

    @Test
    @Transactional
    public void createGezinssituatie() throws Exception {
        int databaseSizeBeforeCreate = gezinssituatieRepository.findAll().size();

        // Create the Gezinssituatie
        GezinssituatieDTO gezinssituatieDTO = gezinssituatieMapper.toDto(gezinssituatie);
        restGezinssituatieMockMvc.perform(post("/api/gezinssituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(gezinssituatieDTO)))
            .andExpect(status().isCreated());

        // Validate the Gezinssituatie in the database
        List<Gezinssituatie> gezinssituatieList = gezinssituatieRepository.findAll();
        assertThat(gezinssituatieList).hasSize(databaseSizeBeforeCreate + 1);
        Gezinssituatie testGezinssituatie = gezinssituatieList.get(gezinssituatieList.size() - 1);
        assertThat(testGezinssituatie.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testGezinssituatie.getBurgerlijkeStaat()).isEqualTo(DEFAULT_BURGERLIJKE_STAAT);
        assertThat(testGezinssituatie.getHuwelijkseVw()).isEqualTo(DEFAULT_HUWELIJKSE_VW);
        assertThat(testGezinssituatie.getHuwelijkOntbonden()).isEqualTo(DEFAULT_HUWELIJK_ONTBONDEN);
        assertThat(testGezinssituatie.getWeduweWeduwnaar()).isEqualTo(DEFAULT_WEDUWE_WEDUWNAAR);
        assertThat(testGezinssituatie.getKinderenAantal()).isEqualTo(DEFAULT_KINDEREN_AANTAL);
    }

    @Test
    @Transactional
    public void createGezinssituatieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = gezinssituatieRepository.findAll().size();

        // Create the Gezinssituatie with an existing ID
        gezinssituatie.setId(1L);
        GezinssituatieDTO gezinssituatieDTO = gezinssituatieMapper.toDto(gezinssituatie);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGezinssituatieMockMvc.perform(post("/api/gezinssituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(gezinssituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Gezinssituatie in the database
        List<Gezinssituatie> gezinssituatieList = gezinssituatieRepository.findAll();
        assertThat(gezinssituatieList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllGezinssituaties() throws Exception {
        // Initialize the database
        gezinssituatieRepository.saveAndFlush(gezinssituatie);

        // Get all the gezinssituatieList
        restGezinssituatieMockMvc.perform(get("/api/gezinssituaties?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(gezinssituatie.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].burgerlijkeStaat").value(hasItem(DEFAULT_BURGERLIJKE_STAAT.toString())))
            .andExpect(jsonPath("$.[*].huwelijkseVw").value(hasItem(DEFAULT_HUWELIJKSE_VW.toString())))
            .andExpect(jsonPath("$.[*].huwelijkOntbonden").value(hasItem(DEFAULT_HUWELIJK_ONTBONDEN.toString())))
            .andExpect(jsonPath("$.[*].weduweWeduwnaar").value(hasItem(DEFAULT_WEDUWE_WEDUWNAAR.toString())))
            .andExpect(jsonPath("$.[*].kinderenAantal").value(hasItem(DEFAULT_KINDEREN_AANTAL)));
    }
    

    @Test
    @Transactional
    public void getGezinssituatie() throws Exception {
        // Initialize the database
        gezinssituatieRepository.saveAndFlush(gezinssituatie);

        // Get the gezinssituatie
        restGezinssituatieMockMvc.perform(get("/api/gezinssituaties/{id}", gezinssituatie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(gezinssituatie.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.burgerlijkeStaat").value(DEFAULT_BURGERLIJKE_STAAT.toString()))
            .andExpect(jsonPath("$.huwelijkseVw").value(DEFAULT_HUWELIJKSE_VW.toString()))
            .andExpect(jsonPath("$.huwelijkOntbonden").value(DEFAULT_HUWELIJK_ONTBONDEN.toString()))
            .andExpect(jsonPath("$.weduweWeduwnaar").value(DEFAULT_WEDUWE_WEDUWNAAR.toString()))
            .andExpect(jsonPath("$.kinderenAantal").value(DEFAULT_KINDEREN_AANTAL));
    }
    @Test
    @Transactional
    public void getNonExistingGezinssituatie() throws Exception {
        // Get the gezinssituatie
        restGezinssituatieMockMvc.perform(get("/api/gezinssituaties/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGezinssituatie() throws Exception {
        // Initialize the database
        gezinssituatieRepository.saveAndFlush(gezinssituatie);

        int databaseSizeBeforeUpdate = gezinssituatieRepository.findAll().size();

        // Update the gezinssituatie
        Gezinssituatie updatedGezinssituatie = gezinssituatieRepository.findById(gezinssituatie.getId()).get();
        // Disconnect from session so that the updates on updatedGezinssituatie are not directly saved in db
        em.detach(updatedGezinssituatie);
        updatedGezinssituatie
            .volgnummer(UPDATED_VOLGNUMMER)
            .burgerlijkeStaat(UPDATED_BURGERLIJKE_STAAT)
            .huwelijkseVw(UPDATED_HUWELIJKSE_VW)
            .huwelijkOntbonden(UPDATED_HUWELIJK_ONTBONDEN)
            .weduweWeduwnaar(UPDATED_WEDUWE_WEDUWNAAR)
            .kinderenAantal(UPDATED_KINDEREN_AANTAL);
        GezinssituatieDTO gezinssituatieDTO = gezinssituatieMapper.toDto(updatedGezinssituatie);

        restGezinssituatieMockMvc.perform(put("/api/gezinssituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(gezinssituatieDTO)))
            .andExpect(status().isOk());

        // Validate the Gezinssituatie in the database
        List<Gezinssituatie> gezinssituatieList = gezinssituatieRepository.findAll();
        assertThat(gezinssituatieList).hasSize(databaseSizeBeforeUpdate);
        Gezinssituatie testGezinssituatie = gezinssituatieList.get(gezinssituatieList.size() - 1);
        assertThat(testGezinssituatie.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testGezinssituatie.getBurgerlijkeStaat()).isEqualTo(UPDATED_BURGERLIJKE_STAAT);
        assertThat(testGezinssituatie.getHuwelijkseVw()).isEqualTo(UPDATED_HUWELIJKSE_VW);
        assertThat(testGezinssituatie.getHuwelijkOntbonden()).isEqualTo(UPDATED_HUWELIJK_ONTBONDEN);
        assertThat(testGezinssituatie.getWeduweWeduwnaar()).isEqualTo(UPDATED_WEDUWE_WEDUWNAAR);
        assertThat(testGezinssituatie.getKinderenAantal()).isEqualTo(UPDATED_KINDEREN_AANTAL);
    }

    @Test
    @Transactional
    public void updateNonExistingGezinssituatie() throws Exception {
        int databaseSizeBeforeUpdate = gezinssituatieRepository.findAll().size();

        // Create the Gezinssituatie
        GezinssituatieDTO gezinssituatieDTO = gezinssituatieMapper.toDto(gezinssituatie);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restGezinssituatieMockMvc.perform(put("/api/gezinssituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(gezinssituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Gezinssituatie in the database
        List<Gezinssituatie> gezinssituatieList = gezinssituatieRepository.findAll();
        assertThat(gezinssituatieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGezinssituatie() throws Exception {
        // Initialize the database
        gezinssituatieRepository.saveAndFlush(gezinssituatie);

        int databaseSizeBeforeDelete = gezinssituatieRepository.findAll().size();

        // Get the gezinssituatie
        restGezinssituatieMockMvc.perform(delete("/api/gezinssituaties/{id}", gezinssituatie.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Gezinssituatie> gezinssituatieList = gezinssituatieRepository.findAll();
        assertThat(gezinssituatieList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Gezinssituatie.class);
        Gezinssituatie gezinssituatie1 = new Gezinssituatie();
        gezinssituatie1.setId(1L);
        Gezinssituatie gezinssituatie2 = new Gezinssituatie();
        gezinssituatie2.setId(gezinssituatie1.getId());
        assertThat(gezinssituatie1).isEqualTo(gezinssituatie2);
        gezinssituatie2.setId(2L);
        assertThat(gezinssituatie1).isNotEqualTo(gezinssituatie2);
        gezinssituatie1.setId(null);
        assertThat(gezinssituatie1).isNotEqualTo(gezinssituatie2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(GezinssituatieDTO.class);
        GezinssituatieDTO gezinssituatieDTO1 = new GezinssituatieDTO();
        gezinssituatieDTO1.setId(1L);
        GezinssituatieDTO gezinssituatieDTO2 = new GezinssituatieDTO();
        assertThat(gezinssituatieDTO1).isNotEqualTo(gezinssituatieDTO2);
        gezinssituatieDTO2.setId(gezinssituatieDTO1.getId());
        assertThat(gezinssituatieDTO1).isEqualTo(gezinssituatieDTO2);
        gezinssituatieDTO2.setId(2L);
        assertThat(gezinssituatieDTO1).isNotEqualTo(gezinssituatieDTO2);
        gezinssituatieDTO1.setId(null);
        assertThat(gezinssituatieDTO1).isNotEqualTo(gezinssituatieDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(gezinssituatieMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(gezinssituatieMapper.fromId(null)).isNull();
    }
}
